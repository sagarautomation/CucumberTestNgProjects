package Stringbasics;

public class Removeallspecialchar
{
	
	public static void m1()
	{
		// remove special characters
		String price1="₹45,000";
		String price2="45000";
		System.out.println(price1);
		System.out.println(price1.equalsIgnoreCase(price2));
		price1=price1.replaceAll("[^a-z A-Z 0-9]", "");
		System.out.println(price1.equalsIgnoreCase(price2));
		
	}
	
	public static void m2()
	{
		String s="sagar";
		String new1=s.replace(s.charAt(1), (char)32);
		char ch=32;
		String new2=new1.trim();
		System.out.println(new2);
	}

	public static void m3()
	{
		String s="AABBABAAcC";
		int count=0;
		for(int i=0;i<s.length();i++)
		{
			int nextindex=i+1;
			for(int j=i+1;j<s.length();j++) 
			{
				if(s.charAt(i)==s.charAt(j)&& nextindex==j)
					
				{
					count++;
				}
			}
		}
		
		System.out.println(count);
		}
	
	public static void m4()
	{
		String s="Backdoor"; int n=2;
		int count=0;
		
	}
	
	public static void m5()
	{
		String s="Boackoork";
		System.out.println(s.lastIndexOf('k'));
		System.out.println(s.lastIndexOf('k', 5));
		System.out.println(s.lastIndexOf("ack", 7));
		System.out.println(s.substring(7, 8));//exception
		char[]x=s.toCharArray();
		System.out.println(x[3]);
		

	}
	
	public static void main(String[]args)
	{
		Removeallspecialchar.m5();	
	}

}
