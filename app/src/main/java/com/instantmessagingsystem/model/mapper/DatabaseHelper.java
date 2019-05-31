package com.instantmessagingsystem.model.mapper;

import android.content.Context;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

//persistence layer class
public class DatabaseHelper extends SQLiteOpenHelper {

    //constructor
    public DatabaseHelper(Context context) {
        super(context, TABLE_User, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(createUserTable);
        db.execSQL(createChatTable);
        db.execSQL(createChatUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_User);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Chat);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Chat_User);

        onCreate(db);
    }

    //inserts new user tuple into User table
    public boolean insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1_User, username);
        contentValues.put(COL2_User, password);

        //insert data into table
        long result = db.insert(TABLE_User, null, contentValues);

        //if data is inserted incorrectly it will return -1
        if (result == -1)
            return false;
        return true;
    }

    //inserts new chat tuple into Chat table
    public boolean insertChat(String chat_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1_Chat, chat_id);

        //insert data into table
        long result = db.insert(TABLE_Chat, null, contentValues);

        //if data is inserted incorrectly it will return -1
        if (result == -1)
            return false;
        return true;
    }

    //inserts new chat user tuple into Chat_User Table
    public boolean insertChatUser(String username, String chat_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL1_User, username);
        contentValues.put(COL1_Chat, chat_id);

        //insert data into table
        long result = db.insert(TABLE_Chat_User, null, contentValues);

        //if data is inserted incorrectly it will return -1
        if (result == -1)
            return false;
        return true;
    }

    //returns true if such tuple in User table exists
    public boolean isExistingUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectUserQuery = "SELECT * FROM " + TABLE_User +
                " WHERE " + COL1_User + " = '" + username +
                "' AND " + COL2_User + " = '" + password + "'";


        Cursor cursor = db.rawQuery(selectUserQuery, null);
        boolean exists = (cursor.getCount() > 0);
        cursor.close();
        return exists;
    }

    //returns all the id of the chats that the user is a member of
    public ArrayList<String> getUserChatIds(String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        String selectUserChatsQuery = "SELECT * FROM " + TABLE_Chat_User +
                " WHERE " + COL1_User + " = '" + username + "'";
        Cursor cursor = db.rawQuery(selectUserChatsQuery, null);

        ArrayList<String> chats = new ArrayList<String>();
        //iterate through results
        while (cursor.moveToNext()) {
            String chatId = cursor.getString(cursor.getColumnIndex(COL1_Chat));
            chats.add(chatId);
        }
        cursor.close();

        return chats;
    }

    //private constants & queries
    private static final String TABLE_User = "User";
    private static final String COL1_User = "username";
    private static final String COL2_User = "password";

    private static final String TABLE_Chat = "Chat";
    private static final String COL1_Chat = "chat_id";

    private static final String TABLE_Chat_User = "Chat_User";


    private static final String createUserTable = "CREATE TABLE " + TABLE_User + "(" +
            COL1_User + " TEXT PRIMARY KEY, " +
            COL2_User + " TEXT)";

    private static final String createChatTable = "CREATE TABLE " + TABLE_Chat + "(" +
            COL1_Chat + " TEXT PRIMARY KEY)";

    private static final String createChatUserTable = "CREATE TABLE " + TABLE_Chat_User + "(" +
            COL1_User + " TEXT REFERENCES " + TABLE_User + ", " +
            COL1_Chat + " TEXT REFERENCES " + TABLE_Chat + ", " +
            "PRIMARY KEY(" + COL1_User + ", " + COL1_Chat + "))";
}
