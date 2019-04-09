package com.battleships.ships;
//Another type of battleShip in the game type "Q"


import com.battleships.player.Player;
import com.battleships.userinput.UserInput;

public class QBattleShip extends Ships {

    private int battleShipStrength= 2;
    private int locationOfShipWidth;
    private int locationOfShipHeight;

    public int getBattleShipStrength() {
        return battleShipStrength;
    }

    public void setBattleShipStrength(int battleShipStrength) {
        this.battleShipStrength = battleShipStrength;
    }

    public int getLocationOfShipWidth() {
        return locationOfShipWidth;
    }

    public void setLocationOfShipWidth(int locationOfShipWidth) {
        this.locationOfShipWidth = locationOfShipWidth;
    }

    public int getLocationOfShipHeight() {
        return locationOfShipHeight;
    }

    public void setLocationOfShipHeight(int locationOfShipHeight) {
        this.locationOfShipHeight = locationOfShipHeight;
    }

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


    public void takeDimensionOfBattleShipQ(){
        UserInput input = new UserInput();

        int width = Integer.parseInt(input.getUserInput("Enter Width of BattleShip Q:"));
        int height = Integer.parseInt(input.getUserInput("Enter Height of BattleShip Q:"));
        setShipHeight(height);
        setShipWidth(width);

    }
}
