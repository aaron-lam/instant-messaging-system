package com.instantmessagingsystem.serviceLayer;

import android.content.Context;

import android.widget.Toast;

import com.instantmessagingsystem.model.entities.Chat;
import com.instantmessagingsystem.model.entities.User;
import com.instantmessagingsystem.model.mapper.DatabaseHelper;

import java.util.ArrayList;
import java.util.List;


public class ServiceLayer {

    private DatabaseHelper dbHelper;
    private InputVerification verification;
    private static User user;
    private static String chatId;

    public ServiceLayer(Context context) {
        dbHelper = new DatabaseHelper(context);
        verification = new InputVerification();
    }

    public boolean createAccount(Context context, String username, String password) {
        boolean isInserted = dbHelper.insertUser(username, password);
        String toastMessage = (isInserted) ? "account created" : "cannot create account";
        Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show();
        if (isInserted) {
            return true;
        }
        return false;
    }

    public void loginUser(String username, String password) {
        //create user and user's chat instances
        user = new User(username, password);
        ArrayList<String> chatIds = dbHelper.getUserChatIds(username);
        ArrayList<Chat> chats = new ArrayList<Chat>();

        //add all chats related to chatID
        for (String chatId : chatIds)
            chats.add(new Chat(chatId));
        user.setChats(chats);
        // go to main page
    }

    public boolean validateCredentials(String username, String password) {
        if (verification.validateUsername(username)) {
            if (verification.validatePassword(password)) {
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean userExists(String username, String password) {
        return dbHelper.isExistingUser(username, password);
    }

    public boolean addChatId(String chatId) {
        if (user == null) {
            return false;
        }
        String username = user.getUserName();
        //attempt to insert new chat to Chat database table
        boolean isInserted = dbHelper.insertChat(chatId);
        if (isInserted) {
            //attempt to insert new entry to Chat_User database table
            dbHelper.insertChatUser(username, chatId);
            //add new chat to user's chats array
            ArrayList<Chat> chats = user.getChats();
            chats.add(new Chat(chatId));
            return true;
        }
        return false;
    }

    public boolean searchChatId(String chatId) {
        return dbHelper.isExistingChat(chatId);
    }

    public void sendMessage(String message) {
        //send typedMessage to DB
        dbHelper.insertMessage(user.getUserName(), chatId, message);
    }

    public List<String> getMessages(){
        return dbHelper.getMessages(chatId);
    }

    public void updateChatDisplay() {

    }

    public void setChatId(String chatId){
        this.chatId = chatId;
    }

    public void logout() {
        this.user = null;
        this.chatId = null;
    }

    public List<String> getChatList() {
        return dbHelper.getUserChatIds(user.getUserName());
    }

    public String getUserName() {
        return user.getUserName();
    }
}
