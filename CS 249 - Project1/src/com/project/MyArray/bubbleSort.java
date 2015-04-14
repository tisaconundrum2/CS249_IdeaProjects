package com.project.MyArray;

/**
 * Created by User on 9/26/2014.
 */
public class bubbleSort {
    private double[] a;
    private int nElems;
    //--------------------------
    public bubbleSort(int max){ //constructor
        a = new double[max];
        nElems = 0;
    }
    //--------------------------
    public void insert(double value){
        a[nElems] = value;
        nElems++;
    }
    //--------------------------
    public void display(){
        for(int j=0; j<nElems; j++)
            System.out.print(a[j] + " ");
        System.out.println("");
    }
    //--------------------------
    public void bubbleSort()
    {
        int out;
        int in = 0;
        int swaps = 0;
        int comparisons = 0;
        for(out = nElems - 1; out > 0; out--) // outer loop (backward)
        {
            comparisons += 1;
            for (in = 0; in < out; in++) { // inner loop (forward)
                if (a[in] > a[in + 1]) { // out of order?
                    swaps += 1;
                    swap(in, in + 1); // swap them
                }
            }
        }
        System.out.println("Swaps = " + swaps);
        System.out.println("Comparisons = "+comparisons);
    } // end bubbleSort()

    private void swap(int one, int two) {
        double temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}// end class bubbleSort

////////////////////////////////////////////////////////////////
