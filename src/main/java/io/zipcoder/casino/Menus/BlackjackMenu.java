package io.zipcoder.casino.Menus;

import io.zipcoder.casino.CardGames.Blackjack;
import io.zipcoder.casino.utilities.Console;

    public class BlackjackMenu {
        private Console console;
        private String name = "Blackjack Menu";
        private Blackjack blackjack;


    public BlackjackMenu(Blackjack blackjack) {
        this.console = new Console (System.in, System.out);
        this.blackjack = blackjack;
    }

        public void displayMenu() {
            console.println("Choose table stakes:\n");
            console.println("1. $5 min / $25 max");
            console.println("2. $20 min / $100 max");
            console.println("3. $50 min / $250 max");
            console.println("4. Go Back to Game menu");
        }

        double getStakes() {
            double minBet = console.getCurrency("Table Stakes?");
            if (minBet >= 5.00 && minBet <= 250.00) {
                return minBet;
            } else if (minBet < 5.00) {
                console.println("Tables have a $5.00 minimum");
            } else {
                console.println("Tables have a $250.00 maximum");
            }
            return getStakes();
        }


        public void setStakes(int choice) {
            switch (choice) {
                case 1: // low stakes
                    this.blackjack.setMinBet(5.00);
                    this.blackjack.setMaxBet(25.00);
                    break;
                case 2: // med stakes
                    this.blackjack.setMinBet(20.00);
                    this.blackjack.setMaxBet(100.00);
                    break;
                case 3: // max stakes
                    this.blackjack.setMinBet(50.00);
                    this.blackjack.setMaxBet(250.00);
                    break;
                case 4:

            }
            if (this.blackjack.getMinBet() != 0.0) {
                double minBet = this.blackjack.getMinBet();
                double maxBet = this.blackjack.getMaxBet();
                console.println(String.format("Minimum bet is %.2f; maximum bet is %.2f", minBet, maxBet));
            }

        }
    }



