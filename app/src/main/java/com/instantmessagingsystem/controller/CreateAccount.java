package com.instantmessagingsystem.controller;

public class CreateAccount {

    public boolean checkIfUsernameIsAvailable(String username){
        if(username != "user"){
            return true;
        }
        return false;
    }

    public void createAccount(String username, String hashedPass){
        //send username and hashedPass to DB for storage
    }

}
