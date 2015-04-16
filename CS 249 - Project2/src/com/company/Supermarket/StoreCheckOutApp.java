package com.company.Supermarket;

import java.util.Random;
import java.util.Scanner;

/*
[[[5] [2] [3]], [[5] [6]], [[3]]]
[[[4] [2] [3]], [[4] [6]], [[2]]]
[[[3] [2] [3]], [[3] [6]], [[1]]]
[[[2] [2] [3]], [[2] [6]], [[0]]]
[[[1] [2] [3]], [[1] [6]], [[0]]]
[[[0] [2] [3]], [[0] [6]], [[0]]]
[[[0] [1] [3]], [[0] [5]], [[0]]]
[[[0] [0] [3]], [[0] [4]], [[0]]]
[[[0] [0] [2]], [[0] [3]], [[0]]]
[[[0] [0] [1]], [[0] [2]], [[0]]]
[[[0] [0] [0]], [[0] [1]], [[0]]]
[[[0] [0] [0]], [[0] [0]], [[0]]]

 * Author: Nicholas Finch
 * CS 249
 * 3/8/2015
 *
 */


public class StoreCheckOutApp{
    public static void main(String[] args){
        Random rand = new Random();
        Scanner input = new Scanner(System.in);//checks for input
        //======================================================
        System.out.print("Please enter the number of checkout lines: ");
        int numCheckOuts = Integer.parseInt(input.nextLine());
        System.out.println("Store populated with " + numCheckOuts + " lines\n\n");
        System.out.print("How many customers per line? ");
        int clerkLineSize = Integer.parseInt(input.nextLine());
        System.out.println("Populated lines with "+ clerkLineSize+ " spaces\n\n");
        //--------------------------------
        storeClass myStore = new storeClass(numCheckOuts);
        //--------------------------------
        for (int i = 0; i < myStore.getSize(); i++){
            clerkLine line = new clerkLine(clerkLineSize);
            myStore.insertLine(line);
        }
        boolean flag = true;
        String commandKey = "";
        //======================================================
        while (flag){
            System.out.println("");
            System.out.println("-------------------------------");
            System.out.println("" +
                    "Press key and hit enter:\n" +
                    "Enter 'a' to add a customer to the line\n" +
                    "Enter 's' to simulate passing of time\n" +
                    "Enter 'q' to quit\n");
            int randItem = rand.nextInt(5)+1;//number of items to be placed in customer basket
            commandKey = input.nextLine();
            System.out.println("You pressed: " + commandKey);
            if (commandKey.equalsIgnoreCase("a")) {
                myStore.newPerson(randItem);
                myStore.display();
            }
            else if (commandKey.equalsIgnoreCase("s")) {
                myStore.incrementTime();
                myStore.display();
            }
            else if (commandKey.equalsIgnoreCase("q")) {
                flag = false;
            }
            else
                System.out.println("Not a valid input, try again.");

        }
    }
}
