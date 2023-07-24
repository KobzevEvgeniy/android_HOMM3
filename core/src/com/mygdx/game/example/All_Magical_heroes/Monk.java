package com.mygdx.game.example.All_Magical_heroes;

import com.mygdx.game.example.Abstract_heroes.Magical_Heroes;
import com.mygdx.game.example.Abstract_heroes.Names;

public class Monk extends Magical_Heroes {
    public Monk(Names name, int row, int col) {
        super(name, 5, 5, 3, 2,3, 8, 8, row, col);
    }

}