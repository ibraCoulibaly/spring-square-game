package com.square.game;

import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GameCotroller {
    @Autowired
    private GameCatalog gameCatalog;
    @PostMapping("/games")
        public GameDTO createGame(@RequestBody GameCreationParams params){
            GameFactory gameFactory = gameCatalog.getFactoryById(params.getTypeGame());
            gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());
            return new GameDTO(gameFactory.getGameId(), params.getPlayerCount(), params.getBoardSize());
    }
}
