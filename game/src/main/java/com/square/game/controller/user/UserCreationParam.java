package com.square.game.controller.user;

import java.util.UUID;

public record UserCreationParam(String lastName, String firstName, int age) {
}
