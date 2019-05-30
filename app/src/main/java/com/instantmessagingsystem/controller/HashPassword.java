package com.instantmessagingsystem.controller;

public class HashPassword {

    private String hashedPass;

    public HashPassword(){
        hashedPass = "";
    }

    public void hashPassword(String password){
        //hash password then set
        hashedPass = password;
    }

    public String getHashedPass(){
        return hashedPass;
    }

}
