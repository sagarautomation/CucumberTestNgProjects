package Interview;

public class Increment 
{
	public static int counter=0;
	public static void m1()
	{
		counter++;
		System.out.println(counter);

		if(counter<2)
		{
			System.out.println("pass");
			
		}
		else
		{
			System.out.println("Fail");

		}
		
	}

	public static void main(String[] args)
	{
		Increment.m1();
	}

}
