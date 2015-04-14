//package com.company.recycle.bin; /**
//* Created by User on 3/24/2015.
//*/
//
//
///**
//* Class Comments for your RadixSort class
//*
//* @author Nicholas Finch
//* @version 1.0
//* @since 11:37 AM 4/8/2015
//*
//*/
//public class RadixSort {
//    /**
//     * delegate space for the 10 digits that should be recognized.
//     */
//    Queue bins[] = {null, null, null, null, null, null, null, null, null, null};
//
//    public RadixSort() {}
//
//    /**
//     * sortLSD will go through the a single digit
//     * see a certain digit inside this digit. Will place it in the proper bin
//     * to be assessed.
//     */
//    public void sortLSD(int[] inputs, int maxSignificantDigits) {
//        int maxSize = inputs.length;
//        int digit;
//        while (digit > 0) {
//            digit %= 10;
//            digit /= 10;
//            insert(digit, 124, maxSize);
//        insert(4, 240, maxSize);
//        insert(3, 234, maxSize);
//        insert(3, 430, maxSize);
//        insert(4, 540, maxSize);
//        for (int c = 0; c < inputs.length; c++)
//            inputs[c] = 0;
//        int a = 0;
//        int b = 0;
//        int nItems = 0;
//        for (int c = 0; c < inputs.length; c++){
//            while (bins[b] == null && b < 9) {
//                b++;
//            }
//            while (!bins[b].isEmpty()){
//                inputs[a] = bins[b].remove();
//                a++;
//            }
//            b++;
//        }
//    }
//
//
//    /**
//     * prior to this command, we should know that we need to add
//     * insert(5,350)
//     * the 5 means goto the fifth node, the 350 will placed in list 5
//     *  [zero] [ones] [twos] [thre] [four] [five] [six ] [seve] [eigh] [nine]
//     *                                     [350 ]
//     *
//     */
//    public void insert(int place, int num, int maxSize) {
//        //the place will be where the number will need to go.
//        //the num is the information
//        //input a maxsize.
//        if (bins[place] == null)
//            bins[place] = new Queue(maxSize);
//        bins[place].insert(num);
//
//    }
//}
//
///**
//* Sources
//* http://stackoverflow.com/questions/3389264/how-to-get-the-separate-digits-of-an-int-number
//*/
