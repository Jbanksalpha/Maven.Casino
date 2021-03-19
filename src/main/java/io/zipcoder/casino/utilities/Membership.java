package io.zipcoder.casino.utilities;

import io.zipcoder.casino.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Membership {

    private static ArrayList<Player> currentMembers = new ArrayList<Player>();

    public static void addMember(Player player) {currentMembers.add(player);}

    public static void addMultipleMembers(Player... players){currentMembers.addAll(Arrays.asList(players));}

    public static Player getPlayerByFirstName(String firstName){
        for(Player player : currentMembers){
            if(player.getFirstName().equals(firstName)){
                return player;
            }
        }
        return null;
    }


    public static Player createPlayer(String firstName, String lastName, int age, double balance){
        return new Player(firstName, lastName, age, balance);
    }

    public static void membersStart(){
        Player mike = Player.createMember("Mike", "Ninh", 22,1400 );
        Player lena = Player.createMember("Lena","Litouka", 21, 500);
        Player monali = Player.createMember("Monali","Khandelwal", 22, 5000);
        Player justin = Player.createMember("Justin","Banks", 23, 10000);
        addMultipleMembers(mike, lena, monali, justin);
    }









}
