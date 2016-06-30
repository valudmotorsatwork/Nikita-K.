package com.Palindrome;

public class Application {

	public static void main(String[] args) 
	{
		System.out.println("Enter The String To check");
		Logic obj=new Logic();
		
		obj.isPalindrome(obj.str);
		if(obj.b)
			System.out.println("Palindrome");
		else
			System.out.println("Not Palindrome");
	}

}
