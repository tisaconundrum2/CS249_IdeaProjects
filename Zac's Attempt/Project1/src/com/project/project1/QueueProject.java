package com.project.project1;

/**
 * Created by Zac on 9/24/2014.
 */
public class QueueProject {

    private long [] QuArray;
    private int size;                                       //should be set in constructor of array
    private int numElem;
    private int front;                                      //keep track of where front and rear of array is
    private int rear;

    public QueueProject(int size) {
        this.size = size;
        this.numElem = 0;
        QuArray = new long[size];
        front = 0;
        rear = -1;
    }

    public void insert(int inInt) {                         //The insert method for adding to the queue
        if (rear == size - 1) {                             //For the wrap around
            rear = -1;
        }
        QuArray[++rear] = inInt;
        numElem++;

    }

    public void remove() {                              //The remove method for deleting from the queue
        if (front == size-1)                            //For the wrap around
            front = -1;
        numElem--;                                      //Note that this only removes element from queue, NOT from the array
        front++;
    }

    public boolean isFull(){
        return (numElem > size);
    }  //Check if queue had max allowed elements

    public boolean isEmpty(){
        return (numElem == 0);
    }   //Check if queue has no elements in it

    public void display() {                                 //Displays where front and rear are located
        //System.out.println("size: " + size);
        System.out.println("Front index: " + front + " = Front element: " + QuArray[front]);
        System.out.println("Rear index: " + rear + " = Rear element: " + QuArray[rear]);
        System.out.println("# of elements: " + numElem);
    }

    public String toString(){                               //So that I can print the array
        String output="";
        for(int i=0; i<size; i++)
            output = output + " " + QuArray[i];
        return output;
    }
}


class QueueProjectApp{                                      //The driver

    public static void main(String[] args) {
        int maxSize = 6;
        QueueProject arr;
        arr = new QueueProject(maxSize);

        /*arr.insert(10);                                     //Add or remove elements from queue
        arr.insert(20);
        arr.insert(30);
        arr.insert(40);
        arr.insert(50);
        arr.insert(60);
        arr.remove();
        arr.remove();
        arr.remove();
        arr.remove();
        arr.insert(70);
        arr.insert(80);
        arr.remove();
        arr.remove();*/


        if (arr.isEmpty()) {                                    //Check if there are no elements
            System.out.println("No items in Queue");
        }

        else {

            if (arr.isFull()) {                                //Check if there are too many elements
                System.out.println("Too many items in Queue. Max allowed items is: " + maxSize);
            } else {

                System.out.println("The Queue: [" + arr.toString() + " ]");          //Displaying the queue
                arr.display();                                                       //Displaying front/rear/element information

            }
        }



    }

}
