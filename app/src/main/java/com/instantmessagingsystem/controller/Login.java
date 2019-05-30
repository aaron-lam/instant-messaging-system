package com.instantmessagingsystem.controller;

public class Login {

    //Check with DB if credentials are correct.
    //Hash password before sending
    private HashPassword hashPassword;
    private DatabaseQueries dbQueries;
    private final String table = "Accounts";

    public Login(){
        hashPassword = new HashPassword();
        dbQueries = new DatabaseQueries();
    }

    public boolean checkCredentials(String username, String password) {
        //Needs to be modified
        dbQueries.get(table, username);
        hashPassword.hashPassword(password);
        return false;
    }
}
