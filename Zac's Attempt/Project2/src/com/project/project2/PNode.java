package com.project.project2;

import java.util.Scanner;

/**
 * Created by Zac on 10/21/2014.
 */
public class PNode {

        public long iData;              // data item (key)
        public PNode next;              // next node in the list


    // -------------------------------------------------------------
        public PNode(long id) {           // constructor
            iData = id;		// (next automatically null)
        }

        // -------------------------------------------------------------
        public void displayNode() {     // display yourself
            System.out.print(iData + " ");
        }

        public long getValue()    {
            return this.iData;
        }
    }  // end class Node


class Contest{
    private PNode current;          // ref to current node
    public PNode head;
    private int count;                 // # of nodes on list




    public Contest() {             // constructor
        count = 0;                         // no nodes in the list yet
        current = null;
    }


    public void insert(long id) {   // insert  node before current

        // COMPLETE THIS METHOD
        PNode bNode = new PNode(id);
        if(current == null) {
            bNode.next = bNode;
            head = bNode;
        }
        else if(current.next == null && current != null){
            bNode.next = current;
            current.next = bNode;
        }
        else if(current != null){
            bNode.next = current.next;
            current.next = bNode;
        }
        current = bNode;
        count++;

        System.out.println("The Person: " + current.getValue() + " was inserted");

        //for (int i = 0; i <= count; i++) {
            //current.displayNode();
            //current = current.next;
        //}
    }

    public PNode delete() {         // delete current node
        //System.out.println("Current before: " + current.getValue());
        // COMPLETE THIS METHOD
        if (count == 0) {
            System.out.println("No Nodes");
        }
        else {

            if(current == head){
                head = head.next;
            }

            PNode temp = current;
            current = null;
            current = temp;
            count--;
            for (int i = 1; i <= count; i++) {
                //current.displayNode();
                current = current.next;
            }
            System.out.println("");
            //System.out.println("The Person: " + temp.getValue() + " was deleted");
            //System.out.println("Current da: " + current.getValue());
            return temp;
        }
        return null;
    }

    public void advance() {
        current = current.next;
    }

    //public void winner() {
        //System.out.println("The Winner is Person: " + current.getValue());
    //}

    public void display() {
        if (count == 0) {
            System.out.println("No Nodes");
        } else {

            //current = current.next;

            //System.out.println("Current before: " + current.getValue());
            PNode temp = current;
            current = head;
            for (int i = 1; i <= count; i++) {
                current.displayNode();
                current = current.next;
            }
            current = temp;
            //current = head;
            //for (int i = 1; i <= count - 1; i++) {
               // current = current.next;
            //}
            System.out.println("");
            //System.out.println("Current after: " + current.getValue());
            //System.out.println("Head: " + head.getValue());
            //System.out.println("Count: " + count);
            //System.out.println("Current: " + current);

        }
    }
}                          // end class CircList



class ContestApp {

    public static void main(String[] args) {
        //PNode i;
        int countagain = 0;
        Contest arr2;
        arr2 = new Contest();

        Scanner input = new Scanner(System.in);
        //boolean exit = true;


        String whatDo = "";


        System.out.println("Welcome to the Contest.");
        System.out.println("Please enter the number of Players.");
        int players = input.nextInt();
        System.out.println("Please enter the number used to count off.");
        int counter = input.nextInt();
        System.out.println("What position would you like to start at?");
        int starter = input.nextInt();
        //whatDo = input.nextLine();

        for(int i = 1; i<=players; i++){        //Insert players
            arr2.insert(i);
            countagain++;
        }
        System.out.println("");
        arr2.display();                          //display the initial players
        //System.out.println("Countagain: " + countagain);

        for(int i = 1; i<=starter; i++){          //moves current to the correct starting position
            arr2.advance();
        }

        while(countagain > 1){                    //checks and will run until the last player remains.
            for(int j = 0; j<=counter; j++){      //moves current pointer the required amount of count times.
                arr2.advance();
            }
            arr2.delete();                        //eliminates player
            countagain--;
            //System.out.println("");
            arr2.display();                      //displays the remaining players before the loop runs through again.
        }
        System.out.println("");
        System.out.println("The Winner is Person ");
        arr2.display();                           ///Prints the last standing player.
        //arr2.winner();




/*        arr2.insert(1);
        arr2.insert(2);
        arr2.insert(3);
        arr2.insert(4);
        arr2.insert(5);
        arr2.delete();
        arr2.delete();
        arr2.insert(6);
        arr2.insert(7);

        arr2.display();
*/
    }
}


