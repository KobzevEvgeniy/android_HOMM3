package com.mygdx.game.example.All_Warriors_heroes;

import com.mygdx.game.example.Abstract_heroes.Names;
import com.mygdx.game.example.Abstract_heroes.Warrior;

public class Bandit extends Warrior {
    public Bandit(Names name, int row, int col) {
        super(name, 9, 9, 6, 2, 4, row, col);
    }
}