package com.project.project4;

/**
 * Created by Zac on 11/12/2014.
 */
public class RadixSort {

    public static void RadixSort( int[] arr)
    {
        int element = arr[0], exp = 1, length = arr.length;
        int[] arr1 = new int[10];
        for (int i = 1; i < length; i++)
            if (arr[i] > element)
                element = arr[i];
        while (element / exp > 0)
        {
            int[] sub = new int[10];

            for (int i = 0; i < length; i++)
                sub[(arr[i] / exp) % 10]++;
            for (int i = 1; i < 10; i++)
                sub[i] += sub[i - 1];
            for (int i = length - 1; i >= 0; i--)
                arr1[--sub[(arr[i] / exp) % 10]] = arr[i];
            for (int i = 0; i < length; i++)
                arr[i] = arr1[i];
            exp *= 10;
        }
    }
    /** Main method **/
    public static void main(String[] args)
    {


        int arr[] = new int[10];


        arr[0] = 1;
        arr[1] = 341;
        arr[2] = 222;
        arr[3] = 682;
        arr[4] = 340;
        arr[5] = 100;
        arr[6] = 192;
        arr[7] = 50;
        arr[8] = 455;
        arr[9] = 120;

/*
        arr[0] = 12;
        arr[1] = 341;
        arr[2] = 2222;
        arr[3] = 682;
        arr[4] = 4;

        arr[0] = 14;
        arr[1] = 75;
        arr[2] = 22;
        arr[3] = 68;
        arr[4] = 34;
        arr[5] = 10;
        arr[6] = 19;
        arr[7] = 50;
        arr[8] = 45;
        arr[9] = 12;
        arr[10] = 1;
        arr[11] = 41;
        arr[12] = 76;
        arr[13] = 82;
        arr[14] = 40;
        arr[15] = 10;
        arr[16] = 92;
        arr[17] = 5;
        arr[18] = 55;
        arr[19] = 20;

*/

        System.out.println("Elements before sorting ");
        for (int i = 0; i < 10; i++)
            System.out.print(arr[i]+" ");
        System.out.println();

        RadixSort(arr);

        /** Print sorted Array **/
        System.out.println("Elements after sorting ");
        for (int i = 0; i < 10; i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}


