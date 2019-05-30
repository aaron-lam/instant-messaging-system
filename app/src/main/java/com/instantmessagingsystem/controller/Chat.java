package com.instantmessagingsystem.controller;

import java.util.Stack;

public class Chat {

    private Stack<String> messages = new Stack<String>();
    private String typedMessage;

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
