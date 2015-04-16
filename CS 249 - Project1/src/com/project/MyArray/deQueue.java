package com.project.MyArray;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * Created by User on 9/26/2014.
 */
public class deQueue {
    private int maxSize;
    private int[] queArray;
    private int wroteFirst;
    private int front;
    private int rear;
    private int pointer;
    private int nItems;
    //-------------------------------------------------------------
    public deQueue(int s){
        wroteFirst = 0;
        maxSize = s;
        queArray = new int[maxSize];
        pointer = maxSize / 2;  //set the pointer literally in the middle.
        nItems = 0;
    }//public
    //-------------------------------------------------------------
    public void insertRight(int j) { // put item at rear of queue
        if (wroteFirst == 0) {//the starting node is in the center.
            queArray[pointer] = j;
            rear = pointer + 1;
            front = pointer - 1;
            nItems++;
        }

        if (wroteFirst == 1){
            if(rear == maxSize) // deal with wraparound
                rear = 0;
            queArray[rear] = j;
            rear += 1; // You want the rear pointer to increase and move to the right.
            if (nItems != 5)
                nItems++; // increase item count
        }
        /*
        if (pointer == maxSize/2 && wroteFirst == 0)
            rear = pointer; wroteFirst = 1; // flagging the node in the middle.
        if(rear == maxSize) // deal with wraparound
            rear = 0;
        queArray[rear] = j;
        rear += 1; // You want the rear pointer to increase and move to the right.
        nItems++; // increase item count
        */
        if (wroteFirst == 0)
            wroteFirst = 1;
    }//public
    //-------------------------------------------------------------
    public void insertLeft(int j) { // put item at rear of queue
        if (wroteFirst == 0) {//the starting node is in the center.
            queArray[pointer] = j;
            rear = pointer + 1;
            front = pointer - 1;
            nItems++;
        }

        if (wroteFirst == 1) {
            if (front == -1) // deal with wraparound
                front = maxSize - 1;
            queArray[front] = j;
            front -= 1; // You want the front pointer to decrease and move to the left.
            if (nItems != 5)
                nItems++; // increase item count
        }
        /*if (pointer == maxSize/2)
            front = pointer;
        if(front == 0) // deal with wraparound
            front = maxSize;
        queArray[front] = j;
        front -= 1; // You want the front pointer to decrease and move to the left.
        nItems++; // increase item count*/
        if (wroteFirst == 0)
            wroteFirst = 1;
    }//public
    //-------------------------------------------------------------
    public int removeRight() { // take item from rear of queue
        //move right pointer to the left
        rear -= 1;
        if(rear == -1) // deal with wraparound
            rear = maxSize - 1;
        nItems--; // one less item
        return queArray[rear];
    }//public
    // -------------------------------------------------------------
    public int removeleft() { // take item from front of queue
        front += 1;
        if(front == maxSize) // deal with wraparound
            front = 0;
        nItems--; // one less item
        return queArray[front];
    }//public
    //-------------------------------------------------------------
    public int peekFront(){ // peek at front of queue
        return queArray[front];
    }//public
    //-------------------------------------------------------------
    public boolean isEmpty(){ // true if queue is empty
        return (nItems==0);
    }//public
    //-------------------------------------------------------------
    public boolean isFull(){ // true if queue is full
        return (nItems==maxSize);
    }
    //-------------------------------------------------------------
    public int size(){ // number of items in queue
        return nItems;
    }
    //-------------------------------------------------------------
    public void display(deQueue theQueue){
        while( !theQueue.isEmpty() ){ // remove and display
            // all items
            int n = theQueue.removeleft(); // [90,50,10,60,80]
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");
    }
} // end class Queue
