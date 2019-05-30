package com.instantmessagingsystem.controller;

public class Login {

    //Check with DB if credentials are correct.
    //Hash password before sending
    private DatabaseQueries dbQueries;
    private final String table = "Accounts";

    public Login(){
        dbQueries = new DatabaseQueries();
    }

    public boolean checkCredentials(String username, String hashedPassword) {
        //Needs to be modified
        dbQueries.get(table, username);
        return false;
    }
}
