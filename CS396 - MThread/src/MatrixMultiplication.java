import java.util.Scanner;

/**
 * Created by Zac on 4/28/2015.
 */
public class MatrixMultiplication {
//INITIALIZATION
    private static int[][] first;
    private static int[][] second;

    public static void main(String args[])
    {
        int m, n, p, q, sum = 0, c, d, k;
//==========================================================================================
//ROWS FIRST MATRIX
//==========================================================================================
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of first matrix");
        m = in.nextInt();
        n = in.nextInt();
//==========================================================================================
// GET FIRST MATRIX DATA
//==========================================================================================
        first = new int[m][n];

        System.out.println("Enter the elements of first matrix");

        for ( c = 0 ; c < m ; c++ )
            for ( d = 0 ; d < n ; d++ )
                first[c][d] = in.nextInt();
//==========================================================================================
//ROWS FOR SECOND MATRIX
//==========================================================================================
        System.out.println("Enter the number of rows and columns of second matrix");
        p = in.nextInt();
        q = in.nextInt();

        if ( n != p )
            System.out.println("Matrices with entered orders can't be multiplied with each other.");
        else
        {
            int second[][] = new int[p][q];
            int multiply[][] = new int[m][q];
//==========================================================================================
//GET SECOND MATRIX DATA
//==========================================================================================
            System.out.println("Enter the elements of second matrix");

            for ( c = 0 ; c < p ; c++ )
                for ( d = 0 ; d < q ; d++ )
                    second[c][d] = in.nextInt();
//==========================================================================================
// ALL THE MATH HAPPENS HERE.
//==========================================================================================
            for ( c = 0 ; c < m ; c++ )
            {
                for ( d = 0 ; d < q ; d++ )
                {
                    for ( k = 0 ; k < p ; k++ )
                    {
                        sum = sum + first[c][k]*second[k][d];
                    }

                    multiply[c][d] = sum;
                    sum = 0;
                }
            }
//==========================================================================================
// OUTPUT
//==========================================================================================
            System.out.println("Product of entered matrices:-");

            for ( c = 0 ; c < m ; c++ )
            {
                for ( d = 0 ; d < q ; d++ )
                    System.out.print(multiply[c][d]+"\t");

                System.out.print("\n");
            }
        }
    }

    public class Thread_A extends Thread {
        int k;
        public Thread_A(int k){
            this.k = k;
        }
        public void run() {
            //TODO awesomeness here.
            for (int i = 0; i < k ; i++) {
                first[k][i] * second[i][k];
            }
            System.out.println("Exit from A");
        }
    }
}
