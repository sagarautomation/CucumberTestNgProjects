package Streams;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CompareHashmapVals
{
	//check which keys have the same value in both HashMaps 
	private Map<String, Boolean> areEqualKeyValues(Map<String, String> first, Map<String, String> second)
	{
	    return first.entrySet().stream()
	      .collect(Collectors.toMap(e -> e.getKey(), 
	        e -> e.getValue().equals(second.get(e.getKey()))));
	}
	//return the keys in object array  which have same value in both the hashmap..
	private Object[] areEqualKey(Map<String, String> first, Map<String, String> second)
	{
		return first.entrySet().stream().filter(entry->second.containsValue(entry.getValue())).map(Map.Entry::getKey).toArray();
	} 
	
	public static void main(String[] args) 
	{
		Map<String, String> asiaCapital1 = new HashMap<String, String>();
	    asiaCapital1.put("Japan", "Tokyo");
	    asiaCapital1.put("South Korea", "Seul");
	 
	    Map<String, String> asiaCapital2 = new HashMap<String, String>();
	    asiaCapital2.put("South Korea", "Seoul");
	    asiaCapital2.put("Japan", "Tokyo");
	    CompareHashmapVals c=new CompareHashmapVals();
	    c.areEqualKey(asiaCapital1, asiaCapital2);
	    c.areEqualKeyValues(asiaCapital1, asiaCapital2);
	    
	    //System.out.println(c.areEqualKeyValues(asiaCapital1, asiaCapital2));
	    System.out.println(c.areEqualKey(asiaCapital1, asiaCapital2));
	    
	    
	 

	}

}
