//Input Class

package com.valud;
import java.io.*;

public class SetGet 
   {
	 BufferedReader bin;
	 FileReader fin;
	BufferedReader inputFile()
	{
	try{
	 fin=new FileReader("./resources/ass1_input1.txt");  
	 bin=new BufferedReader(fin); 
	   }
	catch(Exception e)
	   {System.out.println(e);
	   }
	
       return bin; 
     }

    }
