package com.square.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;


@RestController

public class HeartbeatController {

    @Autowired
    private GameCatalog gameCatalog;

    @Autowired

    private HeartbeatSensor heartbeatSensor;

    @GetMapping("/heartbeat")
    public int getHeartbeat(){
        return heartbeatSensor.get();
    }

    @PostMapping("/toto")
    public String responseSomething(@RequestBody String resquestBody) {
        return resquestBody;
    }

    @GetMapping("/list")

    public Collection<String> getGameIdentifiers() {
        return gameCatalog.getGameIdentifiers();
    }

}
