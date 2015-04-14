//package com.company;
//
///**
// * Created by User on 10/29/2014.
// */
//
///*
//fill
//insertRight
//insertLeft
//display
//
// */
//
//
//
//public class matrixList {
//    private Node current;   //moves along the x axis of the matrix
//    private Node header;    //header stays at the first Node, so we can get back to where we belong.
//    private Node footer;    //footer travels freely around the matrix
//
//    public matrixList(){
//        //TODO current, header, and footer do not have a node yet. This will be made when we insertBelow or insertRight
//        current = null;
//        header = null;
//        footer = null;
//
//    }
//
//
//
//    public void insertBelow(long id, double dd){
//        if (header== null) {//this does a check to see if the header Node even exists.
//            //TODO: add a node
//            Node newNode = new Node(id, dd);
//            header = newNode;
//        }
//        else{
//            //TODO: insert a Node below
//            Node header = new Node(id,dd);
//            current = header.isBelow; //cuurent moves right as well as down.
//            footer = header.isBelow; // footer only goes down.
//        }
//    }
//
//    public void insertRight(long id, double dd){
//        if (header == null )//this does a check to see if the header Node even exists.
//            //TODO: add new node
//            Node header = new Node(id,dd);
//        else
//            //TODO: insert a node to the right
//            newNode.isRight = current;
//    }
//
//    public void insertAt(int id, long dd) {
//        //this increments through the list until the ID is matched.
//        while (current != id) {
//            //TODO increment to the right
//            current = current.isRight;
//            if (current.isRight == null) {
//                //TODO Move 2 down
//                footer = footer.isBelow;
//                current = footer;
//            }
//            if (footer.isBelow == null) {
//                System.out.println("You've entered an invalid id, please try again");
//            }
//        }
//        //TODO: add userInput = dd
//        current.dd = dd;
//    }
//
//    public void display(){
//        //TODO: display each line with nodes in it.
//        return;
//    }
//
//    public void fill(long id){
//        //TODO: fill the nodes in
//        if (current == null && header == null && footer == null)
//            current = null;
//            Node header = new Node(id);
//            Node footer = null;
//
//    }
//}
