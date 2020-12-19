package Streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntstreammandBoxed 
{
	public static void boxedconcept()
	{
		List<String>strings=Stream.of("Java8","Lambda","Expression").collect(Collectors.toList());
		System.out.println(strings);
		
		//IntStream.of(28,03,1991).collect(Collectors.toList());
		
		
		
		//error--The method collect in the type Innstream is not applicable for the arguments
		//8The method collect(Supplier<R>, ObjIntConsumer<R>, BiConsumer<R,R>) in the type IntStream is not applicable for the arguments 
	    //- Type mismatch: cannot convert from Collector<Object,?,List<Object>> to Supplier<R>
	    //(Collector<Object,capture#2-of ?,List<Object>>)
		//TO COVERT STREAM OF PRIMITIVES WE  MUST FIRST BOXED THE ELEMENTS IN THEIR WRAPPER CLASSES AND THEN COLLECT
		//THE WRAPPED OBJECT.THIS IS CALLED BOXED STREAM.
		List<Integer>ints=IntStream.of(28,03,1991).boxed().collect(Collectors.toList());
		System.out.println(ints);
		
		String s="Sagar";
		List<Character>ints1=s.chars().boxed().map(el->Character.valueOf((char)el.intValue())).collect(Collectors.toList());
		System.out.println(ints1);
		//in above example if boxed() is removed then error will come cannot invoke intValue on primitive type
	}
	public static void findsum()
	{
		
		String s="Date of Birth is 10/16/2020";
		s=s.replaceAll("[^0-9\\/]", "");
		System.out.println(s);
		int sum=Arrays.stream(s.split("\\/")).mapToInt(Integer::parseInt).sum();
		
		//using map and reduce
		//int sum=Arrays.stream(s.split("\\/")).map(Integer::parseInt).reduce(Integer::sum).get();
		
		//using maptoInt and reduce
		//int sum=Arrays.stream(s.split("\\/")).mapToInt(Integer::parseInt).reduce(0,(s1,s2)->(s1+s2));

		System.out.println(sum);
		
	}
	
	public static void Streamcollect()
	{
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = integers.stream()
		  .collect(Collectors.summingInt(Integer::intValue));
		System.out.println(sum);

	}
	
	public static void mapptoInt()
	{
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		Integer sum = integers.stream().mapToInt(Integer::intValue).sum();
		  
		System.out.println(sum.intValue());

	}
	
	public static void sumwithmap()
	{
		Map<Object,String>hm=new HashMap<Object,String>();
		hm.put("A", "1");
		hm.put("B", "2");
		hm.put("C", "3");
		hm.put("D", "4");
		System.out.println(hm.values());
		int sum=hm.values().stream().mapToInt(Integer::valueOf).sum();
		System.out.println(sum);

		
	}

	public static void main(String[] args) 
	
	{
		Stream.of("A1","B2","C3","D4");
		IntStream.range(0,4)
		  .forEach(index -> 
		  {
			  //System.out.println(index);
		  }
		  );
		
		//IntstreammandBoxed.boxedconcept();
		IntstreammandBoxed.findsum();
		//IntstreammandBoxed.Streamcollect();
		//IntstreammandBoxed.mapptoInt();
		//IntstreammandBoxed.sumwithmap();



	}
	
	

}
