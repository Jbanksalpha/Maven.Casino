package io.zipcoder.casino.CardGames;
import io.zipcoder.casino.Menus.WelcomeMenu;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;

import sun.java2d.SurfaceDataProxy;


import java.util.Scanner;
//import io.zipcoder.casino.Menus.BlackjackMenu;
//import io.zipcoder.casino.Player;
//import io.zipcoder.casino.utilities.Console;


public class Blackjack extends CardGame {
    private final Player player;
    private double minBet;
        private double maxBet;
        private Console console = new Console(System.in, System.out);

    public Blackjack(Player player, double minBet, double maxBet) {
        this.player = player;
        this.minBet = minBet;
        this.maxBet = maxBet;
    }

    public  void runGame() {
        WelcomeMenu welcome = new WelcomeMenu();
        double playerMoney = player.getBalance();
        System.out.println("You currently have $" + player.getBalance());
        while (playerMoney >= 0.0) {


            double playerBet=console.getDoubleInput("Enjoy playing your game. Make your wager!!! \n or press 0 to exit game");
            if (playerBet == 0){
                welcome.returningPlayer(player);
            }

            if (playerBet<0){
                System.out.println("Duck you!");
                break;
            }

            if (playerBet > playerMoney) {
                System.out.println("You need more money to bet.");
                break;
            }
            boolean endRound = false;

            playerHand.drawFrom(dealCards());
            playerHand.drawFrom(dealCards());

            dealerHand.drawFrom(dealCards());
            dealerHand.drawFrom(dealCards());

            while (true) {
                System.out.print(playerHand.toString());

                System.out.println("\nYour hand is valued at " + playerHand.cardsValue() + "\n");
                System.out.println("The dealer's hand is valued at " + dealerHand.getCard(0).toString() + " and a hidden card.");
                int response = console.getInteger("Would you like to (1) Hit or (2) Stand?");
                if (response == 1) {
                    playerHand.drawFrom(dealCards());
                    System.out.println("\nYou got a: " + playerHand.getCard(playerHand.deckSize() - 1).toString() + "\n");

                    if (playerHand.cardsValue() > 21) {
                        System.out.println("BUST!!! Your cards are at " + playerHand.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        System.out.println("You now have $" + playerMoney + ".");
                        break;
                    }
                }
                if (response == 2) {
                    break;
                }
            }
            System.out.println("\nDealer hand is " + dealerHand.toString() + "\n");
            if ((dealerHand.cardsValue() > playerHand.cardsValue()) && endRound == false) {
                System.out.println("Dealer wins");
                playerMoney -= playerBet;
                endRound = true;
                System.out.println("You now have $" + playerMoney + ".");
            }
            while ((dealerHand.cardsValue() < 17) && endRound == false) {
                dealerHand.drawFrom(dealCards());
                System.out.println("Dealer draws " + dealerHand.getCard(dealerHand.deckSize() - 1).toString());
            }
            System.out.println("Dealar's hand is valued at " + dealerHand.cardsValue());
            if ((dealerHand.cardsValue() > 21) && endRound == false) {
                System.out.println("Dealer busts!!! YOU WIN!!!");
                playerMoney += playerBet * 2;
                endRound = true;
                System.out.println("You now have $" + playerMoney + ".");
            }
            if ((playerHand.cardsValue() == dealerHand.cardsValue()) && endRound == false) {
                System.out.println("This game ends in a tie! The dealer wins by default\n");
                playerMoney -= playerBet;
                endRound = true;
                System.out.println("You now have $" + playerMoney);
            }
            if ((playerHand.cardsValue() > dealerHand.cardsValue()) && endRound == false) {
                System.out.println("Congratulations!!! You win the hand.\n");
                playerMoney += playerBet * 2;
                endRound = true;
                System.out.println("You now have $" + playerMoney + ".");
            }

            playerHand.bringCardsBack(dealCards());
            dealerHand.bringCardsBack(dealCards());
            System.out.println("End of hand. Please play again.");
        }
    }

    public Deck dealCards() {
        Deck sampleDeck = new Deck();
        sampleDeck.createFullDeck();
        sampleDeck.shuffleDeck();
        return sampleDeck;

    }

    public void getResults() {


    }

    public void endGame() {
        System.out.println("The game is over.");
    }


    Deck playerHand = new Deck();
    Deck dealerHand = new Deck();



    Scanner userInput = new Scanner(System.in);







    public double getMinBet() {
        return minBet;
    }

    public double getMaxBet() {
        return maxBet;
    }

    public void setMinBet(double minBet) {
        this.minBet = minBet;
    }

    public void setMaxBet(double maxBet) {
        this.maxBet = maxBet;
    }


}
