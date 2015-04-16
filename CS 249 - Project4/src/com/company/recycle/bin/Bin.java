package com.company.recycle.bin;

/**
 * Created by User on 3/24/2015.
 */
class Bin {
    public Bin holdBin;
    public double zero;
    public double one;
    public double two;
    public double three;
    public double four;
    public double five;
    public double six;
    public double seven;
    public double eight;
    public double nine;

    public Bin(int key, double dData) {
        //TODO input a key that will then select one of the variables that will then hold dData
        double temp[] = {zero, one, two, three, four, five, six, seven, eight, nine};
        temp[key] = dData;
    }

    public void display() {
        //TODO add a display function
    }

}