package com.company.eliminationGameV1_5;

/**
 * Created by User on 3/23/2015.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Random;
import java.util.Scanner;

import java.util.Random;
import java.util.Scanner;


public class elimGameApp {
    public static void main(String[] args){
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        elimGame newElimGame = new elimGame();

        System.out.println("How many people (1-10 people): ");
        int people = Integer.parseInt(input.nextLine());
        while (!(people <= 10)){
            System.out.println("You must input a number between 1 and 10: ");
            people = Integer.parseInt(input.nextLine());
        }
        System.out.println("There are " + people + " people.");

        System.out.println("Input the elimination number: ");
        int priorityElim = Integer.parseInt(input.nextLine());
        System.out.println("Eliminate every "+ priorityElim + " people.");

        System.out.println("Input the number to start at: ");
        int numStart = Integer.parseInt(input.nextLine());
        System.out.println("Starting at "+ numStart);

        for (int i = 0; i < people; i++){
            newElimGame.insertPerson(i);
        }
        //newElimGame.openLoop();
        newElimGame.display();
        newElimGame.playerLocation(numStart);
        for (int i = 0; i < people-1; i++){
            newElimGame.eliminate(priorityElim);
            newElimGame.display();
        }
    }
}


