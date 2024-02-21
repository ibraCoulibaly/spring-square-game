package com.square.game.controller;

import com.square.game.controller.dto.GameDTO;
import com.square.game.service.GameCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

public class GameCotroller {

    @Autowired
    private GameCatalog gameCatalog;
    @PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params){
        return gameCatalog.getGameDTO(params);
    }


    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable String gameId){
        return gameCatalog.getGameById(gameId);
    }

}
