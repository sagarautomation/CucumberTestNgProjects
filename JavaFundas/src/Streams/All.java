package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class All
{
	public static void m1()
	{
		Stream<String> s = Stream.of("apple", "banana", "orange");
        Map<Character, String> m = s.collect(
                            Collectors.toMap(s1 -> s1.charAt(0),
                                                s1 -> s1));
        //System.out.println(m);
	}
	public static void m2()
	{
		String s="Sagar";
		System.out.println(s.valueOf(s.charAt(2)));
		//System.out.println(s.charAt(2).intValue());
	}
	public static void m3()
	{
	 String s="Backdooor";
	 //Map<Character,Integer>m=s.chars().boxed().collect(Collectors.toMap(k->Character.valueOf((char)k.intValue()),v->1, Integer::sum,LinkedHashMap::new));

	 Map<Object,Integer>m=s.chars().boxed().collect(Collectors.toMap(k->Character.valueOf((char)k.intValue()),v->1, Integer::sum,LinkedHashMap::new));
	 System.out.println(m);
	
	}
	
	public static void m4()
	{
	   String s="AADNBBAHAA";  //o/p-3
	}

	public static void main(String[] args)
	{
		All.m4();
	}

}
