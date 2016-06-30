package com.ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;
import java.awt.List;
import java.lang.*;

public class Collect 
{
public void switchPairs()
{
	 Iterator itr,itr1;
	  int n = 0;
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
	  System.out.println("The List Elements Before swaping are...");
	  
	  
	  itr=al.iterator();//getting Iterator from arraylist to traverse elements  
	  System.out.print("{");
	  while(itr.hasNext())
	  { 
	   System.out.print(" ");
	   System.out.print(itr.next());
	   System.out.print(",");
	  }  
	  System.out.print("}");
	 
	  System.out.println("\nThe List Elements After swaping are...");
 
	   for(int i=0;i<(al.size()-1);i+=2)
	  {
         Collections.swap(al, i, i+1);
		 
	  }
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
