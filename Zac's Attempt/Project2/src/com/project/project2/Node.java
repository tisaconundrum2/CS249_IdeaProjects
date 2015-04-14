package com.project.project2;

/**
 * Created by Zac on 10/19/2014.
 */
public class Node<T> {



    public T iData;              // data item (key)
    public Node<T> next;              // next node in the list

    // -------------------------------------------------------------
    public Node(T id) {           // constructor
        iData = id;
        next = null;		// (next automatically null)
    }

    // -------------------------------------------------------------
    public void displayNode() {     // display yourself
        System.out.print(iData + " ");
    }

    public T getValue()    {

        return this.iData;
    }
}  // end class Node


class Stack<T>{
    private Node<T> current;          // ref to current node
    private int count;                 // # of nodes on list
    private Node<T> bottom;



    public Stack() {             // constructor
        count = 0;                         // no nodes in the list yet
        current = null;
        bottom = null;
    }


    public void push(T id) {   // insert  node before current

        // COMPLETE THIS METHOD
        Node<T> aNode = new Node (id);
        if(current == null) {
            aNode.next = aNode;
            bottom = aNode;
        }
        else if(current.next == null && current != null){
            aNode.next = current;
            current.next = aNode;
        }
        else if(current != null){
            aNode.next = current.next;
            current.next = aNode;
        }

        current = aNode;


        count++;
        System.out.println("The Node: " + current.getValue() + " was pushed onto stack");
        //current = current.next;
    }

    public void pop() {         // delete current node

        // COMPLETE THIS METHOD
        if (count == 0) {
            System.out.println("No Nodes");

        }
        else {

            //current = bottom;
            Node temp = current;
            //current.next = temp.next;
            this.current = null;
            count--;
            current = temp;



            System.out.println("The Node: " + temp.getValue() + " was deleted");
            //return temp;
        }

        //return null;
    }


    public void display(){
        if (count == 0) {
            System.out.println("No Nodes");
        }
        else {


            current = current.next;
            for (int i = 1; i <= count; i++) {
                current.displayNode();
                current = current.next;
            }
            for (int i = 1; i <= count-1; i++) {
                current = current.next;
            }
            System.out.println("Count: " + count);
            //System.out.println("Current: " + current);

        }
    }
}                          // end class CircList



class StackApp {

    public static void main(String[] args) {
        Stack arr1;
        arr1 = new Stack();

        arr1.push("a");
        arr1.push(1);
        arr1.push("c");
        arr1.push(2);
        arr1.push(5);
        arr1.pop();
        //arr1.push(6);
        //arr1.push(7);




        arr1.display();

        //System.out.print(arr1);
    }
}




