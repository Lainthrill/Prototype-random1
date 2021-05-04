package com.Lainthrill.random1.logic.Monsters;

public class Treant extends Monster{
    private String name;
    private int hp = 135;
    private static final Types type = Types.PLANT;
    private static final Types weakness = Types.WATER;
    private int dmg = 30;

    public Treant(String name) {
        this.name = name;
    }

    @Override
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
