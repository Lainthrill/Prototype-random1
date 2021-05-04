package com.Lainthrill.random1.logic.Monsters;

public enum Types{
    FIRE("fire"),//lava monster
    WATER("water"),//krakken
    ELECTRICITY("electricity"),//energy elemental
    PLANT("plant");//treant


    private final String type;

    Types(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
