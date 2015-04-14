package com.company;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by User on 11/18/2014.
 */

class Node <E>{
    public int iData;
    public E dData;
    public Node leftChild;
    public Node rightChild;

    public void displayNode() {
        System.out.print('{' + iData + ", " + dData + "} ");
    }
}

class binaryTree{

    private void inOrder(Node localRoot){
        if(localRoot != null){
            inOrder(localRoot.leftChild);
            localRoot.displayNode();
            inOrder(localRoot.rightChild);
        }
    }

    private void preOrder(Node localRoot){
        if (localRoot != null){
            localRoot.displayNode();
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot){
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
            System.out.println(next.dData + " ");
            if (next.leftChild != null)
                node.add(next.leftChild);
            if (next.rightChild != null)
                node.add(next.rightChild);
        }
    }

}

