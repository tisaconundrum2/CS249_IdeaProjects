package com.hw0.helloworld;

/**
 * Created by Zac on 8/27/2014.
 */
public class HelloWorld {

    private int[] myArray;
    private int size;
    //private final int SIZE = 10; //This constant allows us to set the size, but should be set in constructor of myArray
    private int numElem;


    public void MyArray(int size) {
        this.size = size;
        this.numElem = 0;
        myArray = new int[size];
    }
    public void insertNext(int inInt){
        myArray[numElem] = inInt;
        numElem += 1;

    }
    public void insertAtIndex(int index, int inInt){

        if (myArray[index]== 0){
            myArray[index]=inInt;
            numElem += 1;
        }
        else if (myArray[index] != 0){
            for(int from = numElem-1;from>=index;from--){
                myArray[from+1] = myArray[from];
            }
            numElem += 1;
            myArray[index]=inInt;
        }
    }

    public void insertOrder(int inInt){
        if (myArray[0]< inInt){
            this.insertAtIndex(0, inInt);
        }
        else{
            for(int i=0;i<myArray.length;i++){
                if (myArray[i]<inInt){
                    this.insertAtIndex(i,inInt);
                    break;
                }
                continue;
            }
        }
    }

    // Created by Justin Poehnelt, Jean Paul Labadne, Micheal Ortega, Zachary Qrawiz, and Tanner Stevens
    public int removeSpecificIndex(int index){
        // R.I.P. Shifty.
        int temp = this.myArray[index];
        //numElem-1
        for(int i=index;i<this.numElem-1;i++){
            this.myArray[i] = this.myArray[i+1];
        }
        this.numElem--;
        return temp;
    }
    public int removeOldest(){
        return removeSpecificIndex(0);
    }
    public boolean removeValue(int value){
        // Removes every instance of Value
        Boolean found = false;
        for(int i=0;i<this.numElem;i++){
            if(this.myArray[i]==value){
                removeSpecificIndex(i);
                found = true;
            }
        }
        return found;
    }
    /*
    Code by:
            Temitope Alaga
            Curtis Green
            Michael Debenq
            Katherine DeFonce
            Brandon Garing
        */
    public int binary_search(int value){
        int lowbound = 0, highbound = numElem, mid_val = (highbound - lowbound) / 2;
        boolean found = false;
        while(!found)
        {
            if(value == myArray[mid_val]) found = true;
            else if(value < myArray[mid_val])
            {
                if(Math.abs(highbound - lowbound) <= 1)
                    break;
                highbound = mid_val;
                mid_val = ((highbound - lowbound) /2) + lowbound;
            }
            else
            {
                if(Math.abs(highbound - lowbound) <= 1)
                    break;
                lowbound = mid_val;
                mid_val = ((highbound - lowbound) /2) + lowbound;
            }
        }
        if(found) return mid_val;
        else return -1;
    }


    public int linear_search(int value){
        for(int i = 0; i < numElem; ++i)
        {
            if(myArray[i] == value) return i;
        }
        return -1;
    }
    /* Group 4: Anthony Black, Seth Giorgianni, Andy Salazar, Zachary Patten, Ian Abshire
    */
    public void bubbleSort(){
        int out, in;

        for (out = numElem-1; out > 1; out--){
            for (in=0; in<out; in++)
                if (myArray[in]>myArray[in+1]){
                    int temp = myArray[in];
                    myArray[in]=myArray[in+1];
                    myArray[in+1]=temp;
                }
        }
    }
// Insertion sort
//
// GOLD TEAM:
// - Luke Sanchez
// - Sean Baquiro
// - Nicholas F
// - Jun Rao
// - AJ Spatz
//

    public void insertionSort() {
        int n,k; 	  						// Iterator reference variables
        int temp; 							// Temporary storage reference variable for item to-be sorted
        for(n = 0; n < numElem; n++) {
            temp = myArray[n];
            k = n;
            while((k > 0) && (myArray[k - 1]) > temp) { // Inner while loop for shifting items appropriately
                myArray[k] = myArray[k - 1];
                k--;
            }
            myArray[k] = temp;
        }
    }
    public void selectionSort (){
        int in,out,min;     //Initialize pointer variables

        for(out = 0; out < numElem-1; out++){     //Move through slowly adding values to the sorted portion of array.
            min = out;                      //Start the minimum value as the outer pointer
            for(in = out; in < numElem-1; in++){  //Move through and find the smallest value in the unsorted array.
                if(myArray[in + 1] < myArray[min]){
                    min = in + 1;
                }
            }
            int temp = myArray[out];      //Swap the minimum value into the end of the sorted array portion
            myArray[out] = myArray[min];
            myArray[min] = temp;
        }
    }

    public void printStored() {
        String out = "[";
        for (int i = 0; i < myArray.length; i++) {
            if (i != myArray.length - 1)
                out += Integer.toString(myArray[i]) + ",";
            else
                out += Integer.toString(myArray[i]) + "]";
            System.out.println(out);
        }
    }

