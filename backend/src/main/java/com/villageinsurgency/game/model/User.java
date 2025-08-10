package com.villageinsurgency.game.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
//@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private UUID userID;
    private String email;
    private String password;

    protected  User() {}

    public User(String email, String password){
        this.email = email;
        this.password = password;
    }

    public UUID getUserID() { return userID; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public void setEmail(String email) { this.email = email; }
    public void setPassword(String password) { this.password = password; }



}
