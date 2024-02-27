package com.square.game.controller.dto;

import java.util.UUID;

public record UserDTO(UUID id, String firstName, String lastName,  int age) {
}
