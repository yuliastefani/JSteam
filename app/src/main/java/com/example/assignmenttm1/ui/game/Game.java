package com.example.assignmenttm1.ui.game;

public class Game {

    private String gameImageID;
    private String gameName;
    private String gameGenre;
    private Integer gamePrice;

    public Game(String gameImageID, String gameName, String gameGenre, Integer gamePrice) {
        this.gameImageID = gameImageID;
        this.gameName = gameName;
        this.gameGenre = gameGenre;
        this.gamePrice = gamePrice;
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
}
