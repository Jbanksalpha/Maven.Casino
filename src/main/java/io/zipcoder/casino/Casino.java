package io.zipcoder.casino;
import io.zipcoder.casino.CardGames.Deck;
import io.zipcoder.casino.DiceGames.Craps.Craps;
import io.zipcoder.casino.Menus.TellerMenu;
import io.zipcoder.casino.Menus.WelcomeMenu;
import io.zipcoder.casino.Player;


import io.zipcoder.casino.CardGames.Blackjack;

import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Membership;

public class Casino {

    private static Console console = new Console(System.in, System.out);

    public static void main(String[] args) {
        WelcomeMenu welcome = new WelcomeMenu();
        Membership.membersStart();

        while(true){
            welcome.menuRun();

        }
    }
    }


