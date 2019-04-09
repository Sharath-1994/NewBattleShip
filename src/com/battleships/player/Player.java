package com.battleships.player;

//Purpose of the class is to create and hold the details of player


public class Player {

    private String name;

    public String getName() {

        return name;
    }


    public Player(String name) {
        this.name = name;
    }

    public Player() {

    }

    public static String hitLogic(int number) {

        String hitResultName = null;
        switch (number) {

            case 1:
                hitResultName = "Hit";
                break;

            case 0:
                hitResultName = "Miss";
                break;
        }

        return hitResultName;

    }

    public static String playerLogic(int number) {

        String playerName = null;

        switch (number) {
            case 1:
                playerName = "Player1 ";
                break;

            case 2:
                playerName = "Player2 ";
                break;
        }

        return playerName;

    }
}
