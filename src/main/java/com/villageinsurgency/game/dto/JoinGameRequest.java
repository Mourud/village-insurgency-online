package com.villageinsurgency.game.dto;

public class JoinGameRequest {
    private int gameKey; // Unique identifier for the game
    private String p2;      // Player 2 identifier

    // Default constructor
    public JoinGameRequest() {
    }

    // Parameterized constructor
    public JoinGameRequest(int gameKey, String p2) {
        this.gameKey = gameKey;
        this.p2 = p2;
    }

    // Getters and Setters
    public int getGameKey() {
        return gameKey;
    }

    public void setGameKey(int gameKey) {
        this.gameKey = gameKey;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }
}