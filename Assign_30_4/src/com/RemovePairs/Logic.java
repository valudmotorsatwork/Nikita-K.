package com.RemovePairs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Logic 
{
	void removeBadPairs(ArrayList<Integer> newList)
	{
		 int n = 0;
		  ArrayList<Integer> al=new ArrayList<Integer>();//creating arraylist  
		  int no;
		  Iterator itr,itr1;
		  Scanner scanner = new Scanner(System.in);
		  System.out.println("Enter no of integers You want to enter...No=...");
	     n=scanner.nextInt();
	     
	     System.out.println("Now Enter The Random Numbers To Check.. ");
		  while(al.size()<n) 
		  {
		  no = scanner.nextInt();
		  al.add(no);
		  }
    if(!al.isEmpty())
	  {
		  System.out.println("\nYour Strings Before Operation Are.. ");
		  itr = al.iterator();//getting Iterator from arraylist to traverse elements  
		  System.out.print("{");
		  while(itr.hasNext())
		  { 
		   System.out.print(" ");
		   System.out.print(itr.next());
		   System.out.print(",");
		  }  
		  System.out.print("}");//While Loop For Printing The Elements
		  
		  if(al.size()%2==1)
		  {
		  al.remove(al.get(al.size()-1));
		  }
		  
		  for(int i=0;i<al.size()-1;i+=2)
		  { 
	         if(al.get(i)>al.get(i+1))
	         {
	        	 al.remove(i);
	        	 al.remove(i);
	         }   
	        
	       }
	  
		  System.out.println("\nYour Strings After Operation Are.. ");
		  itr1 = al.iterator();//getting Iterator from arraylist to traverse elements  
		  System.out.print("{");
		  while(itr1.hasNext())
		  { 
		   System.out.print(" ");
		   System.out.print(itr1.next());
		   System.out.print(",");
		  }  //While Loop For Printing The Elements
		  System.out.print("}");
		  
		}
		 else
			  System.out.println("Empty List {  }");
	}

}
