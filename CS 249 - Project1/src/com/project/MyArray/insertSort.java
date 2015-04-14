package com.project.MyArray;

/**
 * Created by User on 9/26/2014.
 */
public class insertSort {
    private double[] a; // ref to array a
    private int nElems; // number of data items

    public insertSort(int max) {
        a = new double[max]; // create the array
        nElems = 0; // no items yet
    }//end public
    //-------------------------------------------------------------
    public void insert(double value){// put element into array
        a[nElems] = value; // insert it
        nElems++; // increment size
    }//emd public
    //-------------------------------------------------------------
    public void display(){ // displays array contents
        for(int j=0; j<nElems; j++) // for each element,
            System.out.print(a[j] + " "); // display it
        System.out.println("");
    }//end public
    //-------------------------------------------------------------
    public void insertionSort(){
        int in, out, swaps = 0, comparisons = 0;
        for(out=1; out<nElems; out++){
            comparisons += 1;
            double temp = a[out]; // remove marked item
            in = out; // start shifts at out
            while(in>0 && a[in-1] >= temp){ // until one is smaller,
                swaps += 1;
                a[in] = a[in-1]; // shift item right,
            --in; // go left one position
            } //end while
            a[in] = temp; // insert marked item
        } // end for
        System.out.println("Swaps = "+ swaps);
        System.out.println("Comparisons = "+ comparisons);
    } // end insertionSort()
}//end class
////////////////////////////////////////////////////////////////
