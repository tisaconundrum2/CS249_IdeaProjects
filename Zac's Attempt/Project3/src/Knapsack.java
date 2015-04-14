import java.util.Scanner;

/**
 * Created by Zac on 10/30/2014.
 */
public class Knapsack {

    public static boolean thesack( int[] items,int total){
        return thesackagain(items,0,total);
    }

    private static boolean thesackagain( int[] items,int n,  int sum){
        if (n == items.length){
            return false;
        }
        int current = items[n];
        if (current == sum){
            System.out.println(current);
            return true;
        }else if (current > sum || !thesackagain(items,n+1,sum-current)){
            return thesackagain(items,n+1,sum);
        }
        System.out.println(current);
        return true;

    }



//class MatrixListApp {

    public static void main(String[] args) {


        Scanner input = new Scanner(System.in);
        //boolean exit = true;


        String whatDo = "";

        System.out.println("Please enter how many weights you what to add");
        int num = input.nextInt();
        int items[] = new int[num];
        System.out.println("Please enter the numbers");
        for (int i = 0; i < items.length; i++) {
            items[i] = input.nextInt();
        }
        System.out.println("What is the weight capacity of the sack?");
        int weight = input.nextInt();
        System.out.println("");

        thesack(items,weight);
    }

}
