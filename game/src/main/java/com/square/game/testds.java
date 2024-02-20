package com.square.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;

public class testds {
    public static void main(String[] args) {

        Game game = new TicTacToeGameFactory().createGame(2,3);
        System.out.println(game.getId());
        System.out.println(game.getPlayerIds());
        System.out.println(game.getCurrentPlayerId());

    }
}
