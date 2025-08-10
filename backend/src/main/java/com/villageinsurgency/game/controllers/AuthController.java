package com.villageinsurgency.game.controllers;


import com.villageinsurgency.game.dto.LoginRequest;
import com.villageinsurgency.game.dto.LoginResponse;
import com.villageinsurgency.game.dto.RegisterRequest;
import com.villageinsurgency.game.dto.RegisterResponse;
import com.villageinsurgency.game.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {this.userService = userService;}

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody RegisterRequest req) {
        return ResponseEntity.ok(userService.register(req));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest req){
        return ResponseEntity.ok(userService.login(req));
    }
}
