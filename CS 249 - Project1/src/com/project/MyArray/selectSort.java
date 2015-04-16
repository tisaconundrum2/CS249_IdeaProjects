package com.project.MyArray;

/**
 * Created by User on 9/26/2014.
 */
public class selectSort {
    private double[] a; // ref to array a
    private int nElems; // number of data items
    //-------------------------------------------------------------
    public selectSort(int max) {
        a = new double[max]; // create the array
        nElems = 0; // no items yet
    }// end public
    //-------------------------------------------------------------
    public void insert(double value){// put element into array
        a[nElems] = value; // insert it
        nElems++; // increment size
    }//end public
    //-------------------------------------------------------------
    public void display(){ // displays array contents
        for(int j=0; j<nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println("");
    }
    //-------------------------------------------------------------
    public void selectionSort(){
        int out, in, min;
        int swaps = 0;
        int comparisons = 0;
        for(out=0; out<nElems-1; out++){ // outer loop
            comparisons += 1;
            min = out; // minimum
            for(in=out+1; in<nElems; in++) // inner loop
                if(a[in] < a[min] ) // if min greater,
                    min = in; // we have a new min
            swap(out, min); // swap them
            swaps += 1;
        } // end for(outer)
        System.out.println("Swaps = " + swaps);
        System.out.println("Comparisons = " + comparisons);
    } // end public()
    //-------------------------------------------------------------
    private void swap(int one, int two){
        double temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }//end swap
}//end class SelectSort

////////////////////////////////////////////////////////////////
