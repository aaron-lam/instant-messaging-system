package com.instantmessagingsystem.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.instantmessagingsystem.R;
import com.instantmessagingsystem.serviceLayer.ServiceLayer;

public class CreateAccountActivity extends AppCompatActivity {

    private ServiceLayer serviceLayer;
    private Button createAccountButton;

    private EditText usernameText;
    private EditText passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Create an Account");
        setContentView(R.layout.activity_create_account);

        createAccountButton = findViewById(R.id.create_account_button);
        usernameText = findViewById(R.id.username_edit_text);
        passwordText = findViewById(R.id.password_edit_text);
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
        if (serviceLayer.createAccount(this, usernameText.getText().toString(), passwordText.getText().toString())) {
            // go to main page
            startActivity(new Intent(CreateAccountActivity.this, MainActivity.class));
        }
    }
}

/* Previous class variables
* //    private DatabaseHelper dbHelper;
 */

/* Previous constructor logic
* //        dbHelper = new DatabaseHelper(this);
 */

/* Previous create account logic
//        String username = usernameText.getText().toString();
//        String password = passwordText.getText().toString();

        //attempt to insert new user to User database table
//        boolean isInserted = dbHelper.insertUser(username, password);
//        String toastMessage = (isInserted) ? "account created" : "cannot create account";
//        Toast.makeText(this, toastMessage, Toast.LENGTH_LONG).show();
*/