package Streams;

import java.util.HashMap;
import java.util.Map;

public class CompareHashmapKeys
{
	private boolean comparekeys(Map<String,String> data1,Map<String,String> data2)
	{
		if(data1.keySet().equals(data2.keySet()))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
		
	}

	public static void main(String[] args) 
	{
		Map<String, String> asiaCapital1 = new HashMap<String, String>();
	    asiaCapital1.put("Japan", "Tokyo");
	    asiaCapital1.put("South Korea", "Seoul");
	 
	    Map<String, String> asiaCapital2 = new HashMap<String, String>();
	    asiaCapital2.put("South Korea", "Seoul");
	    asiaCapital2.put("Japan", "Tokyo");
	    CompareHashmapKeys c=new CompareHashmapKeys();
	    boolean isequal=c.comparekeys(asiaCapital1,asiaCapital2);
	    System.out.println(isequal);
	    
	    
	 

	}

}
