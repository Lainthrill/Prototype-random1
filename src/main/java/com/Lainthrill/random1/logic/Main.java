package com.Lainthrill.random1.logic;


import com.Lainthrill.random1.logic.Monsters.EnergyElemental;
import com.Lainthrill.random1.logic.Monsters.Krakken;
import com.Lainthrill.random1.logic.Monsters.LavaMonster;
import com.Lainthrill.random1.logic.Monsters.Treant;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static boolean someoneHasWon = false;
    public static boolean isRoundOne = true;

    int player1 = 1;
    int player2 = 2;

//    public static void main(String[] args) {
//        System.out.println(coinToss());
//    }

    public static void main(String[] args) {
        MonsterTeams monsterTeams = new MonsterTeams();

        cleanScreen();
        System.out.println("M-M-M-M-M-MONSTER FIGHTER !!!!");
        cleanScreen();
        selectDifficulty(monsterTeams);
        battle(monsterTeams);
    }

    private static void battle(MonsterTeams monsterTeams) {
        while (!someoneHasWon) {
            if (isRoundOne){
                int whoIsPlayer1 = coinToss();
                if (whoIsPlayer1 == 1) {

                }
            }
        }
    }

    private static void cleanScreen() {
        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }
    }

    private static void selectDifficulty(MonsterTeams monsterTeams) {
        System.out.println("Select a difficulty\n"
        + "1. Easy\n"
        + "2. Normal");
        cleanScreen();
        String difficulty = input();
        setDifficulty(difficulty,monsterTeams);
    }

    public static int coinToss() {
        Random random = new Random();
        return random.nextInt(2) + 1;
    }

    public static void setDifficulty(String difficulty,MonsterTeams monsterTeams) {
        if (difficulty.equals("1")) {
            System.out.println("You can see you opponent's team," +
                    "and choose your monsters after that. This allows " +
                    "you to choose creatures that are more effective " +
                    "against your opponents monsters.");
            System.out.println("The enemy team consist of :");
            System.out.println("");
            addAiMonsters(monsterTeams);
            for (int i = 0; i < monsterTeams.getAiList().size(); i++) {
                System.out.println(monsterTeams.getAiList().get(i).getName());
            }
            cleanScreen();
            selectMonsters(monsterTeams);
        } else if (difficulty.equals("2")) {
            System.out.println("You won't see your opponent's " +
                    "monsters until you fight them,choose your " +
                    "monsters wisely !");
            for (int i = 0; i < 4; i++) {
                selectMonsters(monsterTeams);
                addAiMonsters(monsterTeams);
            }
        }
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
                    monsterTeams.getPlayersList().add(new LavaMonster(monsterName));
                }
                break;
            case "2":
                System.out.println("Type the name you want to give to your monster," +
                        " and press enter .If you don't want to name it, just press enter.");
                monsterName = input();//"" esetén nem adja a base nevet,itt lekezelni 67.sor monsterName helyett Lava Monster
                if (!monsterName.equals("")) {
                    monsterTeams.getPlayersList().add(new Treant(monsterName));
                } else {
                    monsterTeams.getPlayersList().add(new Treant("Treant"));
                }
                break;
            case "3":
                System.out.println("Type the name you want to give to your monster," +
                        " and press enter . If you don't want to name it, just press enter.");
                monsterName = input();
                if (!monsterName.equals("")) {
                    monsterTeams.getPlayersList().add(new EnergyElemental(monsterName));
                } else {
                    monsterTeams.getPlayersList().add(new EnergyElemental("Energy Elemental"));
                }
                break;
            case "4":
                System.out.println("Type the name you want to give to your monster," +
                        " and press enter .If you don't want to name it, just press enter.");
                monsterName = input();
                if (!monsterName.equals("")) {
                    monsterTeams.getPlayersList().add(new Krakken(monsterName));
                } else {
                    monsterTeams.getPlayersList().add(new Krakken("Krakken"));
                }
                break;
        }
    }

    private static void showPlayerTeam(MonsterTeams monsterTeams) {
        System.out.println("Your team: ");
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
