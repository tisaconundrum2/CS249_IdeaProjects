package multiThread;

/**
 * Created by User on 4/2/2015.
 */

class A extends Thread{
    public void run(){
        for (int i = 1; i <= 5; i++) System.out.println("\t From Thread A: i=" +i);
        System.out.println("Exit from A");
    }
}
