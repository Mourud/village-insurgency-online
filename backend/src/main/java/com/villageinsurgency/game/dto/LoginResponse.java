package com.villageinsurgency.game.dto;

import java.util.UUID;

public record LoginResponse(UUID userId, String email) {
}
