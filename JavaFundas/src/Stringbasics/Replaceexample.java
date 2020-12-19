package Stringbasics;

public class Replaceexample 
{
	public static void m1()
	{
		String s="Tomorrow";
		//o/p--replace first o with x second o with xx and third o with xxx.
		String replaceable="X";
		for(int i=0;i<=s.length()-1;i++)
		{
			if(s.charAt(i)=='o')
			{
				s=s.replaceFirst(Character.toString(s.charAt(i)), replaceable);
				replaceable=replaceable+"X";
			}
			else
			{
				
			}
		}
		System.out.println(s);
	}
	public static void main(String[] args)
	{
		Replaceexample.m1();
	}

}
