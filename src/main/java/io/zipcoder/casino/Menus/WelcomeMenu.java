
package io.zipcoder.casino;

package io.zipcoder.casino.Menus;


import io.zipcoder.casino.utilities.Console;

import javax.swing.*;
import java.util.regex.Pattern;

public class WelcomeMenu {
    private Console console = new Console(System.in, System.out);


    public WelcomeMenu(Console console) {
        this.console = console;
    }

    public WelcomeMenu(Console console) {
        this.console = console;

    }



    public void menuRun(){
        console.println("Hi! Welcome to the Casino!");
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
            System.exit(0);

        }

        console.println("Which game would you like to play");
        console.println("1-Blackjack 2-Craps 3-Exit");

        Integer choice= console.getIntegerInput("Enter the number of the operation you want to perform: ");


        switch(choice){
            case 1:
                System.out.println("Playing blackjack");
                break;
            case 2:
                System.out.println("Playing craps");
                break;
            case 3:
                System.out.println("Bye!");
                break;

        boolean currentlyWorking=true;
        while(currentlyWorking){
            switch(choice){
                case 1:
                    System.out.println("Playing blackjack");
                    currentlyWorking=false;
                    break;
                case 2:
                    System.out.println("Playing craps");
                    currentlyWorking=false;
                    break;
                case 3:
                    System.out.println("Bye!");
                    System.exit(3);
                default:
                    System.out.println("Invalid choice! Please enter a valid number.");
                    choice= console.getIntegerInput("Enter the number of the operation you want to perform: ");
        }

        }
    }
    public boolean isWord (String in){
        return Pattern.matches("[a-zA-Z]+",in);
    }


}
