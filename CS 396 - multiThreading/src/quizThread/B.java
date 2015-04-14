package quizThread;

/**
 * Created by User on 4/2/2015.
 */
class B extends Thread{
    public void run(){
        for (int i = 1; i <= 5; i++) System.out.println("\t From Thread B: i=" +i);
        System.out.println("Exit from B");
    }
}

