package groupingsApp;

/**
* <H1>Recrusive Grouping</H1>
* <p>
* Models n Choose k combinatorics.
* <p>
* Executes under a main method and thus can be called and tested directly.
*
* @author      Nicholas Finch ngf4@nau.edu
* @version     3.0
* @since       03-27-2015
*/
public class recursiveGrouping {

    private static StringBuilder players = new StringBuilder();
    private final String inputString;
    public recursiveGrouping(final String str) {
        inputString = str;
        System.out.print("\n\nThe input string is: " + inputString);
    }

    /**
     * Main method, takes number of players and group size as arguments
     *
     * @param args [0]= int players>0, [1] = int group size>0
     */
    public static void main(String[] args)
    {
        //test bad player size (none)
        recursiveGrouping badPlayerSize1 = new recursiveGrouping("ABCDEF");
        System.out.print("\n");
        badPlayerSize1.showTeams(0, 0); //returns no players.

        //test bad player size (too large)
        recursiveGrouping badPlayerSize2 = new recursiveGrouping("ABCDEF");
        System.out.print("\n");
        badPlayerSize2.showTeams(7, 0); //returns no players.

        //test bad group size(too large)
        recursiveGrouping tooLarge = new recursiveGrouping("ABCDEFGHIJKLMNOP");
        System.out.print("\n");
        tooLarge.showTeams(2, 0); //recurse as normally. displaying all possibilities

        //test bad group size (none)
        recursiveGrouping notEnough = new recursiveGrouping("");
        System.out.print("\n");
        notEnough.showTeams(2, 0); //returns no players

        //test single group
        recursiveGrouping singleGroup = new recursiveGrouping("AB");
        System.out.print("\n");
        singleGroup.showTeams(2, 0); //returns just that group

        //test single group, single player
        recursiveGrouping sinGroupsinPlayer = new recursiveGrouping("AB");
        System.out.print("\n");
        sinGroupsinPlayer.showTeams(1, 0); //returns each player

        //test 6 players groups 2 (As in project description).
        recursiveGrouping newRecGroup = new recursiveGrouping("ABCDEF");
        System.out.print("\n");
        newRecGroup.showTeams(2, 0); //returns each player

    }

    /**
     * Static method to recursively display desired team groupings.
     *
     * @param
     * @param
     * @return
     */



    //TODO go through all possible combinations and show only groups of 2
    public void showTeams(int size, int current)
    { //take in a size that user would like to have length of groups, move the current around to get results.
        for( int i = current; i < inputString.length(); ++i ){ //first we use the inputString's length
            players.append(inputString.charAt(i)); //add each letter to the players
            if (players.length() == size) //and if the player's length is a given size, example 2 will allow for our, AB, AC, AD, AE
                System.out.println( players ); //print this data out.
            if ( i < inputString.length() ) //this second case checks the inputString's length against our starting i and allows
                showTeams(size, i + 1); // the incrementation of A to AB to ABC to ABCD... to eventually F
                // the only way this works is to go all the way up, then come back down.
            players.setLength( players.length() - 1 ); //decrement a letter.
        }
    }

}


/**
* Sources
* https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
*
*/