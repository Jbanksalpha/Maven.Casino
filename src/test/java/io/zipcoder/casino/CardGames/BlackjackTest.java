package io.zipcoder.casino.CardGames;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BlackjackTest {



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
        //Given
        double maxBet=50.0;
        double minBet=25.0;
        Blackjack blackJackT=new Blackjack(minBet,maxBet);
        //When
        double expected =25.0;
        double actual=blackJackT.getMinBet();
        //Then
        Assert.assertEquals(expected,actual,0.001);
    }

    @Test
    public void getMaxBet() {
        //Given
        double maxBet=50.0;
        double minBet=25.0;
        Blackjack blackJackT=new Blackjack(minBet,maxBet);
        //When
        double expected =50.0;
        double actual=blackJackT.getMaxBet();
        //Then
        Assert.assertEquals(expected,actual,0.001);
    }

    @Test
    public void setMinBet() {
            //Given
            double maxBet=50.0;
            double minBet=25.0;
            Blackjack blackJackT=new Blackjack(minBet,maxBet);
            //When
            double expected =30.0;
            blackJackT.setMinBet(30.0);
            double actual=blackJackT.getMinBet();
            //Then
            Assert.assertEquals(expected,actual,0.001);
    }

    @Test
    public void setMaxBet() {
        //Given
        double maxBet=50.0;
        double minBet=25.0;
        Blackjack blackJackT=new Blackjack(minBet,maxBet);
        //When
        double expected =60.0;
        blackJackT.setMinBet(60.0);
        double actual=blackJackT.getMinBet();
        //Then
        Assert.assertEquals(expected,actual,0.001);
    }
}