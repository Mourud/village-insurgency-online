package com.villageinsurgency.game.dto;


public class CreateUnitRequest {
    private int gameKey; // Unique identifier for the game
    private String type;    // Type of unit to be created
    private String user;    // User identifier (e.g., the player creating the unit)

    // Default constructor
    public CreateUnitRequest() {
    }

    // Parameterized constructor
    public CreateUnitRequest(int gameKey, String type, String user) {
        this.gameKey = gameKey;
        this.type = type;
        this.user = user;
    }

    // Getters and Setters
    public int getGameKey() {
        return gameKey;
    }

    public void setGameKey(int gameKey) {
        this.gameKey = gameKey;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}