class Link
{
    private int iData; // data item
    private double dData; // data item
    public Link next; // next link in list
    private int count;// count how many time made.

// ------------------------------------------------------------

    public Link(int id, double dd) // constructor
    {
        iData = id; // initialize data
        dData = dd; // ('next' is automatically
    } // set to null)
// ------------------------------------------------------------

    public void displayLink() // display ourself
    {
        System.out.print("{" + iData + ", " + dData + "} ");}
} // end class Link

class LinkList {
    private Link first; // ref to first link on list
// ------------------------------------------------------------

    public void LinkList() // constructor
    {
        first = null; // no items on list yet
    }
// ------------------------------------------------------------

    public boolean isEmpty() // true if list is empty
    {
        return (first == null);
    }

    public void insertFirst(int id, double dd)
    { // make new link
        Link newLink = new Link(i =d, dd);
        newLink.next = first; // newLink.next <-- old first (old first is going into newLink.next)
        first = newLink; // first <-- newLink (newLink is going into first.
    }

    public Link deleteFirst() // delete first item
    { // (assumes list not empty)
        Link temp = first; // save reference to link
        first = first.next; // delete it: first-->old next
        return temp; // return deleted link
    }

    public void displayList()
    {
        System.out.print("List (first-->last): ");
        Link current = first; // start at beginning of list
        while (current != null) // until end of list,
        {
            current.displayLink(); // print data
            current = current.next; // move to next link
        }
        System.out.println("");
    }

    public int getNth(int count)
    {
        return count++;
    }
}