package com.company.genericStack;

import java.net.Socket;

/**
 * Created by User on 3/12/2015.
 */
public class genericStackApp {
    public static void main(String[] args){
        genericStack<String> list1 = new genericStack<String>(10);
        genericStack<Socket> list2 = new genericStack<Socket>(10);
        genericStack<Double> list3 = new genericStack<Double>(10);

        list1.push("Hello World!");
        list1.push("More Strings!");
        list1.push("This string!");
        list1.push("Is string!");
        list1.push("Awesome string!");
        list2.push(new Socket());
        list2.push(new Socket());
        list2.push(new Socket());
        list2.push(new Socket());
        list2.push(new Socket());
        list2.push(new Socket());
        list3.push(223.655);//1
        list3.push(123.654);//2
        list3.push(423.765);//3
        list3.push(254.276);//4
        list3.push(435.313);//5
        list3.push(256.445);//6
        list3.push(256.345);//7
        list3.push(256.345);//8
        list3.push(256.345);//9
        list3.push(256.345);//10
        list3.push(256.345);//one more to break it

        System.out.print("These are the Stacks\n");
        System.out.print("List1 stack\n");
        list1.display();
        System.out.print("List2 stack\n");
        list2.display();
        System.out.print("List3 stack\n");
        list3.display();
    }
}
