package com.Lainthrill.random1.logic;


import com.Lainthrill.random1.logic.Monsters.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static Logic logic = new Logic();

    public static void main(String[] args) {
        logic.cleanScreen();
        System.out.println("M-M-M-M-M-MONSTER FIGHTER !!!!");
        logic.cleanScreen();
        logic.selectDifficulty(logic.getMonsterTeams());
        for (int i = 0; i < logic.getMonsterTeams().getPlayersList().size(); i++) {
            System.out.println(logic.getMonsterTeams().getPlayersList().get(i).getName());
        }
        logic.battle(logic.getMonsterTeams());
    }
}
