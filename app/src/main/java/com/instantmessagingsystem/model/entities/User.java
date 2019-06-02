package com.instantmessagingsystem.model.entities;

import com.instantmessagingsystem.model.entities.Chat;

import java.util.ArrayList;

public class User {

    //private fields
    private String username;
    private String password;
    private ArrayList<Chat> chats;

    //constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.chats = new ArrayList<Chat>();
    }

    //getter and setter methods
    public String getUserName() { return username; }

    public String getPassword() { return password; }

    public ArrayList<Chat> getChats() { return chats; }

    public void setChats(ArrayList<Chat> chats) { this.chats = chats; }

}
