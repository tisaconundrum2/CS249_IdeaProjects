
/**
 * Created by Zac on 11/13/2014.
 */

import java.util.*;
import java.io.*;

public class Node<T> {



    public T iData;              // data item (key)
    public Node<T> left;         // Left child in the tree
    public Node<T> right;        // Right child in the tree
    public Node<T> current;

    // -------------------------------------------------------------
    public Node(T id) {           // constructor
        iData = id;
        left = null;		// (next automatically null)
        right = null;
    }

    // -------------------------------------------------------------
    public void displayNode() {     // display yourself
        System.out.print(iData + " ");
    }

    public T getValue()    {

        return this.iData;
    }
}  // end class Node


class BST<T extends Comparable<T>> {

    private Node<T> current;          // ref to current node
    //private int count;                 // # of nodes on list
    public Node<T> root;



    public BST() {             // constructor
        //count = 0;                         // no nodes in the tree yet
        current = null;
        root = null;
    }




    public void insert(T id) {   // insert  node before current
        Node newNode = new Node(id);



        if(root == null){
            root = newNode;
        }
        else{
            current = root;
            Node parent;
            while(true){
                parent = current;

                if(id.compareTo(current.iData) < 0){
                    //System.out.println("True");
                    current = current.left;
                    if(current == null) {
                        parent.left = newNode;
                        return;
                    }
                }
                else{
                    //System.out.println("False");
                    current = current.right;
                    if(current == null) {
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }


    }

    private Node<T> getSuccessor(Node<T> delNode){

        Node<T> successorParent = delNode;
        Node<T> successor = delNode;
        Node<T> current = delNode.right;

        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if(successor != delNode.right){
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }

        return successor;

    }

    public boolean delete(T key) {

        current = root;
        Node parent = root;
        boolean isleftChild = true;

        while(key.compareTo(current.iData) != 0 ){
            parent = current;
            if(key.compareTo(current.iData) < 0){
                isleftChild = true;
                current = current.left;
            }
            else{
                isleftChild = false;
                current = current.right;
            }
            if(current == null)
                return false;
        }

        if(current.left == null && current.right == null){            //No Children
            if(current == root)
                root = null;
            else if(isleftChild)
                parent.left = null;
            else
                parent.right = null;
        }

        else if(current.right == null) {                               // 1 Child
            if (current == root)                                     // If Child is root
                root = current.left;
            else if (isleftChild)                                    // If Child was left
                parent.left = current.left;
            else
                parent.right = current.left;
        }

        else if(current.left == null) {
            if (current == root)                                     // If Child is root
                root = current.right;
            else if (isleftChild)                                    // If Child was right
                parent.left = current.right;
            else
                parent.right = current.right;
        }

        else {                                                       // 2 Children

            Node successor = getSuccessor(current);

            if(current == root)
                root = successor;
            else if(isleftChild)
                parent.left = successor;
            else
                parent.right = successor;
            successor.left = current.left;
        }
        return true;
    }

    public Node<T> find(T key){
        if(root != null) {
            current = root;
            //System.out.println("Root: " + root.getValue());
            //System.out.println("Key: " + key);
            //System.out.println(key.equals(current.iData));
            while (key.compareTo(current.iData) != 0) {
                //System.out.println("1st Current: " + current.getValue());
                if (key.compareTo(current.iData) < 0) {
                    current = current.left;
                    //System.out.println("2nd: " + current.getValue());
                }
                else
                    current = current.right;

                if(current == null) {
                    System.out.println("Does not exist");
                    return null;
                }
            }
            System.out.println("Found it: " + current.getValue());

            return current;

        }
        else
            //System.out.println("Found it: " + current.getValue());
            return root;

    }

    public void display(Node<T> root){
        //How on earth do you display a tree?!?!?
        if(root == null)
            return;

        display(root.left);

        root.displayNode();

        display(root.right);

        //System.out.println(" ");

    }

}

class BSTApp {

    public static void main(String[] args) {
        BST arr1;
        arr1 = new BST();

        arr1.insert(2.5);
        arr1.insert(4.0);
        arr1.insert(2.2);
        arr1.insert(2.7);
        arr1.insert(1.5);
        arr1.insert(3.4);
        arr1.insert(0.9);
        arr1.insert(3.0);
        arr1.insert(1.9);
        arr1.insert(3.6);
        arr1.insert(2.4);
        arr1.delete(3.4);
/*
        arr1.insert(12);
        arr1.insert(4);
        arr1.insert(6);
        arr1.insert(25);
        arr1.insert(13);
        arr1.insert(2);
        arr1.insert(8);
        arr1.delete(13);

*/

        arr1.display(arr1.root);
        System.out.println(" ");
        arr1.find(3.4);
    }
}
