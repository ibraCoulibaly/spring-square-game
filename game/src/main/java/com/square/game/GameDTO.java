package com.square.game;

public record GameDTO(
         String gameType,
         int playerCount,
         int boardSize
) {
}
