package com.String;
import java.io.*;
import java.util.Scanner;
public class Logic 
{
	 void check()
	 {
     int cnt=0;
	 try
		{
	Scanner scr;
	String s1= null;
	
	scr=new Scanner(System.in);
	s1=scr.nextLine();
	System.out.println("Your String Is "+ s1);
	
	s1.trim();
	String line[]=s1.split(" ");
	
	System.out.println("Strings Starting With B or b are " );
	 for(int i=0;i<s1.length();i++)
	 {
     if(line[i].startsWith("b")||line[i].startsWith("B"))
       {
	    System.out.println(line[i]);
	    cnt++;
	
        }
	 }
	 if(cnt==0)
	 {
		 System.out.println("No String Found...Please Enter The String Again..");
	 }
   }
	 catch(Exception e)
		 {
			 
		 }
	 finally
	 {
		 System.out.println("Successfull...");
	 }
 }
}
	
