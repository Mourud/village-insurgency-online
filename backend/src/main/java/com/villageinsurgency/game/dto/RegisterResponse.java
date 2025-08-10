package com.villageinsurgency.game.dto;

import java.util.UUID;

public record RegisterResponse(UUID userId, String email) {
}
