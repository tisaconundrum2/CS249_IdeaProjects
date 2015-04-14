package com.company.Supermarket;

/*
 * Author: Nicholas Finch
 * CS 249
 * 10/17/14
 * Collaborated with Doug
 */
public class storeClass {
    //TODO: Make your store class to be an empty list
    private clerkLine[] clerkLines;
    private int sizeOfLines;
    private int count = 0;
    private int lineSizeSmall;
    //======================================================
    public storeClass(int numCheckOuts){
        clerkLines = new clerkLine[numCheckOuts];//populate store with lines
        sizeOfLines = numCheckOuts;
    }
    //======================================================
    public void insertLine(clerkLine newLine){
        clerkLines[count] = newLine;//add lines when needed
        count++;
    }
    //======================================================
    public void display(){
        for (int i = 0; i < sizeOfLines; i++){
            System.out.println("Line " +(i+1) + ": ");
            clerkLines[i].display();
            System.out.println("\n--------------------------------");
        }
    }
    //======================================================
    public void newPerson(int items){
        lineSizeSmall = 0;
        for (int i = 0; i < sizeOfLines; i++)
            if (clerkLines[i].getCount() < clerkLines[lineSizeSmall].getCount())
                lineSizeSmall = i;
        clerkLines[lineSizeSmall].insert(items);
    }
    //======================================================
    public void incrementTime(){
        for (int i = 0; i < sizeOfLines; i++)
            clerkLines[i].incrementTime();
    }

    public int getSize(){
        return sizeOfLines;
    }

}