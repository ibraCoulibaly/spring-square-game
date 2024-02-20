package com.square.game;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController

public class GameCotroller {
    @Autowired
    private GameCatalog gameCatalog;
    ArrayList<Game> list = new ArrayList<>();
    Map<String, Game> list2 = new HashMap<>();


    @PostMapping("/games")
        public GameDTO createGame(@RequestBody GameCreationParams params){
            GameFactory gameFactory = gameCatalog.getFactoryById(params.getTypeGame());
            Game save = gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());
            list2.put(save.getId().toString(), save);
            //list.add(save);
            return new GameDTO(save.getId().toString(), params.getPlayerCount(), params.getBoardSize());
    }

    @GetMapping("/games/{gameId}")
    public Object getGame(@PathVariable String gameId){
        //return list.stream().filter(e -> gameId.equals(e.getId().toString()));
        Game game = list2.get(gameId);
        return new GameDTO(game.getId().toString(), game.getPlayerIds().size(), game.getBoardSize());
    }
}
