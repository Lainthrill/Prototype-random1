package com.Lainthrill.random1.logic.Monsters;

public class Krakken extends Monster {
    private String name;
    private int hp = 150;
    private static final Types TYPE = Types.WATER;
    private static final Types WEAKNESS = Types.ELECTRICITY;
    private int dmg = 20;
    private static boolean isDefending;

    public Krakken(String name) {
        this.name = name;
    }

    public boolean isIsDefending() {
        return isDefending;
    }

    public void setIsDefending(boolean isDefending) {
        Krakken.isDefending = isDefending;
    }

    public String getName() {
        return name;
    }

    @Override
    public void attack(Monster playerMonster) {
        int damageMultiplier = 0;
        if (playerMonster.getWeakness() == getType()) {
            damageMultiplier += 2;
        }
        if (playerMonster.isIsDefending()) {
            damageMultiplier /= 2;
        }
        playerMonster.setHp(playerMonster.getHp() - (getDmg() + getDmg() * 2));
    }

    @Override
    public void defend() {
        isDefending = true;
    }

    @Override
    public void switchMonster() {

    }

    public int getHp() {
        return hp;
    }

    public Types getType() {
        return TYPE;
    }

    public Types getWeakness() {
        return WEAKNESS;
    }

    public int getDmg() {
        return dmg;
    }
}
