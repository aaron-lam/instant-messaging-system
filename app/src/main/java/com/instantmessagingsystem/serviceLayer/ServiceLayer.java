package com.instantmessagingsystem.serviceLayer;

import android.content.Context;
import android.widget.Toast;

import com.instantmessagingsystem.model.entities.Chat;
import com.instantmessagingsystem.model.entities.User;
import com.instantmessagingsystem.model.mapper.DatabaseHelper;

import java.util.ArrayList;
import java.util.Stack;

public class ServiceLayer {

    private DatabaseHelper dbHelper;
    private InputVerification verification;

    private User user;
    private ArrayList<Chat> chatList;
    private int activeChat;
    private Stack<String> messages;
    private String typedMessage;

    public ServiceLayer(Context context){
        dbHelper = new DatabaseHelper(context);
        verification = new InputVerification();
        user = null;
        messages = new Stack<String>();
        typedMessage = "";
    }

    public boolean createAccount(Context context, String username, String password){
        boolean isInserted = dbHelper.insertUser(username, password);
        String toastMessage = (isInserted) ? "account created" : "cannot create account";
        Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show();
        if(isInserted){
            return true;
        }
        return false;
    }

    public boolean loginUser(Context context, String username, String password){
        if(validateCredentials(username, password)) {
            boolean isExistingUser = dbHelper.isExistingUser(username, password);
            String toastMessage = (isExistingUser) ? "Login Successful" : "Login Unsuccessful";
            Toast.makeText(context, toastMessage, Toast.LENGTH_LONG).show();

            if (isExistingUser) {
                //create user and user's chat instances
                user = new User(username, password);
                ArrayList<String> chatIds = dbHelper.getUserChatIds(username);
                ArrayList<Chat> chats = new ArrayList<>();

                //add all chats related to chatID
                for (String chatId : chatIds)

                    chats.add(new Chat(chatId));
                user.setChats(chats);
                // go to main page
                return true;
            }
        }
        return false;
    }

    public boolean validateCredentials(String username, String password){
        if(verification.validateUsername(username)){
            if(verification.validatePassword(password)){
                user = new User(username, password);
                return true;
            }
            return false;
        }
        return false;
    }

    public void fetchMessages(){
        int lastID = 10;
        if(messages.size()-1 < lastID){
            while(messages.size()-1 <= lastID){

            }
        }
    }
    public void sendMessage(){
        //send typedMessage to DB
    }
    public void updateChatDisplay(){

    }
    public ArrayList<Chat> getChatList(){
        return chatList;
    }
    public void setActiveChat(int index){
        this.activeChat = index;
    }
    public int getActiveChat(){
        return activeChat;
    }
    public void addChat(Chat newChat){
        chatList.add(newChat);
    }
    public void removeChat(int index){
        chatList.remove(index);
    }
    public void logout(){
        user = null;
        chatList = null;
        activeChat = -1;
    }

}
