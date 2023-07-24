package com.mygdx.game.example.All_Shooters;

import com.mygdx.game.example.Abstract_heroes.Names;
import com.mygdx.game.example.Abstract_heroes.Shooter;

public class Sniper extends Shooter {
    public Sniper(Names name, int row, int col) {
        super(name, 5, 5, 2,1, 5, 10, 10, row, col);
    }

}