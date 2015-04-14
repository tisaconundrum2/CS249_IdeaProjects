package com.company.recycle.bin;

/**
 * Created by User on 4/8/2015.
 */
public class Bins {
    private int dData;
    public Bins next;

    public Bins(int i) {
        this.dData = i;
        this.next = null;
    }

    public Bins(){
        this.dData = 0;
        this.next = null;
    }

    public void setdData(int dData){
        this.dData = dData;
    }

    public void display(){
        /**
         * Iterate through each Bins.next, and display the data in each.
         */

        while (this.next != null){
            System.out.printf("%d, ", this.dData);
            this.next = this.next.next;
        }
    }

    public int getdData(){
        return this.dData;
    }
}
