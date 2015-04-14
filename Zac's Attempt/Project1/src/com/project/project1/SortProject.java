package com.project.project1;

/**
 * Created by Zac on 9/23/2014.
 */
public class SortProject {

    private long[] myArray;
    private int size;
    private int numElem;
    int bcomps = 0;                                         //Count comparisons and swaps for bubble sort
    int bswaps = 0;
    int scomps = 0;                                         //Count comparisons and swaps for selection sort
    int sswaps = 0;
    int icomps = 0;                                         //Count comparisons and swaps for insertion sort
    int iswaps = 0;

    public SortProject(int size){                           //Constructor... I think
        myArray = new long[size];
        numElem = 0;
    }

    public void insert(long value){                         //Method to insert into array used is driver
        myArray[numElem] = value;
        numElem++;
    }

    public void bubbleSortdisplay(){                       //Print comparisons and swaps for bubble sort
        System.out.println("Bubble Sort Comparisons: " + bcomps);
        System.out.println("Bubble Sort Swaps: " + bswaps);
    }

    public void selectionSortdisplay(){                     //Print comparisons and swaps for selection sort
        System.out.println("Selection Sort Comparisons: " + scomps);
        System.out.println("Selection Sort Swaps: " + sswaps);
    }

    public void insertionSortdisplay(){                     //Print comparisons and swaps for insertion sort
        System.out.println("Insertion Sort Comparisons: " + icomps);
        System.out.println("Insertion Sort Swaps: " + iswaps);
    }


    public void bubbleSort(){                              //The bubble sort function
        int out, in;

        for(out=numElem-1; out>0; out--){                   //Outer loop
            bcomps++;
            for(in=0; in<out; in++){                        //Inner loop
                bcomps++;                                   //Count comparisons
                if(myArray[in] > myArray[in+1]){
                    long temp = myArray[in];
                    myArray[in] = myArray[in+1];
                    myArray[in+1] = temp;
                    bswaps++;                               //Count swaps
                }
            }
        }
    }

    public void selectionSort (){                   //The selection sort function
        int in,out,min;                            //Initialize pointer variables

        for(out = 0; out < numElem-1; out++){     //Move through slowly adding values to the sorted portion of array.
            min = out;                            //Start the minimum value as the outer pointer
            for(in = out; in < numElem-1; in++){  //Move through and find the smallest value in the unsorted array.

                if(myArray[in + 1] < myArray[min]){
                    min = in + 1;
                    scomps++;                         //Count comparisons
                    sswaps++;                       //Count swaps
                }
            }
            long temp = myArray[out];              //Swap the minimum value into the end of the sorted array portion
            myArray[out] = myArray[min];
            myArray[min] = temp;
            sswaps++;                               //Count swaps
        }
    }

    public void insertionSort() {                       //The insertion sort function
        int n,k; 	  						            // Iterator reference variables
        for(n = 0; n < numElem; n++) {
            icomps++;                                   //Count comparisons
            long temp = myArray[n];
            k = n;
            while((k > 0) && (myArray[k - 1]) > temp) { // Inner while loop for shifting items appropriately
                myArray[k] = myArray[k - 1];
                k--;
                iswaps++;                               //Count comparisons
            }
            myArray[k] = temp;
        }
    }

    public String toString(){                           //So that I can print the array
        String output="";
        for(int i=0; i<numElem; i++)
            output = output + " " + myArray[i];
        return output;
    }

}

class SortProjectApp{                                       //The driver

    public static void main(String[] args) {

        int maxSize = 100;
        SortProject arr1;
        SortProject arr2;
        SortProject arr3;
        //SortProject comps;
        arr1 = new SortProject(maxSize);                        //Creating arrays for each sort function to be tested
        arr2 = new SortProject(maxSize);
        arr3 = new SortProject(maxSize);
        //comps = new SortProject();


        arr1.insert(7);                                        //Adding elements to the arrays
        arr1.insert(2);
        arr1.insert(1);
        arr1.insert(11);
        arr1.insert(-4);
        arr1.insert(-1);
        arr1.insert(0);
        arr1.insert(12);
        //arr1.insert(5);
        //arr1.insert(6);

        arr2.insert(10);
        arr2.insert(7);
        arr2.insert(3);
        arr2.insert(4);
        arr2.insert(99);
        arr2.insert(23);
        arr2.insert(100);
        arr2.insert(2);
        arr2.insert(5);
        arr2.insert(6);

        arr3.insert(10);
        arr3.insert(7);
        arr3.insert(3);
        arr3.insert(4);
        arr3.insert(99);
        arr3.insert(23);
        arr3.insert(100);
        arr3.insert(2);
        arr3.insert(5);
        arr3.insert(6);

        System.out.println("Original: " + arr1.toString());             //Printing the original array
        arr1.bubbleSort();
        System.out.println("Bubble Sorted: " + arr1.toString());       //Printing the sorted array
        arr1.bubbleSortdisplay();                                       //Printing the number of comparisons and swaps
        arr2.selectionSort();
        System.out.println("Selection Sorted: " + arr2.toString());    //Printing the sorted array
        arr2.selectionSortdisplay();                                    //Printing the number of comparisons and swaps
        arr3.insertionSort();
        System.out.println("Insertion Sorted: " + arr3.toString());     //Printing the sorted array
        arr3.insertionSortdisplay();                                    //Printing the number of comparisons and swaps
    }
}
