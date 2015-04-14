package com.company;

public class Player{
    public String name;
    public int amtMoney;
    public int dice;

    public Player(String name, int dice, int amtMoney){
        //TODO player constructor, these will be all the player objects in the world
        this.name = name;
        this.dice = dice;
        this.amtMoney = amtMoney;
    }

    public int roll(){
        int dice = (int) (6.0 * Math.random() + 1.0) +
                (int) (6.0 * Math.random() + 1.0);
        return dice;
    }
}
