package com.company.eliminationGameV1_0;

/**
 * Created by User on 3/12/2015.
 */

public class Person{
    private String iData;
    public Person next;

    public Person(){
        next = null;
        iData = "";
    }

    public Person(String d, Person n){
        next = n;
        iData = d;
    }

    public void setNext(Person next){
        this.next = next;
    }

    public void setiData(String id){
        iData = id;
    }

    public Person getNext(){
        return next;
    }

    public String getiData(){
        return iData;
    }

    public void display(){
        System.out.printf("[%s] ", iData);
    }
}