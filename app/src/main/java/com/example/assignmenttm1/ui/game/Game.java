package com.example.assignmenttm1.ui.game;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Game implements Parcelable {

    private int gameID;
    private String gameImageID;
    private String gameName;
    private String gameGenre;
    private String gameRating;
    private int gamePrice;
    private String gameDesc;

    public Game(int gameID, String gameImageID, String gameName, String gameGenre, String gameRating, Integer gamePrice, String gameDesc) {
        this.gameID = gameID;
        this.gameImageID = gameImageID;
        this.gameName = gameName;
        this.gameGenre = gameGenre;
        this.gameRating = gameRating;
        this.gamePrice = gamePrice;
        this.gameDesc = gameDesc;
    }

    protected Game(Parcel in) {
        gameImageID = in.readString();
        gameName = in.readString();
        gameGenre = in.readString();
        gameRating = in.readString();
        gamePrice = in.readInt();
        gameDesc = in.readString();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public int getGameID() {
        return gameID;
    }

    public void setGameID(int gameID) {
        this.gameID = gameID;
    }

    public String getGameRating() {
        return gameRating;
    }

    public void setGameRating(String gameRating) {
        this.gameRating = gameRating;
    }

    public void setGamePrice(int gamePrice) {
        this.gamePrice = gamePrice;
    }

    public String getGameDesc() {
        return gameDesc;
    }

    public void setGameDesc(String gameDesc) {
        this.gameDesc = gameDesc;
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

    public String getGameGenre() {
        return gameGenre;
    }

    public void setGameGenre(String gameGenre) {
        this.gameGenre = gameGenre;
    }

    public Integer getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(Integer gamePrice) {
        this.gamePrice = gamePrice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(gameImageID);
        dest.writeString(gameName);
        dest.writeString(gameGenre);
        dest.writeString(gameRating);
        dest.writeInt(gamePrice);
        dest.writeString(gameDesc);
    }
}
