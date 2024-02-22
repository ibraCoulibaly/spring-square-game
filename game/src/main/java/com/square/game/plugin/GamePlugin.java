package com.square.game.plugin;

import com.square.game.controller.GameCreationParams;
import com.square.game.controller.dto.GameDTO;
import fr.le_campus_numerique.square_games.engine.GameFactory;

import java.util.Locale;

public interface GamePlugin {

    String getName(Locale locale);
    String getIdForPlugin();

    GameFactory getFactory();
    int getNbPlayer();
    int getBoardSize();
}
