package com.udacity.gradle.jokejavalib;


import java.util.Random;

public class Joker {

    String joke;

    public Joker() {
        joke = JokeUtils.getRandomJoke();
    }

    public String getJoke() {
        return joke;
    }

}
