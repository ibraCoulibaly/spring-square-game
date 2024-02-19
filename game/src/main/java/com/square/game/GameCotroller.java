package com.square.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGame;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController

public class GameCotroller {
    @Autowired
    private GameCatalog gameCatalog;


    @PostMapping("/games")
    public Collection createGame(@RequestBody GameCreationParams params){
        return gameCatalog.getFactoryById(params);
        //return UUID.randomUUID().toString();
    }
}
