package com.Diamond;

import java.util.Scanner;

public class Logic
{
	
	public static String space(int x)
	{
	    String s = "";
	    for(int i=0; i<x; i++)
	    {
	        s += " ";
	    }
	    return s;
	}
   public void diamond()
     {	
	  StringBuilder sb;
	    int i;
	  Scanner scr = new Scanner(System.in);
	   
	    String s1 = scr.nextLine();
	   
	    if(s1.length()>10)
	    {
	    	System.out.println("Your String Contains More Than 10 Letters");
	    	s1=s1.substring(0, 10);
	    	System.out.println("String Considered to generate the required shape is "+s1);
	    }
	  
	    for(i=1; i<=s1.length(); i++){
	        System.out.print(space(s1.length()-i) + s1.substring(0,i)); 
	        if(i>1)
	        {
	            sb = new StringBuilder(s1.substring(0,i-1));
	            sb = sb.reverse();
	            System.out.print(sb.toString());
	        }
	        System.out.println();
	    }
	    for(i=s1.length()-1; i>0; i--)
	       {
	        System.out.print(space(s1.length()-i) + s1.substring(0,i));
	        if(i>1){
	            sb = new StringBuilder(s1.substring(0,i-1));
	            sb = sb.reverse();
	            System.out.print(sb.toString());
	        }
	        System.out.println();
	    }
	  }
	
	
}
