package com.battleships.ships;
//one type of battleShip in the game which is "P"


import com.battleships.player.Player;
import com.battleships.userinput.UserInput;

public class PBattleShip extends Ships {

    private int battleShipStrength = 1;
    private int locationOfShipWidth;
    private int locationOfShipHeight;


    public int getLocationOfShipWidth() {
        return locationOfShipWidth;
    }


    public int getLocationOfShipHeight() {
        return locationOfShipHeight;
    }


    public void setLocationOfShipWidth(int locationOfShipWidth) {
        this.locationOfShipWidth = locationOfShipWidth;
    }


    public void setLocationOfShipHeight(int locationOfShipHeight) {
        this.locationOfShipHeight = locationOfShipHeight;
    }

    public int getBattleShipStrength() {
        return battleShipStrength;
    }

    public void setBattleShipStrength(int battleShipStrength) {
        this.battleShipStrength = battleShipStrength;
    }

    //Converting A1 location to 01 where A = 0;
    public void convertCharToNumber(String prompt) {

        UserInput input = new UserInput();
        Player p = new Player();
        System.out.print(prompt + ": ");
        String inputLocation = input.getUserInput("");
        setLocationOfBattleShip(inputLocation);


        int conversionNumber = Ships.checkChar(getLocationOfBattleShip());
        setLocationOfShipWidth(conversionNumber);


        int conversionNumber1 = Ships.checkNumber(getLocationOfBattleShip());
        setLocationOfShipHeight(conversionNumber1);

    }


    public void takeDimensionOfBattleShipP(){
        UserInput input = new UserInput();

        int width = Integer.parseInt(input.getUserInput("Enter Width of BattleShip P:"));
        int height = Integer.parseInt(input.getUserInput("Enter Height of BattleShip P:"));
        setShipHeight(height);
        setShipWidth(width);

    }


}
