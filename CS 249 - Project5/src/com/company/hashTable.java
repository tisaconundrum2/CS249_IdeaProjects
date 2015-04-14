package com.company;

/**
 * Created by User on 12/5/2014.
 */

import java.util.LinkedList;
import java.util.Queue;

/**

 TODO you will create an array of null pointers that have binary tree objects in them
 TODO each object will have a parent root that will be used first.
 TODO all collisions will be amended through the binary function

 [0x00, 0x01, 0x02, 0x03]

 0x00
 |_ 1
 |_ null
 |_ null

 0x01
 |_ 2
 |_ null
 |_ null

 TODO insert some data
 insert(data)
 TODO use the size of the table as a means to find the index
 insert(2)

 0x01
 |_ 2
 |_ 12
 |_ null



 401 for SortedList code
 286 for BinarySort Code
 */

class Node{
    //TODO create your key function
    //your key is created modulo'ing the dataItem variable.
    //Thus there technically is no reason to create a dData variable.
    //But whatever, keep it there because levelOrder needs it.
    public int iData;
    public Node rightChild, leftChild;

    public Node(int iData) {
        this.iData = iData;
    }

    public int displayNode(){
        return iData;
    }
}

class binaryTree{
    //TODO instead of a SortedList class, we'll make a binary tree
    //TODO reference the Node.
    private Node root;

    public Node find(int key)
    {
        Node current = root;
        while (current.iData != key){
            if (key < current.iData)
                current = current.leftChild;
            else
                current = current.rightChild;
            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(int iData)
    {
        Node newNode = new Node(iData);
        if (root == null)
            root = newNode;
        else {
            Node current = root;
            Node parent = null;
            while (true){
                if (iData < current.iData){
                    current = current.leftChild;
                    if (current == null){
                        parent.leftChild = newNode;
                        return;
                    }//end if
                }//end if
                else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = newNode;
                        return;
                    }//end if
                }//end else
            }//end while
        }//end else
    }//end insert

