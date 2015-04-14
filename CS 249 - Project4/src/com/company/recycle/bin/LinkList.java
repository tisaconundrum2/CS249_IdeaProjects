//package com.company.recycle.bin;
//
///**
// * Created by Nicholas on 4/9/2015.
// */
//class LinkList {
//    private Link first; // ref to first link on list
//
//    // ------------------------------------------------------------
//    public void LinkList() // constructor
//    {
//        first = null; // no items on list yet
//    }
//
//    // ------------------------------------------------------------
//    public boolean isEmpty() // true if list is empty
//    {
//        return (first == null);
//    }
//
//    // ------------------------------------------------------------
//    public void insertFirst(int id)
//    { // make new link
//        Link newLink = new Link(id);
//        newLink.next = first; // newLink --> old first
//        first = newLink; // first --> newLink
//    }
//
//    // ------------------------------------------------------------
//    public Link deleteFirst() // delete first item
//    { // (assumes list not empty)
//        Link temp = first; // save reference to link
//        first = first.next; // delete it: first-->old next
//        return temp; // return deleted link
//    }
//
//}