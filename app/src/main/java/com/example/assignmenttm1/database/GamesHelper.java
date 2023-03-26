package com.example.assignmenttm1.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignmenttm1.ui.game.Game;

import java.util.Vector;

public class GamesHelper {

    private static String database_table = "JSteamGames";

    private Context ctx;
    private DatabaseHelper database_Helper;

    private SQLiteDatabase db;

    public GamesHelper(Context ctx) {
        this.ctx = ctx;
    }

    public void open() throws SQLException{
        database_Helper = new DatabaseHelper(ctx);
        db = database_Helper.getWritableDatabase();
    }

    public void close() throws SQLException{
        database_Helper.close();
    }

    public Vector<Game> viewGames(){
        Vector<Game> gameVector = new Vector<>();

        String query = "Select * from JSteamGames";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        Game games;
        String tempImgID, tempName, tempGenre, tempPrice;

        if (cursor.getCount() > 0){
            do {
                tempImgID = cursor.getString(cursor.getColumnIndexOrThrow("gameImageID"));
                tempName = cursor.getString(cursor.getColumnIndexOrThrow("gameName"));
                tempGenre = cursor.getString(cursor.getColumnIndexOrThrow("gameGenre"));
                tempPrice = String.valueOf(cursor.getInt(cursor.getColumnIndexOrThrow("gamePrice")));

                games = new Game(tempImgID, tempName, tempGenre, Integer.valueOf(tempPrice));

                gameVector.add(games); //add to vector

                cursor.moveToNext();

            }while(!cursor.isAfterLast());
        }

        cursor.close();

        return gameVector;
    }

}
