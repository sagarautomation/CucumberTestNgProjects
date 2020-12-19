package Streams;

import java.util.HashMap;
import java.util.Map;

public class Comparemapusingequal {

	public static void main(String[] args)
	{
		Map<String, String> asiaCapital1 = new HashMap<String, String>();
	    asiaCapital1.put("Japan", "Tokyo");
	    asiaCapital1.put("South Korea", "Seoul");
	 
	    Map<String, String> asiaCapital2 = new HashMap<String, String>();
	    asiaCapital2.put("South Korea", "Seoul");
	    asiaCapital2.put("Japan", "Tokyo");
	 
	    Map<String, String> asiaCapital3 = new HashMap<String, String>();
	    asiaCapital3.put("Japan", "Tokyo");
	    asiaCapital3.put("China", "Beijing");
	    System.out.println(asiaCapital1.equals(asiaCapital2));
	    System.out.println(asiaCapital1.equals(asiaCapital3));

	}

}
