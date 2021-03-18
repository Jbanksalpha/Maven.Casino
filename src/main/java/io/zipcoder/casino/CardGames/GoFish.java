package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.utilities.Console;

import java.util.Scanner;

public class GoFish extends CardGame{

    private double minBet;
    private double maxBet;
    private Console console = new Console(System.in, System.out);

    public GoFish(double minBet, double maxBet) {
        this.minBet = minBet;
        this.maxBet = maxBet;

    }
    Deck playerHand = new Deck();
    Deck dealerHand = new Deck();
    double playerMoney = 300.00;

    Scanner userInput = new Scanner(System.in);


    public Deck dealCards() {
        return null;
    }

    public void runGame() {
        while (playerMoney >= 0.0) {

            double playerBet = console.getDoubleInput("Enjoy playing your game. Make your wager!!! \n or press 0 to exit game");
            if (playerBet == 0) {
                System.exit(0);
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
        }

    }

    public void getResults() {

    }

    public void endGame() {

    }
}
