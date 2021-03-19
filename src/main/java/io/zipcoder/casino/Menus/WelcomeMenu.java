package io.zipcoder.casino.Menus;
import io.zipcoder.casino.CardGames.Blackjack;
import io.zipcoder.casino.DiceGames.Craps.Craps;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.utilities.Console;
import io.zipcoder.casino.utilities.Membership;

import java.util.regex.Pattern;

public class WelcomeMenu {

    private Console console = new Console(System.in, System.out);
    private Blackjack blackjack;
    BlackjackMenu blackjackMenu1=new BlackjackMenu(blackjack);


    public WelcomeMenu() {
        this.console = console;

    }


    public void menuRun() {
        console.println("Hi! Welcome to the Casino!");
        int newOrReturning = console.getInteger("Enter 1 if you are a new player or 2 if you are a returning player\n");
        if (newOrReturning == 1) {createPlayer();}
        else if (newOrReturning == 2){
            Player currentPlayer = checkPlayer();
            returningPlayer(currentPlayer);
        }
        else{System.exit(3);}
        }

    public void returningPlayer(Player player){

        console.println("Where would you like to go?");
        console.println("1-Blackjack 2-Craps 3-Teller 4-Exit");

        Integer choice = console.getIntegerInput("Enter the number of the operation you want to perform: ");
        boolean currentlyWorking = true;
        while (currentlyWorking) {
            switch (choice) {
                case 1:
                    Blackjack blackjack = new Blackjack(player, 25, 50);
                    blackjack.runGame();
                    break;
                case 2:
                    Craps craps = new Craps(player);
                    craps.runGame();
                    break;

                case 3:
                    TellerMenu teller = new TellerMenu(player);
                    teller.displayTellerMenu();
                    teller.myChoice(choice);
                    break;

                case 4:
                    System.out.println("Bye!");
                    menuRun();
                    break;
                default:
                    System.out.println("Invalid choice! Please enter a valid number.");
                    choice = console.getIntegerInput("Enter the number of the operation you want to perform: ");
                    currentlyWorking = false;
            }
        }
    }

    public Player checkPlayer(){
        String checkName = console.getStringInput("Please enter your first name");
        if(Membership.getPlayerByFirstName(checkName) == null){
            System.out.println("You dont have a membership.");
            menuRun();
        }
        Player currentPlayer = Membership.getPlayerByFirstName(checkName);

        return currentPlayer;
    }

    public void createPlayer(){

        String firstName = console.getInput("Teller: What's your first name? ");
        boolean test=true;
        while(test){
            if(isWord(firstName)){
                test=false;
            }
            else{
                System.out.println("Invalid entry ");
                firstName = console.getInput("Teller: What's your first name? ");
            }
        }
        String lastName = console.getInput("Teller: What's your last name? ");
        boolean bool=true;
        while(bool) {
            if (isWord(lastName)) {
                bool=false;

            } else {
                System.out.println("Invalid entry");
                lastName = console.getInput("Teller: What's your last name? ");
            }
        }

        int age = console.getInteger("Teller: How old are you? ");
        if (age<18){
            System.out.println("Minimum Casino Gambling Age 18+");
            menuRun();
        }
        Player newPlayer = Membership.createPlayer(firstName,lastName,age,0);
        Membership.addMember(newPlayer);
        returningPlayer(newPlayer);
    }

    public boolean isWord (String in){
        return Pattern.matches("[a-zA-Z]+",in);
    }
}
