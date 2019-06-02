package com.instantmessagingsystem.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.instantmessagingsystem.R;
import com.instantmessagingsystem.model.mapper.DatabaseHelper;

public class CreateAccountActivity extends AppCompatActivity {

    private ServiceLayer serviceLayer;
    private Button createAccountButton;

    private EditText usernameText;
    private EditText passwordText;

//    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Create an Account");
        setContentView(R.layout.activity_create_account);

        createAccountButton = findViewById(R.id.create_account_button);
        usernameText = findViewById(R.id.username_edit_text);
        passwordText = findViewById(R.id.password_edit_text);
//        dbHelper = new DatabaseHelper(this);
        serviceLayer = new ServiceLayer(this);

        // add on click listener to login button
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        });
    }

    private void createAccount() {
//        String username = usernameText.getText().toString();
//        String password = passwordText.getText().toString();

        //attempt to insert new user to User database table
//        boolean isInserted = dbHelper.insertUser(username, password);
//        String toastMessage = (isInserted) ? "account created" : "cannot create account";
//        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();

        if (serviceLayer.createAccount(this, usernameText.getText().toString(), passwordText.getText().toString())) {
            // go to main page
            startActivity(new Intent(CreateAccountActivity.this, MainActivity.class));
        }
    }
}
