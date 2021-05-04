package com.Lainthrill.random1.logic.Monsters;

public class Treant extends Monster{
    private String name;
    private int hp = 135;
    private static final Types TYPE = Types.PLANT;
    private static final Types WEAKNESS = Types.WATER;
    private int dmg = 30;
    private static boolean isDefending;

    public Treant(String name) {
        this.name = name;
    }

    public boolean isIsDefending() {
        return isDefending;
    }

    public void setIsDefending(boolean isDefending) {
        Treant.isDefending = isDefending;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void attack(Monster playerMonster) {
        if (playerMonster.isIsDefending()) {
            playerMonster.setHp(playerMonster.getHp() - (getDmg() / 2));
        } else {
            playerMonster.setHp(playerMonster.getHp() - getDmg());
        }
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
