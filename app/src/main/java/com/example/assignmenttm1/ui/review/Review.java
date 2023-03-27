package com.example.assignmenttm1.ui.review;

public class Review {

    private String gameImageID;
    private String gameName;
    private String userName;
    private String gameComment;

    public Review(String gameImageID, String gameName, String userName, String gameComment) {
        this.gameImageID = gameImageID;
        this.gameName = gameName;
        this.userName = userName;
        this.gameComment = gameComment;
    }

    public String getGameImageID() {
        return gameImageID;
    }

    public void setGameImageID(String gameImageID) {
        this.gameImageID = gameImageID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGameComment() {
        return gameComment;
    }

    public void setGameComment(String gameComment) {
        this.gameComment = gameComment;
    }
}
