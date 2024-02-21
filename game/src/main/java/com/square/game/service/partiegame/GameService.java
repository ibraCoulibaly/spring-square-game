package com.square.game.service.partiegame;

import com.square.game.controller.GameCreationParams;
import com.square.game.controller.dto.GameDTO;
import fr.le_campus_numerique.square_games.engine.GameFactory;

public interface GameService {
    GameFactory getFactoryById(String id);

    GameDTO getGameDTO(GameCreationParams params);

    GameDTO getGameById(String gameId);
}
