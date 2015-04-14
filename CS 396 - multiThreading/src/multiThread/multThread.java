package multiThread;

import java.util.concurrent.TimeUnit;

/**
 * Created by User on 4/2/2015.
 */
public class multThread {
    public static void main (String args[]) throws InterruptedException {
        new A().start();
        TimeUnit.SECONDS.sleep(4);
        new B().start();
        TimeUnit.SECONDS.sleep(8);
        new C().start();
    }
}
