package DataStructures;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListofList
{

	public static void main(String[] args) 
	{
		Map<String, List<List>> hm = new LinkedHashMap<String, List<List>>();

		List<List>ls=new ArrayList<List>();
		List<String>l1=new ArrayList<String>();
		l1.add("sagar");
		l1.add("29");
		List<String>l2=new ArrayList<String>();
		l2.add("suraj");
		l2.add("26");
		List<String>l3=new ArrayList<String>();
		l3.add("asma");
		l3.add("25");
		ls.add(l1);
		ls.add(l2);
		ls.add(l3);
//		System.out.println(ls.size());
//		for(int i=0;i<=ls.size()-1;i++)
//		{
//			for(int j=0;j<=ls.get(i).size()-1;j++)
//			{
//				System.out.println(ls.get(i).get(j));
//			}
//		}
		
		hm.put("1", ls);
		System.out.println(hm.get("1"));
		

	}

}
