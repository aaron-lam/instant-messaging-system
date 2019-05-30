package com.instantmessagingsystem.controller;

public class CreateAccount {

    private String username;
    private HashPassword hashedPass;

    public CreateAccount(){
        username = "";
        hashedPass = new HashPassword();
    }

    public boolean checkIfUsernameIsAvailable(String username){
        if(username != "user"){
            return true;
        }
        return false;
    }

    public void createAccount(){
        hashedPass.hashPassword("pass");
        //send username and hashedPass to DB for storage

        hashedPass.getHashedPass();
    }

}
