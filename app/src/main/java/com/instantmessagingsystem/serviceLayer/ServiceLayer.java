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

    public ServiceLayer(Context context){
        dbHelper = new DatabaseHelper(context);
        verification = new InputVerification();
        user = null;
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

    public void loginUser(String username, String password){
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

    public boolean validateCredentials(String username, String password){
        if(verification.validateUsername(username)){
            if(verification.validatePassword(password)){
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean userExists(String username, String password){
        return dbHelper.isExistingUser(username, password);
    }

    public void sendMessage(){
        //send typedMessage to DB
    }
    public void updateChatDisplay(){

    }
    public void logout(){
        user = null;
    }

}
