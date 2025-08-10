package com.villageinsurgency.game.services;


import com.villageinsurgency.game.dto.LoginRequest;
import com.villageinsurgency.game.dto.LoginResponse;
import com.villageinsurgency.game.dto.RegisterRequest;
import com.villageinsurgency.game.dto.RegisterResponse;
import com.villageinsurgency.game.model.User;
import com.villageinsurgency.game.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserRepository users;

    public UserService(UserRepository users) { this.users = users; }

    @Transactional
    public RegisterResponse register(RegisterRequest req) {
        User saved = users.save(new User(req.email(), req.password()));
        return new RegisterResponse(saved.getUserID(), saved.getEmail());
    }

    @Transactional(readOnly = true)
    public LoginResponse login(LoginRequest req){
        var user = users.findByEmail(req.email())
                .orElseThrow( () -> new IllegalArgumentException("Invalid email or password"));
        if (!user.getPassword().equals(req.password())){
            throw new IllegalArgumentException("Invalid email or password");
        }
        return new LoginResponse(user.getUserID(), user.getEmail());


    }
}