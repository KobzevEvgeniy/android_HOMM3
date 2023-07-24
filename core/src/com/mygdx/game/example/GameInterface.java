package com.mygdx.game.example;

import com.mygdx.game.example.Abstract_heroes.Hero;

import java.util.ArrayList;

public interface GameInterface {
    void step(ArrayList< Hero > teamFoe, ArrayList<Hero> teamFriend);
        String getInfo();



}


