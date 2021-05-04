package com.Lainthrill.random1.logic.Monsters;

public class Krakken extends Monster {
    private String name;
    private int hp = 150;
    private static final Types type = Types.WATER;
    private static final Types weakness = Types.ELECTRICITY;
    private int dmg = 20;

    public Krakken(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void attack() {

    }

    @Override
    public void defend() {

    }

    @Override
    public void switchMonster() {

    }

    public int getHp() {
        return hp;
    }

    public static Types getType() {
        return type;
    }

    public static Types getWeakness() {
        return weakness;
    }

    public int getDmg() {
        return dmg;
    }
}
