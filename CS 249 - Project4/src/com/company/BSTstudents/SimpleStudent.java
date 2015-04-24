package com.company.BSTstudents;

/**
 * Comments for a class you can use in your BST
 *
 * @author 
 * @version 
 * @since 
 *
    Implementing Interfaces in Java: implements

    In Java, an Interface is a class which contains method definitions with no functionality.
    When another class is written to implement this interface class, it is making a promise to the compiler.
    By implementing the interface, the programmer is forced into creating those methods in the interface,
    and providing them with functionality.

    By writing our SimpleStudent class to implement Comparable, we are agreeing to provide the method
    in Comparable called "compareTo" in our class. This returns an int which is negative if our class is 
    'smaller' than the other class, is 0 if our class is equal to the other class, and is positive if our class is
    'greater' than the other class.

    You may delete this comment when you no longer need it.
*/
public class SimpleStudent implements Comparable<SimpleStudent> {

    private String name;
    private double gpa;

    /**
     * Constructor of our Simple Student
     */
    public SimpleStudent(String name, double gpa){
        this.name = name;
        this.gpa = gpa;
    }



    /**
     * comments
     */
    public double getGpa(){
        return gpa;
    }

    /**
     * comments
     */
    public String getName(){
        return name;
    }

    /**
     * comments
     */
    @Override
    public String toString(){

        return "[Student Name: " + name + " Student GPA: " + gpa + "]";
    }

    /**
     This returns an int which is negative if our class is
     'smaller' than the other class, is 0 if our class is equal to the other class, and is positive if our class is
     'greater' than the other class.
     */
    @Override
    public int compareTo(SimpleStudent other_student){
        /**
         *  if (1 > 0){return -1} //push to left side
         *  if (1 < 2){return 1} //push to right side
         *      1
         *    /   \
         *  0      2
         *
         */

        /*returns an int which is negative if our class is 'smaller'*/
        if (other_student.gpa > this.gpa) {
            return -1;
        }
        /*is positive if our class is 'greater' than the other class.*/
        else if (other_student.gpa < this.gpa) {
            return 1;
        }
        /*is 0 if our class is equal to the other class*/
        return 0;
    }
}
