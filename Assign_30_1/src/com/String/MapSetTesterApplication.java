//Assignment 1:30/06/2016
package com.String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;

public class MapSetTesterApplication
{

	public static void main(String[] args) 
	{ 
		String input;
		 TreeSet<String> TVshow = new TreeSet<String>();
		HashMap<String,TreeSet> networkMap = new HashMap<String,TreeSet>();
	    //int n=0;
		 Scanner in = new Scanner(System.in); 
		// System.out.println("Enter no of pairs you want to Enter...No=...");
		//   n=in.nextInt();
		   String networkName = null;
	        while(true) 
	          {
	        	System.out.println("Enter Networkname..");
	            networkName = in.next();
	            TVshow.add(networkName);
	            System.out.println("Enter TVshow for "+networkName);
	            String show = in.next();
	            TVshow = networkMap.get(networkName);
	            if (TVshow == null) 
	            	 {
	            	TVshow = new TreeSet<String>();
	            	  TVshow.add(show);
	            	  networkMap.put(networkName, TVshow);
	            	  }
	              else 
	            	 {
	          			TVshow.add(show);
	            	 }      	     		
	        
	                 System.out.print("Do you want to insert more.. If No... Enter No..");
	               		   String ask = in.next();
	                		if(ask.equals("no") || ask.equals("No"))
	            	        {
	            	            break;
	            	        }
	        }
	       
	       System.out.println("Your Elements Are...");
	       
	        Iterator i = TVshow.iterator();
	        // Display elements
	        for(Map.Entry m:networkMap.entrySet())
	             {  
	        	   System.out.println(m.getKey()+" "+m.getValue());  
	        	 }  
	        System.out.println("Sorted Elements are...");
	        ArrayList<String> keyList = new ArrayList<String>(networkMap.keySet());
	        		Collections.sort(keyList);
	        		for (String net: keyList) 
	        		{
	        		 System.out.println(net + " : " + networkMap.get(net));
	        		}		
	     
	}

}
