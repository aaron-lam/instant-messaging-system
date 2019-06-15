package com.instantmessagingsystem.controller;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.instantmessagingsystem.R;
import com.instantmessagingsystem.serviceLayer.ServiceLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MessageListActivity extends AppCompatActivity {

    private ServiceLayer serviceLayer;
    private RecyclerView mMessageRecycler;
    private MessageListAdapter adapter;

    private Button sendMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_list);

        sendMessageButton = (Button)findViewById(R.id.button_chatbox_send);
        serviceLayer = new ServiceLayer(this);

        //get messages from serviceLayer
//        List<String> chatList = new ArrayList<>();
//        Stack<String> messages = serviceLayer.getMessages();
//        //add messages to chat
//        while(!messages.isEmpty())
//        {
//            chatList.add(messages.peek());
//            messages.pop();
//        }

        //get messages from serviceLayer
        List<String> messageList = serviceLayer.getMessages();


        //define sendMessageButton behavior
        sendMessage();

        mMessageRecycler = findViewById(R.id.reyclerview_message_list);

        adapter = new MessageListAdapter(this, messageList);
        mMessageRecycler.setLayoutManager(new LinearLayoutManager(this));
        mMessageRecycler.setAdapter(adapter);
    }

    public void sendMessage(){
        sendMessageButton.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        EditText  chatBox = (EditText)findViewById(R.id.edittext_chatbox);
                        serviceLayer.sendMessage(chatBox.getText().toString());
                        chatBox.setText("");
                    }
                }
        );
    }

    //Jerry's failed attempt
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle item selection
//        switch (item.getItemId()) {
//            case R.id.button_chatbox_send:
//                sendMessage();
//                return true;
//            default:
//                System.out.println(item.getItemId());
//                return super.onOptionsItemSelected(item);
//        }
//    }

//    private void sendMessage(){
//        EditText  chatBox = (EditText)findViewById(R.id.edittext_chatbox);
//        serviceLayer.sendMessage(chatBox.getText().toString());
//    }

}
