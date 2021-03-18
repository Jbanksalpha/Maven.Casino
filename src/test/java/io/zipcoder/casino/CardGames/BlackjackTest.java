package io.zipcoder.casino.CardGames;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackTest {

//    @Test
//    public void runGame() {
//    }

    @Test
    public void dealCardsTest() {
        //Given
        Deck sampleDeckT= new Deck();

        //When
        Deck expected=sampleDeckT;
        Blackjack blackjack=new Blackjack(25.0,50.0);
        Deck actual=blackjack.dealCards();

        Assert.assertTrue(sampleDeckT instanceof Deck);
    }

    @Test
    public void getResults() {
    }

    @Test
    public void endGame() {
    }

    @Test
    public void getMinBet() {
    }

    @Test
    public void getMaxBet() {
    }

    @Test
    public void setMinBet() {
    }

    @Test
    public void setMaxBet() {
    }
}