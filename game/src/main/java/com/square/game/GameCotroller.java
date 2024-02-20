package com.square.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController

public class GameCotroller {
    @Autowired
    private GameCatalog gameCatalog;

    private GameFactory gameFactory;


    @PostMapping("/games")
        public Game createGame(@RequestBody GameCreationParams params){
        gameFactory = gameCatalog.getFactoryById(params.getTypeGame());
        return gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());
        //return UUID.randomUUID().toString();
    }
}
