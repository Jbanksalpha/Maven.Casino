package io.zipcoder.casino.CardGames;
import java.util.Random;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> cards;

    public Deck () {
        this.cards = new ArrayList<Card>();
    }

    public void createFullDeck() {
        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()){
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
    }


    public String toString() {
        String listOutput = "";
        int i = 0;
        for (Card aCard : this.cards) {
            listOutput += "\n" + " " + aCard.toString();
        }
        return listOutput;
    }
    public void shuffleDeck() {
        ArrayList<Card> temporaryDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomSpot = 0;
        int originSize = this.cards.size();
        for (int i = 0; i < originSize; i++) {
            randomSpot = random.nextInt((this.cards.size() - 1) +1);
            temporaryDeck.add(this.cards.get(randomSpot));
            this.cards.remove(randomSpot);
        }
        this.cards = temporaryDeck;
    }
    public void removeCard(int i) {
        this.cards.remove(i);
    }
    public Card getCard(int i) {
        return this.cards.get(i);
    }
    public void addCard(Card addCard) {
        this.cards.add(addCard);
    }
    public void drawFrom(Deck fromDeck) {
        this.cards.add(fromDeck.getCard(0));
        fromDeck.removeCard(0);
    }
    public int deckSize() {
        return this.cards.size();
    }

    public int cardsValue() {
        int totalValue = 0;
        int aces = 0;
        for (Card aCard : this.cards) {
            switch(aCard.getValue()) {
                case TWO : totalValue += 2;
                break;
                case THREE : totalValue += 3;
                break;
                case FOUR : totalValue +=4;
                break;
                case FIVE : totalValue += 5;
                break;
                case SIX : totalValue += 6;
                break;
                case SEVEN : totalValue += 7;
                break;
                case EIGHT : totalValue += 8;
                break;
                case NINE : totalValue += 9;
                break;
                case TEN : totalValue += 10;
                break;
                case J : totalValue += 10;
                break;
                case Q : totalValue += 10;
                break;
                case K : totalValue += 10;
                break;
                case A: totalValue += 1;
                break;
            }
        }
        for (int i = 0; i < aces; i++) {
            if (totalValue > 10) {
                totalValue += 1;
            } else {
                totalValue += 11;
            }
        }
        return totalValue;
    }
    public void bringCardsBack(Deck moveCards) {
        int thisDeckSize = this.cards.size();
        for (int i = 0; i < thisDeckSize; i++) {
            moveCards.addCard(this.getCard(i));
        }
        for (int i = 0; i < thisDeckSize; i++) {
            this.removeCard(0);
        }

    }





}
