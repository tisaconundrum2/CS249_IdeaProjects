package com.company.BinaryHashTable;

public class Link {

    public int data;
    public Link left;
    public Link right;

    public Link(int value) {
        data = value;
        left = null;
        right = null;
    }


    public int getData() {
        return data;
    }
}


