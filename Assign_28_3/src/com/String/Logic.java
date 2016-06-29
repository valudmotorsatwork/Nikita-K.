package com.String;

import java.util.Scanner;

public class Logic 
{
	void check()
	{
		  int cnt=0;
			Scanner scr;
			String s1= null;
			char ch,ch1;
			scr=new Scanner(System.in);
			s1=scr.nextLine();
			System.out.println("Your String Is "+ s1);
			
			for(ch1='A';ch1<='Z';ch1++)
			{
			for(int j=0;j<s1.length();j++)
			{
				if(ch1==s1.charAt(j))
				{
					cnt++;
				}
				
			}
			if(cnt!=0)
			{
				System.out.println(ch1+" "+cnt+" times..");	
				cnt=0;
			}
		   }
	        
			for(ch='a';ch<='z';ch++)
				{
				for(int i=0;i<s1.length();i++)
				{
					if(ch==s1.charAt(i))
					{
						cnt++;
					}
					
				}
				if(cnt!=0)
				{
					System.out.println(ch+" "+cnt+" times..");	
					cnt=0;
				}
				}
		
			
		  
			
	}

}
