package com.square.game.controller.game;

public class GameCreationParams {
    private String typeGame;
    private int playerCount;
    private int boardSize;


    public String getTypeGame() {
        return typeGame;
    }

    public void setTypeGame(String typeGame) {
        this.typeGame = typeGame;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
    }
}
