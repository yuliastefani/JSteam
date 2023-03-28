package com.example.assignmenttm1.database;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.assignmenttm1.ui.review.Review;

import java.util.Vector;

public class ReviewHelper {

    private static String database_table = "JSteamReviews";

    private Context ctx;
    private DatabaseHelper database_Helper;

    private SQLiteDatabase db;

    public ReviewHelper(Context ctx) {
        this.ctx = ctx;
    }

    public void open() throws SQLException {
        database_Helper = new DatabaseHelper(ctx);
        db = database_Helper.getWritableDatabase();
    }

    public void close() throws SQLException {
        database_Helper.close();
    }

    public void addReview(int gameID, int userID, String reviewComment) {
        String query = "INSERT INTO JSteamReview (gameID, userID, reviewComment) VALUES (" + gameID + ", " + userID + ", '" + reviewComment + "')";
        db.execSQL(query);
    }

    public Vector<Review> viewReview(){
        Vector<Review> reviewVector = new Vector<>();

        String query = "Select * from JSteamReviews";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToFirst();

        Review review;
        int tempID, tempGameID, tempUserID;
        String tempReviewComment;

        if (cursor.getCount() > 0) {
            do {
                tempID = cursor.getInt(cursor.getColumnIndexOrThrow("reviewID"));
                tempGameID = cursor.getInt(cursor.getColumnIndexOrThrow("gameID"));
                tempUserID = cursor.getInt(cursor.getColumnIndexOrThrow("userID"));
                tempReviewComment = cursor.getString(cursor.getColumnIndexOrThrow("reviewComment"));

                review = new Review(tempID, tempGameID, tempUserID, tempReviewComment);

                reviewVector.add(review); //add to vector

            } while (cursor.moveToNext());
        }

        return reviewVector;
    }



}
