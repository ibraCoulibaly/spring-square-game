package com.square.game.controller.dto;

import java.util.UUID;

public record UserDTO(UUID id, String lastName, String firstName, int age) {
}
