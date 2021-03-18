package io.zipcoder.casino.Menus;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.Menus.WelcomeMenu;
import io.zipcoder.casino.utilities.Console;

public class TellerMenu {
    private Console console;
    private Player player;
    private String name = "Teller Menu";
    private WelcomeMenu welcome;


    public TellerMenu(Player player) {
        this.player = player;
        this.console = new Console(System.in, System.out);
    }

    public void myChoice(int choice) {

        switch (choice) {
            case 1:
                depositFunds();
                break;
            case 2:
                withdrawFunds();
                //console.clearScreen();
                break;
            case 3:
                welcome.menuRun();
                break;
        }
        public void displayTellerMenu() {
            console.println("How can help you?");
            console.println("1. Deposit funds");
            console.println("2. Cash out / Go home");
            console.println("3. Back to lobby");
            console.println(String.format("\nCurrent balance: $%.2f", player.getBalance()));
            myChoice(console.getInteger(3));
        }
    }



    public void deposit(double amount, Player player) {
        payOut(amount, player);
        player.setInitialBalance(player.getInitialBalance() + amount);
    }

    public Double withdraw(Player player) {
        double withdrawal = player.getBalance();
        if (wager(player.getBalance(), player)) {
            return withdrawal;
        } else {
            return null;
        }
    }

    public boolean wager(double amount, Player player) {
        double balance = player.getBalance();
        if (amount > balance) {
            return false;
        } else {
            player.setBalance(balance - amount);
            player.setWinAmt(player.getBalance() - player.getInitialBalance());
            return true;
        }
    }

    public void payOut(double amount, Player player) {
        player.setBalance(player.getBalance() + amount);
        player.setWinAmt(player.getBalance() - player.getInitialBalance());
    }

    public void depositFunds() {
        double funds = console.getCurrency("Teller: How much are you depositing?");
        if (funds == 0.0) {
            console.println("Teller: Please enter a valid amount, buddy");
        } else if (funds <= 20.0){
            console.println("TELLER: Wow, are you sure it's safe walkin' around with all that?");
            deposit(funds, this.player);
            console.println("[TELLER]: Don't spend it all in once place!");
        } else {
            console.println(String.format("Teller: Depositing $%.2f",funds));
            deposit(funds, this.player);
            console.println("Teller: Here you go! Good luck at the tables.");
        }

        console.getInput("( Press Enter to continue )");
    }


    public Double withdrawFunds () {
        Double withdrawal = withdraw(this.player);
        if (withdrawal != null) {
            this.player.setWinAmt(withdrawal - this.player.getInitialBalance());
            return withdrawal;
        } else {
            return 0.0;
        }

}