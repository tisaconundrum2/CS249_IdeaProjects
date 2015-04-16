/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixApp;

import java.util.Scanner;

/**
 * <H1>LinkedMatrixApp</H1>
 * Models a 2D Matrix through the command line for exploratory visual testing.
 * Lots of formatted strings and scanner loops in here.
 *
 * @author Nicholas Finch ngf4@nau.edu
 * @version 2.4
 * @since 3-24-2015
 */
public class LinkedMatrixApp {
    private static final Scanner input = new Scanner(System.in);
    private static LinkedMatrix matrix; //the static linked matrix app
    private static int rows; //local value of rows to help with display formatting
    private static int columns; //local value of columns to help with display formatting

    // this main method should use scanner to query the user and provide an interface for testing the matrix
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("");
        System.out.println("Lets get started!");
        promptReady();

        boolean on = true;
        while(on){
            System.out.println("---------------MENU OPTIONS---------------\n"+
                            "D:) Display Matrix\n"+
                            "I:) Insert a new value to any specific place.\n"+
                            "J:) Insert a single value into all available places.\n"+
                            "S:) Display the sums of the columns and rows.\n"+
                            "Q:) Quit program."
            );
            String button = input.nextLine();
            System.out.println("You have selected option " + button + "!");
            if (button.equalsIgnoreCase("D")){
                System.out.print(matrix.display());
                System.out.println("");
            }

            else if (button.equalsIgnoreCase("I")){
                System.out.println("Insert desired value 0-99: ");
                int v = Integer.parseInt(input.nextLine());

                System.out.println("Insert desired row: ");
                int r = Integer.parseInt(input.nextLine());

                System.out.println("Insert desired column: ");
                int c = Integer.parseInt(input.nextLine());

                matrix.insert(v,r,c);
                System.out.print(matrix.display());
                System.out.println("");
            }

            else if (button.equalsIgnoreCase("J")){
                System.out.println("Insert desired value 0-99: ");
                int av = Integer.parseInt(input.nextLine());

                matrix.insertAll(av);
                System.out.print(matrix.display());
                System.out.println("");
            }

            else if (button.equalsIgnoreCase("S")){
                System.out.print(matrix.displaySummed());
                System.out.println("");
            }

            else if (button.equalsIgnoreCase("Q")){
                System.out.print("Good bye!");
                System.out.println("");
                on = false;
            }

            else {
                System.out.print("That is not recognizable character, please try again \n");
            }


        }
    }

    // this private helper method should be used to indicate to the user when the system is ready for a new command
    // you can make more helper methods for other prompts as needed
    private static void promptReady(){
        System.out.println("Input the number for Rows: ");
        rows = Integer.parseInt(input.nextLine());

        System.out.println("Input the number for Columns: ");
        columns = Integer.parseInt(input.nextLine());
        matrix = new LinkedMatrix(rows, columns);
    }
}