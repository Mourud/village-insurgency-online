package com.villageinsurgency.game.controllers;

import com.villageinsurgency.game.dto.JoinGameRequest;
import com.villageinsurgency.game.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;


@Controller
public class GameController {

    private final GameService gameService;
    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public GameController(GameService gameService, SimpMessagingTemplate messagingTemplate) {
        this.gameService = gameService;
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/games/createGame")
    public void createNewGame(Principal principal) {
        String username = principal.getName();  // Extract Clerk username

        if (username == null || username.isEmpty()) {
            messagingTemplate.convertAndSendToUser(username, "/queue/errors", "Username cannot be empty");
            return;
        }

        String response = gameService.createGame(username);
        messagingTemplate.convertAndSendToUser(username, "/queue/game", response);
    }

    @MessageMapping("/games/join")
    @SendTo("/topic/games")
    public String joinGame(@Payload JoinGameRequest request) {
        return String.valueOf(gameService.joinGame(request.getGameKey(), request.getP2()));
    }
//
//    @MessageMapping("/units/create")
//    @SendTo("/topic/units")
//    public String createUnit(@Payload CreateUnitRequest request) {
//        return String.valueOf(gameService.createUnit(request.getGameKey(), request.getType(), request.getUser()));
//    }
}