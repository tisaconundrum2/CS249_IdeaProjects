package com.company.BSTstudents;

/**
 * Comments for your BST Class
 *
 * @author
 * @version
 * @since
 */

/* 
Inheritance in Java: extends 

Java features single inheritance, which means that each class can only inherit from one other class.
When you inherit another Object by extending, your class gains all the methods and variables of that class.

Here, the Generic type "Value" is extending Comparable<Value>, which forces Value to always use the Comparable interface.
We do this because we want to ensure that any Object Type we store in our BST can be compared against similar 
Objects so that we know how to organize them.

Comparable adds the method "compareTo()" to the class that implements it, allowing us to compare objects inside 
boolean statements. For example, if the Generic object "Value" extends comparable, then I and the compiler
know that these statements will work in this Class and the Node private Class:

Value parent = root;
Value new_node = input_value;

if(new_node.compareTo(parent) <= 0) 
	System.out.println("The new node is smaller than or equal to our root value!");

If this concept is not clear, please research it online and consider visiting office hours.
You can delete this comment when you no longer need it.
*/

public class BinarySearchTree <Value extends Comparable>{

    /**
     *
     * comments for isEmpty method
     */
    public boolean isEmpty() {
        return false;
    }

    /**
     * TODO get the size of
     */
    public int getSize() {
        return 0;
    }


    /**
     * TODO Find a certain Node
     */
    public Value find(Value val) {
        return val;
    }


    /**
     * comments for insert method
     */
    public void insert(Value val) {
    }


    /**
     * comments for delete method
     */
    public void delete(Value val) {

    }


    /**
     * comments for method that prints by level order
     */
    public void printLevelOrder(){
    }


    /**
     * Comments for private inner Node class
     */
    private class Node {

        /**
         * Comments for Node constructor, note that Node is inheriting the attributes of Value from the outer class.
         */
        public Node(Value val) {

        }
        /**
         * Comments for toString override
         */
        @Override
        public String toString(){
            return null;
        }
    }
}
