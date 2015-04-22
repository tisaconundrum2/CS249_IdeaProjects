package com.company.BinaryHashTable;

/**
 * Created by User on 4/22/2015.
 */
class HashTable{

    public Link[] hashArray;
    public int arraySize;

    public HashTable(int aSize){
        hashArray = new Link[aSize];
        arraySize = 0;

    }

    public void insert(int value){
        arraySize ++;
        int pos = hashFunc(value);
        Link root = hashArray[pos];
        root = insert(root, value);
        hashArray[pos] = root;
    }

    public Link insert(Link node, int data){
        if (node == null)
            node = new Link(data);
        else{
            if(data <= node.data)
                node.left = insert(node.left, data);
            else
                node.right = insert(node.right, data);
        }
        return node;
    }


    public int find(int key){
        int hashVal = hashFunc(key);
        Link current = hashArray[hashVal];
        while (key < current.data && current.left != null) {
            current = current.left;
            if (key == current.data)
                return key;
        }
        while (key > current.data && current.right != null){
            current = current.right;
            if (key == current.data)
                return key;
        }

        return -1;
    }



//
//            if (hashArray[hashVal].getData() == key)
//                return key;
//            ++hashVal;
//            hashVal %= arraySize;
//        }
//        return key;
//    }

    private int hashFunc(Integer x){
        int hashVal = x.hashCode();
        hashVal %= hashArray.length;
        if(hashVal < 0)
            hashVal += hashArray.length;
        return hashVal;
    }

    public void displayTable(){
        System.out.println();
        for(int i=0; i< hashArray.length; i++){
            System.out.print("Table" + i + ": ");
            inOrder(hashArray[i]);
            System.out.println();
        }
    }

    private void inOrder(Link r){
        if(r != null){
            inOrder(r.left);
            System.out.print(r.data + " ");
            inOrder(r.right);
        }
    }

}
