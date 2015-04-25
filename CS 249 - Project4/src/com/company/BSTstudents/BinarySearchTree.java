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

import java.util.LinkedList;
import java.util.Queue;

/**
 * The student now has a Name and GPA.
 * call student.getName() to access their name
 * call student.getGPA() to access their GPA
 */


public class BinarySearchTree <Value extends Comparable>{
    private Value key;
    private Node parent, current, root; //remember Value can be anything. in this case it will be holding a student
    private int n;

    public BinarySearchTree() {

    }


    /**
     *
     * TODO check to see the current Node is null.
     */
    public boolean isEmpty() {
        if (n <= 0)
            return true;
        return false;
    }

    /**
     * TODO get the size of what?
     */
    public int getSize() {
        return n;
    }


    /**
     * TODO Find a certain Node
     */
    public Node find(Value key) { // (assumes non-empty tree)
        current = parent; // start at root
        while(key.compareTo(current.val) != 0 ) // while no match,
        {
            if(key.compareTo(current.val) < 0)// go left?
                current = current.leftChild;
            else
                current = current.rightChild; // or go right?
            if(current == null) // if no child,
                return null; // didn't find it
        }
        return current; // found it
    }


    /**
     * TODO insert a Node into the BST,
     * if it's empty simply add to the root
     * if it's not, do a check on it's value
     * place the element in the left or right
     */
    public void insert(Value val) {
        Node newNode = new Node(val); //create the new node to be inserted
        if(parent == null){ //if the root is null add the newNode to it
            n++;    //increment our number of items.
            parent = newNode; //the root is a Value type. Which means that it holds a student.
            current = parent;   //also add our current to be at the root as well
        }
        else{ //else lets start exploring the depths of the tree
            //move our current pointer around
            while (current.leftChild != null && current.val.compareTo(newNode.val) >= 0)
                current = current.leftChild;
            while (current.rightChild != null && current.val.compareTo(newNode.val) < 0)
                current = current.rightChild;

            if (current.val.compareTo(newNode.val) >= 0){ //while the current value compared to the newNode is grtr than
                current.leftChild = newNode; //move to the right side
                n++; //increment our number of items.
                current = parent; //put it back at the top;

            }
            if (current.val.compareTo(newNode.val) < 0){ //while the current value compared to the newNode is less than
                current.rightChild = newNode; //move to the left side
                n++; //increment our number of items.
                current = parent; //put it back at the top;
            }
        }
    }


    /**
     * TODO seach through the BST
     * find the student with the key value
     * delete that Node. Get a successor to
     * replace the deleted Parent
     *
     * start at root,
     * if key value
     *  delete
     *  getSuccessor()
     * else
     *  while (!null && !key)
     *      go left or right.
     *      getSuccessor()
     *  return does not exist
     *
     */
    public String delete(Value key){
        if (deleted(key)){
            return key + " was Deleted\n";
        }
        else {
            return key + " doesn't seem to exist.\n";
        }
    }

    private boolean deleted(Value key) {
        current = parent;
        boolean isleftChild = true;
        while(key.compareTo(current.val) != 0 ){
            parent = current;
            if(key.compareTo(current.val) < 0){
                isleftChild = true;
                current = current.leftChild;
            }
            else{
                isleftChild = false;
                current = current.rightChild;
            }
            if(current == null)
                return false;
        }

        if(current.leftChild == null && current.rightChild == null){            //No Children
            if(current == root)
                root = null;
            else if(isleftChild)
                parent.leftChild= null;
            else
                parent.rightChild= null;
        }
        else if(current.rightChild== null) {                               // 1 Child
            if (current == root)                                     // If Child is root
                root = current.leftChild;
            else if (isleftChild)                                    // If Child was left
                parent.leftChild= current.leftChild;
            else
                parent.rightChild= current.leftChild;
        }

        else if(current.leftChild== null) {
            if (current == root)                                     // If Child is root
                root = current.rightChild;
            else if (isleftChild)                                    // If Child was right
                parent.leftChild= current.rightChild;
            else
                parent.rightChild= current.rightChild;
        }

        else {                                                       // 2 Children

            Node successor = getSuccessor(current);

            if(current == root)
                root = successor;
            else if(isleftChild)
                parent.leftChild= successor;
            else
                parent.rightChild= successor;
            successor.leftChild= current.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node delNode){

        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != delNode.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;

    }

    /**
     * TODO Print the BST in Level Order.
     * Utilize your BST methods from your previous
     * assignment
     */

    public void printLevelOrder() {
        Node localRoot = parent;
        Queue node = new LinkedList();
        if (localRoot != null)
            node.add(localRoot);
        while (!node.isEmpty()){
            Node next = (Node) node.remove();
            System.out.println(next + " ");
            if (next.leftChild != null)
                node.add(next.leftChild);
            if (next.rightChild != null)
                node.add(next.rightChild);
        }

    }





    public class Node<T> {
        /**
         * TODO BST Node
         * It should have these
         * remember the value can be anything
         * Node
         * [Value   ]
         * [Left    ]
         * [Right   ]
         *
         * Value
         * [Simple Student]
         * [NAME          ]
         * [GPA           ]
         */

        Node leftChild;
        Node rightChild;
        Value val;

        public void setVal(Value val){
            this.val = val;
        }

        /**
         * TODO null out the left and right child.
         * note that Node is inheriting the attributes of Value from the outer class.
         */
        public Node(Value val) {
            this.val = val;
            leftChild = null;
            rightChild = null;
        }
        /**
         * Comments for toString override
         * print the actual tree.
         */
        @Override
        public String toString(){
            return val.toString();
        }
    }
}
/**
 * Souces
 * http://introcs.cs.princeton.edu/java/44st/LinkedListST.java.html
 */