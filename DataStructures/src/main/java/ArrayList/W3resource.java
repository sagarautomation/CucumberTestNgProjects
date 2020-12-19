package ArrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class W3resource
{
     private static void syso() 
     {
         ArrayList<String>as=new ArrayList<String>(Arrays.asList("Yellow","Green","Blue","Orange"));
         System.out.println(as);
         as.remove("Blue");
         System.out.println(as);
         as.add(0,"violet");
         System.out.println(as);
         //as.stream().map(as.get)
         
        java.util.List<String>res= as.stream().map(i->new StringBuilder(i).reverse().toString()).collect(Collectors.toList());
        System.out.println(res);

         String re="";
        as.forEach((el)->rev(el));
	}
     
     public static void rev(String n)
     {
    	 String res="";
         for(int i=n.length()-1;i>=0;i--)
         {
        	res=res+n.charAt(i);
         } 
         System.out.println(res);
     }
     

	public static void main(String[] args)
	{
		
		W3resource.syso();

	}

}
