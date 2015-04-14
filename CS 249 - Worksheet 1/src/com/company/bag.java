package com.company;

/**
 * Created by Nicholas Finch on 1/28/2015.
 */
public class bag {
    private apple[] applesInBag; //array for apples
    private int totalApples; //setting how much the bag can hold before ripping
    public bag(int s){ //constructor
        applesInBag = new apple[s]; //creating the array with the fixed size to bag
    }


    public void addAnApple(String color, int weight){
        if (totalApples == applesInBag.length){
            System.out.println("You have too many apples!");
            return;
        } else {
            System.out.println("You still have room for more apples.");
        }
        apple newApple = new apple(color, weight);
        if (applesInBag[totalApples] == null) //check to make sure you're not overstepping bounds
            applesInBag[totalApples] = newApple;
            totalApples += 1;
    }

    public void removeAnApple(){
        if (totalApples - 1 >= 0){
            if (applesInBag[totalApples-1].getColor() != "red" &&  applesInBag[totalApples-1].getColor() != "green" ) {
                System.out.println("you dig in the bag and pulled out a " + applesInBag[totalApples - 1].getColor() + " apple, WTF");
            } else {
                System.out.println("you dig in the bag and pulled out a " + applesInBag[totalApples - 1].getColor() + " apple");
            }
            applesInBag[totalApples - 1] = null;
            totalApples -= 1;
        }else{
            System.out.println("There's nothing in the bag");
        }
    }

    public int getNumberOfApples(){
        return (totalApples);
    }
}
