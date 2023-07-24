package com.mygdx.game.example.All_Shooters;

import com.mygdx.game.example.Abstract_heroes.Names;
import com.mygdx.game.example.Abstract_heroes.Shooter;

public class Arbalester extends Shooter {
    public Arbalester(Names name, int row, int col) {
        super(name, 6, 6, 3, 1, 4, 7, 7, row, col);
    }
}