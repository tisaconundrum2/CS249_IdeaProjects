package com.company;
import java.util.Scanner;


public class SockDriver {
	
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		boolean keepGoing = true;
		//------------------------------------------Start of what the user sees----------------------------------------
		System.out.println("Hello and welcome to the DoorSock test program!\n\n");
		System.out.println("It looks like your a new user, would you like a tutorial? y/n ");
		String tutorial = input.nextLine();
		System.out.println("\n\n");

		//-----------------------TUTORIAL PHASE---------------------------

		if (tutorial.equalsIgnoreCase("y")){
			System.out.println("Heres the tutorial! Im too lazy to make it! WOOO!\n\n");
		}
		else if(tutorial.equalsIgnoreCase("n")){
			System.out.println("Good choice! I didnt even make one! hahahaha!\n\n");
		}
		else{
			System.out.println("You idiot! you pressed the wrong key! You were supposed to press y or n\n\n");
		}
		System.out.println("Press enter to continue!");
		String more = input.nextLine();
		System.out.println("|-------------------------------------------------------------------------|\n\n");

		System.out.println("Please enter your username: ");
		String userName = input.nextLine();
		System.out.println("\n\n");
		System.out.println("....... Thats a terrible name!\n\n");
		System.out.println("Press enter to continue!");
		more = input.nextLine();
		System.out.println("|-------------------------------------------------------------------------|\n\n");
		System.out.println("Please enter the name of your house/appartment/dwelling/cardboard box/whatever");
		String houseName = input.nextLine();
		System.out.println("\n\n");
        if (houseName.equalsIgnoreCase("cardboard box"));
	    	System.out.println("Oh, so you do live in a cardboard box!");
		System.out.println("\n\nPress enter to continue!");
		System.out.println("NOTE! THERE WILL BE A SMALL POPUP WINDOW AFTER YOU PRESS ENTER");
		System.out.println("JUST CLICK OUT OF IT AND BACK INTO THE CONSOLE TO KEEP INTERACTING WITH THE PROGRAM!");
		more = input.nextLine();
		System.out.println("|-------------------------------------------------------------------------|");
		System.out.println("");
		System.out.println("");
		System.out.println("");

		//TODO: Here is where I would have put a prompt to ask for their GPS locations but that seems a little
		// unnecessary for a tester app so Im just putting in 0.00 for both longitude and latitude until later
		House userHouse = new House(houseName, 0.0000, 0.0000); // create house
		userHouse.addRoommate(userName); // add the user to the house, in the House class it will create a new
											// roommate file for them

		// -------------------------------------MAIN MENU WHILE LOOP------------------------------------
		while (keepGoing == true){
					System.out.println("|-------------------------------------------------------------------------|");
			System.out.println("\nWhat would you like to do?\n");
			System.out.println("To REQUEST PRIVACY press 'p' ");
			System.out.println("To CHECK the house's STATUS press 's' ");
			System.out.println("To ADD a ROOMMATE press 'r' ");
			System.out.println("To DELETE a ROOMMATE press 'd' ");
			System.out.println("To give a HIGH FIVE press 'h' ");
			System.out.println("To VIEW the house SCORES press 'v' ");
			System.out.println("To QUIT pess 'q' ");
			System.out.println("\nHit the enter button after you make your selection!\n");
			String selection = input.nextLine(); 													//selection input
			System.out.println("|-------------------------------------------------------------------------|");
				//----------------------------REQUEST PRIVACY----------------------------------------
			if (selection.equals("p")){
		
				System.out.println("How long would you like privacy for? Enter the number of minutes between 1 and 120(2 hours): ");
				int time = Integer.parseInt(input.nextLine());
				System.out.println("");
				System.out.println("");
								if (time >= 1 && time <= 120){
								// the timer runs on seconds, so if they enter 20 it will end in 20 seconds
					// it seemed a little silly to make the timer actually run for several minutes while testing but
					// if you really want to do that just uncomment the next line:
					//time = time * 60;
								userHouse.setStatus(time);
				}
				else {
					System.out.println("Please enter a time between 1 and 120 minutes\n\n");
				}
						System.out.println("Press enter to go back to the menu!");
				String goBack = input.nextLine();
			}
					//------------------------------------CHECK STATUS-------------------------------------
			else if (selection.equals("s")){
						boolean currentStatus = userHouse.getStatus();
						if (currentStatus == false){
					System.out.println("The house is not currently reserved!");
				}
				else {
					System.out.println("Someone has requested privacy!\n\n"); // Later I will have it return WHO has requested privacy.
					System.out.println("Here are some coupons for places in your area!");
					System.out.println("Hopefully they can help you kill some time until your roommate is done!\n");
					userHouse.printCoupons();
				}
				System.out.println("Press enter to go back to the menu!");
				String goBack = input.nextLine();
			}
				//-------------------------------------ADD ROOMMATE----------------------------------------
			else if (selection.equals("r")){
				System.out.println("Please enter the name of the new roommate: ");
				String newGuy = input.nextLine();
				System.out.println("\n\nWow thats a terrible name too!!\n\n");
				userHouse.addRoommate(newGuy);
				System.out.println("Added " + newGuy + " to the house!");
                System.out.println("\n\nPress enter to go back to the menu!");
				String goBack = input.nextLine();
			}
				//-------------------------------------DELETE ROOMMATE-----------------------------------
			else if (selection.equals("d")){
                System.out.println("|-----------------------DELETE ROOMMATE-----------------------|");
				System.out.println("\n\nAre you sure? You can't undo this action and their score will be erased!");
				System.out.println("Press 'y' to confirm or 'n' to cancel: ");
				String confirmDelete = input.nextLine();
				System.out.println("");
				System.out.println("");
				if(confirmDelete.equalsIgnoreCase("y")){
                    System.out.println("Please enter the name of the person you wish to delete: ");
					String deleteName = input.nextLine();
					System.out.println("\n\nBye Bye " + userHouse.getName(deleteName) + "!!!!");
					userHouse.removeRoommate(deleteName);
					System.out.println("");
					System.out.println("");
                }
				else
					System.out.println("Ok, they wont be deleted!");
                    System.out.println("Press enter to go back to the menu!");
	    			String goBack = input.nextLine();
                }
				//-------------------------------------VIEW SCORES--------------------------------------
			else if (selection.equals("v")){
                System.out.println(userHouse.houseName + "'s occupants and thier scores \n");
				userHouse.printRoommateList();
				System.out.println("\n|----------------------------------------------|\n\n");
                System.out.println("Press enter to go back to the menu!");
				String goBack = input.nextLine();
					}
				//-----------------------------------HIGH FIVE--------------------------------------
			else if (selection.equals("h")){
                System.out.println("Awesome! Someone gets a high five!!");
				System.out.println("Enter the name of the high five recipient: ");
				String name = input.nextLine();
                userHouse.highFive(name);
				System.out.println("\n\nGreat! " + userHouse.getName(name) + " now has " + userHouse.getScore(name) + " high fives!");
            }
				//------------------------------------QUIT-------------------------------------------
			else if (selection.equals("q")){
                keepGoing = false;
				System.out.println("\n\nGoodbye! Thanks for using DoorSock!!!\n\n\n");
			}
        }// end while loop
	}//end main
}//end Class
