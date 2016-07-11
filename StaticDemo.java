//1.Write a Java Applications to demonstrate the concept of Static members, methods & Instance Members, methods.

import java.io.*;

public class StaticDemo 
{
 static int a=10;
 int x;
 static void  display()
   {
	a=20;
	System.out.println("The Value Of a after updating.. a = "+a);
	
   }
 void show()
 {
	 x=30;
	 System.out.println("Accessing instance Member in Non-Static method x="+x);
 }

public static void main(String[] args)
	{
	StaticDemo obj=new StaticDemo();
	 int b=StaticDemo.a;
	 System.out.println("The value Of a before updating.. a ="+b);
	 display();
	 obj.show();
	 

	}

}
