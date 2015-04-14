import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by Zac on 9/29/2014.
 */
public class Node {

    public long iData;              // data item (key)
    public Node next;              // next node in the list

    // -------------------------------------------------------------
    public Node(long id) {           // constructor
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


/*class CircList{
    private Node current;          // ref to current node
    private int count;                 // # of nodes on list




    public CircList() {             // constructor
        count = 0;                         // no nodes in the list yet
        current = null;
    }


    public void insert(long id) {   // insert  node before current

        // COMPLETE THIS METHOD
        Node aNode = new Node(id);
        if(current == null) {
            aNode.next = aNode;
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
        System.out.println("The Node: " + current.getValue() + " was inserted");
    }

    public Node delete() {         // delete current node

        // COMPLETE THIS METHOD
        if (count == 0) {
            System.out.println("No Nodes");

        }
        else {
            Node temp = current;
            //current.next = temp.next;
            current = null;
            current = temp.next;
            count--;
            System.out.println("The Node: " + temp.getValue() + " was deleted");
            return temp;
        }
        return null;
    }

   public Node find(long key) {     // find first node starting at current with given key

        // COMPLETE THIS METHOD
       int i;

       for(i=1; i<=count-1; i++){
           if(current.iData == key) {
               return current;
           }
           current = current.next;
           //System.out.println(i);
       }
       //System.out.println(i);
       if(i==count)
           System.out.println("No such element exists");

       return null;
    }

    public Node delete(long key) {    // delete node with given key

        // COMPLETE THIS METHOD
        int i;
        if (count == 0) {
            System.out.println("No Nodes");
        }

        for(i=1; i<=count; i++){
            if(current.iData == key){
                Node temp = current;
                current = null;
                current = temp.next;
                count--;
                System.out.println("The Node: " + temp.getValue() + " was deleted");
                return temp;
            }
            current = current.next;
        }
        if(i==count)
            System.out.println("No such element exists");

        return null;
    }

    public void display(){
        for(int i=1; i<=count; i++){
            current.displayNode();
            current = current.next;
        }
        System.out.println("Count: " + count);
        //System.out.println("Current: " + current);
    }
}                          // end class CircList



class CircListApp {

    public static void main(String[] args) {
        CircList arr1;
        arr1 = new CircList();

        arr1.insert(5);
        arr1.insert(1);
        arr1.insert(7);
        arr1.insert(12);
        arr1.insert(3);
        arr1.insert(11);
        arr1.insert(9);
        //arr1.delete();
        //arr1.delete();
        //arr1.delete();
        //arr1.delete();

        //arr1.find(5);



        arr1.display();
        //System.out.print(arr1);
    }
}

*/

class singList {
    private Node first;          // ref to current node
    private int size;                 // # of nodes on list


    public singList() {             // constructor
        size = 0;                         // no nodes in the list yet
        first = null;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(long id) {   // insert  at first position.

        // COMPLETE THIS METHOD
        Node aNode = new Node(id);
        aNode.next = first;
        first = aNode;
        size++;
        System.out.println("The Node: " + first.getValue() + " was inserted");
    }

    public Node deleteFirst() {         // delete first node.

        // COMPLETE THIS METHOD
        Node temp = first;
        //current.next = temp.next;
        first = first.next;
        size--;
        System.out.println("The Node: " + temp.getValue() + " was deleted");
        return temp;

    }

    public void displayList() {
        System.out.print("List (first-->last): ");
        Node current = first;
        while (current != null) {
            current.displayNode();
            current = current.next;
        }
        System.out.println(" ");
    }

    public int count(int key) {
        int count = 0;                          //Initialize count variable at 0
        Node current = first;
        while (current != null) {
            if (current.getValue() == key) {
                count++;
            }
            current = current.next;
        }
        System.out.println("Count: " + count);
        System.out.println("  ");
        return count;
    }

    public Node getNth(int key) {

        if(key > size){
            System.out.println("Not in Range");
        }

        else{
        Node current = first;
        for (int i = 1; i < key; i++) {
            current = current.next;
        }
        System.out.println("Nth Node: " + current.getValue());
        System.out.println("  ");
        return current;
        }
        return null;
    }

    public void insertNth(int key, long id) {

        if (key > size+1) {
            System.out.println("Not in Range");
        } else {
            if (key == 1) {
                Node aNode = new Node(id);
                aNode.next = first;
                first = aNode;
                size++;
                System.out.println("The Node: " + first.getValue() + " was inserted");
            }

             else {
                Node current = first;
                for (int i = 1; i < key - 1; i++) {
                    current = current.next;
                }
                //System.out.println("Nth Node: " + current.getValue());
                Node aNode = new Node(id);
                aNode.next = current.next;
                current.next = aNode;
                size++;
                System.out.println("The Node: " + current.next.getValue() + " was inserted at the " + key + " position");
            }
        }
    }

    public Node reverse() {
        Node prev = null;
        Node current = first;
        Node next = current.next;
        while(current.next != null) {
            current.next = prev;
            prev = current;
            current = next;
            next = current.next;
        }
        current.next = prev;
        first = current;
        return current;
    }

}


class singListApp {

    public static void main(String[] args) {
        singList arr1;
        arr1 = new singList();


        arr1.insertFirst(5);
        arr1.insertFirst(1);
        arr1.insertFirst(7);
        arr1.insertFirst(12);
        arr1.insertFirst(7);
        arr1.insertFirst(11);
        arr1.insertFirst(7);
        arr1.insertNth(4,18);


        //arr1.displayList();
        //arr1.reverse();
        arr1.displayList();

        arr1.count(7);
        //arr1.Nth(8);




    }
}