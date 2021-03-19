package io.zipcoder.casino.CardGames;

import io.zipcoder.casino.utilities.Console;

import java.util.Scanner;

public class GoFish extends CardGame{
    Deck playerHand = new Deck();
    Deck dealerHand = new Deck();
    Scanner userInput = new Scanner(System.in);


    public Deck dealCards() {
        return null;
    }

    public void runGame() {
        playerHand.drawFrom(dealCards());
        playerHand.drawFrom(dealCards());
        playerHand.drawFrom(dealCards());
        playerHand.drawFrom(dealCards());
        playerHand.drawFrom(dealCards());

        dealerHand.drawFrom(dealCards());
        dealerHand.drawFrom(dealCards());
        dealerHand.drawFrom(dealCards());
        dealerHand.drawFrom(dealCards());
        dealerHand.drawFrom(dealCards());

        System.out.println("Your hand is valued at " + playerHand.cardsValue());
        System.out.println("The dealer's hand is valued at " + dealerHand.getCard(0).toString() + "and a hidden card.");

    }

    public void getResults() {

    }

    public void endGame() {

    }
}
