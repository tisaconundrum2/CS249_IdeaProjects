/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixApp;


import java.text.DecimalFormat;

/**
 * <H1>A 2D Linked-List</H1>
 * <p>
 * Creates the functionality of a linked list with 2-dimensions.
 *
 * @author Nicholas Finch ngf4@nau.edu
 * @version 2.4
 * @since 3-24-2015
 */
public class LinkedMatrix {

    private Node2d start, current, above, currentrow; //holds the starting reference (top left)
    private int totrows; //holds the total number of rows
    private int totcols; //holds the total number of columns

    private String leadzeros="0"; // Optional! holds a value of leading zeros needed (for formatting)
    private String matrixDisplayWithSums = ""; // Optional! holds a string which represents the matrix (for efficient display)


    /**
     * Constructs the 2D-Linked List, called a "matrix".
     *
     * @param rows The number of vertical Nodes
     * @param columns The number of horizontal Nodes
     */
    public LinkedMatrix(int rows, int columns)
    {
        totrows = rows;
        totcols = columns;
        Node2d startNode = new Node2d(-1);
        start = startNode;
        current = startNode;

        int flag = 1; //Flag for usage
        for (int i = 0; i < totrows; i++){ //this is setting up our row numbers
            for (int j = 0; j < totcols; j++){ // this is setting up our column numbers
                int columnCount = i * 10;//TODO set the 10th place data to be held, this will allow for padding a number ahead in iData
                int rowCount= j + columnCount; //add the count to the row. Ex: 1 + 10 = 11

                Node2d newNode = new Node2d(rowCount);//create a new Node
                current.right= newNode; // set our current Node's right to have a newNode
                current = current.right;//move our current over one. current.right now is null and ready to have a new Node

                while (start.right != null && flag == 1){//while our start is not null and our flag has a 1 go on
                    start = start.right; // move our right over
                    above = start; // prepare our above pointer
                    flag = 0; //flag 0 so that we don't do this set of code again. 
                } //The above code is basically removing the dummy Node that we created from earlier.
            }
        }
        current = start; // prepare our current pointer (this pointer will move throughout the matrix)
        int size = 0;
        //TODO create the traversal that traverses pass our first row
        //and adds our pointers of down to their correct Nodes.
        while (size < totcols-1){
            current = current.right;
            size++;
        }
        //add all our down nodes.
        while (current.right != null){
            above.down = current.right; //sew these two nodes together
            above = above.right; //move our above over 1
            current = current.right;
        }
        current = start;
        //TODO we need to cut off the ends of each of our rows
        size = 0;
        while (current.right != null){ //while the current's right pointer is not null go on
            while (size < totcols-1){ // check your size against totcols, this will allow you to find how far you need to go
                current = current.right; // traverse the matrix
                size++; // increment our size.
            }
            size = 0;
            currentrow = current.right; //allow a recovery over creating a null;
            current.right = null; //cut the cable
            current = currentrow; //recover from the cut            
            if (currentrow.down == null){
                break; //break us out when we know that we have reached a point of no passing.
            }
        }

        //cleaning up our mess. and bringing all pointers back to the source
        currentrow = start; //reset our currentrow so other functions may be able to use it.
        current = start;
        above = start;
    }

    /**
     * Inserts a value at a specific location in the matrix.
     *
     * @param val
     * @param
     * @param
     * @param
     * @return
     */
    public boolean insert(Integer val, int row, int col)
    {
        //TODO return true if we can insert.

        for (int i = 0; i < col - 1; i++) {
            //TODO GO over amount of columns, using current.right
            //TODO check to see if the current.right's node is not null, if it is we return false
            if (current.right != null){ //as long as we aren't hitting a null area, keep on moving it to the right
                current = current.right; //move our current over
            }
            else {
                return false;
                //we've found a null spot, we can't move anymore, return false we can't input a val.
            }

        }
        for (int j = 0; j < row - 1; j++){
            //TODO Go down amount of rows, using current.down
            //TODO check to see if the current.down's node is not null
            if (current.down != null){
                current = current.down;
            }
            else {
                return false;
                //we've found a null spot.
            }
        }

        //TODO return true if we find that we can add data.
        //TODO add the new data into the current node.
        current.value = val;
        //Put current back where it belongs.
        current = start;
        return true;
    }

