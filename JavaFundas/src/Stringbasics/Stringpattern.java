package Stringbasics;

import java.util.HashMap;

public class Stringpattern
{
	
	public static void m1()
	{
		Character ch=32;
		String word="COMBINATION";
		int len=word.length()/2;
		System.out.println(len); 
		for(int i=0;i<len;i++)
		{
			word=word.substring(0, word.length()-1);
			System.out.println(word);
			word=word.substring(1, word.length());
			System.out.println(word);
		}
		
		
	}
	
	public static void m2()
	{
		String s="NaveenAutomationlabs 1234";
		//o/p-123
		
		
	}
	
	public static void m3()
	{
		HashMap<Character,Character>mapper=new HashMap<Character, Character>();
		mapper.put('2', 'B');
		mapper.put('4', 'D');
		mapper.put('5', 'e');
		mapper.put('6', 'F');
		mapper.put('7', 'g');
		mapper.put('3', 'c');
		int n=24245673;//BDBDeFgc
		//1st way
		char[] arr=String.valueOf(n).toCharArray();
		for(int i=0;i<=arr.length-1;i++)
		{
			if(mapper.containsKey(arr[i]))
			{
				arr[i]=mapper.get(arr[i]);
			}
		}
		System.out.println(arr);
		
		//2 nd way.
		System.out.println((char)64+2);
		
		
	}
	
	
	
	

	public static void main(String[] args)
	{
		Stringpattern.m3();
	}

}
