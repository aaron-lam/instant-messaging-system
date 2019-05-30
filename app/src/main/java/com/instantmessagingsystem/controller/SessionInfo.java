package com.instantmessagingsystem.controller;

import java.util.ArrayList;

public class SessionInfo {

    private String username;
    private String hashedPassword;
    private ArrayList<Chat> chatList;
    private int activeChat;

    public SessionInfo(String username, String hashedPassword){
        this.username = username;
        this.hashedPassword = hashedPassword;
        chatList = new ArrayList<Chat>();
        activeChat = -1;
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
