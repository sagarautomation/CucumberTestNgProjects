package Interview;

public class Ex2
{

	public static void main(String[] args)
	{
		
		  String s="yamaha";
		  int count=0;
		  String output="";//y
		//text to replace a
		//text to repace with a
		//"yamaaahaaaaa
		  for(int i=0;i<=s.length()-1;i++)
		  {
			  if(s.charAt(i)=='a')
			  {
				  for(int j=0;j<=count;j++)
				  {
					  output=output+'a';
				  }
				  count+=2;
				  
			  }
			  else
			  {
				output=output+s.charAt(i);  
			  }
		  }

		 System.out.println(output); 
		
		
	}

}
