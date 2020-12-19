package DataStructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;

public class AllMaps 
{
	public static void treemap()
	{
		TreeMap<String,String>hm=new TreeMap<String, String>();
		  hm.put("ID4", "200");
		  hm.put("ID1", "100");
		  hm.put("ID3", "300");
		  hm.put("ID2", "50");
		  System.out.println(hm);
		  String value=hm.get("ID3");
		  System.out.println(value); 
		  TreeMap<String,String>hm2=new TreeMap<String, String>();
		  hm2.put("ID4", "200");
		  hm2.put("ID1", "100");
		  hm2.put("ID9", "300");
		  hm2.put("ID2", "500");
		 // System.out.println(hm2.containsValue(value));
		  Set<String> s1=hm.keySet();
		  Set<String> s2=hm2.keySet();
		  for(String eachkey:s1)
		  {
			  if(hm2.containsKey(eachkey))
			  {
				  String val=hm2.get(eachkey);
				  if(val.equals(hm.get(eachkey)))
				  {
					  System.out.println("true");
				  }
				  
			  }
			  else
			  {
				  
			  }
		  }

		  

	}
	public static void hasmap()
	{
	  HashMap<String,String>hm=new HashMap<String, String>();
	  hm.put("ID1", "200");
	  hm.put("ID2", "100");
	  hm.put("ID3", "300");
	  hm.put("ID4", "50");
	  System.out.println(hm);



	}
	public static void linkedhasmap()
	{
		LinkedHashMap<String,String>hm=new LinkedHashMap<String, String>();
		  hm.put("ID1", "200");
		  hm.put("ID2", "100");
		  hm.put("ID3", "300");
		  hm.put("ID4", "50");
		  System.out.println(hm);

	}

	public static void main(String[] args) 
	{
		//AllMaps.hasmap();
		//AllMaps.linkedhasmap();
		AllMaps.treemap();
		
	}

}
