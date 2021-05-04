package com.Lainthrill.random1.logic;


import com.Lainthrill.random1.logic.Monsters.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static boolean someoneHasWon = false;
    public static boolean isRoundOne = true;
    public static String player1;
    public static String player2;
    public static Monster player1Monster;
    public static Monster player2Monster;

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
        int turn = 0;
        while (!someoneHasWon) {
            if (isRoundOne){
                setPlayers();
            }
            turn++;
            if (turn == 1) {
                player1Monster = monsterTeams.getPlayersList().get(chooseMonster(turn,monsterTeams));
                player2Monster = monsterTeams.getAiList().get(chooseMonster(turn,monsterTeams));
            }
            if (turn % 2 == 0) {
                System.out.println("It's Player 1's turn.");
                if (player1.equals("Human")) {
                    cleanScreen();
                    System.out.println("Choose your action: \n" +
                            "1. Attack\n" +
                            "2. Switch Monster\n" +
                            "3. Defend\n");
                    cleanScreen();
                    String input = inputString();
                    switch (input) {
                        case "1":
                            player1Monster.attack(player2Monster);
                            break;
                        case "2":
                            player1Monster = monsterTeams.getPlayersList().get(chooseMonster(turn,monsterTeams));
                            break;
                        case "3":
                            player1Monster.defend();
                            break;
                    }

                }

            } else {
                System.out.println("It's Player 2's turn.");

            }
        }
    }

    public static int chooseMonster(int turn,MonsterTeams monsterTeams) {
        if (turn % 2 == 0) {
            System.out.println("Choose a monster from your team to fight.");
            for (int i = 0; i < monsterTeams.getPlayersList().size(); i++) {
                System.out.println( i + "" + monsterTeams.getPlayersList().get(i).getName());
            }
        } else {
            Random random = new Random();
            return random.nextInt(4) + 1;
        }
        return inputInt();
    }

    public static void setPlayers() {
        int whoIsPlayer1 = coinToss();
        if (whoIsPlayer1 == 1) {
            player1 = "Human";
            player2 = "AI";
        } else {
            player1 = "AI";
            player2 = "Human";
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
        String difficulty = inputString();
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

        switch (inputString()) {
            case "1":
                System.out.println("Type the name you want to give to your monster," +
                        " and press enter .If you don't want to name it, just press enter.");
                monsterName = inputString();
                if (!monsterName.equals("")) {
                    monsterTeams.getPlayersList().add(new LavaMonster(monsterName));
                } else {
                    monsterTeams.getPlayersList().add(new LavaMonster(monsterName));
                }
                break;
            case "2":
                System.out.println("Type the name you want to give to your monster," +
                        " and press enter .If you don't want to name it, just press enter.");
                monsterName = inputString();//"" esetén nem adja a base nevet,itt lekezelni 67.sor monsterName helyett Lava Monster
                if (!monsterName.equals("")) {
                    monsterTeams.getPlayersList().add(new Treant(monsterName));
                } else {
                    monsterTeams.getPlayersList().add(new Treant("Treant"));
                }
                break;
            case "3":
                System.out.println("Type the name you want to give to your monster," +
                        " and press enter . If you don't want to name it, just press enter.");
                monsterName = inputString();
                if (!monsterName.equals("")) {
                    monsterTeams.getPlayersList().add(new EnergyElemental(monsterName));
                } else {
                    monsterTeams.getPlayersList().add(new EnergyElemental("Energy Elemental"));
                }
                break;
            case "4":
                System.out.println("Type the name you want to give to your monster," +
                        " and press enter .If you don't want to name it, just press enter.");
                monsterName = inputString();
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

    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
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
