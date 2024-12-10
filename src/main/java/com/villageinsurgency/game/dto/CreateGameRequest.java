package com.villageinsurgency.game.dto;

public class CreateGameRequest {
    private String p1; // Player 1 identifier (could be a username, ID, etc.)

    // Default constructor
    public CreateGameRequest() {
    }

    // Parameterized constructor
    public CreateGameRequest(String p1) {
        this.p1 = p1;
    }

    // Getters and Setters
    public String getP1() {
        return p1;
    }

    public void setP1(String p1) {
        this.p1 = p1;
    }
}