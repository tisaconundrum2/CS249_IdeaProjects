package com.company;

public class Coupons {
	public int count;
	public int discountPercent;
	public String companyName;
	public String[] itemsList = new String[50];
	public Coupons(String company, int discount, String[] items){
		companyName = company;
		discountPercent = discount;
		int size = items.length;
		for (int i = 0; i < size; i++){
				itemsList[i] = items[i];
				count ++;
			}	
	}
	
	public void addItem(String itemName){
		itemsList[count] = itemName;
	}
	
	public void removeItem(String itemName){
		String temp[] = new String[count];
		int tempCount = 0;
		boolean found = false;
		for (int i = 0; i < count; i++){
				if (itemsList[i].equalsIgnoreCase(itemName)){
						itemsList[i] = null;
						found = true;
						for (i = 0; i < count; i++){
								if (itemsList[tempCount].equals(null)){
										tempCount++;
									}
					else{
										temp[i] = itemsList[tempCount];
										tempCount++;
					}
				}
						count--;
						for (i = 0; i < count; i++){
								itemsList[i] = temp[i];
							}
					}// end of if(itemsList[i].equalsIgnoreCase .....
			}
		if (found == false)
			System.out.println("That item does not exist in the list!");
	}
	
	public void changeDiscount(int newAmount){
		discountPercent = newAmount;
	}
	
}
