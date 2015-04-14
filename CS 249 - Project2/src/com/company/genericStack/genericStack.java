package com.company.genericStack;

/**
 * Created by User on 3/11/2015.
 */
class genericStack <E>{
    private final int size;
    private int top;
    private E[] elements;

    public genericStack(int size){
        this.size = size;
        top = -1;
        elements = (E[]) new Object[size]; //creating array
    }

    public void push(E pushVal){
        //TODO push to the stack
        //if it's full error
        if (isFull())
            System.out.println("Can't push to stack, it is full");
        else
            elements[++top] = pushVal;
    }

    public E pop(){
        //TODO pop off the stack
        //If it's empty error
        //return the data in the stack when popping.
        //it is a generic pop, thus we place E to allow for objects that are popped off
        if (isEmpty())
            System.out.println("Can't pop off stack, it is empty");
        else
            return elements[top--];
        return null;
    }

    public void display(){
        //TODO display the data that is in the stack
        //while there is still data to display, keep popping.
        while (!isEmpty() && top != 0)
            System.out.printf("[%s],", pop());
        System.out.printf("[%s]\n",pop());
    }

    public boolean isEmpty(){
        //TODO return true or false
        if (top == -1)
            return true;
        return false;
    }

    public boolean isFull(){
        //TODO return true or false
        if (top == size - 1)
            return true;
        return false;
    }
}