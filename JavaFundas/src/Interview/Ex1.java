package Interview;

public class Ex1
{

	public static void main(String[] args)
	{
		String s="welcome"; //output-->ewclmoe
		String res="";
		for(int i=0;i<=s.length()-1;i+=2)
		{
			try
			{
			res=res+Character.toString(s.charAt(i+1));
			}
			catch(Exception e)
			{	
			}
			res=res+Character.toString(s.charAt(i));
			

		}
		System.out.println(res);
		
		
	}

}
