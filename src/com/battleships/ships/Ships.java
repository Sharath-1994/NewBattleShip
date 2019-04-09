package com.battleships.ships;

//Abstract class to show the ship attributes

public abstract class Ships {


    private int shipHeight;
    private int shipWidth;
    //Eg A1,A3,B4 etc
    private String locationOfBattleShip;



    public int getShipHeight() {
        return shipHeight;
    }

    public void setShipHeight(int shipHeight) {
        this.shipHeight = shipHeight;
    }

    public int getShipWidth() {
        return shipWidth;
    }

    public void setShipWidth(int shipWidth) {
        this.shipWidth = shipWidth;
    }

    public String getLocationOfBattleShip() {
        return locationOfBattleShip;
    }

    public void setLocationOfBattleShip(String locationOfBattleShip) {
        this.locationOfBattleShip = locationOfBattleShip;
    }


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


