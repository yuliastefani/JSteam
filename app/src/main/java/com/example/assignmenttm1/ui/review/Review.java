package com.example.assignmenttm1.ui.review;

public class Review {
    private int reviewID;
    private int gameID;
    private int userID;
    private String reviewComment;

    public Review(int reviewID, int gameID, int userID, String reviewComment) {
        this.reviewID = reviewID;
        this.gameID = gameID;
        this.userID = userID;
        this.reviewComment = reviewComment;
    }

    public int getReviewID() {
        return reviewID;
    }

    public void setReviewID(int reviewID) {
        this.reviewID = reviewID;
    }

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getReviewComment() {
        return reviewComment;
    }

    public void setReviewComment(String reviewComment) {
        this.reviewComment = reviewComment;
    }
}