/**
 * Created by User on 4/28/2015.
 */
class ThreadTest {
    //Run all the threads you need here.
    public static void main(String args[]) {
        Thread_A[] p = new Thread_A[10];
        for (int i = 0; i < 3; i++) {
            p[i] = new Thread_A(i);
            p[i].start();
        }
    }
}
