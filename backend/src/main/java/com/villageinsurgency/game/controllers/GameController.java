package com.villageinsurgency.game.controllers;

import com.villageinsurgency.game.dto.CreateGameRequest;
import com.villageinsurgency.game.dto.CreateUnitRequest;
import com.villageinsurgency.game.dto.JoinGameRequest;
import com.villageinsurgency.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;


@Controller
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @MessageMapping("/games/get")
    @SendTo("/topic/games")
    public String getGame(@Payload int id) {
        return gameService.getGameObjectJsonById(id);
    }

    @MessageMapping("/games/create")
    @SendTo("/topic/games")
    public ResponseEntity<String> createNewGame(@Payload CreateGameRequest request) {
        return gameService.createGame(request.getP1());
    }

    @MessageMapping("/games/join")
    @SendTo("/topic/games")
    public String joinGame(@Payload JoinGameRequest request) {
        return String.valueOf(gameService.joinGame(request.getGameKey(), request.getP2()));
    }

    @MessageMapping("/units/create")
    @SendTo("/topic/units")
    public String createUnit(@Payload CreateUnitRequest request) {
        return String.valueOf(gameService.createUnit(request.getGameKey(), request.getType(), request.getUser()));
    }
}