package com.square.game.service;

import com.square.game.controller.GameCreationParams;
import com.square.game.controller.dto.GameDTO;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service

public class GameCatalogDummyImpl implements GameCatalog {

    private final TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();


    @Override
    public Collection<String> getGameIdentifiers() {
        return List.of(ticTacToeGameFactory.getGameFactoryId());
    }




}
