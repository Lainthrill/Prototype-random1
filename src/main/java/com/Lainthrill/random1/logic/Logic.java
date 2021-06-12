package com.Lainthrill.random1.logic;

import com.Lainthrill.random1.logic.Monsters.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    private MonsterTeams monsterTeams = new MonsterTeams();

    public boolean someoneHasWon = false;
    public String player1;
    public boolean player1sTurn;
    public String player2;
    public boolean player2sTurn;
    public Monster player1Monster;
    public Monster player2Monster;
    public int turn = 0;

    public void battle(MonsterTeams monsterTeams) {
        int turn = 0;
        while (!someoneHasWon) {
            turn++;
            if (turn == 1) {
                setPlayers();
                player1Monster = monsterTeams.getPlayersList().get(chooseMonster(monsterTeams));
                player2Monster = monsterTeams.getAiList().get(chooseMonster(monsterTeams));
            }
            if (player1sTurn) {
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
                            player1Monster = monsterTeams.getPlayersList().get(chooseMonster(monsterTeams));
                            break;
                        case "3":
                            player1Monster.defend();
                            break;
                    }
                }

            } else {
                System.out.println("It's Player 2's turn.");
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
                            player1Monster = monsterTeams.getPlayersList().get(chooseMonster(monsterTeams));
                            break;
                        case "3":
                            player1Monster.defend();
                            break;
                    }
                }
            }
        }
    }

    public int chooseMonster(MonsterTeams monsterTeams) {
        if (turn == 1) {//turn one, both player chooses their monster to fight first
            System.out.println("Choose a monster from your team to fight.");
            for (int i = 0; i < monsterTeams.getPlayersList().size(); i++) {
                System.out.println( i + "" + monsterTeams.getPlayersList().get(i).getName());
            }
        } else if (player1sTurn && player1.equals("AI") || player2sTurn && player2.equals("AI")){
            //AI's turn to choose their monster if they want or have to if their monster lost all their health
            Random random = new Random();
            return random.nextInt(4) + 1;
        } else if (player1sTurn && player1.equals("Human") || player2sTurn && player2.equals("Human")){
            //Human player's turn to choose their monster if they want or have to if their monster lost all their health

        } else {
            showInvalidAction();
            chooseMonster(monsterTeams);
        }
        return 0;
    }

    public void setPlayers() {
        int whoIsPlayer1 = coinToss();
        if (whoIsPlayer1 == 1) {
            player1 = "Human";
            player2 = "AI";
        } else {
            player1 = "AI";
            player2 = "Human";
        }
        player1sTurn = true;
    }

    public void cleanScreen() {
        for (int i = 0; i < 5; i++) {
            System.out.println("");
        }
    }

    public void selectDifficulty(MonsterTeams monsterTeams) {
        System.out.println("Select a difficulty\n"
                + "1. Easy\n"
                + "2. Normal");
        cleanScreen();
        String difficulty = inputString();
        if (!difficulty.equals("1") && !difficulty.equals("2")) {
            showInvalidAction();
            selectDifficulty(monsterTeams);
        }
        setDifficulty(difficulty,monsterTeams);
    }

    public int coinToss() {
        Random random = new Random();
        return random.nextInt(2) + 1;
    }

    public void setDifficulty(String  difficulty,MonsterTeams monsterTeams) {
        if (difficulty.equals("1")) {
            System.out.println("You can see you opponent's team," +
                    "and choose your monsters after that. This allows " +
                    "you to choose creatures that are more effective " +
                    "against your opponents monsters.");
            System.out.println("The enemy team consist of :\n");
            addAiMonsters(monsterTeams);
            for (int i = 0; i < monsterTeams.getAiList().size(); i++) {
                System.out.println(monsterTeams.getAiList().get(i).getName());
            }
            cleanScreen();
            for (int i = 0; i < 4; i++) {
                selectMonsters(monsterTeams);
            }
        } else if (difficulty.equals("2")) {
            System.out.println("You won't see your opponent's " +
                    "monsters until you fight them,choose your " +
                    "monsters wisely !");
            for (int i = 0; i < 4; i++) {
                selectMonsters(monsterTeams);
            }
            addAiMonsters(monsterTeams);
        }
    }

    public void selectMonsters(MonsterTeams monsterTeams) {
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
                    monsterTeams.getPlayersList().add(new LavaMonster("Lava Monster"));
                }
                break;
            case "2":
                System.out.println("Type the name you want to give to your monster," +
                        " and press enter .If you don't want to name it, just press enter.");
                monsterName = inputString();
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
            default:
                showInvalidAction();
                selectMonsters(monsterTeams);
        }
    }

    public void showPlayerTeam(MonsterTeams monsterTeams) {
        System.out.println("Your team: ");
        for (int i = 0; i < monsterTeams.getPlayersList().size(); i++) {
            System.out.println(monsterTeams.getPlayersList().get(i).getName());
        }
    }

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void addAiMonsters(MonsterTeams monsterTeams) {
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

    public void showInvalidAction() {
        System.out.println("##############################################################\n"
                + "#Invalid Action,please read the description below carefully !#\n" +
                "##############################################################\n");
    }

    public void switchTurns() {
        if (!player1sTurn){
            player1sTurn = true;
            player2sTurn = false;
        } else if (!player2sTurn) {
            player2sTurn = true;
            player1sTurn = false;
        }
    }

    public boolean isSomeoneHasWon() {
        return someoneHasWon;
    }

    public String getPlayer1() {
        return player1;
    }

    public boolean isPlayer1sTurn() {
        return player1sTurn;
    }

    public String getPlayer2() {
        return player2;
    }

    public boolean isPlayer2sTurn() {
        return player2sTurn;
    }

    public Monster getPlayer1Monster() {
        return player1Monster;
    }

    public Monster getPlayer2Monster() {
        return player2Monster;
    }

    public int getTurn() {
        return turn;
    }

    public MonsterTeams getMonsterTeams() {
        return monsterTeams;
    }
}
