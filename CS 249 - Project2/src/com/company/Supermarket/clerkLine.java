package com.company.Supermarket;
/*
 * Author: Nicholas Finch
 * CS 249
 * 10/17/14
 * Collaborated with Doug
 */

public class clerkLine {
    private int[] person;
    private int maxSize;
    private int count = 0;
    //======================================================
    public clerkLine(int maxSize){
        person = new int[maxSize];
        this.maxSize = maxSize;
    }
    //======================================================
    public void insert(int newCustomer){
        if (count >= maxSize) System.out.println("The line is full!");
        else person[count++] = newCustomer;
    }
    //======================================================
    public void incrementTime() {
        if (person[0] > 0)
            {
            person[0] = person[0] - 1; //decrement an item from their basket
            if (person[0] == 0)  // if the person has no items
                {
                remove(); // remove them from the line
                }
            }
        else
            {
            System.out.println("No Person in Line!");
            }
    }
    //======================================================
    public void remove(){
        if (!isEmpty())
            {
            int[] temp = new int[maxSize + 1];
            for (int i = 0; i < maxSize - 1; i++)
                temp[i] = person[i + 1];
            for (int i = 0; i < maxSize; i++)
                person[i] = temp[i];
            count--;
            }
        else
            {
            System.out.println("No person to Checkout");
            }
    }

    public boolean isEmpty() {
        return (count==0);
    }

    //======================================================
    public void display(){
        for (int i = 0; i < maxSize; i++){
            System.out.print("[" + person[i] + "]");
        }
    }


    public int getCount() {
        return count;
    }
}//end clerkLine

