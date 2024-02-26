package com.square.game.service.game;

import com.square.game.controller.dto.GameDTO;
import com.square.game.plugin.GamePlugin;

public interface GameService {
    //GameDTO getFactoryById(String id);

    //GameDTO getGameDTO(GameCreationParams params);

    GameDTO getGameById(String gameId);

    GameDTO createGameWithPlugin(GamePlugin plugin);


}
