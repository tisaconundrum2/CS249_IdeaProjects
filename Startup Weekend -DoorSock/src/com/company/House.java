package com.company;
import java.util.Timer;


public class House {
	//-----------------------------------------CLASS VARIABLES-------------------------------------
	public Roommate[] rList = new Roommate[50];
	/*
	max house size is 50, should we have a static size? I feel it would be easier than
    making size dynamic and who honestly lives with over 50 people (boarding school students lol)
    Nick: I guess if we suddenly turn into a social media platform... then perhaps, but i doubt we'll get
    that big anyways.
    */
	public int count;
	public String houseName;
	public boolean status = false;
	int statusTime = 0;
	public double lonLoc; //TODO: GPS location should be a two doubles of two coordinates; longitude and latitude
    // we'll have to revisit this later to figure out how to implement it
	public double latLoc; // TODO: but I'm willing to bet that we will be using those coordinates
	//public Coupons[] coupList = new Coupons[50];
	//public int couponCount= 0; TODO: these two coupon variables are unnecessary at the moment, just didn't feel like deleting them
	StatusTimer timer = new StatusTimer();
	public String[] coupons = {"25% off at Starbucks", "10% off at TacoBell", "Free coffe with the purchase of a bagel at Einstiens"};

	//-----------------------------------------CONSTRUCTOR-------------------------------------
	public House(String name, double loc1, double loc2){
			houseName = name;
			lonLoc = loc1;
			latLoc = loc2;
		}
	//-----------------------------------------SET LOCATION-------------------------------------
	public void setLocation(){ 
			//TODO: some sort of getGPS method will be in here to set the location variables;
			// lonLoc = GPS1
			// latLoc = GPS2
		}
	//-----------------------------------------ADD ROOMMATE-------------------------------------
	public void addRoommate(String name){
			Roommate newRoomie = new Roommate(name);
			rList[count] = newRoomie;
			count++;
		}
	//-----------------------------------------REMOVE ROOMMATE-------------------------------------
	public void removeRoommate(String name){
			Roommate[] temp = new Roommate[50];
			int tempCount = 0;
			boolean found = false;
			for (int i = 0; i < count; i++){			//search for the name to be removed and set that array slot to null
					if (rList[i].name.equalsIgnoreCase(name)){
							rList[i] = null;
							found = true;
							for ( i = 0; i < count; i++){		//start transferring the rest of the roommates over to a temp
									if (rList[tempCount] == null)		// keep an eye out for the null value, skip it by incrementing tempCount
						tempCount++;
					else{
											temp[i] = rList[i];
						tempCount++;
					}
				}
							count--;								//decrement count because there is now one less roommate in the temp array as there
														// was in the original roommate array
														for ( i = 0; i < count; i++){		//swap the contents of temp[] back to roommate[]
									rList[i] = temp[i];
								}
						}// end if(rList[i].name.......
				}// end of outer for loop
			if (found == false)
			System.out.println("That name does not exist! Try again!");		}
	//-----------------------------------------HIGH FIVE-------------------------------------
	public void highFive(String name){
			for (int i = 0; i < count; i++){
					if (rList[i].name.equalsIgnoreCase(name))
				rList[i].score = rList[i].score + 1;
				}
		}
	//-----------------------------------------PRINT ROOMMATE LIST-------------------------------------
	public void printRoommateList(){

		System.out.println("Roommates		Scores");
		System.out.println("");
			for (int i = 0; i < count; i++){
					System.out.println(rList[i].name + "			" + rList[i].score);
			System.out.println("");
					}
		}
	//-----------------------------------------SET STATUS-------------------------------------
	public void setStatus(int time){
			boolean isReserved = getStatus();
			if (isReserved == false){
			status = true;
					statusTime = time;
					timer.count = 0;
					System.out.println("");
			System.out.println("");
			System.out.println("-----------------------------------------------");
			System.out.println("Enjoy your privacy! ;) ");
			System.out.println("-----------------------------------------------\n\n");
			//StatusTimer timer = new StatusTimer(); TODO: this was added to the top as a public variable
			/*while (timer.count < time + 1){
				if (timer.count > time)
					status = false;
			}*/
			//this stuff was commented out to test a different way of setting and resetting status I left it here in case I mess up
		}
		else{
			System.out.println("");
			System.out.println("");
			System.out.println("------------------------------------------");
			System.out.println("Cannot change status, the house is currently under privacy mode!");
			System.out.println("------------------------------------------");
			System.out.println("");
			System.out.println("");
			System.out.println("Here are some coupons for places in your area!");
			System.out.println("Hopefully they can help you kill some time until your roommate is done!");
			System.out.println("");
			printCoupons();
		}
		}
	//-----------------------------------------GET STATUS-------------------------------------
	public boolean getStatus(){
			if (timer.count > statusTime)
			status = false;
			return status;
		}
	//-----------------------------------------GET NAME-------------------------------------
	public String getName(String name){ // Simple searching thing that returns the capitalized version of a name
			String nameFound = name;
			for(int i = 0; i < count; i++){
			if (rList[i].name.equalsIgnoreCase(name)){
				nameFound = rList[i].name;
			}
				}
			return nameFound;
	}
	//-----------------------------------------GET SCORE-------------------------------------
	public int getScore(String name){ // Searches a name and brings back that users score
			int scoreFound = 0;
			for(int i = 0; i < count; i++){
					if(rList[i].name.equalsIgnoreCase(name)){
				scoreFound = rList[i].score;
			}
				}
			return scoreFound;
	}
	public void printCoupons(){
			int size = coupons.length;
			for (int i = 0; i < size; i++){
					System.out.println(coupons[i]);
				}
			System.out.println("*****************************END OF COUPONS*****************************");
		}
	/*	This whole section is pointless for a tester like this, it isn't even how we will implement coupons
	 *  not sure what I was thinking lol
	 * 
	//-----------------------------------------ADD COUPONS-------------------------------------
	public void addCoupon(String companyName, int discountPercent, String[] items){
			Coupons newCoupon = new Coupons(companyName, discountPercent, items);
			coupList[couponCount] = newCoupon;
			couponCount++;
		}
	//-----------------------------------------REMOVE COUPONS-------------------------------------
	public void removeCoupon(String companyName){
			Coupons[] temp = new Coupons[50];
			int tempCount = 0;
			boolean found = false;
			for (int i = 0; i < count; i++){			//search for the name to be removed and set that array slot to null
					if (rList[i].name.equalsIgnoreCase(companyName)){
							rList[i] = null;
							found = true;
							for ( i = 0; i < count; i++){		//start transferring the rest of the coupons over to a temp
									if (rList[tempCount] == null)		// keep an eye out for the null value, skip it by incrementing tempCount
						tempCount++;
					else{
											temp[i] = coupList[i];
						tempCount++;
					}
				}
							count--;								//decrement count because there is now one less coupon in the temp array as there
														// was in the original coupons array
														for ( i = 0; i < count; i++){		//swap the contents of temp[] back to coupList[]
									coupList[i] = temp[i];
								}
						}// end if(rList[i].name.......
				}// end of outer for loop
			if (found == false)
			System.out.println("That company name does not exist! Try again!");
		}
	//-----------------------------------------CHANGE DISCOUNT PERCENT-------------------------------------
	 
	 */
}
