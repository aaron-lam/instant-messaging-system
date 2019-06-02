package com.instantmessagingsystem.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.instantmessagingsystem.R;
import com.instantmessagingsystem.model.entities.Chat;
import com.instantmessagingsystem.model.mapper.DatabaseHelper;
import com.instantmessagingsystem.model.entities.User;

import java.util.ArrayList;

public class LoginActivity extends AppCompatActivity {

    private ServiceLayer serviceLayer;
//    private DatabaseHelper dbHelper;

    private Button loginButton;
    private Button createAccountButton;

    private EditText usernameText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // reference class field to UI objects
        passwordText = findViewById(R.id.password_edit_text);
        serviceLayer = new ServiceLayer(this);
//        dbHelper = new DatabaseHelper(this);
        loginButton = findViewById(R.id.login_button);
        createAccountButton = findViewById(R.id.create_account_button);
        usernameText = findViewById(R.id.username_edit_text);

        // add on click listener to login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        // add on click listener to create account button
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class));
            }
        });
    }

    private void loginUser() {
//        String username = usernameText.getText().toString();
//        String password = passwordText.getText().toString();
        if(serviceLayer.validateCredentials(usernameText.getText().toString(), passwordText.getText().toString())) {
            if (serviceLayer.loginUser(this)) {
                startActivity(new Intent(this, MainActivity.class));
            }
        }
//        boolean isExistingUser = dbHelper.isExistingUser(username, password);
//        String toastMessage = (isExistingUser) ? "Login Successfully" : "Login Unsuccessfully";
//        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();

//        if (isExistingUser) {
//            //create user and user's chat instances
//            user = new User(username, password);
//            ArrayList<String> chatIds = dbHelper.getUserChatIds(username);
//            ArrayList<Chat> chats = new ArrayList<>();
//            for (String chatId : chatIds)
//                chats.add(new Chat(chatId));
//            user.setChats(chats);
//            // go to main page
//            startActivity(new Intent(LoginActivity.this, MainActivity.class));
//        }
    }
}
