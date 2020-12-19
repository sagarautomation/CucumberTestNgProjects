package Streams;

import java.util.HashMap;
import java.util.Map;

public class ComparemapwithArrays {

	public static void main(String[] args)
	{
	    Map<String, String[]> asiaCity1 = new HashMap<String, String[]>();

		asiaCity1.put("Japan", new String[] { "Tokyo", "Osaka" });
	    asiaCity1.put("South Korea", new String[] { "Seoul", "Busan" });
	 
	    Map<String, String[]> asiaCity2 = new HashMap<String, String[]>();
	    asiaCity2.put("South Korea", new String[] { "Seoul", "Busan" });
	    asiaCity2.put("Japan", new String[] { "Tokyo", "Osaka" });
	    System.out.println(asiaCity1.equals(asiaCity2));
	}

}
