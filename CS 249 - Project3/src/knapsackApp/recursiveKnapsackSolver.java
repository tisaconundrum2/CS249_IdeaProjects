package knapsackApp;

import java.util.ArrayList;
import java.util.List;

/**
 * <H1>The Recursive Knapsack (of doom)</H1>
 * Recursively creates solutions for the 0-1 Knapsack Problem in a static context.
 * Static classes do not need to be made into an object instance in order to access and run their methods.
 *
 *
 * @author Nicholas Finch ngf4@nau.edu
 * @version Version 3.00
 * @since 03-27-2015
 */
public class recursiveKnapsackSolver {

    List<Integer> weights = new ArrayList<Integer>();
    private final int[] inputString;


    public recursiveKnapsackSolver(final int[] weights)
    {
        inputString = weights;
        System.out.print("\n\nThe input string is: [");
        for (int i = 0; i < inputString.length; i++){
            System.out.print(inputString[i]+", ");
        }
        System.out.print("]");
    }


    /**
     * Public call to recursion over 1-0 Knapsack problem variant.
     *
     //* @param weights the set of weights for recursive combinations
     //* @param start the array location to begin at for a set of recursive calls, increments to exclude weights
     //* @param targetWeight the remaining target weight for each recursive call, decrements as weights are 'selected'
     * @return boolean returns true if a (one is enough) perfect solution is found, false otherwise
     */

    public List<Integer> knapsackRecursive(int current, int targetWeight)
    { //take in a size that user would like to have length of groups, move the current around to get results.
        for( int i = current; i < inputString.length; ++i ){ //first we use the inputString's length
            weights.add(inputString[i]); //add each letter to the weights
            if (targetWeight == sum(weights)){
                return weights;
            }
            else if (targetWeight == sum(weights) + 1 || targetWeight == sum(weights) - 1) {
                return weights;
            }
            else if (targetWeight == sum(weights) + 2 || targetWeight == sum(weights) - 2) { //worst?
                return weights;
            }
            if ( i < inputString.length ) //this second case checks the inputString's length against our starting i and allows
                knapsackRecursive(i + 1, targetWeight); // the incrementation of A to AB to ABC to ABCD... to eventually F
            // the only way this works is to go all the way up, then come back down.
            weights.remove( weights.size() - 1 ); //decrement a letter.
        }
        return null;
    }

    private int sum(List<Integer> weights)
    {
        int sum = 0;
        //TODO return the sum
        for (int i = 0; i < weights.size(); i++) {//get the sum of all the numbers.
            sum += weights.get(i);
        }
        return sum;
    }
}

/**
 * Sources
 * http://stackoverflow.com/questions/2843366/how-to-add-new-elements-to-an-array
 */