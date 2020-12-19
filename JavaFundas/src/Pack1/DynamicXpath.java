package Pack1;

public class DynamicXpath
{
	
public static String get(String xpath, String data) 
   {
		
		String rawxpath = xpath.replaceAll("%replaceable%", data);
		System.out.println(rawxpath);
		
		return rawxpath;
		
	}
 public static void main(String[]args)
 {
	 get("//a[@class='dsght']","123");
	 
 }

}
