package com.mygdx.game.example.Abstract_heroes;
import com.mygdx.game.example.All_Other_heroes.Farmer;
import com.mygdx.game.example.GameInterface;

import java.util.ArrayList;

public abstract class Shooter extends Hero implements GameInterface {

    protected int arrows;
    protected int maxArrows;

    public Shooter(Names name, int hp, int maxHp, int damage, int defense, int initiative,
                   int arrows, int maxArrows, int row, int col) {
        super(name, hp, maxHp, damage, defense, initiative, row, col);
        this.arrows = arrows;
        this.maxArrows = maxArrows;
    }

    @Override
    public void step(ArrayList<Hero> teamFoe, ArrayList<Hero> teamFriend) {
        if (this.isDead()) return;
        this.state = States.READY;
        if (arrows <= 0) {
            this.state = States.NOAMMO;
            return;
        }
        Hero nearestFoe = findNearest(getNotDeadTeamMembers(teamFoe));
        if (nearestFoe != null) {
            nearestFoe.getDamage(damage);
            this.arrows -= 1;
            state = States.SHOOT;
        }
        for (Hero c : getNotDeadTeamMembers(teamFriend)) {
            if (c == null) return;
            if (this.arrows < this.maxArrows && c.getClass() == Farmer.class && c.state.equals(States.READY)) {
                this.arrows += 1;
                c.state = States.SUPPLY;
                break;
            }
        }
    }
    @Override
    public String getInfo() {
        return super.getInfo() + String.format(" ammo\uD83C\uDFF9: %d/%d", this.arrows, this.maxArrows);
    }
}