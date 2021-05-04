package com.Lainthrill.random1.logic.Monsters;

public class EnergyElemental extends Monster{
    private String name;
    private int hp = 90;
    private static final Types type = Types.ELECTRICITY;
    private static final Types weakness = Types.PLANT;
    private int dmg = 45;

    public EnergyElemental(String name) {
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
