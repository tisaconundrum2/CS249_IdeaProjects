package com.company.hashTables;

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
