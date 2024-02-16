package com.square.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController

public class HeartbeatController {


    @Autowired

    private HeartbeatSensor heartbeatSensor;

    @GetMapping("/heartbeat")
    public int getHeartbeat(){
        return 40 + (int)(Math.random() * ((230 - 40) +1));
    }

    @PostMapping("/toto")
    public String responseSomething(@RequestBody String resquestBody) {
        return resquestBody;
    }
}
