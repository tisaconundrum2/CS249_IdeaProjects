package com.project.project2;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Zac on 10/18/2014.
 */
public class Queue2 {
    //private long[] Clerkline;
    public int[] Clerk;
    private int[][] Items;
    //private int size = 0;                                       //should be set in constructor of array
    private int numElem;
    private int i;                                      //keep track of where front and rear of array is
    private int j;
    //private int rear2;
    public int items;
    int icount;
    int jcount;

    int linelength;
    int Numclerks;




    public Queue2(int Numclerks, int linelength) {

        //int numppl = 0;
        this.Numclerks = Numclerks;
        this.linelength = linelength;
        this.Items = new int[Numclerks][linelength];

        //this.Clerk = new int[Numclerks];


        //System.out.println("Items: " + items);
        //System.out.println("Clerks: " + Numclerks);
        //System.out.println("Line: " + linelength);
        for (j = 0; j < Numclerks; j++) {
            //Clerk[j] =  1;

            for (i = 0; i < linelength; i++) {

                Random rand = new Random();
                int items = rand.nextInt(10) + 1;
                //Items[j][i] = 0;
                icount = linelength;
                Items[j][i] = items;
                //ClerkArray2[j][i] = items - 1;
                //System.out.println("i " + i);
            }

        }


        //System.out.println("j " + j);

    }


    public void time() {                         //The insert method for adding to the queue

        for (j = 0; j < Numclerks; j++) {
            //for (i = 0; i < linelength; i++) {
            Items[j][0] = Items[j][0] - 1;

            //}


            if (Items[j][0] <= 0) {


                int[][] temp = new int[Numclerks][linelength + 1];

                //for (j = 0; j < Numclerks; j++) {
                    for (int i = 0; i < linelength - 1; i++) {

                        temp[j][i] = Items[j][i + 1];

                    }
                //}

                //for (j = 0; j < Numclerks; j++) {
                    for (int i = 0; i < linelength; i++) {

                        Items[j][i] = temp[j][i];

                    }
                //}
                //count--;

            }
        }

    }

    public void insert(){

        for(j = 0; j < Numclerks; j++) {
            //jcount++;
            for(i = 0; i < linelength; i++) {
                if(Items[j][i] == 0){
                    Random rand = new Random();
                    int items = rand.nextInt(10) + 1;
                    Items[j][i] = items;
                    return;

                }
                else{
                    //System.out.println("The Store needs a new cashier, please wait for a line to open up.");
                }
            }
            //break;
        }

        //for (j = 0; j < Numclerks; j++) {
        /*
            if (icount >= linelength) {
                System.out.println("The Store needs a new cashier, please wait for a line to open up.");
            }

            else {

                Random rand = new Random();
                int items = rand.nextInt(10) + 1;
                Items[j][icount] = items;

                icount++;
            }
        //}
*/
    }


    public void remove() {                                 //Displays where front and rear are located

        //System.out.println("at 0");


        /*for (j = 0; j < Numclerks; j++) {
            for (i = 0; i < linelength; i++) {
                long v = Items[i];
                v--;
                if(v <= 0){

                    long[] temp = new long[linelength + 1];

                    for (int i = 0; i < linelength -1; i++){

                        temp[i] = Items[i + 1];

                    }

                    for (int i = 0; i < linelength; i++){

                        Items[i] = temp[i];

                    }

                    //Items[i] = temp[i];


                }

                //else {

                Items[i] = v;



                //}

                //if(v == -1){
                //v = 0;}


            }

        }

    */

    }

    public String toString() {                               //So that I can print the array
        String output = "";
        System.out.println(" ");
        for (j = 0; j < Numclerks; j++) {
            int num = j + 1;
            System.out.println("Line:" + num);
            for (i = 0; i < linelength; i++) {
                //output = output + " " + ClerkArray[i][j];
                System.out.println(Items[j][i]);
                //System.out.println(" ");
                //System.out.println(ClerkArray2[j][i]);
            }
            System.out.println(" ");
        }
        //System.out.println("count: " + count);
        /*for (j = 0; j < Numclerks; j++) {
            int num = j + 1;
            System.out.println("Line:" + num);
            for (i = 0; i < linelength; i++) {
                //output = output + " " + ClerkArray[i][j];
                System.out.println(ClerkArray2[j][i]);
            }
        }
*/
        return output;


    }
}

class QueueApp2 {                                      //The driver

    public static void main(String[] args) {

        Queue2 arr;
        arr = new Queue2(5,6);
        Scanner input = new Scanner(System.in);
        boolean exit = true;


        String whatDo = "";
        //Random rand = new Random();
        //int items = rand.nextInt(10) + 1;



        while (exit == true) {

            System.out.println("Welcome to the grocery store");
            System.out.println("To display the lines, please press 1");
            System.out.println("To advance time, please press 2");
            System.out.println("To insert a new customer, please press 3");
            System.out.println("To leave the store, please press 4");

            whatDo = input.nextLine();

            if (whatDo.equalsIgnoreCase("1"))
                arr.toString();
            else if (whatDo.equalsIgnoreCase("2"))//{
                arr.time();
                //arr.toString();}
            else if (whatDo.equalsIgnoreCase("3"))//{
                arr.insert();
                //arr.toString();}
            else if (whatDo.equalsIgnoreCase("4"))
                exit = false;
            else
                System.out.println("Incorrect input, please try again");

        }


    }

}