    public boolean delete(int key)
    {
        Node current = root;
        Node parent = root;
        boolean leftChildChild = true;

        while (current.iData != key)
        {
            parent = current;
            if (key < current.iData)
            {
                leftChildChild = true;
                current = current.leftChild;
            }
            else
            {
                leftChildChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;
        }//end while

        if (current.leftChild == null && current.rightChild == null)
        {
            if (current == root)
                root = null;
            else if (leftChildChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        }
        else if (current.rightChild == null) {
            if (current == root)
                root = current.leftChild;
            else if (leftChildChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        }
        else if (current.leftChild == null){
            if (current == root)
                root = current.rightChild;
            else if (leftChildChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        }
        else {
            Node successor = getSuccessor(current);
            if (current == root)
                root = successor;
            else if (leftChildChild)
                parent.leftChild = successor;
            else
                parent.leftChild = successor;
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    private Node getSuccessor(Node delNode)
    {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; // go to right child
        while(current != null) // until no more
        { // left children,
            successorParent = successor;
            successor = current;
            current = current.leftChild; // go to left child
        }

        if(successor != delNode.rightChild) // right child,
        { // make connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    //gets min and max
    public Node minimum() // returns node with minimum key value
    {
        Node current, last = null;
        current = root; // start at root
        while(current != null) // until the bottom,
        {
            last = current; // remember node
            current = current.leftChild; // go to left child
        }
        return last;
    }

    public Node maximum() // returns node with minimum key value
    {
        Node current, last = null;
        current = root; // start at root
        while(current != null) // until the bottom,
        {
            last = current; // remember node
            current = current.rightChild; // go to right child
        }
        return last;
    }

    //Various ways of displaying your table data.
    //you can choose how you want to do it.
    private void inOrder(Node localRoot){
        if(localRoot != null){
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
        }
    }

    private void preOrder (Node localRoot){
        if (localRoot != null){
            localRoot.displayNode();
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void postOrder (Node localRoot){
        if (localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            localRoot.displayNode();
        }
    }

    private void levelOrder(Node localRoot){
        Queue node = new LinkedList();
        if (localRoot != null)
            node.add(localRoot);
        while (!node.isEmpty()){
            Node next = (Node) node.remove();
            System.out.println(next.iData + " ");
            if (next.leftChild != null)
                node.add(next.leftChild);
            if (next.rightChild != null)
                node.add(next.rightChild);
        }
    }


}//end binaryTree

class HashTable {
    //TODO Set up the necessary variables
    Node[] hashArray; //this has an unknown size but its simply setting it up to be an array of dataItems
    int arraySize;
    Node nonItem;

    public HashTable(int arraySize){
        //TODO constructor. Get the arraySize
        this.arraySize = arraySize;
        hashArray = new Node[arraySize];
        nonItem = new Node(-1); //a deleted item has a key of -1
        // **Note nulling out the key is a bad idea because then
        // the Node is nonexistent subsequently deleting all nodes after it.
        //we obviously don't want that.
    }//end hashTable

    public void displayTable(){
        //TODO displays your hastable, however you only want to show the root of each parent tree.
        System.out.print("Table: ");;
        for (int j = 0; j<arraySize; j++){
            if (hashArray[j] != null)//check to see if the key has  root
              inOrder(hashArray[j]);//if it does go ahead and start displaying the key's root and children
        }
        System.out.println("");
    }//end displayTable

    private void inOrder(Node localRoot){
        if(localRoot != null){
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
        }
    }

    private void preOrder (Node localRoot){
        if (localRoot != null){
            localRoot.displayNode();
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void postOrder (Node localRoot){
        if (localRoot != null){
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            localRoot.displayNode();
        }
    }

    private void levelOrder(Node localRoot){
        Queue node = new LinkedList();
        if (localRoot != null)
            node.add(localRoot);
        while (!node.isEmpty()){
            Node next = (Node) node.remove();
            System.out.println(next.iData + " ");
            if (next.leftChild != null)
                node.add(next.leftChild);
            if (next.rightChild != null)
                node.add(next.rightChild);
        }
    }

    public int hashFunc (int key){
        //TODO this function gives you the ability to place your Nodes in the right place within the array
        //Note it does not actually place your array in the right place. You'll have to do that yourself.
        return key%arraySize;
    }//end hashFunc()

    public void insert (Node item){
        int key = item.iData; //item is an object, it has dataItem in it. turn that into a key
        int hashVal = hashFunc(key);//now use the hashFunc() function to find where this particular node belongs
//        while (hashArray[hashVal] != null && hashArray[hashVal].iData != -1){
//            //TODO deal with collisions here. Use your insertion method from binaryTree
//            binaryTree parent = new binaryTree();
//            parent.insert(hashArray[hashVal].iData);
//        }//end while
//        hashArray[hashVal] = item;
        Node newNode = new Node(key);
        if (hashArray[hashVal] == null)
            hashArray[hashVal] = newNode;
        else{
            Node current = hashArray[hashVal];
            Node parent;
            while (true){
                parent = current;
                if (key< current.iData) { //go left?
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else {
                    current = current.rightChild;
                    if (current == null){
                        parent.rightChild = newNode;
                        return;
                    }
                }//end else
            }//end while
        }//end else not root
    }//end insert()

    public Node delete(int key) // delete a DataItem
    {
        int hashVal = hashFunc(key); // hash the key
        while(hashArray[hashVal] != null) // until empty cell,
        { // found the key?
            if(hashArray[hashVal].iData == key)
            {
                Node temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem; // delete item
                return temp; // return item
            }
            ++hashVal; // go to next cell
            hashVal %= arraySize; // wraparound if necessary
        }
        return null; // can't find item
    } // end delete()

    public Node find(int key) // find item with key
    {
        int hashVal = hashFunc(key); // hash the key
        inOrder(hashArray[hashVal]);
        return null; // can't find item
    }//end find



}//end HashTable
