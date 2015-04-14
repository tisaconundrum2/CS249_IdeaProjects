package com.company.Recycle.bin;

/**
 * Created by User on 10/23/2014.
 */
// linkList2.java
// demonstrates linked list
// to run this program: C>java LinkList2App
////////////////////////////////////////////////////////////////
class Link{
    public int iData; // data item (key)
    public double dData; // data item
    public Link next; // next link in list
// ------------------------------------------------------------
    public Link(int id, double dd) // constructor
    {
        iData = id;
        dData = dd;
    }

    public void displayLink()
    {
        System.out.print("{" + iData + ", " + dData + "} ");
    }
}

class LinkList{
    private Link first; // ref to first link on list
    public LinkList(){ //init constructor
        first = null;
    }

    public void insertFirst(int id, double dd){
        Link newLink = new Link(id, dd); //Type variable = new Function(par, par); put the returned data from Function into variable.
        newLink.next = first;   //put old first into next node
        first = newLink;        //put newLink into first node

    }

    public void closeLoop(){
        //Traverse through the links and see who has a null pointer.
        //When the null pointer is found, set it to point to the first link.
        //the only problem with this, is that the hard code must be readjusted when adding in a newLink
        //In other words the closeLoop function must be moved in Main.
        Link current = first;
        while (current.next != null)
            current = current.next;// go to next link
        current.next = first;
    }

    public Link find(int key){
        Link current = first; // start at 'first'
        while(current.iData != key){
            if(current.next == null) // if end of list,
                return null; // didn't find it
            else // not end of list,
                current = current.next; // go to next link
        }
        return current;
    }

    public Link delete(int key){
        Link current = first; // search for link
        Link previous = first;
        while(current.iData != key){
            if(current.next == null)
                return null; // didn't find it
            else{
                previous = current; // go to next link
                current = current.next;
            }
        }
        if (current == first)
            first = first.next;
        else
            previous.next = current.next;
        return current;
    }

    public void displayList(){
        System.out.print("List (first-->last): ");
        Link current = first; // start at beginning of list
        while(current != first) // until end of list,
        {
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }

}