    /**
     * Insert value at all matrix locations.
     *
     * @param val the value to override all matrix positions
     */
    public void insertAll(Integer val)
    {
        //TODO utilize the insert function that was created and turn each element into the val
        //It returns a boolean, thus we can check if we can add to an area.
        //TODO use the traversing program that was used to add data into each node.
        /*[  ][  ][  ][  ]-| //when current hits null, use currentrow.down to move us down
        * [  ][  ][  ][  ]-| //move currentrow down as well.
        * [  ][  ][  ][  ]-| //current = currentrow.down; currentrow = current.down
        * [cr][  ][  ][c ]-| //when currentrow and current have reached a null we are finished
        * utilize two for loops that will move across and down in the linked list.
        *   //TODO do some work here and insert data, use the insert function, it has the ability to insert in any position we'll take advantage of this.
        *   //TODO set the value, and then move to another position and add that value data.
        *   insert(val, row, col);
        */
        for (int moveRow = 0; moveRow <= totrows; moveRow++){//iterate until moveRow and totrows are the samve value.
            for (int moveCol = 0; moveCol <= totcols; moveCol++){//iterate until moveCol and totcols are the samve value.
                insert(val, moveRow, moveCol);
            }
        }
    }

    /**
     * Returns a string representation of the matrix without trailing row and column summations.
     *
     * @return a string representation of the matrix
     */
    public String display()
    {
        String matrixString = "";
        while (currentrow != null){
            while (current != null){
                if (current.value < 10){
                    matrixString += "[" + leadzeros + current.value + "] ";
                }
                else{
                    matrixString += "[" + current.value + "] ";// throw the result into the string
                }
                current = current.right; //move our current over 1
            }
            matrixString += "\n";//break line so we can make a proper matrix
            current = currentrow.down; //when current hits null, use currentrow.down to move us down 
            currentrow = currentrow.down; // move currentrow down as well
        }
        //cleaning up our mess. and bringing all pointers back to the source
        currentrow = start;
        current = start;
        above = start;
        return matrixString;
    }

    /**
     * Returns a string representation of matrix with summations.
     * @return a string representation of the matrix with row/col sums
     */
    public String displaySummed()
    {
        /*[cr][  ][  ][  ]-|  //when current hits null, use currentrow.down to move us down 
        * [  ][  ][  ][  ]-| //current = current.down
        * [  ][  ][  ][  ]-| //move currentrow down as well. currentrow = currentrow.down; 
        * [cr][  ][  ][c ]-| //when currentrow and current have reached a null we are finished
        */
        int sum = 0;
        String matrixString = "";
        while (currentrow != null){
            while (current != null){
                if (current.value < 10){
                    matrixString += " [" + leadzeros + current.value + "] ";
                }
                else{
                    matrixString += " [" + current.value + "] ";// throw the result into the string
                }
                sum += current.value;
                current = current.right; //move our current over 1
            }
            matrixString += "{"+sum+"}";
            sum = 0;
            matrixString += "\n";//break line so we can make a proper matrix
            current = currentrow.down; //when current hits null, use currentrow.down to move us down 
            currentrow = currentrow.down; // move currentrow down as well
        }
        //cleaning up our mess. and bringing all pointers back to the source
        currentrow = start;
        current = start;
        above = start;

        while (currentrow != null){
            while (current != null){
                sum += current.value;
                current = current.down; //move our current over 1
            }
            matrixString += "{"+sum+"} ";
            sum = 0;
            currentrow = currentrow.right; // move our current over
            current = currentrow; //move our current to where currentrow is so we can iterate down again
        }
        //cleaning up our mess. and bringing all pointers back to the source
        currentrow = start;
        current = start;
        above = start;
        return matrixString;
    }

    /**
     * Optional!! If you like a challenge, use regular expressions in this method to format a string
     * for the display method.
     * Private method which updates the string representation of the matrix based on actual values.
     */
    public void updateDisplaySummed()
    {
        return;
    }

    /**
     * Private inner class Node2d, represents elements in the 2d Linked List
     */
    private class Node2d {

        private Node2d right;
        private Node2d down;
        private Integer value;

        public Node2d(Integer myvalue)
        {
            right = null;
            down = null;
            value = myvalue;
        }

        public void setRight(Node2d toright)
        {
            right = toright;
        }

        public Node2d getRight()
        {
            return right;
        }

        public void setDown(Node2d todown)
        {
            down = todown;
        }

        public Node2d getDown()
        {
            return down;
        }

        @Override
        public String toString()
        {
            return null;
        }

        public void setValue(int value)
        {
            this.value = value;
        }

        public Integer getValue()
        {
            return value;
        }
    }
}
