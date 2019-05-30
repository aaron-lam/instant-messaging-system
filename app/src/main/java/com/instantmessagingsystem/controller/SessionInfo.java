package com.instantmessagingsystem.controller;

public class SessionInfo {

    private HashPassword hashedPassword;

    public SessionInfo(){
        hashedPassword = new HashPassword();
    }

    public void hashPassword(){
        hashedPassword.hashPassword(password);
    }

}
