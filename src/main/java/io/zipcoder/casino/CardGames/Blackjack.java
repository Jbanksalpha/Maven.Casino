package io.zipcoder.casino.CardGames;
import java.util.Scanner;
//import io.zipcoder.casino.Menus.BlackjackMenu;
//import io.zipcoder.casino.Player;
//import io.zipcoder.casino.utilities.Console;


    public class Blackjack extends CardGame {
        private double minBet;
        private double maxBet;

    public Blackjack(double minBet, double maxBet) {
        this.minBet = minBet;
        this.maxBet = maxBet;

    }





    public void runGame() {


    }

    public Deck dealCards() {
        Deck sampleDeck = new Deck();
        sampleDeck.createFullDeck();
        sampleDeck.shuffleDeck();
        System.out.println(sampleDeck);


        return sampleDeck;
    }

    public void getResults() {

        while (playerMoney > 0.0) {
            System.out.println("Enjoy playing your game.");
            double playerBet = userInput.nextDouble();
            if (playerBet > playerMoney) {
                System.out.println("You need more money to bet.");
                break;
            }
            boolean endRound = false;

            playerHand.drawFrom(dealCards());
            playerHand.drawFrom(dealCards());

            dealerHand.drawFrom(dealCards());
            dealerHand.drawFrom(dealCards());

            while(true){
                System.out.print(playerHand.toString());
                System.out.println("Your hand is valued at " + playerHand.cardsValue());
                System.out.println("The dealer's hand is valued at " + dealerHand.getCard(0).toString() + "and a hidden card.");
                System.out.println("Would you like to (1) Hit or (2) Stand?");
                int response = userInput.nextInt();
                if (response == 1 ) {
                    playerHand.drawFrom(dealCards());
                    System.out.println("You got a: " + playerHand.getCard(playerHand.deckSize()-1).toString());

                    if (playerHand.cardsValue() > 21) {
                        System.out.println("BUST!!! Your cards are at " + playerHand.cardsValue());
                        playerMoney -= playerBet;
                        endRound = true;
                        break;
                    }
                }
                if (response == 2) {
                    break;
                }
            }
            System.out.println("Dealer hand is " + dealerHand.toString());
            if ((dealerHand.cardsValue() > playerHand.cardsValue()) && endRound == false) {

            }
        }
    }

    public void endGame() {
        System.out.println("The game is over.");
    }


    Deck playerHand = new Deck();
    Deck dealerHand = new Deck();
    double playerMoney = 0.0;

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
