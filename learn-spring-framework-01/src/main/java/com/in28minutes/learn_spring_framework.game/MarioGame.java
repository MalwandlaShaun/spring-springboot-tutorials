package com.in28minutes.learn_spring_framework.game;

public class MarioGame implements GamingConsole {

    public void up(){
        System.out.println("Jump");
    }
    public void down(){
        System.out.println("go into hole");
    }public void left(){
        System.out.println("go back");
    }public void right(){
        System.out.println("Accelerate");
    }
}
