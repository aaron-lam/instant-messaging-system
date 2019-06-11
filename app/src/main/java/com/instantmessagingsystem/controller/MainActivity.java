package com.instantmessagingsystem.controller;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.instantmessagingsystem.R;
import com.instantmessagingsystem.serviceLayer.ServiceLayer;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    private ServiceLayer serviceLayer;

    private RecyclerViewAdapter adapter;
    private RecyclerView recyclerView;
    private List<String> localChatList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Let's Chat!");
        setContentView(R.layout.activity_main);

        serviceLayer = new ServiceLayer(this);
        localChatList = new ArrayList<>();

        // set up the RecyclerView
        recyclerView = findViewById(R.id.chat_lists_recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        render();
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(MainActivity.this, MessageListActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.create_button:
                showCreateButton(MainActivity.this);
                return true;
            case R.id.search_button:
                showSearchButton(MainActivity.this);
                return true;
            default:
                System.out.println(item.getItemId());
                return super.onOptionsItemSelected(item);
        }
    }

    private void showSearchButton(Context c) {
        final EditText taskEditText = new EditText(c);
        taskEditText.setGravity(Gravity.CENTER);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setMessage("Please enter chat room ID:")
                .setView(taskEditText)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String chatId = String.valueOf(taskEditText.getText());
                        boolean isInserted = serviceLayer.searchChatId(chatId);
                        String toastMessage = (isInserted) ? "Chat Found" : "Chat Not Found";
                        if (isInserted) {
                            localChatList.add(chatId);
                            render();
                        }
                        Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
        TextView messageView = dialog.findViewById(android.R.id.message);
        assert messageView != null;
        messageView.setGravity(Gravity.CENTER);
    }

    private void showCreateButton(Context c) {
        final EditText taskEditText = new EditText(c);
        taskEditText.setGravity(Gravity.CENTER);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setMessage("Please enter chat room ID:")
                .setView(taskEditText)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String chatId = String.valueOf(taskEditText.getText());
                        boolean isInserted = serviceLayer.addChatId(chatId);
                        if (isInserted) {
                            List<String> chats = serviceLayer.getChatList();
                            localChatList.add(chatId);
                            render();
                        }
                        String toastMessage = (isInserted) ? "Chat Inserted" : "Chat Not Inserted";
                        Toast.makeText(MainActivity.this, toastMessage, Toast.LENGTH_LONG).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
        TextView messageView = dialog.findViewById(android.R.id.message);
        assert messageView != null;
        messageView.setGravity(Gravity.CENTER);
    }

    // data to populate the RecyclerView with
    public void render() {
        adapter = new RecyclerViewAdapter(this, localChatList);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }
}
