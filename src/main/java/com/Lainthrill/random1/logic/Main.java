package com.Lainthrill.random1.logic;


import com.Lainthrill.random1.logic.Monsters.EnergyElemental;
import com.Lainthrill.random1.logic.Monsters.Krakken;
import com.Lainthrill.random1.logic.Monsters.LavaMonster;
import com.Lainthrill.random1.logic.Monsters.Treant;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }

        System.out.println("M-M-M-M-M-MONSTER FIGHTER !!!!");

        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }

        MonsterTeams monsterTeams = new MonsterTeams();

        for (int i = 0; i < 4; i++) {
            selectMonsters(monsterTeams);
        }

        addAiMonsters(monsterTeams);

    }

    public static void coinToss() {

    }

    public static void selectMonsters(MonsterTeams monsterTeams) {
        System.out.println("Please,select a team of four monsters.\n"
                + "1. Lava Monster\n"
                + "2. Treant\n"
                + "3. Energy Elemental\n"
                + "4. Krakken\n");
        showPlayerTeam(monsterTeams);
        String monsterName;

        switch (input()) {
            case "1":
                System.out.println("Type the name you want to give to your monster," +
                        " and press enter .If you don't want to name it, just press enter.");
                monsterName = input();
                if (!monsterName.equals("")) {
                    monsterTeams.getPlayersList().add(new LavaMonster(monsterName));
                } else {
                    monsterTeams.getAiList().add(new LavaMonster(monsterName));
                }
                break;
            case "2":
                System.out.println("Type the name you want to give to your monster," +
                        " and press enter .If you don't want to name it, just press enter.");
                monsterName = input();
                if (!monsterName.equals("")) {
                    monsterTeams.getPlayersList().add(new Treant(monsterName));
                } else {
                    monsterTeams.getAiList().add(new Treant(monsterName));
                }
                break;
            case "3":
                System.out.println("Type the name you want to give to your monster," +
                        " and press enter . If you don't want to name it, just press enter.");
                monsterName = input();
                if (!monsterName.equals("")) {
                    monsterTeams.getPlayersList().add(new EnergyElemental(monsterName));
                } else {
                    monsterTeams.getAiList().add(new EnergyElemental(monsterName));
                }
                break;
            case "4":
                System.out.println("Type the name you want to give to your monster," +
                        " and press enter .If you don't want to name it, just press enter.");
                monsterName = input();
                if (!monsterName.equals("")) {
                    monsterTeams.getPlayersList().add(new Krakken(monsterName));
                } else {
                    monsterTeams.getAiList().add(new Krakken(monsterName));
                }
                break;
        }
    }

    private static void showPlayerTeam(MonsterTeams monsterTeams) {
        for (int i = 0; i < monsterTeams.getPlayersList().size(); i++) {
            System.out.println(monsterTeams.getPlayersList().get(i).getName());
        }
    }

    public static String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public static void addAiMonsters(MonsterTeams monsterTeams) {
        for (int i = 0; i < 4; i++) {
            Random random = new Random();
            int randomNumber = random.nextInt(4 - 1) + 1;
            if (randomNumber == 1) {
                    monsterTeams.getAiList().add(new LavaMonster("Lava Monster"));
            } else if (randomNumber == 2) {
                monsterTeams.getAiList().add(new Krakken("Krakken"));
            } else if (randomNumber == 3) {
                monsterTeams.getAiList().add(new Treant("Treant"));
            } else {
                monsterTeams.getAiList().add(new EnergyElemental("Energy Elemental"));
            }
        }
    }
}
