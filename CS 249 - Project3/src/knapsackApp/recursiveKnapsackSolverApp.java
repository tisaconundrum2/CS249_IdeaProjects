package knapsackApp;


/**
 * Tests for Recursive Knapsack.
 *
 * @author
 * @version
 * @since
 */
public class recursiveKnapsackSolverApp {

    //Call unit test methods from the main method for testing
    public static void main(String[] args){
        testBadInputs(); //RETURNS NO DATA
        testNoPerfects();
        testPerfectPossible();
        testBestPossible();
    }


    //test to ensure your knapsack does not crash if fed bad input values
    private static void testBadInputs(){
        recursiveKnapsackSolver test = new recursiveKnapsackSolver(new int[] {'A','B','C','D'});
        System.out.print("\n");
        System.out.print(test.knapsackRecursive(0, 7));
    }

    //test to ensure your knapsack will find the perfect solution if there is one (bag is perfectly full)
    //the perfect solution should be chosen over any other possible solution (multiple perfects is not needed)
    private static void testPerfectPossible(){
        recursiveKnapsackSolver test = new recursiveKnapsackSolver(new int[] {1,2,3,4,5,6,7,8});
        System.out.print("\n");
        System.out.print(test.knapsackRecursive(0, 20));
    }

    private static void testNoPerfects() {
        recursiveKnapsackSolver test = new recursiveKnapsackSolver(new int[] {1,2,3,4,5,6,7,8});
        System.out.print("\n");
        System.out.print(test.knapsackRecursive(0, 100));
    }



    //test to ensure that your knapsack will find the best possible solution when there is no perfect solution
    //the best solution should be better than any other solution (regardless of the order of appearance)
    private static void testBestPossible(){
        recursiveKnapsackSolver test = new recursiveKnapsackSolver(new int[] {1,2,3,4,5,6,7,8});
        System.out.print("\n");
        System.out.print(test.knapsackRecursive(0, 37));
    }
}
