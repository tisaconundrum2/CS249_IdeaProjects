package com.company.radixSort;

import java.util.Scanner;

/**
 * Created by User on 3/24/2015.
 */
public class radixSortApp {
    public static void main(String[] args){
        /**
         * sortLSD requires and int[] and int
         * int[] will hold your array
         * int will hold the digit length
         * for example:
         * 234 has 3 digits
         * 23 has 2 digits.
         * 7 has 1 digit
         */
        RadixSort radixSort = new RadixSort();
        System.out.println("//=========================================");
        radixSort.sortLSD(new int[] {4,5,6,7,6,5,4,5},1);
        System.out.println("//=========================================");
        radixSort.sortLSD(new int[] {483, 821, 173, 542, 134, 164,922,153,874,928,736,473},3);
        System.out.println("//=========================================");
        radixSort.sortLSD(new int[] {6,49,3,7,26,4,71,82,6,7},2);
        System.out.println("//=========================================");
        radixSort.sortLSD(new int[] {123,4,56,743,4,562,71},3);
        System.out.println("//=========================================");
    }

}
