package io.zipcoder.casino.CardGames;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest extends TestCase {

    @Test
    public void testCreateFullDeck() {

        //Given
        Deck deck= new Deck();

        //When
        Deck expected=deck;
        Deck actual= deck.createFullDeck();

        Assert.assertTrue(deck instanceof Deck);

    }

    public void testTestToString() {
        //Given
        String string = new String();

        //When
        String expected = string;
        String actual = "";


        //Then
        Assert.assertEquals(expected, actual);



    }

   /* public void testShuffleDeck() {
        //Given
        Deck shuffledDeck = new Deck();

        //When
        Deck actual = shuffledDeck;
        Deck expected = shuffledDeck;

        //Then
        Assert.assertEquals(expected, actual);

    }*/

    public void testRemoveCard() {
    }

    public void testGetCard() {
        Deck deck = new Deck();
        //Given
        Card card = new Card(Suit.HEART, Value.NINE);
        //When
        Card expected =card;
        deck.addCard(expected);
        Card actual = deck.getCard(0);

       //Then

        Assert.assertEquals(expected, actual);
    }

    public void testAddCard() {
        Deck deck = new Deck();
        //Given
        Card card = new Card(Suit.HEART, Value.NINE);
        //When
        Card expected =card;
        deck.addCard(expected);
        Card actual = deck.getCard(0);

        //Then

        Assert.assertEquals(expected, actual);
    }

   public void testDrawFrom() {
        Deck deck = new Deck();

       Card card = new Card(Suit.HEART, Value.NINE);
       Card card2 = new Card(Suit.DIAMOND, Value.NINE);

       deck.addCard(card);
       deck.addCard(card2);
       deck.drawFrom(deck);
       Card expected = card;
       Card actual = deck.getCard(1);

       Assert.assertEquals(expected, actual);


    }

    public void testDeckSize() {
        Deck deck = new Deck();

        //Given

        Card card = new Card(Suit.HEART, Value.NINE);
        Card card2 = new Card(Suit.HEART, Value.FIVE);
        Card card3 = new Card(Suit.HEART, Value.Q);

        //When
        deck.addCard(card);
        deck.addCard(card2);
        deck.addCard(card3);

        int actual = deck.deckSize();
        int expected = 3;
        //Then
        Assert.assertEquals(expected, actual);
    }

    public void testCardsValue() {
       Deck deck = new Deck();
       //Given
        Card card = new Card(Suit.DIAMOND, Value.NINE);
        deck.addCard(card);

        //When
        int expected = 9;
        int actual = deck.cardsValue();

        //then

        Assert.assertEquals(expected, actual);
    }

   /* public void testBringCardsBack() {
        Deck deck = new Deck();
        //Given
        Card card = new Card(Suit.DIAMOND, Value.NINE);


        //When

        deck.addCard(card);
        deck.removeCard(0);
        deck.bringCardsBack(deck);
        Card expected = card;
        Card actual = deck.getCard(0);

        Assert.assertNotEquals(expected, actual);
    }*/



}