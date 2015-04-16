package com.company.hashTables;
import java.util.LinkedList;
import java.util.Queue;

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