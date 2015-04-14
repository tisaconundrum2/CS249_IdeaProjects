package com.company;

public class Roommate {
	public String name;
	public int score;
	public Roommate(String newName){
        name = newName;
		score = 0;
					}
	public void setScore(int addTo){
        score = score + addTo;
		}
	public void changeName(String newName){
        name = newName;
		}
}
