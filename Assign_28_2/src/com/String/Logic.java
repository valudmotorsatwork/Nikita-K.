package com.String;

import java.util.Scanner;

public class Logic 
{
void check()
{
	Scanner scr;
	String s1= null;
	scr=new Scanner(System.in);
	s1=scr.nextLine();
	System.out.println("Your String is.."+s1);
	String str="";
	System.out.println("All the possible Substrings are...");
	for(int i=0;i<5;i++)
	{
		for(int j=0;j<5;j++)
		{
			for(int k=0;k<5;k++)
			{
				System.out.println(str+s1.charAt(i)+s1.charAt(j)+s1.charAt(k));
			}
		}
	}
}
}
