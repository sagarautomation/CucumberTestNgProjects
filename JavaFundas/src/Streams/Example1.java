package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Example1
{

	public static void main(String[] args)
	{
		
		List<Integer> number = Arrays.asList(2,3,4,5); 
		  
	    // demonstration of map method 
	    List<Integer> square = number.stream().filter(i->i%2==0).collect(Collectors.toList());
	    System.out.println(square);
	    
	    
	    // demonstration of map method 
	    List<String> names =Arrays.asList("Reflection","Collection","Stream");
	    List<String> result=names.stream().filter(s->s.contains("S")).collect(Collectors.toList());
	    System.out.println(result);
	    
	 // demonstration of sorted method 
	    List<String> show = names.stream().sorted().collect(Collectors.toList()); 
	    System.out.println(show); 
	    
	 // create a list of integers 
	    List<Integer> numbers = Arrays.asList(2,3,4,5,2); 
	    Set<Integer> squareset=numbers.stream().map(x->x*x).collect(Collectors.toSet());
	    System.out.println(squareset);
	    
	 // demonstration of forEach method 
	    numbers.stream().map(x->x*x).forEach(y->System.out.println(y));
	    
	 // demonstration of reduce method method 
	 // creating a list of Strings 
        List<String> words = Arrays.asList("GFG", "Geeks", "for","GeeksQuiz", "GeeksforGeeks"); 
        Optional<String> longestString=words.stream().reduce((word1,word2)->word1.length()>word2.length() ?word1:word2);
        longestString.ifPresent(System.out::println );        
        
  
	    

        
	  
	  
	  
	  
	  
	  

	}

}
