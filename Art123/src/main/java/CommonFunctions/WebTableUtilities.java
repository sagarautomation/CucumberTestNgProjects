package CommonFunctions;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class WebTableUtilities
{
	public static WebElement ctable=Setup.d.findElement(By.xpath("//table[contains(@id,'main_table_countries_today')]"));
	public static int rowcount;
	public static  int colcount;


    
	public static int getrowcount()
	{
		//table[contains(@id,'main_table_countries_today')]//tr
		List<WebElement>rc=Setup.d.findElements(By.xpath("//table[contains(@id,'main_table_countries_today')]//tr"));
		//System.out.println("Rowscount"+rc.size());
		rowcount=rc.size();
		return rowcount;
		
		

		
	}
	
	public static int getcolcount()
	{
	  List<WebElement>cc=Setup.d.findElements(By.xpath("//table[contains(@id,'main_table_countries_today')]//tr[1]//td"));
	  //System.out.println(cc.size());
	  colcount=cc.size();
	  return colcount;

	}
	
	public static void extractdata(String... args)
	{
		//USA--500000,256,169000
		//coun1 key and data's are value----one key multiple value
		 List<String> countries_list=new ArrayList();
		 for(int i=0;i<=args.length-1;i++) //
		 {
			 countries_list.add(args[i]);
		 }
          System.out.println("First values in countries list"+countries_list.get(0).toString() );
		
		LinkedHashMap<String, List<String>>coronadata=new LinkedHashMap<String, List<String>>();
		String countryname;
		String x1="//table[contains(@id,'main_table_countries_today')]//tr[";
		String x2="]//td[";
		String x3="]";
		System.out.println("Before for loop");
		System.out.println("Colcount"+getcolcount());
		System.out.println("Rowcount"+getrowcount());
		try{

		for(int i=1;i<=getrowcount()-1;i++)
		{
		
		  countryname=Setup.d.findElement(By.xpath(x1+i+x2+2+x3)).getText();
		  String totalcases=Setup.d.findElement(By.xpath(x1+i+x2+3+x3)).getText();
		  String newcases=Setup.d.findElement(By.xpath(x1+i+x2+4+x3)).getText();
		  String totaldeaths=Setup.d.findElement(By.xpath(x1+i+x2+5+x3)).getText();
		  List<String> casecount=new ArrayList();
		  if(countries_list.contains(countryname))
		  {
		  casecount.add(totalcases);;
		  casecount.add(newcases);;
		  casecount.add(totaldeaths);;
		  coronadata.put(countryname, casecount);
		  }
		  else
		  {
			  
		  }

		  
		  
			  
		}//forloop

		}
		catch(NoSuchElementException e)
		{
			
		}
		
		Set<String>keys=coronadata.keySet();
		for(String k:keys)
		{
			System.out.println("The value for"+k+"is------>"+coronadata.get(k).toString());
			
		}
			
	}//method
	
	public static void extractdata_alternate_way(String... param)
	{
		//USA--500000,256,169000 that USA is key and figues are value
		//coun1 key and data's are value----one key multiple value
		 List<String> countries_list=new ArrayList();
		 LinkedHashMap<String, List<String>>coronadata=new LinkedHashMap<String, List<String>>();

		 for(int i=0;i<=param.length-1;i++) //
		 {
			 countries_list.add(param[i]);
		 }
         for(int i=0;i<=countries_list.size()-1;i++)
         {
   		     List<String> casecount=new ArrayList();

        	 String list_item=countries_list.get(i).toString();//USA
        	 String countryname=Setup.d.findElement(By.xpath("//a[text()='"+list_item+"']")).getText();
        	 String totalcase=Setup.d.findElement(By.xpath("//a[text()='"+list_item+"']//parent::td//following-sibling::td[text()][1]")).getText();
        	 String newcases=Setup.d.findElement(By.xpath("//a[text()='"+list_item+"']//parent::td//following-sibling::td[text()][2]")).getText();
        	 String totaldeath=Setup.d.findElement(By.xpath("//a[text()='"+list_item+"']//parent::td//following-sibling::td[text()][3]")).getText();

        	 if(countries_list.contains(countryname))
        	 {
        		 casecount.add(totalcase);
        		 casecount.add(newcases);
        		 casecount.add(totaldeath);
        		 coronadata.put(countryname, casecount);
        		 
        	 }
        	 else
        	 {
        		 
        	 }
        	 
         }//forloop
          
          
         Set<String>keys=coronadata.keySet();
 		for(String k:keys)
 		{
 			System.out.println("The value for"+k+"is------>"+coronadata.get(k).toString());
 			
 		}
          
		
	}//methodname	

     


}	
	   
	       
		

		
		
		
	
	
	


