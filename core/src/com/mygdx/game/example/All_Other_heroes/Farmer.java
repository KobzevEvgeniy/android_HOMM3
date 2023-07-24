package com.mygdx.game.example.All_Other_heroes;
import com.mygdx.game.example.Abstract_heroes.Hero;
import com.mygdx.game.example.Abstract_heroes.Names;
import com.mygdx.game.example.Abstract_heroes.States;

import java.util.ArrayList;

public class Farmer extends Hero {

    public Farmer(Names name, int row, int col) {
        super(name, 4, 4, 1, 1, 1, row, col);
    }

    @Override
    public void step(ArrayList<Hero> team, ArrayList<Hero> team2){
        if (this.isDead()) return;
        state = States.READY;
    }
}