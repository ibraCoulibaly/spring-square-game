package com.square.game.controller;

import com.square.game.service.HeartbeatSensor;
import com.square.game.service.GameCatalog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/somthing")
    public String responseSomething(@RequestBody String resquestBody) {
        return resquestBody;
    }

    @GetMapping("/list")
    public Collection<String> getGameIdentifiers() {
        return gameCatalog.getGameIdentifiers();
    }

}
