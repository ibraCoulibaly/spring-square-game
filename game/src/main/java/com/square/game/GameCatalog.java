package com.square.game;

import fr.le_campus_numerique.square_games.engine.GameFactory;

import java.util.Collection;

public interface GameCatalog {

    public Collection<String> getGameIdentifiers();
    public GameFactory getFactoryById(String id);
}
