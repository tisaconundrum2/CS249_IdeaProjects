package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 4/5/2015.
 */


public class Daemons {
    private String name;
    private int attack;
    private int defense;
    private int spirit;
    private int[] daemonWeight = {0,0}; //[0] will be the new input. [1] will be the old input
    List<Daemons> daemonsList = new ArrayList<Daemons>(); //this holds the sum total of all daemons
    List<Daemons> daemonsArrayList = new ArrayList<Daemons>(); //use this list to recurse daemons for combinations
    String holdList = null;
    //List<String> holdList = new ArrayList<String>(); //use this list to hold the daemons, and eventually output the best daemon

    public Daemons(String name, int attack, int defense, int spirit) {
        this.name = name;
        this.attack = attack;
        this.defense = defense;
        this.spirit = spirit;
    }

    public Daemons(){
        //Just here to allow for a creation of an object without needing to add all the details.
    }

    public void insertDaemon(String name, int attack, int defense, int spirit){
        Daemons newDaemon = new Daemons(name, attack, defense, spirit);
        daemonsList.add(newDaemon);
    }

    public void getOptimizedAtk(int spirit){
        //returns 1 result with an optimized set of Daemons; Atk
        atkRecursive(0, spirit);
        System.out.print("Optomized Attack: ");
        System.out.print(holdList);
        holdList = null;
        daemonWeight = new int[]{0, 0};
    }

    public void getOptimizedDef(int spirit){
        //TODO your combinations here
        defRecursive(0,spirit);
        System.out.print("Optomized Defens: ");
        System.out.print(holdList);
        holdList = null;
        daemonWeight = new int[]{0, 0};

    }

    private List<Daemons> atkRecursive(int current, int targetSPR) {
        for( int i = current; i < daemonsList.size(); ++i ){ //first we use the daemonsList's length
            daemonsArrayList.add(daemonsList.get(i)); //add each letter to the daemonsArrayList
            if (targetSPR >= sum(daemonsArrayList)){
                //TODO add the below data to an array.
                String hold = null; //empty the contents of the list
                hold  = sum(daemonsArrayList) + "\t";
                hold += sumOfAtk()+"\t";
                daemonWeight[0] = sumOfAtk();
                int a = 0;
                while (a < daemonsArrayList.size()) {
                    hold += daemonsArrayList.get(a++).name + "        ";
                }
                hold += "\n";
                if (daemonWeight[0] > daemonWeight[1]) {
                    daemonWeight[1] = daemonWeight[0]; //pass in the new weight variable
                    holdList = hold;
//                    holdList.add(0,hold);// Overwrite the old saved data.
                }
            }
            if ( i < daemonsList.size() && daemonsArrayList.size() < 5 ) //this second case checks the daemonsList's length against our starting i and allows
                atkRecursive(i + 1, targetSPR); // the incrementation of A to AB to ABC to ABCD... to eventually F
            // the only way this works is to go all the way up, then come back down.
            daemonsArrayList.remove( daemonsArrayList.size() - 1 ); //decrement a letter.
        }
        return null;
    }

    private  List<Daemons> defRecursive(int current, int targetSPR) {
        for( int i = current; i < daemonsList.size(); ++i ){ //first we use the daemonsList's length
            daemonsArrayList.add(daemonsList.get(i)); //add each letter to the daemonsArrayList
            if (targetSPR >= sum(daemonsArrayList)){
                //TODO add the below data to an array.
                String hold = null; //empty the contents of the list
                hold  = sum(daemonsArrayList) + "\t";
                hold += sumOfDef()+"\t";
                daemonWeight[0] = sumOfDef();
                int a = 0;
                while (a < daemonsArrayList.size()) {
                    hold += daemonsArrayList.get(a++).name + "        ";
                }
                hold += "\n";
                if (daemonWeight[0] > daemonWeight[1]) {
                    daemonWeight[1] = daemonWeight[0]; //pass in the new weight variable
                    holdList = hold;
//                    holdList.add(0,hold);// Overwrite the old saved data.
                }
            }
            if ( i < daemonsList.size() && daemonsArrayList.size() < 5 ) //this second case checks the daemonsList's length against our starting i and allows
                defRecursive(i + 1, targetSPR); // the incrementation of A to AB to ABC to ABCD... to eventually F
            // the only way this works is to go all the way up, then come back down.
            daemonsArrayList.remove( daemonsArrayList.size() - 1 ); //decrement a letter.
        }
        return null;
    }

    private int sumOfDef() {
        int sum = 0;
        for (int i = 0; i < daemonsArrayList.size(); ++i){
            sum += daemonsArrayList.get(i).defense;
        }
        return sum;
    }

    private int sumOfAtk() {
        int sum = 0;
        for (int i = 0; i < daemonsArrayList.size(); ++i){
            sum += daemonsArrayList.get(i).attack;
        }
        return sum;
    }

    private int sum(List<Daemons> recursiList) {
        int sum = 0;
        for (int i = 0; i < recursiList.size(); ++i){
            sum += recursiList.get(i).spirit;
        }
        return sum;
    }
}
