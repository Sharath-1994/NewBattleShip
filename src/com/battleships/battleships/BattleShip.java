package com.battleships.battleships;

import com.battleships.Missiles;


import com.battleships.ships.Ships;
import com.battleships.userinput.UserInput;


//Purpose of this class is to create battleShip
public class BattleShip {

    private int dimensionWidth;
    private int dimensionHeight;
    private int[][] battleShipArea;
    private Ships ship;
    private Missiles missiles;

    public Missiles getMissiles() {
        return missiles;
    }

    public void setMissiles(Missiles missiles) {
        this.missiles = missiles;
    }

    public int[][] getBattleShipArea() {

        return battleShipArea;
    }


    public int getDimensionHeight() {

        return dimensionHeight;
    }

    public int getDimensionWidth() {

        return dimensionWidth;
    }

    public void setDimensionWidth(int dimensionWidth) {

        this.dimensionWidth = dimensionWidth;
    }

    public void setDimensionHeight(int dimensionHeight) {

        this.dimensionHeight = dimensionHeight;
    }

    public void setBattleShipArea() {
        this.battleShipArea = new int[dimensionWidth][dimensionHeight];

    }

    public void createBattleShipArea() {
        UserInput input = new UserInput();

        int height = Integer.parseInt(input.getUserInput("Enter battle Ship Dimension by width : "));
        int width = Integer.parseInt(input.getUserInput("Enter battle Ship Dimension by height : "));
        setDimensionHeight(height);
        setDimensionWidth(width);
        setBattleShipArea();

    }

    public static void printArray(int[][] a) {

        for (int row = 0; row < a.length; row++) {
            for (int col = 0; col < a[row].length; col++) {
                System.out.print(a[row][col] + " ");
            }
            System.out.println("");
        }

    }

    public static void addElementInArrayByDimension(int[][] a, int battleShipWidth, int bsHeight, int shipType,
                                                    int dimensionOfShipFromWidth, int dimensionOfShipFromHeight) throws Exception {

        int[][] b = a;


        for (int row = dimensionOfShipFromWidth; row < dimensionOfShipFromWidth + battleShipWidth; row++) {

            for (int col = dimensionOfShipFromHeight; col < dimensionOfShipFromHeight + bsHeight; col++) {

                if (b[row][col] == 0) {

                    b[row][col] = shipType;
                } else {
                    throw new Exception("Unable to add ship as other ship already exists");
                }
            }
        }

    }

    // Attacking player logic
    public static boolean Attack(int[][] a, int row, int col) {

        int[][] b = a;

        if (b[row][col] == 1 || b[row][col] == 2) {
            System.out.println(b[row][col]);
            b[row][col] = b[row][col] - 1;
            return true;
        }
        return false;
    }

    //Code to check the result of player
    public static boolean checkResult(int[][] a) {

        boolean searchResult = false;

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] == 1 || a[i][j] == 2) {
                    searchResult = true;
                    break;
                }
            }
        }

        if (searchResult) {
            return true;
        } else {
            return false;
        }

    }

}



