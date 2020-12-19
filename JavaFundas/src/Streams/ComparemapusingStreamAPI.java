package Streams;

import java.util.HashMap;
import java.util.Map;

public class ComparemapusingStreamAPI
{
	private boolean areEqual(Map<String, String> first, Map<String, String> second)
	{
	    if (first.size() != second.size()) {
	        return false;
	    }
	    //first.entrySet().stream().forEach(el->System.out.println(el.getKey()));
	 
	    return first.entrySet().stream()
	      .allMatch(e -> e.getValue().equals(second.get(e.getKey())));
	}

	public static void main(String[] args)
	{
		Map<String, String> asiaCapital1 = new HashMap<String, String>();
	    asiaCapital1.put("Japan", "Tokyo");
	    asiaCapital1.put("South Korea", "Seoul");
	 
	    Map<String, String> asiaCapital2 = new HashMap<String, String>();
	    asiaCapital2.put("South Korea", "Seoul");
	    asiaCapital2.put("Japan", "Tokyo");
	    ComparemapusingStreamAPI c=new ComparemapusingStreamAPI();
	    System.out.println(c.areEqual(asiaCapital1, asiaCapital2));

	}

}
