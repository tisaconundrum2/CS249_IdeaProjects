package com.company;

import java.util.Random;

/**
 * Created by User on 12/22/2014.

 Create some player objects in a world with a table object.
 The players will roll, the table will dictate what to spit out when bets are made
 The players will hold the information of where there bets are
 For example Player 1 will keep in memory what bets he has placed on the table
 (Technically the table doesn't do more than actually do dice rolls.)
 (Perhaps i don't even need the table... But the table may be useful in assigning dice information to all players)
 Once the players have been assigned their designated bets. A roll is to be made.
 After the roll has been made, check all cases and do each case on each object at the table.
 */


public class Craps {
    private Player player;
    public int dice;

    public Craps(int dice){
        this.dice = dice;
    }


    public String roll() {
        //TODO roll 2 dice and return the value
        int dice = (int) (6.0 * Math.random() + 1.0) +
                (int) (6.0 * Math.random() + 1.0);

        if (dice == 2 || dice == 3 || dice == 12) {
            String output = String.format("player lost %d", dice);
            return output;
        }

        else if (dice == 7 || dice == 11) {
            String output = String.format("Win %d", dice);
            return output;
        }
        return null;
    }
}