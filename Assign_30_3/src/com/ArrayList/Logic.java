package com.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Logic
{
	public void markLength4 ()
	{
		 int n = 0;
		 Iterator itr,itr1;
		  ArrayList<String> al=new ArrayList<String>();//creating arraylist  
		  String str ="";
	    
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("Enter no of strings You want to enter...No=...");
	     n=scanner.nextInt();
	     
	     System.out.println("Now Enter The Strings.. ");
		  while(al.size()<n) 
		  {
		  str = scanner.next();
		  al.add(str);
		  }
		  
		System.out.println("\nYour Strings Before Operation Are.. ");
		  itr=al.iterator();//getting Iterator from arraylist to traverse elements  
		  System.out.print("{");
		  while(itr.hasNext())
		  { 
		   System.out.print(" ");
		   System.out.print(itr.next());
		   System.out.print(",");
		  }  
		  System.out.print("}");
		  ArrayList<String > strings=new ArrayList<>();
			for(String s: al )
			{
				if(s.length()==4)			
					strings.add("****");
					strings.add(s);		
			}
			System.out.println("\nYour Strings After Operation Are.. ");
			System.out.println(strings);
			  itr1=al.iterator();//getting Iterator from arraylist to traverse elements 
			   System.out.print("{");
				  while(itr1.hasNext())
				  { 
				   System.out.print(" ");
				   System.out.print(itr1.next());
				   System.out.print(",");
				  }  
				  System.out.print("}");
	}
}
