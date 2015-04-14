package quizThread;

/**
 * Created by User on 4/2/2015.
 */
public class quizThread {
    public static void main (String args[]) throws InterruptedException {
        new A(total).start();
        new B(total).start();

    }
}

}
