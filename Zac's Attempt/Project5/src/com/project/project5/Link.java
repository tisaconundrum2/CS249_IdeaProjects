package com.project.project5;
import java.io.*;

/**
 * Created by Zac on 12/4/2014.
 */
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

        while(hashArray[hashVal] != null) {
            if (hashArray[hashVal].getData() == key)
                return key;
            ++hashVal;
            hashVal %= arraySize;
        }
        return key;
    }

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


class HashTreeApp{
    public static void main(String[] args) throws IOException{
        int aKey, aDataItem;
        int size, n, keysPerCell = 10;
        // get sizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
        // make table
        HashTable theHashTable = new HashTable(size);
        for(int j=0; j<n; j++)  {       // insert data
            aDataItem = (int)(java.lang.Math.random() * keysPerCell * size);
            theHashTable.insert(aDataItem);
        }
        while(true){                 // interact with user
            System.out.print("Enter first letter of ");
            System.out.print("show, insert, or find: ");
            char choice = getChar();
            switch(choice){
                case 's':
                    theHashTable.displayTable();
                    break;
                case 'i':
                    System.out.print("Enter key value to insert: ");
                    aDataItem = getInt();
                    theHashTable.insert(aDataItem);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if(aDataItem != -1)
                        System.out.println("Found " + aDataItem);
                    else
                        System.out.println("Could not find " + aKey);
                    break;
                default:
                    System.out.print("Invalid entry\n");
            }  // end switch
        }  // end while
    }  // end main()
    //--------------------------------------------------------------
    public static String getString() throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
    //-------------------------------------------------------------
    public static char getChar() throws IOException{
        String s = getString();
        return s.charAt(0);

    }
    //-------------------------------------------------------------
    public static int getInt() throws IOException{
        String s = getString();
        return Integer.parseInt(s);
    }
//--------------------------------------------------------------
}  // end class HashTreeApp

