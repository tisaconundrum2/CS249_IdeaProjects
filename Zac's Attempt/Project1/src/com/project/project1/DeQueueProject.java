package com.project.project1;

/**
 * Created by Zac on 9/24/2014.
 */
public class DeQueueProject {

    private long [] DeQuArray;
    private int size;                                       //should be set in constructor of array
    private int numElem;
    private int front;                                      //keep track of where front and rear of array is
    private int rear;


    public DeQueueProject(int size) {
        this.size = size;
        this.numElem = 0;
        DeQuArray = new long[size];
        front = 0;
        rear = -1;
    }

    public void insertRight(int inInt) {                    //The insert method for adding to the end queue
        if (rear == size - 1) {                             //For the wrap around
            rear = -1;
        }
        DeQuArray[++rear] = inInt;
        numElem++;

    }

    public void insertLeft(int inInt) {                     //The insert method for adding to the front queue
        if (front == size) {                                //For the wrap around
            front = 0;
        }
        if (rear == size-1){
            rear = -1;
        }


        long last = DeQuArray[DeQuArray.length - 1];
        for(int i=size-1; i>0; i--){
            DeQuArray[i] = DeQuArray[i-1];
        }
        DeQuArray[0] = last;
        DeQuArray[front] = inInt;

        rear++;
        numElem++;
    }


    public void removeLeft() {                              //The remove method for deleting from the front of the queue
        //long temp = DeQuArray[3];
        if (front == size-1)                                //For the wrap around
            front = -1;
        numElem--;
        front++;
        //return temp;
    }

    public void removeRight() {                             //The remove method for deleting from the end of the queue
        if(rear == 0){                                      //for the wrap aound
            rear = size;
        }
        numElem--;
        rear--;

    }

    public boolean isFull(){
        return (numElem > size);
    }     //Check if queue had max allowed elements

    public boolean isEmpty(){
        return (numElem == 0);
    }      //Check if queue has no elements in it

    public void display() {                                 //Displays where front and rear are located
        //System.out.println("size: " + size);
        System.out.println("Front index: " + front + " = Front element: " + DeQuArray[front]);
        System.out.println("Rear index: " + rear + " = Rear element: " + DeQuArray[rear]);
        System.out.println("# of elements: " + numElem);
    }

    public String toString(){                               //So that I can print the array
        String output="";
        for(int i=0; i<size; i++)
            output = output + " " + DeQuArray[i];
        return output;
    }

}

class DeQueueProjectApp{                                    //The driver

    public static void main(String[] args) {
        int maxSize = 5;
        DeQueueProject arr1;
        arr1 = new DeQueueProject(maxSize);

        arr1.insertLeft(1);                                 //Add or remove elements from queue
        arr1.insertLeft(2);
        arr1.insertRight(10);
        arr1.insertRight(20);
        arr1.insertRight(30);
        arr1.removeLeft();
        arr1.insertRight(40);
        arr1.removeRight();
        arr1.insertLeft(3);

        //arr1.insertLeft(3);
        //arr1.insertLeft(4);
        //arr1.insertLeft(5);




        if (arr1.isEmpty()) {                               //Check if there are no elements
            System.out.println("No items in Queue");
        }

        else {

            if (arr1.isFull()) {                               //Check if there are too many elements
                System.out.println("Too many items in Queue. Max allowed items is: " + maxSize);
            } else {

                System.out.println("The DeQueue: [" + arr1.toString() + " ]");    //Displaying the queue
                arr1.display();                                                   //Displaying front/rear/element information
            }
        }



    }

}