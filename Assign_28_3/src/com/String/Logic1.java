package com.String;

import java.util.Scanner;

public class Logic1
{
void check()
{
	  int cnt=0;
	
 	String s1= null;
		
		Scanner scr=new Scanner(System.in);
		s1=scr.nextLine();
		
		System.out.println("Your String Is "+ s1);
	
		for(int i=0;i<s1.length();i++)
		{
		 for(int j=0;j<s1.length();j++)
		  {
			
		     if(s1.charAt(i)==s1.charAt(j))
	         	{
	         
		        cnt++;
		        }
		 
	     }
		 if(cnt!=0)
		 {
			 switch(cnt)
				{
				case 1:System.out.println("One "+s1.charAt(i));	
				        break;
				case 2:System.out.println("Two "+s1.charAt(i));	
			           break;
				case 3:System.out.println("Three "+s1.charAt(i));	
			           break;
				case 4:System.out.println("Four "+s1.charAt(i));	
			           break;
				case 5:System.out.println("Five "+s1.charAt(i));	
		               break;
				case 6:System.out.println("Six "+s1.charAt(i));	
	                    break;
				case 7:System.out.println("Seven "+s1.charAt(i));	
	                    break;
				case 8:System.out.println("Eight "+s1.charAt(i));	
	                    break;
	            case 9:System.out.println("Nine "+s1.charAt(i));	
	                    break;
	            case 10:System.out.println("Ten "+s1.charAt(i));	
	                   break;
	            default :System.out.println("More Than Ten Occurances..");
	            		break;	
	          
				}
			 cnt=0;
			}
		
	    }
		
	
}
}