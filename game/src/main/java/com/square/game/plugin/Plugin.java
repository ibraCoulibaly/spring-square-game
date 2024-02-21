package com.square.game.plugin;

import com.square.game.controller.GameCreationParams;
import com.square.game.controller.dto.GameDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class Plugin {

    //@PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params){
        return null;
    }
}
