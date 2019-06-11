package com.instantmessagingsystem.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.instantmessagingsystem.R;

import java.util.ArrayList;
import java.util.List;

public class MessageListActivity extends AppCompatActivity {

    private RecyclerView mMessageRecycler;
    private MessageListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        List<String> chatList = new ArrayList<>();
        chatList.add("message1");
        chatList.add("message2");

        mMessageRecycler = findViewById(R.id.reyclerview_message_list);

        adapter = new MessageListAdapter(this, chatList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageRecycler.setAdapter(adapter);
    }
}
