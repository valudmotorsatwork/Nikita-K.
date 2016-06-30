package com.Palindrome;

import java.util.Scanner;

public class Logic 
{
	 boolean b;
	Scanner scr = new Scanner(System.in);
 
     String str=scr.nextLine();
	
	public boolean isPalindrome(String str)
	{ 
	 String output="";
	 for(int i=0;i<str.length();i++)
	 {
		 
	 if(str.charAt(i)==':'||str.charAt(i)==';'||str.charAt(i)==','||str.charAt(i)=='.'||str.charAt(i)=='?'
			|| str.charAt(i)=='@'||str.charAt(i)=='#'||str.charAt(i)=='$'||str.charAt(i)=='*'||str.charAt(i)=='"'||
			str.charAt(i)=='!')
		 continue;
	 else
		 output+=String.valueOf(str.charAt(i));
	 }
		 StringBuffer str1=new StringBuffer(output);
		 StringBuffer str2=new StringBuffer(str1);
		
		  str1.reverse(); 
		  System.out.println("Orginal String ="+str2);
		  System.out.println("After Reverse ="+str1);
		 
		 if(String.valueOf(str2).compareToIgnoreCase(String.valueOf(str1))==0)
			  b=true;
			else
			  b=false;
		 
		 return b;
		}
	
	}

