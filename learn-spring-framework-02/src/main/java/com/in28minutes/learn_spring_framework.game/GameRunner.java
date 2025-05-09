package com.in28minutes.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {
    GamingConsole game;

    public GameRunner(@Qualifier("superContraGameQualifier") GamingConsole game) {
    this.game = game;
    }

    public void run() {
        System.out.println("Game running..." + game);
        game.up();
        game.down();
        game.left();
        game.right();

    }
}
