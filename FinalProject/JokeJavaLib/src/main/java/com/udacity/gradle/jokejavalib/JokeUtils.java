package com.udacity.gradle.jokejavalib;

import java.util.Random;

public class JokeUtils {

    public static String[] jokes = new String[] {
            "Anoop is stress?\n" + "Stress is Thadani\n"+"Anoop is Thadani",
            "Indoooor waaloo ko lagta is Pune is bae\n" + "They are wrooooong",
            "In the Mumbai all over India\n" + "We are the bhaiiiiiii\nWe are the Bhaiiiiiiiii",
            "When we travel from Pune to Mumbai and Mumbai to Pune\n" + "Aishwarya,Ankita and Dhannoo just chilll with Shaunak",
            "Rahul you have to choose Me or the Food??\n" + "Rahul:Food but then again she was pretty beautiful\nI choose you(Fingers crossed)\nDont worry you guys are fine",

    };

    public static String getRandomJoke(){
        Random random = new Random();
        return jokes[random.nextInt(jokes.length)];
    }
}
