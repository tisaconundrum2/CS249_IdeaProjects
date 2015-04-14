package com.project.MyArray;

/**
 * Created by User on 9/26/2014.
 */
public class Queue {
    private int maxSize;
    private int[] queArray;
    private int front;
    private int rear;
    private int nItems;
    //-------------------------------------------------------------
    public Queue(int s){
        maxSize = s;
        queArray = new int[maxSize];
        front = 0;
        rear = 0;
        nItems = 0;
    }//public
    //-------------------------------------------------------------
    public void display(Queue theQueue){
        while( !theQueue.isEmpty() ){ // remove and display
            // all items
            int n = theQueue.remove(); // (40, 50, 60, 70, 80)
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println("");
    }
    //-------------------------------------------------------------
    public void insert(int j) { // put item at rear of queue
//        if (nItems == queArray.length){
//            System.out.println("Queue is full");
//        }
//        else if (rear == queArray.length) // deal with wraparound
//            rear = -1;
//        else {
//            queArray[++rear] = j; // increment rear and insert
//            nItems++; // one more item
//        }
        if (nItems != queArray.length){
            queArray[rear++] = j; // increment rear and insert
            nItems++; // one more item
            if (rear == queArray.length){
                rear = 0;
            }
        } else {
            System.out.println("Queue is full");
        }
    }//public
    //-------------------------------------------------------------
    public int remove() { // take item from front of queue
        int temp = queArray[front++]; // get value and incr front
        if(front == maxSize) // deal with wraparound
            front = 0;
        nItems--; // one less item
        return temp;
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

} // end class Queue
