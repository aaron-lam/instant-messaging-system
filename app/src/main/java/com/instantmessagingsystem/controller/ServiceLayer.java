package com.instantmessagingsystem.controller;

import com.instantmessagingsystem.model.entities.Chat;

import java.util.ArrayList;
import java.util.Stack;

public class ServiceLayer {

    private String username;
    private String hashedPassword;
    private ArrayList<Chat> chatList;
    private int activeChat;

    private Stack<String> messages;
    private String typedMessage;

    public ServiceLayer(){
        messages = new Stack<String>();
        typedMessage = "";
        this.username = username;
        this.hashedPassword = hashedPassword;
        chatList = new ArrayList<Chat>();
        activeChat = -1;
    }

    public boolean createAccount(String username, String hashedPass){
        //send username and hashedPass to DB for storage
        if(checkIfUsernameIsAvailable(username)){
            //push credentials to DB
            return true;
        }
        return false;
    }

    private boolean checkIfUsernameIsAvailable(String username){
        //Check if username is available
        //logic will need to be adjusted
        if(username != "user"){
            return true;
        }
        return false;
    }

    public static boolean checkCredentials(String username, String hashedPassword) {
//        dbQueries.get("Accounts", username);
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
        username = "";
        hashedPassword = "";
        chatList = null;
        activeChat = -1;
    }

}
