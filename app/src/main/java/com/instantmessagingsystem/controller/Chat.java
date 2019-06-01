package com.instantmessagingsystem.controller;

import java.util.Stack;

public class Chat {

    private Stack<String> messages;
    private String typedMessage;
    private DatabaseQueries dbQueries;

    public Chat(){
        messages = new Stack<String>();
        typedMessage = "";
        dbQueries = new DatabaseQueries();
    }

    //get last message ID value from DB and compare with messages size
    //push all message IDs greater than messages size
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
}
