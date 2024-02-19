package com.square.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGame;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service

public class GameCatalogDummyImpl implements GameCatalog{

    TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();

    @Override
    public Collection<String> getGameIdentifiers() {
        return List.of(ticTacToeGameFactory.getGameId());
    }

    @Override
    public GameFactory getFactoryById(String id) {
        switch(id){
            case "tictactoe": return ticTacToeGameFactory;

        }
        default:  null;
    }


}
