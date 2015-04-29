import java.util.Scanner;

/**
 * Created by Zac on 4/28/2015.
 */
public class MatrixMultiplication {
//INITIALIZATION
    private static int[][] first;
    private static int[][] second;
    private static int[][] multiply;



    public static void main(String args[]) {
        GenerateCsv.generateCsvFile("C:\\Users\\User\\test.csv"); //generate the data file to look at things graphically
            int m, n, p, q, sum = 0, c, d, k;
//==========================================================================================
//ROWS FIRST MATRIX
//==========================================================================================
            Scanner in = new Scanner(System.in);
            System.out.println("Enter the number of rows and columns of first matrix");
            m = in.nextInt();
            n = in.nextInt();
            first = new int[m][n];

//==========================================================================================
// GET FIRST MATRIX DATA
//==========================================================================================

            System.out.println("Enter the elements of first matrix");

            for (c = 0; c < m; c++)
                for (d = 0; d < n; d++)
                    first[c][d] = in.nextInt();
//==========================================================================================
//ROWS FOR SECOND MATRIX
//==========================================================================================
            System.out.println("Enter the number of rows and columns of second matrix");
            p = in.nextInt();
            q = in.nextInt();

            if (n != p)
                System.out.println("Matrices with entered orders can't be multiplied with each other.");
            else {
                second = new int[p][q];
                multiply = new int[m][q];
//==========================================================================================
//GET SECOND MATRIX DATA
//==========================================================================================
                System.out.println("Enter the elements of second matrix");

                for (c = 0; c < p; c++)
                    for (d = 0; d < q; d++)
                        second[c][d] = in.nextInt();
//==========================================================================================
//Begin iterations of awesomeness
//==========================================================================================
                for (int i = 0; i < 500; i++) {
                    //reset the matrixes every time
                    multiply = new int[m][q];
/*==========================================================================================
 ALL THE MATH HAPPENS HERE.
1 2 3 4 5
5 4 3 2 1
6 7 8 9 0
0 9 8 7 6
6 3 1 8 6
*///==========================================================================================
                long startTime = System.nanoTime();
                for (c = 0; c < m; c++) {
                    Thread_A[] pThread = new Thread_A[10];
                    pThread[c] = new Thread_A(c, p, q);
                    pThread[c].start();
                while (true) {
                    try {
                        pThread[c].join();
                        break;
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                }
                long estimatedTime =  (System.nanoTime() - startTime);
                System.out.println("It took " + estimatedTime);
                    GenerateCsv.addData(estimatedTime);
//==========================================================================================
// OUTPUT TO CONSOLE AND CSV
//==========================================================================================
                System.out.println("Product of entered matrices:-");

                for (c = 0; c < m; c++) {
                    for (d = 0; d < q; d++)
                        System.out.print(multiply[c][d] + "\t");
                    System.out.print("\n");
                }
            }
                GenerateCsv.close();
        }
    }


//==========================================================================================
// THE THREAD
//==========================================================================================

    static class Thread_A extends Thread {
        int c, q, p;
        public Thread_A(int c, int q, int p){
            this.c = c;
            this.q = q;
            this.p = p;
        }
        public void run() {
            //TODO awesomeness here.
            for (int d = 0; d < q; d++) {
                int sum = 0;
                for (int k = 0; k < p; k++) {
                    sum = sum + first[c][k] * second[k][d];
                }
                multiply[c][d] = sum;
                System.out.printf("Thread %d, creating number %d\n",c,sum);
            }
        }
    }
}



