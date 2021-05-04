package com.Lainthrill.random1.logic.Monsters;

public abstract class Monster {
    public static String name;
    public static int hp;
    public static Types type;
    public static Types weakness;
    public static int dmg;

    public abstract void attack();

    public abstract void defend();

    public abstract void switchMonster();

    public String getName() {
        return name;
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
