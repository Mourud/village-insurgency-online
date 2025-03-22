package com.villageinsurgency.game.dto;

public class CreateGameRequest {
    private String userName; // Player 1 identifier (could be a username, ID, etc.)

    // Default constructor
    public CreateGameRequest() {
    }

    // Parameterized constructor
    public CreateGameRequest(String userName) {
        this.userName = userName;
    }

    // Getters and Setters
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}