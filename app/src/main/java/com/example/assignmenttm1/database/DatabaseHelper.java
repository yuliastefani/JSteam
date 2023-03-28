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
        String query = "Create table JSteamGames (gameID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, gameName text, gameGenre text, gameImageID text, gameRating text, gamePrice INTEGER, gameDesc text)";
        String queryReview = "Create table JSteamReview (reviewID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, gameID INTEGER, userID INTEGER, reviewComment text)";
        String queryUser = "Create table JSteamUser (userID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, userName text, userPassword text, userEmail text, userRegion text, userPhone text)";

        db.execSQL(query);
        db.execSQL(queryUser);
        db.execSQL(queryReview);

        query = "Insert into JSteamGames values" + "(1, 'Cookie Run: Kingdom', 'Role-Play', 'ic_cookie_run_kingdom', '4.5', 250000, 'Meet our Cookies, all voiced by an amazing cast of voice actors. Witness their epic skills, fall in love with their voices, and dress them into new chic costumes. Join the Cookies in Cookie Run: Kingdom!'), " +
                "(2, 'Cookie Run: Ovenbreak', 'Casual', 'ic_cookie_run_ovenbreak', '4.6', 150000, 'Run, jump, slide, collect, and bake no prisoners! Cookie Run is the endless runner game with deliciously sweet and challenging levels, tons of fun, heart racing running modes, and big rewards!'), " +
                "(3, 'Cookie Run: Puzzle World', 'ic_cookie_run_puzzle', 'Puzzle', '4.6', 50000, 'What happens if you help a cookie out of the burning oven? You get invited to the charming Puzzle World full of sweet surprises and appetizing adventures!'), " +
                "(4, 'Cookie Run: Ovensmash', 'Action', 'ic_cookie_run_ovensmash', '4.2', 200000, 'Cookie Run: OvenSmash is an online multiplayer platformer battle-royale game of the popular Cookie Run franchise developed by Devsisters. In this game, players need to battle each other by controlling different cookie characters with unique battle skills strategically to clinch the victory.');";

        db.execSQL(query);

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
