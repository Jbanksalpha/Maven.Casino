package io.zipcoder.casino;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {
    @Test
    public void testPlayer(){
        // : Given
        String playerFirstName="Lena";
        String playerLastName="L";
        int playerAge=31;
        double playerBalance=100;

        // : When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,100);
        String actualFirstName=playerZero.getFirstName();
        String actualLastName=playerZero.getLastName();
        int actualAge=playerZero.getAge();
        double actualBalance=playerZero.getBalance();

        // :Then
        Assert.assertEquals(playerFirstName,actualFirstName);
        Assert.assertEquals(playerLastName,actualLastName);
        Assert.assertEquals(playerAge,actualAge,0.001);
        Assert.assertEquals(playerBalance,actualBalance,0.001);

    }
    @Test
    public void testGetFirstName() {
        // : Given
        String playerFirstName="Monali";
        String playerLastName="K";
        int playerAge=31;
        double playerBalance=130;

        // :When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,playerBalance);
        String actualFirstName=playerZero.getFirstName();

        // :Then
        Assert.assertEquals(playerFirstName,actualFirstName);
    }
    @Test
    public void testGetLastName() {
        // : Given
        String playerFirstName="Justin";
        String playerLastName="B";
        int playerAge=40;
        double playerBalance=150;

        // :When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,playerBalance);
        String actualLastName=playerZero.getLastName();

        // :Then
        Assert.assertEquals(playerLastName,actualLastName);
    }
    @Test
    public void testSetFirstName() {
        // : Given
        String playerFirstName="Mike";
        String playerLastName="N";
        int playerAge=28;
        double playerBalance=170;

        // :When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,playerBalance);
        playerZero.setFirstName("Mike");
        String actualFirstName=playerZero.getFirstName();

        // :Then
        Assert.assertEquals(playerFirstName,actualFirstName);
    }
    @Test
    public void testSetLastName() {
        // : Given
        String playerFirstName="Lena";
        String playerLastName="L";
        int playerAge=31;
        double playerBalance=200;

        // :When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,playerBalance);
        playerZero.setLastName("L");
        String actualLastName=playerZero.getLastName();

        // :Then
        Assert.assertEquals(playerLastName,actualLastName);
    }
    @Test
    public void testGetAge() {
        // : Given
        String playerFirstName="Monali";
        String playerLastName="K";
        int playerAge=31;
        double playerBalance=210;

        // :When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,playerBalance);
        int actualAge=playerZero.getAge();

        // :Then
        Assert.assertEquals(playerAge,actualAge);
    }
    @Test
    public void testSetAge() {
        // : Given
        String playerFirstName="Justin";
        String playerLastName="B";
        int playerAge=40;
        double playerBalance=220;

        // :When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,playerBalance);
        playerZero.setAge(40);
        int actualAge=playerZero.getAge();

        // :Then
        Assert.assertEquals(playerAge,actualAge);
    }
    @Test
    public void testGetBalance() {
        // : Given
        String playerFirstName="Mike";
        String playerLastName="N";
        int playerAge=28;
        double playerBalance=230.0;

        // :When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,playerBalance);
        double actualBalance=playerZero.getBalance();

        // :Then
        Assert.assertEquals(playerBalance,actualBalance,0.001);
    }
    @Test
    public void testSetBalance() {
        // : Given
        String playerFirstName="Marie";
        String playerLastName="C";
        int playerAge=70;
        double playerBalance=170.0;

        // :When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,playerBalance);
        playerZero.setBalance(170.0);
        double actualBalance=playerZero.getBalance();

        // :Then
        Assert.assertEquals(playerBalance,actualBalance,0.001);
    }
    @Test
    public void testGetInitialBalance() {
        // : Given
        String playerFirstName="Stephanie";
        String playerLastName="H";
        int playerAge=40;
        double playerBalance=170.0;
        double playerInitial=100.0;

        // :When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,playerBalance);
        playerZero.setInitialBalance(100.0);
        double actualInitial=playerZero.getInitialBalance();

        // :Then
        Assert.assertEquals(playerInitial,actualInitial,0.001);
    }
    @Test
    public void testSetInitialBalance() {
        // : Given
        String playerFirstName="Kevin";
        String playerLastName="H";
        int playerAge=40;
        double playerBalance=230.0;
        double playerInitial=100.0;

        // :When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,playerBalance);
        playerZero.setInitialBalance(100.0);
        double actualInitial=playerZero.getInitialBalance();

        // :Then
        Assert.assertEquals(playerInitial,actualInitial,0.001);
    }
    @Test
    public void testGetWinAmt() {
        // : Given
        String playerFirstName="Dave";
        String playerLastName="C";
        int playerAge=50;
        double playerBalance=230.0;
        double winAmount=300.0;

        // :When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,playerBalance);
        playerZero.setWinAmt(300.0);
        double actualWin=playerZero.getWinAmt();

        // :Then
        Assert.assertEquals(winAmount,actualWin,0.001);
    }
    @Test
    public void testSetWinAmt() {
        // : Given
        String playerFirstName="Bill";
        String playerLastName="B";
        int playerAge=50;
        double playerBalance=270.0;
        double winAmount=150.0;

        // :When
        Player playerZero=new Player(playerFirstName,playerLastName,playerAge,playerBalance);
        playerZero.setWinAmt(150.0);
        double actualWin=playerZero.getWinAmt();

        // :Then
        Assert.assertEquals(winAmount,actualWin,0.001);
    }
}