package com.project.project3;

import java.util.Scanner;


/**
 * Created by Zac on 10/31/2014.
 */
public class Teams {

    static void combinations(String group, String s, int numteam){

        if(group.length() < numteam){
            return;
        }

        else if(numteam==0){
            System.out.println(s);
        }

        else{
            combinations(group.substring(1), s + group.charAt(0), numteam-1);    //Recursive call
            combinations(group.substring(1), s, numteam);                        //Recursive call
        }

    }

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        //boolean exit = true;


        //String group[] = new String[num];
        //String group = "ABCDEF";
        System.out.println("Please enter the group members");
        String group = input.next();
        System.out.println("How many group members do you want on your team?");
        int numteam = input.nextInt();
        System.out.println("");


        String s = "";

        Teams.combinations(group, s, numteam);

    }

}
