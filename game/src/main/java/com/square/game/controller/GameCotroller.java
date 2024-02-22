package com.square.game.controller;

import com.square.game.controller.dto.GameDTO;

import com.square.game.plugin.GamePlugin;
import com.square.game.service.partiegame.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController

public class GameCotroller {
    @Autowired
    private GameService gameService;
    @Autowired
    private List<GamePlugin> gamePlugin;

    @GetMapping("/games2")
    public Collection<GamePlugin> getIdAfterCreate(){
        return gamePlugin;
    }



    @PostMapping("/games2/{game2Id}")
    public GameDTO getIdAfterCreate(@PathVariable String game2Id){
        GamePlugin plugin = gamePlugin.stream().filter(e -> e.getIdForPlugin().equals(game2Id)).toList().getFirst();
        return gameService.createGameWithPlugin(plugin);
    }

    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable String gameId){
        return gameService.getGameById(gameId);
    }

    @GetMapping("/lang")
    public List<String> headerTest(@RequestHeader("Accept-Language") Locale locale) {
        return gamePlugin.stream().map(e -> e.getName(locale)).toList();
    }





}
