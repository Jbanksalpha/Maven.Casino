package io.zipcoder.casino;
import io.zipcoder.casino.CardGames.Deck;
import io.zipcoder.casino.DiceGames.Craps.Craps;
import io.zipcoder.casino.Menus.WelcomeMenu;
import io.zipcoder.casino.Player;


import io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Membership;


public class Casino {

    private static Console console = new Console(System.in, System.out);
    private static String firstName;
    private static String lastName;
    private static Integer age;
    private static Double balance;

    public static void main(String[] args) {
        WelcomeMenu welcome = new WelcomeMenu(console);
        Membership membership = new Membership();
//        membership.membersList(firstName, lastName, age, balance);
        boolean enterCasino = true;

        while(enterCasino){
            welcome.menuRun();
        }

    }






}

