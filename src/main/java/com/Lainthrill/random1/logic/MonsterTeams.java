package com.Lainthrill.random1.logic;

import com.Lainthrill.random1.logic.Monsters.Monster;

import java.util.ArrayList;
import java.util.List;

public class MonsterTeams {

    private List<Monster> playersList = new ArrayList<>();
    private List<Monster> aiList = new ArrayList<>();

    public List<Monster> getPlayersList() {
        return playersList;
    }

    public List<Monster> getAiList() {
        return aiList;
    }

    public void addMonsterForPlayer(Monster monster) {
        playersList.add(monster);
    }

    public void addMonsterForAI(Monster monster) {
        aiList.add(monster);
    }
}
