package Stringbasics;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class CountRepetetiveChar
{
	public static String s="Sagar";
	Set<Character>chset=new LinkedHashSet<Character>();

	public static void m1()
	{
		//o/p-2
		int count=0;
		Set<Object>chset=new HashSet<Object>();
		for(int i=0;i<s.length();i++)
		{
			if(!chset.add(s.charAt(i)))
			{
				count++;
			}
			else
			{
				
			}
		}
		System.out.println(count);
		
	}
	

	public static void main(String[] args)
	{
		CountRepetetiveChar.m1();

	}

}
