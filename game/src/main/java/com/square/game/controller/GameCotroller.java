package com.square.game.controller;

import com.square.game.controller.dto.GameDTO;
import com.square.game.service.partiegame.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController

public class GameCotroller {
    @Autowired
    private GameService gameService;
    @PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params){
        return gameService.getGameDTO(params);
    }

    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable String gameId){
        return gameService.getGameById(gameId);
    }

}
