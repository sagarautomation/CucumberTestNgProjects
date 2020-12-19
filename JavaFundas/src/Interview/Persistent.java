package Interview;

public class Persistent 
{
	public static void m1()
	{
		String s="foo";
		Object obj=(Object)s;
		if(s.equals(obj))
		{
			System.out.println("AA");
		}
		
		 if(obj.equals(s))
		{
			System.out.println("BB");
			
		}
		else
		{
			System.out.println("CC");
			
		}
		
	}
	
	
	
	 static int x;
	 static boolean  Catch()
	 {
		 x++;
		 return true;
	 }

	public static void main(String[] args)
	{
		
		x=0;
		if(Persistent.Catch()|Persistent.Catch()||Persistent.Catch())
		{
			 x++;
			 System.out.println(x);

		}
		else
		{
			System.out.println("AA");
		}
		
	}

}
