package com.square.game;

import org.springframework.stereotype.Service;

@Service
public class RandomHeartbeat  implements HeartbeatSensor{
    @Override
    public int get() {
        return 0;
    }
}
