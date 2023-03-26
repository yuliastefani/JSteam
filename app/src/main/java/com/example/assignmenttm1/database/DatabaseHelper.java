package com.example.assignmenttm1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static String DATABASE_GAME = "JSteam.db";
//    Context ctx;


    public DatabaseHelper(@Nullable Context ctx) {
        super(ctx, DATABASE_GAME, null, 1);
//        this.ctx = ctx;
//        SQLiteDatabase database_game = this.getReadableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "Create table JSteamGames (gameImageID, gameName, gameGenre, gamePrice)";
//        String query2 = "Create table JSteamReview (gameImageID, gameName, gameGenre, gamePrice)";
        String queryUser = "Create table JSteamUser (user, pass, em, phone, reg)";

        db.execSQL(query);
        db.execSQL(queryUser);
//        db.execSQL(query2);

        query = "Insert into JSteamGames values" + "('ic_cookie_run_kingdom', 'Cookie Run: Kingdom', 'Role-Play', '250000'), " +
                "('ic_cookie_run_ovenbreak', 'Cookie Run: Ovenbreak', 'Casual', '150000'), " +
                "('ic_cookie_run_puzzle', 'Cookie Run: Puzzle World', 'Puzzle', '50000'), " +
                "('ic_cookie_run_ovensmash', 'Cookie Run: Ovensmash', 'Action', '200000');";

        db.execSQL(query);
//        db.execSQL(query2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists JSteamGames");
        onCreate(db);
    }

    public Boolean insertUser(String user, String pass, String em, String phone, String reg){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user", user);
        contentValues.put("pass", pass);
        contentValues.put("em", em);
        contentValues.put("phone", phone);
        contentValues.put("reg", reg);
        long result = db.insert("JSteamUser", null, contentValues);
        if (result == -1){
            return false;
        }else{
            return true;
        }
    }
}
