package com.company.eliminationGameV1_5;

/**
 * Created by User on 3/12/2015.
 */

public class Person {
    private int iData;
    public Person next;

    public Person(){
        next = null;
        iData = 0;
    }

    public Person(int d, Person n){
        next = n;
        iData = d;
    }

    public void setNext(Person next){
        this.next = next;
    }

    public void setiData(int id){
        iData = id;
    }

    public Person getNext(){
        return next;
    }

    public int getiData(){
        return iData;
    }

    public void display(){
        System.out.printf("[%s] ", iData);
    }
}