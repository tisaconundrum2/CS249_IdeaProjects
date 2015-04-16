package com.company.hashTables;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HashTreeApp{
    public static void main(String[] args) throws IOException {
        int aKey;
        Node aDataItem;
        int size, n, keysPerCell = 10;
// get sizes
        System.out.print("Enter size of hash table: ");
        size = getInt();
        System.out.print("Enter initial number of items: ");
        n = getInt();
// make table
        HashTable theHashTable = new HashTable(size);
        for(int j=0; j<n; j++)  {       // insert data
            aKey = (int)(java.lang.Math.random() * keysPerCell * size);

            aDataItem = new Node(aKey);
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
                    aKey = getInt();
                    aDataItem = new Node(aKey);
                    theHashTable.insert(aDataItem);
                    break;
                case 'f':
                    System.out.print("Enter key value to find: ");
                    aKey = getInt();
                    aDataItem = theHashTable.find(aKey);
                    if(aDataItem != null)
                        System.out.println("Found " + aDataItem.iData);
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