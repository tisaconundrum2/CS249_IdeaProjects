package com.project.MyArray;

/**
 * Created by User on 9/26/2014.
 */


class BubbleSortApp{
    public static void main(String[] args){
        int maxSize = 100; // array size
        bubbleSort arr; // reference to array
        arr = new bubbleSort(maxSize); // create the array
        arr.insert(1); // insert 10 items
        arr.insert(2);
        arr.insert(3);
        arr.insert(4);
        arr.insert(7);
        arr.insert(6);
        arr.insert(5);
        arr.insert(0);
        arr.insert(8);
        arr.insert(9);
        arr.display(); // display items
        arr.bubbleSort(); // bubble sort them
        arr.display(); // display them again
    } // end main()
} // end class BubbleSortApp

class SelectSortApp{
    public static void main(String[] args){
        int maxSize = 100; // array size
        selectSort arr; // reference to array
        arr = new selectSort(maxSize); // create the array
        arr.insert(1); // insert 10 items
        arr.insert(2);
        arr.insert(3);
        arr.insert(4);
        arr.insert(7);
        arr.insert(6);
        arr.insert(5);
        arr.insert(0);
        arr.insert(8);
        arr.insert(9);
        arr.display(); // display items
        arr.selectionSort(); // selection-sort them
        arr.display(); // display them again
    } // end main()
}//End of SelectSort app

class InsertSortApp{
    public static void main(String[] args){
        int maxSize = 100; // array size
        insertSort arr; // reference to array
        arr = new insertSort(maxSize); // create the array
        arr.insert(1); // insert 10 items
        arr.insert(2);
        arr.insert(3);
        arr.insert(4);
        arr.insert(7);
        arr.insert(6);
        arr.insert(5);
        arr.insert(0);
        arr.insert(8);
        arr.insert(9);
        arr.display(); // display items
        arr.insertionSort(); // insertion-sort them
        arr.display(); // display them again
    } // end main()
} // end class InsertSortApp


class QueueApp{
    public static void main(String[] args){
        Queue theQueue = new Queue(5); // queue holds 5 items
        theQueue.insert(10); // insert 4 items
        theQueue.insert(20);
        theQueue.insert(30);
        theQueue.insert(40);
        theQueue.remove(); // remove 3 items
        theQueue.remove(); // (10, 20, 30)
        theQueue.remove();
        theQueue.insert(50); // insert 4 more items
        theQueue.insert(60); // (wraps around)
        theQueue.insert(70);
        theQueue.insert(80);
        theQueue.insert(90); // error checking
        theQueue.display(theQueue);
    } // end main()
} // end class QueueApp


class deQueueApp{
    public static void main(String[] args){
        deQueue theQueue = new deQueue(5); // queue holds 5 items
        theQueue.insertRight(10);   // [10]
        theQueue.insertLeft(20);    // [20,10]
        theQueue.insertRight(30);   // [20,10,30]
        theQueue.insertLeft(40);    // [40,20,10,30]
        theQueue.removeleft();      // [20,10,30]
        theQueue.removeRight();     // [20,10]
        theQueue.removeleft();      // [10]
        theQueue.insertLeft(50);    // [50,10]
        theQueue.insertRight(60);   // [50,10,60]
        theQueue.insertLeft(70);    // [70,50,10,60]
        theQueue.insertRight(80);   // [70,50,10,60,80]
        theQueue.insertRight(30);   // [30,50,10,60,80]
        theQueue.display(theQueue);
    } // end main()
} // end class deQueueApp