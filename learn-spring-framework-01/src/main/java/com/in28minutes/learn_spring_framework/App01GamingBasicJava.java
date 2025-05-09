package com.in28minutes.learn_spring_framework;

import com.in28minutes.learn_spring_framework.game.GameRunner;
import com.in28minutes.learn_spring_framework.game.MarioGame;
import com.in28minutes.learn_spring_framework.game.PacmanGame;

public class App01GamingBasicJava {

    public static void main(String[] args){

        var marioGame = new MarioGame();
//        var game = new SuperContraGame();
        var game = new PacmanGame();    // 1. Object creation
        var gameRunner = new GameRunner(game);  // 2. Object creation + wiring of dependencies
        // Game is a dependency of the GameRunner
        gameRunner.run();

    }
}
