package com.company.hashTables;
import java.util.LinkedList;
import java.util.Queue;

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
