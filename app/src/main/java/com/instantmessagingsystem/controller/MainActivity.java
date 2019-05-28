package com.instantmessagingsystem.controller;

import android.content.Context;
import android.content.DialogInterface;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewAdapter.ItemClickListener {

    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Let's Chat!");
        setContentView(R.layout.activity_main);

        // data to populate the RecyclerView with
        List<String> chatsListDemo = new ArrayList<>();
        chatsListDemo.add("Chat1");
        chatsListDemo.add("Chat2");
        chatsListDemo.add("Chat3");
        chatsListDemo.add("Chat4");
        chatsListDemo.add("Chat5");

        // set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.chat_lists_recycler_view);
        recyclerView.addItemDecoration(new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewAdapter(this, chatsListDemo);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
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
            case R.id.join_button:
                showAddItemDialog(MainActivity.this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void showAddItemDialog(Context c) {
        final EditText taskEditText = new EditText(c);
        taskEditText.setGravity(Gravity.CENTER);
        AlertDialog dialog = new AlertDialog.Builder(c)
                .setMessage("Please enter chat room ID:")
                .setView(taskEditText)
                .setPositiveButton("Submit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String task = String.valueOf(taskEditText.getText());
                    }
                })
                .setNegativeButton("Cancel", null)
                .create();
        dialog.show();
        TextView messageView = dialog.findViewById(android.R.id.message);
        assert messageView != null;
        messageView.setGravity(Gravity.CENTER);
    }
}
