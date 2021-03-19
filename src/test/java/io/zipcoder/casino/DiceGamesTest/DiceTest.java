package io.zipcoder.casino.DiceGamesTest;

import io.zipcoder.casino.DiceGames.Dices.Dice;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void roll2Dices() {
        //given
        Dice dice = new Dice();
        //when
        int actual = dice.roll2Dices();
        //then

        Assert.assertTrue(actual <= 12 && actual >=2);
    }

    @Test
    public void roll2DicesNot() {
        //given
        Dice dice = new Dice();
        //when
        int actual = dice.roll2Dices();
        //then

        Assert.assertFalse(actual > 12 && actual < 2);
    }

    @Test
    public void roll2DicesMulti() {
        //given
        Dice dice = new Dice(2);
        //when
        int actual = dice.roll2Dices();
        //then

        Assert.assertTrue(actual <= 48 && actual >=8);
    }



}