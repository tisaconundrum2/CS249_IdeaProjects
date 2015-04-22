package com.company.BSTstudents;

/**
 * Created by User on 4/21/2015.
 */

/**
 * Main idea:
 * 1) make a student
 * 2) add this student to the root
 * 3) make another student
 * 4) compare them against the root student
 *      a) if less than, add them to left tree
 *      b) if more than, add them to right tree
 * 5) Repeat 3-5 until no more students
 */


public class BinarySearchTreeApp {
    public static void main(String[] args){
        //create the two structures and work from there.
        SimpleStudent student;
        BinarySearchTree bst = new BinarySearchTree();
        student =  new SimpleStudent("Nick", 3.1);
        bst.insert(student);
        student =  new SimpleStudent("Nick", 3.1);
        bst.insert(student);
        student =  new SimpleStudent("Nick", 3.1);
        bst.insert(student);
        student =  new SimpleStudent("Nick", 3.1);
        bst.insert(student);
        student =  new SimpleStudent("Nick", 3.1);
        bst.insert(student);

    }
}