   /* public void printAscending() {
        int[] temp = myArray;
        bubblesort(myArray);
        printStored();
        myArray = temp;
    }

    public void printDescending() {
        String out = "[";
        int[] temp = myArray;
        bubblesort(myArray);
        for (int i = myArray.length - 1; i >= 0; i--) {
            if (i != 0) {
                out += Integer.toString(myArray[i]) + ",";
            } else
                out += Integer.toString(myArray[i]) + "]";
        }
        System.out.println(out);
        myArray = temp;
    }*/

    /* Added functionality by Dr. Vanderberg */
    public String toString(){
        String output="";
        for(int i=0; i<numElem; i++)
            output = output + " " + myArray[i];
        return output;
    }

    public int getLength(){
        return size;
    }

    MyArray array1 = new MyArray(19);
    MyArray array2 = new MyArray(23);
    MyArray array3 = new MyArray(9);

    int [] sample_data = new int[] {4,6,3,1,7,9,2,10,0};

    System.out.println("*** TESTING Insert methods***");

    fillArray(array1);
    fillArray(array2);

    for(int i=0; i<sample_data.length; i++){
        //System.out.println(i);
        array3.insertOrder(i);
    }

    //CANNOT print an entire array unless MyArray has toString method
    System.out.println("Array 1 should have 19 items" + array1);
    System.out.println("Array 2 should have 23 items" + array2);
    System.out.println("Array 3 should have 9 items" + array3);

    int size = 10;					// number of items in the array
    Random random = new Random();		// initialize new random object for random numbers
    MyArray testArray = new MyArray(size);	// new test array initialized to 10 empty slots

    //populate the array with 10 random numbers between 0 and 100
    for (int i = 0; i < size; i++) {
        int rand = random.nextInt(100);
        testArray.insertNext(rand);
    }
    System.out.println("*********Testing Removing items from array*********");
    System.out.println("Original array: " + testArray.toString());

    ////////////////// Testing removing oldest index//////////////////
    System.out.println("Testing remove oldest");
    int old = testArray.removeOldest();
    System.out.println(old + " was removed from index 0.");
    System.out.println("Array now minus the first item: " + testArray.toString());

    //////////////// Testing removing item from a given index /////////////
    System.out.println("Testing remove from index 4");
    int idx4 = testArray.removeSpecificIndex(4);	// not sure about the name of this remove method
    System.out.println(idx4 + " was removed from index 4.");
    System.out.println("Array now minus 5th item: " + testArray.toString());

    ////////////// Testing removing item with a given value ///////////////
    System.out.println("Testing removing an item with the value of -1");
    testArray.insertNext(-1);  // because the random nums are all positive, I know this will be unique
    Boolean removed = testArray.removeValue(-1);  // correct method name??
    if (removed) {
        System.out.println("-1 was removed from array.");
    } else {
        System.out.println("Error removing -1!");
    }
    System.out.println("Array is now " + testArray.toString());

    int[] values = new int[] { 1, 10, 7, 5, 0 };

    MyArray arrA = new MyArray(5);
    MyArray arrB = new MyArray(5);
    MyArray arrC = new MyArray(5);

    for(int i = 0; i < values.length; i++)
    {
        arrA.insertNext(values[i]);
        arrB.insertNext(values[i]);
        arrC.insertNext(values[i]);
    }

    arrA.bubbleSort();
    arrB.insertionSort();
    arrC.selectionSort();

    System.out.println("Bubble: " + arrA.toString());
    System.out.println("Insertion: " + arrB.toString());
    System.out.println("Selection: " + arrB.toString());

    System.out.println("Find 5 using linear search. Index is: " + arrA.linear_search(5));
    //System.out.println(arrB.linear_search(0));
    System.out.println("Find 5 using binary search. Index is: " + arrA.binary_search(5));
    System.out.println("Find 4 using binary search. Index is: " + arrB.binary_search(4));

}

    public static void fillArray(MyArray array){
        Random rand = new Random();
        //need to add method getLength to MyArrayClass
        for(int i = 0; i < array.getLength(); i++){
            int random = rand.nextInt(100);
            array.insertNext(random);
        }
        //if(array.linear_search(random)!=-1){
        //  i--; //reduce i by one so we make sure to fill the entire array
        //}
        //else{
        //array.Add(random);
        //}
    }


    /*public static void fillArrayInsertion(MyArray array){
        Random rand = new Random();
        for(int i = 0; i < array.getLength(); i++){
            int random = rand.nextInt(100);
            if(array.linearSearch(random)!=-1){
                i--; //reduce i by one so we make sure to fill the entire array
            }
            else{
                array.Insert(random, 0);
            }
        }
    }*/

    /*
    public static void printArray(my_array array){
        for(int i = 0; i < array.length; i++){
            System.out.println(array.array[i]);
        }
    }*/
}