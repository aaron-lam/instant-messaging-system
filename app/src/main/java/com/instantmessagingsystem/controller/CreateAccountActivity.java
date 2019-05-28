package com.instantmessagingsystem.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.instantmessagingsystem.R;

public class CreateAccountActivity extends AppCompatActivity {

    private Button createAccountButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Create an Account");
        setContentView(R.layout.activity_create_account);

        createAccountButton = findViewById(R.id.create_account_button);

        // add on click listener to login button
        createAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CreateAccountActivity.this, MainActivity.class));
            }
        });
    }
}
