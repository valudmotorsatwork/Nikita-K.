package com.String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Logic  
{
    public void check()
   {
     Scanner scr=new Scanner(System.in);
       String s=null;
        
      s=scr.nextLine();
      System.out.println("Your String Is.. " +s);
    
    try
       {
      System.out.printf( "%-15s %15s %n","Words Length","Occurances");
      String line[]= s.split(" ");
      ArrayList< String > list = new ArrayList< String >();

       list.addAll( Arrays.asList(line) );

       int cnt = 0;

       for( int i = 0; i < list.size(); i++ )
        {
        for( int j = 0; j < list.size(); j++ )
           {
            if( list.get( i ).equals(list.get( j ) ) )
               cnt++;
             if( list.get( i ).equals( list.get( j ) ) && cnt > 1 )
              list.remove( j );                      
           
           }
        System.out.printf("%-15s %15s %n",( list.get( i ).length()), cnt );
        cnt = 0;
               
            }
          System.out.println();
          }
         catch(Exception e)
           {
            e.printStackTrace();}
    }

}
