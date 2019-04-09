package com.battleships;

import com.battleships.userinput.UserInput;

import java.util.ArrayList;

//Class to hold data of missiles

public class Missiles {

    private int numberOfMissile;

    private boolean isMissileLocationEmpty;

//Method which holds the list of missiles for each player
    public ArrayList<String> missileTargetList(String missile) {

        ArrayList<String> missileList = new ArrayList<String>();

        UserInput u = new UserInput();

        int resultNumber = getNumberOfMissile();
        while (resultNumber > 0) {
            missileList.add(u.getUserInput(""));
            resultNumber--;
        }

        return missileList;

    }

    public int getNumberOfMissile() {
        return numberOfMissile;
    }

    public void setNumberOfMissile(int numberOfMissile) {
        this.numberOfMissile = numberOfMissile;
    }

    // Logic to check while placing ship to battle field
    public static int checkChar(String a) {

        char firstCharacter = a.charAt(0);
        int numbers = 0;

        switch (firstCharacter) {

            case 'A':
                numbers = 0;
                break;
            case 'B':
                numbers = 1;
                break;
            case 'C':
                numbers = 2;
                break;
            case 'D':
                numbers = 3;
                break;
            case 'E':
                numbers = 4;
                break;
            case 'F':
                numbers = 5;
                break;

            case 'G':
                numbers = 6;
                break;
        }

        return numbers;

    }

    // Logic to check while placing ship to battle field
    public static int checkNumber(String dimension) {
        String a = dimension;
        char a1 = a.charAt(1);

        int result = 0;
        switch (a1) {

            case '1':
                result = 0;
                break;
            case '2':
                result = 1;
                break;
            case '3':
                result = 2;
                break;
            case '4':
                result = 3;
                break;
            case '5':
                result = 4;
                break;
            case '6':
                result = 5;
                break;
            case '7':
                result = 6;
                break;
            case '8':
                result = 7;
                break;
            case '9':
                result = 8;
                break;

        }

        return result;
    }


}
