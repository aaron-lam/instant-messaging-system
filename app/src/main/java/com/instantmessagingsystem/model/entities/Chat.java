package com.instantmessagingsystem.model.entities;

import java.util.Stack;

public class Chat {

    //private field
    private String chatId;
    private Stack<String> messages;
    private String typedMessage;


    //constructor
    public Chat(String chatId) {
        this.chatId = chatId;
        messages = new Stack<String>();
        typedMessage = "";
    }

    //getter method
    public String getChatId() { return chatId; }

    public Stack<String> getMessages() { return messages;};

    public String getTypedMessage() { return typedMessage;};

    public void fetchMessages(){
        int lastID = 10;
        if(messages.size()-1 < lastID){
            while(messages.size()-1 <= lastID){

            }
        }
    }

}
