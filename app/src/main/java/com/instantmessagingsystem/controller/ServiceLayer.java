package com.instantmessagingsystem.controller;

public class ServiceLayer {

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
}
