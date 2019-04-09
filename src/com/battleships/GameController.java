package com.battleships;

import com.battleships.battleships.BattleShip;
import com.battleships.player.Player;
import com.battleships.ships.PBattleShip;
import com.battleships.ships.QBattleShip;
import com.battleships.userinput.UserInput;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    UserInput input;

    Player player1;
    Player player2;

    BattleShip b1;
    BattleShip b2;

    PBattleShip player1PBattleShipP;
    PBattleShip player2PBattleShipP;

    QBattleShip player1BattleShipQ;
    QBattleShip player2BattleShipQ;

    // Status to check results of player 1
    private static boolean resultPlayer1 = false;

    // Status to check results of player 2
    private static boolean resultPlayer2 = false;

    //prints list of messages based on attack between 2 players
   private static List<String> message = new ArrayList<>();

    //Flag to identify hit or miss where Hit is 0 and not Hit is 1
    private static int hit = -1;

    //Flag to identify current player where Player 1 is 1 and Player 2 is 2
    private static int currentPlayer = -1;


    private ArrayList<String> player1MissileList = new ArrayList<>();
    private ArrayList<String> player2MissileList = new ArrayList<>();

    public void gameStart() throws Exception {

        createPlayerList();
        createBattleShipForPlayers();


        setDimensionOfBattleShipForP();


        player1PBattleShipP.convertCharToNumber("Location Of BattleShip P for " + player1.getName());
        player2PBattleShipP.convertCharToNumber("Location Of BattleShip P for " + player2.getName());

        BattleShip.addElementInArrayByDimension(b1.getBattleShipArea(), player1PBattleShipP.getShipWidth(), player1PBattleShipP.getShipHeight(),
                player1PBattleShipP.getBattleShipStrength(), player1PBattleShipP.getLocationOfShipWidth(), player1PBattleShipP.getLocationOfShipHeight());

        BattleShip.addElementInArrayByDimension(b2.getBattleShipArea(), player2PBattleShipP.getShipWidth(), player2PBattleShipP.getShipHeight(),
                player2PBattleShipP.getBattleShipStrength(), player2PBattleShipP.getLocationOfShipWidth(), player2PBattleShipP.getLocationOfShipHeight());

        setDimensionOfBattleShipQ();

        player1BattleShipQ.convertCharToNumber("Location Of BattleShip Q for " + player1.getName());
        player2BattleShipQ.convertCharToNumber("Location Of BattleShip Q for " + player2.getName());

        BattleShip.addElementInArrayByDimension(b1.getBattleShipArea(), player1BattleShipQ.getShipWidth(), player1BattleShipQ.getShipHeight(),
                player1BattleShipQ.getBattleShipStrength(), player1BattleShipQ.getLocationOfShipWidth(), player1BattleShipQ.getLocationOfShipHeight());

        BattleShip.addElementInArrayByDimension(b2.getBattleShipArea(), player2BattleShipQ.getShipWidth(), player2BattleShipQ.getShipHeight(),
                player2BattleShipQ.getBattleShipStrength(), player2BattleShipQ.getLocationOfShipWidth(), player2BattleShipQ.getLocationOfShipHeight());


        System.out.println("Player 1 battleship");
        BattleShip.printArray(b1.getBattleShipArea());

        System.out.println("Player 2 battleship");
        BattleShip.printArray(b2.getBattleShipArea());


        setMissileLocationForPlayer1();
        setMissileLocationForPlayer2();

        attack();

        for(String message : message){
            System.out.println(message);
        }


    }
