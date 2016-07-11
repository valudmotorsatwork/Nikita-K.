import java.util.Scanner;

class KeyboardInput 
{
 String name;

	public void setName(String n)
	{
	this.name=n;
	}
	public String getName()
	{
	return name;
	}
	public static void main(String args[])
	{
		KeyboardInput obj=new KeyboardInput();
		Scanner scr=new Scanner(System.in);
		System.out.println("Enter The String... ");
		obj.setName(scr.next());
		System.out.println("You Entered The Name =" +obj.getName());
    	}
}