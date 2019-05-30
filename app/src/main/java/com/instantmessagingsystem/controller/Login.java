package com.instantmessagingsystem.controller;

public class Login {

    //Check with DB if credentials are correct.
    //Hash password before sending
    private final String table = "Accounts";

    private boolean checkCredentials(String username, String hashedPassword) {
        //Needs to be modified
        dbQueries.get(table, username);
        return false;
    }
}
