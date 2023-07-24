package com.mygdx.game.example.Abstract_heroes;

import com.mygdx.game.example.GameInterface;
import com.mygdx.game.example.map.Coordinates;
import com.mygdx.game.example.map.Directions;

import java.util.ArrayList;

public abstract class Warrior extends Hero implements GameInterface {
    public Warrior(Names name, int hp, int maxHp, int damage, int defense, int initiative, int row, int col) {
        super(name, hp, maxHp, damage, defense, initiative, row, col);
    }

    @Override
    public void step(ArrayList<Hero> teamFoe, ArrayList<Hero> teamFriend) {
        if (this.isDead()) return;
        Hero nearestFoe = findNearest(getNotDeadTeamMembers(teamFoe));
        if (nearestFoe == null) return;
        if (this.attack(nearestFoe)) return;
        this.move(nearestFoe, getNotDeadTeamMembers(teamFriend), getNotDeadTeamMembers(teamFoe));
    }

    @Override
    public String getInfo() {
        return super.getInfo();
    }

    public boolean attack(Hero enemy) {
        if (this.getCoordinates().getDistance(enemy.getCoordinates()) == 1) {
            enemy.getDamage(damage);
            state = States.ATTACK;
            return true;
        }
        return false;
    }

    public void move(Hero enemy, ArrayList<Hero> team1, ArrayList<Hero> team2) {
        Directions direction = this.getCoordinates().getDirection(enemy.getCoordinates());
        switch (direction) {
            case SOUTH:
                if (this.checkStep(team1, new Coordinates(this.getCoordinates().toArray()[0] + 1, this.getCoordinates().toArray()[1]))
                        && this.checkStep(team2, new Coordinates(this.getCoordinates().toArray()[0] + 1, this.getCoordinates().toArray()[1])))
                    this.position.setCoordinates(this.getCoordinates().toArray()[0] + 1, this.getCoordinates().toArray()[1]);
                state = States.MOVE;
                break;
            case NORTH:
                if (this.checkStep(team1, new Coordinates(this.getCoordinates().toArray()[0] - 1, this.getCoordinates().toArray()[1]))
                        && this.checkStep(team2, new Coordinates(this.getCoordinates().toArray()[0] - 1, this.getCoordinates().toArray()[1])))
                    this.position.setCoordinates(this.getCoordinates().toArray()[0] - 1, this.getCoordinates().toArray()[1]);
                state = States.MOVE;
                break;
            case WEST:
                if (this.checkStep(team1, new Coordinates(this.getCoordinates().toArray()[0], this.getCoordinates().toArray()[1] - 1))
                        && this.checkStep(team2, new Coordinates(this.getCoordinates().toArray()[0], this.getCoordinates().toArray()[1] - 1)))
                    this.position.setCoordinates(this.getCoordinates().toArray()[0], this.getCoordinates().toArray()[1] - 1);
                state = States.MOVE;
                break;
            case EAST:
                if (this.checkStep(team1, new Coordinates(this.getCoordinates().toArray()[0], this.getCoordinates().toArray()[1] + 1))
                        && this.checkStep(team2, new Coordinates(this.getCoordinates().toArray()[0], this.getCoordinates().toArray()[1] + 1)))
                    this.position.setCoordinates(this.getCoordinates().toArray()[0], this.getCoordinates().toArray()[1] + 1);
                state = States.MOVE;
                break;
        }
    }


    private boolean checkStep(ArrayList<Hero> team, Coordinates coordinates) {
        for (Hero hero : team) {
            if (!hero.isDead() && coordinates.isEqual(hero.getCoordinates())) return false;
        }
        return true;
    }
}