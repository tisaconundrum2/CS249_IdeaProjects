package com.company;

import java.util.Scanner;

class radixMain {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Radix Sort Test\n");
        int n, i;
        System.out.println("Enter number of integer elements");
        n = scan.nextInt();
        int arr[] = new int[n];
        System.out.println("\nEnter "+ n +" integer elements");
        //go through the whole range of numbers entered and add them to a list
        //stop after n amount of numbers have been reached.
        for (i = 0; i < n; i++)
            arr[i] = scan.nextInt();
        radixSort.sort(arr);
        System.out.println("\nElements after Sorting ");
        for (i = 0; i < n; i++)
            System.out.print(arr[i]+ " ");
        System.out.println();
    }
}

class studentSortMain{
    public static void main(String[] args){
        Tree student = new Tree();
        student.insert(1.7, "Tyrone");
        student.insert(3.8, "South");
        student.insert(2.4, "Nick");
        student.insert(4.2, "Tony Stark");
        student.insert(2.6, "Blue");
        student.insert(4.5, "Captain America");
        student.insert(1.1, "West");
        student.insert(3.3, "North");
        student.delete(4.2);
        student.inOrder();

    }
}