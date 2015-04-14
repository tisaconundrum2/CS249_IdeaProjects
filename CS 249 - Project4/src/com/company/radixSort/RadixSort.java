package com.company.radixSort;

import java.util.LinkedList;

/**
 * Created by User on 4/9/2015.
 */
public class RadixSort {
    private LinkedList <Integer> stack = new LinkedList<Integer>();
    private Link[] bins = {null, null, null, null, null, null, null, null, null, null }; // ref to first link on list

    /**
     * ints = [890,789,678,567,456,345,234,123] get initial list
     * ints = [890,123,234,345,456,567,678,789] look @ 1st digit, sort
     * ints = [123,234,345,456,567,678,789,890] look @ 2nd digit, sort
     * ints = [123,234,345,456,567,678,789,890] look @ 3rd digit, sort
     *
     * [0] [1] [2] [3] [4] [5] [6] [7] [8] [9]
     * nul 231 932 953 nul nul nul nul nul nul
     * nul 211 nul 983 nul nul nul nul nul nul
     * nul nul nul nul nul nul nul nul nul nul
     *
     * place data into links.
     *
     */
    public void sortLSD(int[] ints, int maxSigDig) {
        System.out.print("Your initial array is: ");
        intsDisplay(ints);
        int digLen = 0;
        while (digLen++ < maxSigDig){ //using the length given by maxSigDig, iterate through placing all buts into bins.
            for (int j = 0; j < ints.length; j++) { //iterate until we've emptied the whole list into bins.
                int digit = getDigits(digLen, ints[j]);
                insertFirst(ints[j], digit); //insertFirst(BIN number, The Number to stick in the bin)
            }
            int j = 0, a = 0;
            for (int k = 0; k < ints.length; k++) { //clear the list (for debugging purposes)
                ints[k] = 0;
            }
            while (j < 10) {
                while (!isEmpty(j)) {
                    stack.push(deleteFirst(j).iData);
                }
                while (!stack.isEmpty()) {
                    ints[a++] = stack.pop();
                }
                j++;
            }
            System.out.printf("After pass %d", digLen);
            intsDisplay(ints);
        }
        System.out.print("Your Final Result: ");
        intsDisplay(ints);
    }

    private void intsDisplay(int[] ints) {
        System.out.print("{");
        for (int i = 0; i < ints.length-1; i++) {
            System.out.printf("%d, ",ints[i]);
        }
        System.out.printf("%d",ints[ints.length - 1]);
        System.out.print("}\n\n");
    }

    public int getDigits(int digLen, int anInt) {
        for (int i = 1; i < digLen; i++) {
                anInt /= 10;
                //The need for padding zeros is not required, because when deleting against a small number
                //the result is zero anyways. And repeated dividing (0/10) will return 0.
        }
        return anInt % 10;
    }

    // ------------------------------------------------------------
    public boolean isEmpty(int place) // true if list is empty
    {
        return (bins[place] == null);
    }

    // ------------------------------------------------------------
    public void insertFirst(int id, int place)
    { // make new link
        Link newLink = new Link(id);
        newLink.next = bins[place]; // newLink --> old first
        bins[place] = newLink; // first --> newLink
    }

    // ------------------------------------------------------------
    public Link deleteFirst(int place) // delete first item
    { // (assumes list not empty)
        Link temp = bins[place]; // save reference to link
        bins[place] = bins[place].next; // delete it: first-->old next
        return temp; // return deleted link
    }

    private class Link {
        public int iData; // data item
        public Link next; // next link in list
// ------------------------------------------------------------

        public Link(int id) // constructor
        {
            iData = id; // initialize data
        } // set to null)
    }
}
