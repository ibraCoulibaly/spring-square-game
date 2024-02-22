package com.square.game.service.partiegame;

import com.square.game.controller.GameCreationParams;
import com.square.game.controller.dto.GameDTO;
import com.square.game.plugin.GamePlugin;
import fr.le_campus_numerique.square_games.engine.GameFactory;

import java.util.Locale;

public interface GameService {
    //GameDTO getFactoryById(String id);

    //GameDTO getGameDTO(GameCreationParams params);

    GameDTO getGameById(String gameId);

    GameDTO createGameWithPlugin(GamePlugin plugin);


}
