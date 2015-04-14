package com.company.eliminationGameV1_0;

/**
 * Created by User on 3/12/2015.
 */

public class elimGameApp {
    public static void main(String[] args){
        elimGame newElimGame = new elimGame();
        System.out.print("How many players?");
        int numPlayers = 5;//scan for input and put it into numPlayers
        for (int i = 0; i < numPlayers; i++){
            newElimGame.insertAtStart("Player" + i);
        }
        /*
        * since positions are absolute.
        * [1][2][3][4][5]
        *
        *
        */


        newElimGame.display();
        newElimGame.deleteAtPos(1);
        newElimGame.display();
        newElimGame.deleteAtPos(3);
        newElimGame.display();
        newElimGame.deleteAtPos(2);
        newElimGame.display();
        newElimGame.deleteAtPos(1);
        newElimGame.display();
        newElimGame.deleteAtPos(1);
        newElimGame.display();

    }
}

