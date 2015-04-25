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
        //=====================================================setup up the BST and SimpleStudent
        SimpleStudent student;
        BinarySearchTree bst = new BinarySearchTree();
        //=====================================================student insertion
        student =  new SimpleStudent("Nick", 3.1);
        bst.insert(student);
        student =  new SimpleStudent("John", 4.0);
        bst.insert(student);
        student =  new SimpleStudent("Jacob", 2.2);
        bst.insert(student);
        student =  new SimpleStudent("Eric", 3.1);
        bst.insert(student);
        student =  new SimpleStudent("Bat", 2.4);
        bst.insert(student);
        bst.printLevelOrder();
        //=====================================================
        System.out.println("//=====================================================");
        //=====================================================delete a student
        SimpleStudent delStu = new SimpleStudent("John", 4.0);
        System.out.print("Deleting: ");
        System.out.println(bst.find(delStu));
        System.out.print(bst.delete(delStu));
        bst.printLevelOrder();
        //=====================================================
        System.out.println("//=====================================================");
        //=====================================================delete a nonexistent student
        SimpleStudent delStuNA = new SimpleStudent("Nathan", 5.0); //lol @ 5.0 grade
        System.out.print(bst.delete(delStu));
        //=====================================================
        System.out.println("//=====================================================");
        //=====================================================print stuff
        bst.printLevelOrder();
    }
}
