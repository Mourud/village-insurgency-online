package com.villageinsurgency.game.controllers;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class MyWebSocketHandler extends TextWebSocketHandler {
    private final Set<WebSocketSession> sessions = Collections.newSetFromMap(new ConcurrentHashMap<>());



    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        System.out.println("New connection: " + session.getId());
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        System.out.println("Received: " + message.getPayload());

        // Echo back the message
        // Broadcast the message to all connected clients
//        for (WebSocketSession activeSession : sessions) {
//            System.out.println("Session: " + activeSession.getId());
//            if (activeSession.isOpen()) {
//                activeSession.sendMessage(new TextMessage("Broadcast: " + message.getPayload()));
//            }
//        }
//        session.sendMessage(new TextMessage("Server: " + message.getPayload()));
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, org.springframework.web.socket.CloseStatus status) throws Exception {
        System.out.println("Connection closed: " + session.getId());
        sessions.remove(session);
    }
}