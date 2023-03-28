package com.example.assignmenttm1.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignmenttm1.User;

import java.util.Vector;

public class UserHelper {
    private static String database_table = "JSteamUsers";

    private Context ctx;
    private DatabaseHelper database_Helper;

    private SQLiteDatabase db;

    public UserHelper(Context ctx) {
        this.ctx = ctx;
    }

    public void open() throws SQLException {
        database_Helper = new DatabaseHelper(ctx);
        db = database_Helper.getWritableDatabase();
    }

    public void close() throws SQLException {
        database_Helper.close();
    }

    public void addUser(String username, String password, String email, String region, String phone) {
        String query = "INSERT INTO JSteamUsers (userName, userPassword, userEmail, userRegion, userPhone) VALUES ('" + username + "', '" + password + "', '" + email + "', '" + region + "', '" + phone + "')";
        db.execSQL(query);
    }

    public Vector<User> viewUser(int userID) {
        Vector<User> userVector = new Vector<>();

        String query = "Select * from JSteamUsers where userID = '" + userID + "'";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        User user;
        int tempID;
        String tempUsername, tempPassword, tempEmail, tempPhone, tempRegion;

        if (cursor.getCount() > 0) {
            do {
                tempID = cursor.getInt(cursor.getColumnIndexOrThrow("userID"));
                tempUsername = cursor.getString(cursor.getColumnIndexOrThrow("userName"));
                tempPassword = cursor.getString(cursor.getColumnIndexOrThrow("userPassword"));
                tempEmail = cursor.getString(cursor.getColumnIndexOrThrow("userEmail"));
                tempPhone = cursor.getString(cursor.getColumnIndexOrThrow("userPhone"));
                tempRegion = cursor.getString(cursor.getColumnIndexOrThrow("userRegion"));

                user = new User(tempID, tempUsername, tempPassword, tempEmail, tempRegion, tempPhone);

                userVector.add(user); //add to vector

                cursor.moveToNext();

            } while (!cursor.isAfterLast());
        }
        cursor.close();
        return userVector;
    }

}
