package Arrays;

import java.lang.reflect.Array;
import java.util.Arrays; 
import java.util.Collections;
import java.util.List;


public class SortArray
{
	 String arr[] ={"15","2","1"}; 
	 
    

	public static void main(String[] args) 
	{
      // = +
		SortArray s=new SortArray();
		for(int i=0;i<=s.arr.length-1;i++)
		{
			System.out.println(s.arr[i]);
			
		}
		//Arrays.sort(s.arr);
		
		for(int i=0;i<=s.arr.length-1;i++)
		{
			System.out.println(s.arr[i]);
			
		}
		
		List<String>coll=Arrays.asList(s.arr);
		Collections.sort(coll);
		System.out.println("element are"+coll.get(0));
	}

}
