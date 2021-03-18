package io.zipcoder.casino.DiceGames.Craps;

import io.zipcoder.casino.DiceGames.Dices.Dice;
import io.zipcoder.casino.DiceGames.Dices.DiceGame;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.utilities.Console;

public class Craps extends DiceGame implements Game {
    Console console = new Console(System.in, System.out);
    Dice dice = new Dice();
    private Boolean playOrNot;


    public Integer firstWager() {
        Integer tablePot = console.getInteger("Please enter your wager.\n");
        return tablePot;
    }

    public Integer continueWagers() {
        Integer tablePot2 = console.getInteger("Please enter amount to add to pot");
        return tablePot2;
    }

    public boolean playOrNot() {
        return playOrNot;
    }

    public void runGame() {
        int playOrDont = console.getIntegerInput("Would you like to sit at the Craps table?\nEnter 1 for yes or 2 to exit to casino floor.");
        if (playOrDont == 1) {
            playCraps(firstWager(), true);
        } else if (playOrDont == 2) {
            System.out.println("Thank you for visiting the Craps Table.");

        } else {
            runGame();
        }
    }

    public void playCraps(Integer wager, boolean isChoosingPassLane) {
        Integer passOrDont = console.getIntegerInput("What would you like to bet on?\n1 for PASS LINE or 2 for DON'T PASS BAR or 3 to get up.");
        if (passOrDont == 1) {
            playGame(wager, true);
        } else if (passOrDont == 2) {
            playGame(wager, false);
        } else if (passOrDont == 3) {
            runGame();
        } else {
            playCraps(wager, playOrNot);
        }
    }

    private void playGame(int wager, boolean isChoosingPassLane){


        int roll = dice.roll2Dices();
        System.out.println(roll);
        if(isChoosingPassLane) {
            if (roll == 7 || roll == 11) {
                int winnings = playerwins(wager, roll);
                restartGame(winnings);
            } else if (roll == 2 || roll == 3 || roll == 12) {
                int losings = playerloses(wager, roll);
                restartGame(losings);
            } else {
                playSecondRound(wager, roll, isChoosingPassLane);
            }
        } else {
            if (roll == 2 || roll == 3) {
                int winnings = playerwins(wager, roll);
                restartGame(winnings);
            } else if (roll == 7 || roll == 11) {
                int losings = playerloses(wager, roll);
                restartGame(losings);
            } else if (roll == 12) {
                playerties(wager, roll);
            }
            playSecondRound(wager, roll, isChoosingPassLane);
        }

    }


    private void playSecondRound(int wager, int roll, boolean isChoosingPassLine){

        if(isChoosingPassLine){
            int second_roll = dice.roll2Dices();
            if(second_roll == roll){
                int winnings = playerwins(wager, second_roll);
                restartGame(winnings);
            } else{
                int losings = playerloses(wager, second_roll);
                restartGame(losings);
            }
        }else{
            int second_roll = dice.roll2Dices();
            while(second_roll != roll || second_roll != 7){
                second_roll = dice.roll2Dices();
            }
            if(second_roll == roll) {
                int losings = playerloses(wager, roll);
                restartGame(losings);
            }else{
                int winnings = playerwins(wager, roll);
                restartGame(winnings);

            }
        }
    }

    private boolean winPassBetSecondRound(int roll){
        while(true){
            int second_roll = dice.roll2Dices();
            if(second_roll == 7) return false;
            if(second_roll == roll) return true;
        }
    }

    private boolean losePassBetSecondRound(int roll){
        while(true){
            int second_roll = dice.roll2Dices();
            if(second_roll == 7) return true;
            if(second_roll == roll) return false;
        }
    }

    private int playerwins(int wager, int roll){
        System.out.println("your roll was " + roll);
        int winnings = wager * 2;
        return winnings;
    }
    private int playerloses(int wager, int roll){
        System.out.println("your roll was " + roll);
        return 0;
    }

    private int playerties(int wager, int roll){
        System.out.println("your roll was " + roll);
        int winnings = wager;
        return winnings;
    }

    private void restartGame(Integer wager){
        playCraps(wager,true);
    }







    public void countMoney(){}


    public void getResults() {
    }

    public void endGame() {

    }





}



