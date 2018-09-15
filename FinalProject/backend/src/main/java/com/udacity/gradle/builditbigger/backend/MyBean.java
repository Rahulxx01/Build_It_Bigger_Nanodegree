package com.udacity.gradle.builditbigger.backend;

import com.udacity.gradle.jokejavalib.Joker;



/** The object model for the data we are sending through endpoints */
public class MyBean {

    private String myData;
    private Joker joker;


/*    public void setData(String data) {
        myData = data;
    }

    public MyBean(){
        joker = new Joker();
    }

    public String getData() {
        return joker.getRandomJoke();
    }*/

    private String name;
   // private String myData;

    public String getData() {
        return myData;
    }

    public void setData(String data) {
        myData = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}