package com.company;

/**
 * Created by User on 2/16/2015.
 */
class Link
{
    public long iData; // data item
    public long dData; // data item
    public Link next; // next link in list
    public Link prev; // previous link in list
// ------------------------------------------------------------

    public Link(long id, long dd) // constructor
    {
        iData = id; // initialize data
        dData = dd;
    } // set to null)

// ------------------------------------------------------------

    public void displayLink() // display ourself
    {
        System.out.print("{" + iData + ", " + dData + "} ");}
} // end class Link

class CircList {
    private Link first;
    private Link temp;
    private Link current;
    public void CircList(){
        first = null;
    }

    public void insert(long id, long dd){
        Link newLink = new Link(id, dd);
        if (first == null){
            first = newLink;
            first.prev = null; // since it's the first set everything to null
            first.next = null;
        } else {
            current = first;
            while(current.next != null){ //while the current nodes' next is not null
                current = current.next; // goto the next node and check for a null
            }
            current.next = newLink; //once we break out of the while loop we will set the newLink
            newLink.prev = current;
            newLink.next = null;
        }
    }

    public String delete(long key){
        current = first;
        while (current.dData != key){
            current = current.next;
        }
        if (current.next == null){
            current.prev.next = null;
            current.prev = null;
        }else { //we set these two separate nodes to be connected to eachother.
            current.prev.next = current.next;
            current.next.prev = current.prev
        }
        return "This Node does not exist";
    }

    public void delete(){
        current = first;
        while (current.next != first){
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
    }

    public String find(long key){
        current = first;
        while (current.iData != key){
            current = current.next;
            if (current.iData == first.iData){
                return "Could Not find Node";
            }else {
                return "Found node: "+current.iData+", "+current.dData;
            }
        }
    }
}
