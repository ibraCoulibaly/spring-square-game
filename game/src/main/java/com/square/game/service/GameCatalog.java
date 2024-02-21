package com.square.game.service;

import com.square.game.controller.GameCreationParams;
import com.square.game.controller.dto.GameDTO;
import fr.le_campus_numerique.square_games.engine.GameFactory;

import java.util.Collection;

public interface GameCatalog {

    Collection<String> getGameIdentifiers();

}
