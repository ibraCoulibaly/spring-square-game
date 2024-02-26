package com.square.game.service.game;

import com.square.game.controller.dto.GameDTO;
import com.square.game.plugin.GamePlugin;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class GameServiceImpl implements GameService {
    private final Map<String, Game> gameMap = new HashMap<>();

    @Override
    public GameDTO getGameById(String gameId) {
        Game game = gameMap.get(gameId);
        return new GameDTO(game.getId().toString(), game.getPlayerIds().size(), game.getBoardSize());
    }

    @Override
    public GameDTO createGameWithPlugin(GamePlugin plugin) {
        Game gameWithplugin = plugin.getFactory().createGame(plugin.getNbPlayer(), plugin.getBoardSize());
        gameMap.put(gameWithplugin.getId().toString(), gameWithplugin);
        return new GameDTO(gameWithplugin.getId().toString(), plugin.getNbPlayer(), plugin.getBoardSize()) ;
    }


}
