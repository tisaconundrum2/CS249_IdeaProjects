package com.company;

public class Main {

    public static void main(String[] args) {
        bag newBag = new bag(8);
        //addAnApple(String color (rainbow), int weight(ounces, 6-8))
        for (int i = 0; i<9; i++) {
            newBag.addAnApple("blue", 8);
            newBag.addAnApple("green", 8);
            newBag.addAnApple("red", 8);
            System.out.println(newBag.getNumberOfApples());
        }
        newBag.removeAnApple();
        newBag.removeAnApple();
        newBag.removeAnApple();
        newBag.removeAnApple();
        newBag.removeAnApple();
        newBag.removeAnApple
        newBag.removeAnApple();
        newBag.removeAnApple();
        newBag.removeAnApple();
    }
}
