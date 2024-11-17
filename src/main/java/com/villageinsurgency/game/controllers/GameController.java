package com.villageinsurgency.game.controllers;

import com.villageinsurgency.game.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/games")
    public ResponseEntity<String> getGame(@RequestParam int id) {
        String gameJson = gameService.getGameObjectJsonById(id);
        return ResponseEntity.ok(gameJson);
    }
    @PostMapping("/games/create")
    public ResponseEntity<String> createNewGame(@RequestParam String p1) {
        gameService.createGame(p1);
        return gameService.createGame(p1);
    }
    @PutMapping("/games/join")
    public ResponseEntity<String> joinGame(@RequestParam int gameKey, @RequestParam String p2){
        return gameService.joinGame(gameKey, p2);
    }
    @PutMapping("/units/create")
    public ResponseEntity<String> createUnit(@RequestParam int gameKey, @RequestParam String type, @RequestParam String user) {
        return gameService.createUnit(gameKey, type, user);
    }
}