//Creates BattleShipDimenionforBothPlayers

    public void createBattleShipForPlayers() {
        b1 = new BattleShip();
        b1.createBattleShipArea();


        b2 = new BattleShip();
        b2.setDimensionHeight(b1.getDimensionHeight());
        b2.setDimensionWidth(b1.getDimensionWidth());
        b2.setBattleShipArea();


    }

    //Creates Player Names
    public void createPlayerList() {
        input = new UserInput();
        System.out.print("Enter Player1 name : ");
        String name1 = input.getUserInput("");


        player1 = new Player(name1);


        System.out.print("Enter Player2 name : ");
        String name2 = input.getUserInput("");

        player2 = new Player(name2);

    }

    public void setMissileLocationForPlayer1() {
        Missiles missiles = new Missiles();
        int player1MissileNumber = Integer.parseInt(input.getUserInput("Enter how many missiles Player 1 wants"));
        missiles.setNumberOfMissile(player1MissileNumber);


        System.out.println("Enter Missile of Player 1");
        player1MissileList = missiles.missileTargetList("");
    }

    public void setMissileLocationForPlayer2() {
        Missiles missiles = new Missiles();
        int player1MissileNumber = Integer.parseInt(input.getUserInput("Enter how many missiles Player 2 wants"));
        missiles.setNumberOfMissile(player1MissileNumber);


        System.out.println("Enter Missile of Player 2");
        player2MissileList = missiles.missileTargetList("");
    }

    public void setDimensionOfBattleShipForP() {

        player1PBattleShipP = new PBattleShip();
        player1PBattleShipP.takeDimensionOfBattleShipP();
        player2PBattleShipP = new PBattleShip();
        player2PBattleShipP.setShipWidth(player1PBattleShipP.getShipWidth());
        player2PBattleShipP.setShipHeight(player1PBattleShipP.getShipHeight());

    }

    public void setDimensionOfBattleShipQ() {
        player1BattleShipQ = new QBattleShip();
        player1BattleShipQ.takeDimensionOfBattleShipQ();

        player2BattleShipQ = new QBattleShip();
        player2BattleShipQ.setShipWidth(player1BattleShipQ.getShipWidth());
        player2BattleShipQ.setShipHeight(player1BattleShipQ.getShipHeight());

    }

    public void attack(){

        int lengthOfBothArray = player1MissileList.size() + player1MissileList.size();

        // Initial calling of Player 1
        if (hit == -1) {
            currentPlayer = 1;
            player1MissileList = GameController.chanceToNextPlayer(b2.getBattleShipArea(), player1MissileList);

        }

        for (int i = 0; i < lengthOfBothArray; i++) {
            resultPlayer1 = BattleShip.checkResult(b2.getBattleShipArea());
            resultPlayer2 = BattleShip.checkResult(b1.getBattleShipArea());
            if (resultPlayer1 == false) {
                message.add("Player 1 Wins");
                break;
            } else if (resultPlayer2 == false) {
                message.add("Player 2 Wins");
                break;
            } else if (player1MissileList.size() == 0 && player2MissileList.size() == 0
                    && (resultPlayer1 && resultPlayer2) == true) {

                message.add("Match draw");
                break;

            }

            else {

                if (hit == 0 || hit == 1) {

                    switch (hit) {

                        case 1:
                            if (currentPlayer == 1) {

                                if (player2MissileList.size() == 0) {
                                    message.add("Player2 Runs out of missiles");
                                    chanceToNextPlayer(b2.getBattleShipArea(), player2MissileList);
                                    currentPlayer = 1;
                                } else {
                                    chanceToNextPlayer(b2.getBattleShipArea(), player1MissileList);

                                    break;
                                }

                            } else if (currentPlayer == 2) {

                                if (player1MissileList.size() == 0) {
                                    message.add("Player1 Runs out of missiles");
                                    chanceToNextPlayer(b1.getBattleShipArea(), player2MissileList);
                                    currentPlayer = 2;
                                } else {

                                    chanceToNextPlayer(b1.getBattleShipArea(), player2MissileList);
                                    break;
                                }
                            }

                        case 0:
                            if (currentPlayer == 1) {

                                if (player2MissileList.size() == 0) {
                                    message.add("Player2 Runs out of missiles");
                                    chanceToNextPlayer(b2.getBattleShipArea(), player1MissileList);
                                    currentPlayer = 1;
                                } else {
                                    currentPlayer = 2;
                                    chanceToNextPlayer(b1.getBattleShipArea(), player2MissileList);
                                }
                            } else if (currentPlayer == 2) {

                                if (player1MissileList.size() == 0) {
                                    message.add("Player1 Runs out of missiles");
                                    chanceToNextPlayer(b1.getBattleShipArea(), player2MissileList);
                                    currentPlayer = 2;
                                } else {
                                    currentPlayer = 1;
                                    chanceToNextPlayer(b2.getBattleShipArea(), player1MissileList);
                                }

                            }

                    }
                }
            }

        }


    }

    private static ArrayList<String> chanceToNextPlayer(int[][] player, ArrayList<String>  missile) {

        for (int i = 0; i < missile.size();) {

            String missileLocation = missile.get(i);
            int locationRow = Missiles.checkChar(missileLocation);
            int locationCol = Missiles.checkNumber(missileLocation);
            boolean hitResult = BattleShip.Attack(player, locationRow, locationCol);
            String hitNumber;
            String battleShipCurrentPlayer;

            if (hitResult == true) {
                hit = 1;
                hitNumber = Player.hitLogic(hit);
                battleShipCurrentPlayer = Player.playerLogic(currentPlayer);
                message.add(battleShipCurrentPlayer + " " + hitNumber + " " + missileLocation);
                missile.remove(i);
                return missile;
            } else {
                hit = 0;
                hitNumber = Player.hitLogic(hit);
                battleShipCurrentPlayer = Player.playerLogic(currentPlayer);
                message.add(battleShipCurrentPlayer + " " + hitNumber + " " + missileLocation);
                missile.remove(i);
                return missile;
            }

        }

        return missile;

    }


}
