package com.Lainthrill.random1.logic.Monsters;

public class EnergyElemental extends Monster{
    private String name;
    private int hp = 90;
    private static final Types TYPE = Types.ELECTRICITY;
    private static final Types WEAKNESS = Types.PLANT;
    private int dmg = 45;
    private static boolean isDefending;

    public EnergyElemental(String name) {
        this.name = name;
    }

    public boolean isIsDefending() {
        return isDefending;
    }

    public void setIsDefending(boolean isDefending) {
        EnergyElemental.isDefending = isDefending;
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
