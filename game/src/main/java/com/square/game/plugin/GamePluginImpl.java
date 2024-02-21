package com.square.game.plugin;

import com.square.game.controller.dto.GameDTO;
import org.springframework.beans.factory.annotation.Value;

public class GamePluginImpl implements GamePlugin {
    @Value("/")
    @Override
    public String getName(String name) {
        return null;
    }
}
