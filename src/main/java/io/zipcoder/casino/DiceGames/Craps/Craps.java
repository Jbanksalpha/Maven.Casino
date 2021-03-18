package io.zipcoder.casino.DiceGames.Craps;

import io.zipcoder.casino.DiceGames.Dices.Dice;
import io.zipcoder.casino.DiceGames.Dices.DiceGame;
import io.zipcoder.casino.Games.Game;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

public class Craps extends DiceGame implements Game {
    Console console = new Console(System.in, System.out);
    Dice dice = new Dice();
    Player player;

    public Craps(Player player) {this.player = player;
    }

    public void runGame() {
        int playOrDont = console.getIntegerInput("Would you like play at the Craps table?\nEnter 1 for yes or 2 to exit this part of the casino floor.");
        System.out.println("Your current balance is " + player.getBalance());
        if (playOrDont == 1 ) {
            passOrDont();
        } else if (playOrDont == 2) {

            System.out.println("Thank you for visiting the Craps Table.");

        } else {
            System.out.println("Stop wasting our time. There's others who want to play!");
            runGame();
        }
    }

    public double getWager(){
        System.out.println("You have $" + player.getBalance() + " to bet.");
        double tablePot = console.getDoubleInput("Please enter your wager: ");
        if (tablePot <= 0){
            System.out.println("Please enter a positive amount. We can't give you money");
            tablePot = console.getDoubleInput("Please enter your wager: ");
        }
        return tablePot;
    }

    public void passOrDont(){
        Integer passOrDont = console.getIntegerInput("What would you like to bet on?\n1 for PASS LINE or 2 for DON'T PASS BAR or 3 to get up.");
        double remainingBal;

        if(passOrDont == 1) {
            double tablePot = getWager();
            remainingBal = player.getBalance() - tablePot;
            player.setBalance(remainingBal);
            playGame((int) tablePot, true);
        }
        else if(passOrDont == 2){
            double tablePot = getWager();
            remainingBal = player.getBalance() - tablePot;
            player.setBalance(remainingBal);
            playGame((int) tablePot, false);
        }
        else {passOrDont();}
    }


    private void playGame(int wager, boolean isPassLine) {

        if (isPassLine == true) {
            GameState outcome = playPassBet();
            endGame(wager, outcome);
        }else {
            GameState outcome = playDontPassLaneBet();
            endGame(wager, outcome);
        }
    }

    private GameState playPassBet() {
        String rollThisDice = console.getStringInput("Enter anything to roll the dices");
        int roll = dice.roll2Dices();
        System.out.println("The total of the two dice is " + roll);
        if (roll == 7 || roll == 11) {
            return GameState.Win;
        }
        if (roll == 2 || roll == 3 || roll == 12) {
            return GameState.Lose;
        }
        System.out.println("The point number is set at " + roll);
        int secondRoll = playSecondRound(roll);
        if(secondRoll == roll){return GameState.Win;}
        else return GameState.Lose;
    }

    private GameState playDontPassLaneBet() {
        String rollThisDice = console.getStringInput("Enter anything to roll the dices");
        int roll = dice.roll2Dices();
        System.out.println("The total of the two dice is " + roll);
        if (roll == 2 || roll == 3) {
            return GameState.Win;
        }
        if (roll == 7 || roll == 11) {
            return GameState.Lose;
        }
        if (roll == 12) {
            return GameState.Push;
        }
        System.out.println("The point number is set at " + roll);
        int secondRoll = playSecondRound(roll);
        if(secondRoll == 7){return GameState.Win;}
        else return GameState.Lose;
    }


    private int playSecondRound(int roll) {
        double rollAgain = console.getDoubleInput("Press 1 to roll.");
        int secondRoll = 0;
        System.out.println("Phase2:\nThe total of the two dice is " + secondRoll);

        while (secondRoll !=7 || secondRoll == roll){

        if (rollAgain == 1){
            double rollAgain2 = console.getDoubleInput("Press 1 to roll.");
            secondRoll = dice.roll2Dices();
            System.out.println("Phase2:\nThe total of the two dice is " + secondRoll);
            return secondRoll;
            }
            else{
                System.out.println("What are you waiting for! Keep throwing the dices!!!");
                break;
            }

        }

        return secondRoll;
    }

    private void endGame(int wager, GameState outcome) {

        if(outcome == GameState.Win){
        double playersCurrentBalance = player.getBalance();
        double totalWinnings = wager * 2;
        player.setBalance(playersCurrentBalance + totalWinnings);
        System.out.println("Congratulations! You got the winning roll. You got the table pot for a total of $" + totalWinnings + "\nYour current balance is $" + player.getBalance());
        Integer continuePlaying = console.getInteger("\nDo you want to continue playing?\nEnter 1 for yes or 2 to walk away.\n");
        if(continuePlaying == 1){
            passOrDont();
        }else if(continuePlaying == 2){
            runGame();
        }else{
            System.out.println("We're waiting for you to decide.");
            }
        }

        if(outcome == GameState.Lose){
        double playersCurrentBalance = player.getBalance();
        double totalWinnings = 0;
        player.setBalance(playersCurrentBalance + totalWinnings);
        System.out.println("Sorry! You got the losing roll. You did not win anything.\nYour current balance is " + player.getBalance());
        Integer continuePlaying = console.getInteger("\nDo you want to continue playing?\nEnter 1 for yes or 2 to walk away.\n");
        if(continuePlaying == 1){
                passOrDont();
        }else if(continuePlaying == 2){
               runGame();
        }else{
            System.out.println("\nWe're waiting for you to decide.");
            }
        }

        if(outcome == GameState.Push){
        double playersCurrentBalance = player.getBalance();
        double totalWinnings = wager;
        player.setBalance(playersCurrentBalance + totalWinnings);
        System.out.println("The roll was a 12. Your wager is pushed back to you.\nYour balance is $" + player.getBalance());
        Integer continuePlaying = console.getInteger("\nDo you want to continue playing?\nEnter 1 for yes or 2 to walk away.\n");
            if(continuePlaying == 1){
                passOrDont();
            }else if(continuePlaying == 2){
                runGame();
            }else{
                System.out.println("We're waiting for you to decide.");
            }
        }


    }
}





