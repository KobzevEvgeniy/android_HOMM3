package com.mygdx.game.example.Abstract_heroes;

import com.mygdx.game.example.GameInterface;
import com.mygdx.game.example.map.Coordinates;

import java.util.ArrayList;

public abstract class Hero implements GameInterface {
    protected Names name;
    protected int hp;
    protected int maxHp;
    protected int damage;
    protected int protect;
    protected int initiative;
    public Coordinates position;
    protected States state;

    public Hero(Names name, int hp, int maxHp, int damage, int protect, int initiative, int row, int col) {
        this.name = name;
        this.hp = hp;
        this.maxHp = maxHp;
        this.damage = damage;
        this.protect = protect;
        this.initiative = initiative;
        this.position = new Coordinates(row, col);
        this.state = States.READY;
    }

    public Coordinates getCoordinates() {
        return position;
    }

    protected Hero findNearest(ArrayList<Hero> team) {
        if (team.size() == 0) return null;
        Hero nearest = team.get(0);
        for (Hero character : team) {
            if (!character.state.equals(States.DEAD)
                    && this != character
                    && position.getDistance(character.getCoordinates()) < position.getDistance(nearest.getCoordinates())) {
                nearest = character;
            }
        }
        return nearest;
    }
    ArrayList<Hero> getNotDeadTeamMembers(ArrayList<Hero> team) {
        ArrayList<Hero> notDeadTeamMembers = new ArrayList<>();
        for (Hero c: team) {
            if (!c.isDead()) notDeadTeamMembers.add(c);
        }
        return notDeadTeamMembers;
    }

    protected void getDamage(int damagePoints) {
        hp -= damagePoints;
        if (hp <= 0) {
            hp = 0;
            state = States.DEAD;
        }
    }

    public boolean isDead() {
        return state.equals(States.DEAD);
    }

    protected void getHealing(int healPoints) {
        hp += healPoints;
        if (hp > maxHp) hp = maxHp;
    }

    public String getInfo() {
        return String.format("nm: %s, cl: %s, st: %s, hp \u2665: %d/%d, dmg: %d, prt: %d, init: %d,", this.name.name(),
                this.toString(), this.state.name(), this.hp, this.maxHp, this.damage, this.protect, this.initiative);
    }

    public int getInitiative() {
        return this.initiative;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}