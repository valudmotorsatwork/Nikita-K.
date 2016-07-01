//4.Write a method removeBadPairs that accepts an ArrayList of integers and removes any 
//adjacent pair of integers in the list if the left element of the pair is larger than the 
//right element of the pair. 
package com.RemovePairs;

import java.util.ArrayList;

public class Application {

	public static void main(String[] args) 
	{
		ArrayList<Integer> list=new ArrayList<Integer>();
		Logic obj=new Logic();
		obj.removeBadPairs(list);

	}

}
