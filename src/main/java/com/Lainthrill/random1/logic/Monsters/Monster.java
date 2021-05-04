package com.Lainthrill.random1.logic.Monsters;

public abstract class Monster {
    public static String name;
    public static int hp;
    public static Types type;
    public static Types weakness;
    public static int dmg;
    public static boolean isDefending;

    public boolean isIsDefending() {
        return isDefending;
    }

    public void setIsDefending(boolean isDefending) {
        Monster.isDefending = isDefending;
    }

    public abstract void attack(Monster playerMonster);

    public abstract void defend();

    public abstract void switchMonster();

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public Types getType() {
        return type;
    }

    public Types getWeakness() {
        return weakness;
    }

    public int getDmg() {
        return dmg;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
