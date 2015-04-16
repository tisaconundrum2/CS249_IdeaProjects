package com.company.recycle.bin; /**
 ** Java Program to Implement Radix Sort
 **/

import java.util.Scanner;

/** Class RadixSort **/
public class radixSort_1
{
    /** Radix Sort function **/
    public static void sort( int[] a)
    {
        int i, m = a[0];/*this is our zeroth position*/
        int exp = 1/*digit exponent, we'll use this to modulate the numbers*/;
        int n = a.length/*length of list*/;

        int[] b = new int[10];
        //Find the largest element
        for (i = 1; i < n; i++) //iterate until we reach the end of the list.
            if (a[i] > m)       //if the aith element is larger that the mth element
                m = a[i];       // make this new element
        while (m / exp > 0)
        {
            int[] bucket = new int[10];

            /**
             * Go through the list of number the user put in.
             * look at it's 1th 10th and 100th values.
             * depending on what these values are
             * place them in a bucket array.
             * this bucket holds the index place of the numbers we are working on.
             *
             */

            for (i = 0; i < n; i++)
                bucket[(a[i] / exp) % 10]++;
            for (i = 1; i < 10; i++)
                bucket[i] += bucket[i - 1];
            for (i = n - 1; i >= 0; i--)
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            for (i = 0; i < n; i++)
                a[i] = b[i];
            exp *= 10;
        }
    }
    /** Main method **/
    public static void main(String[] args)
    {
        Scanner scan = new Scanner( System.in );
        System.out.println("Radix Sort Test\n");
        int n, i;
        /** Accept number of elements **/
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();
        /** Create integer array on n elements **/
        int arr[] = new int[ n ];
        /** Accept elements **/
        System.out.println("\nEnter "+ n +" integer elements");
        for (i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        /** Call method sort **/
        sort(arr);
        /** Print sorted Array **/
        System.out.println("\nElements after sorting ");
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}