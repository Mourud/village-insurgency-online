package com.villageinsurgency.game.controllers;

import com.villageinsurgency.game.services.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //
    @PostMapping("users/create")
    public ResponseEntity<String> createUser(@RequestParam String username, @RequestParam String email) {
        boolean isCreated = false;
        try{
            isCreated = userService.createUser(username, email);
        }catch (DataIntegrityViolationException sqlException){
            if (sqlException.getCause() instanceof java.sql.SQLIntegrityConstraintViolationException &&
                    sqlException.getCause().getMessage().contains("username_UNIQUE")) {
                return ResponseEntity.status(HttpStatus.CONFLICT)
                        .body("Username '" + username + "' already exists. Please choose a different one.");
            }
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while creating the user");
        }
        if (isCreated) {
            return ResponseEntity.ok("User created successfully");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User could not be created");
        }
    }
}
