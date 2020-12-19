package DataStructures;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;

public class ListofMaps
{
    


	public static void main(String[] args) 
	{
        
        List<LinkedHashMap<String, String>> coronaresult=new ArrayList<LinkedHashMap<String,String>>();
         
        
         //Basics
//		 LinkedHashMap<String, String>coronadata=new LinkedHashMap<String, String>();
//		 coronadata.put("USA", "170000");
//		 coronadata.put("India", "180000");
//		 coronadata.put("China", "1800");
//		 System.out.println(coronadata);
         for(int i=0;i<=2;i++)
         {
        	 Random rand = new Random(); 
             int num=rand.nextInt(5000);
        	 String key="key"+num;
        	 String val="val"+num;
        	 LinkedHashMap<String, String>coronadata=new LinkedHashMap<String, String>();
        	 coronadata.put(key, val);
        	 coronaresult.add(coronadata);
        	 
         }

         System.out.println(coronaresult);
         
//      // Each row will be a key value pair. So we will use LinkedHashMap so that order can be retained.
// 		// All map will be added to a list.
// 		List<LinkedHashMap<String, String>> allTableData = new ArrayList<LinkedHashMap<String, String>>();
//  
//      // Get total headers of table using stream apis,
// 		String rowLoc = "//table[@class='tg']//tr";
// 		List<String> headers = driver.findElements(By.xpath("//table[@class='tg']//tr//th")).stream().map(headerEle -> headerEle.getText()).collect(Collectors.toList());
//  
// 		// Getting each row then getting each column of row
// 		// skip(1) to skip first row as first row is header row
// 		driver.findElements(By.xpath(rowLoc)).stream().skip(1).forEach(row -> {
// 			// each cell data of row
// 			List<String> rowData = row.findElements(By.tagName("td")).stream().map(columnEle -> columnEle.getText()).collect(Collectors.toList());
// 			// Now iterating both header list and rowData list and putting in to a LinkedHashMap
// 			// toMap() has overloaded version.Third argument is to combine duplicate key values. 
// 			allTableData.add(IntStream.range(0, headers.size()).boxed().collect(Collectors.toMap(i -> headers.get(i),
// 					i -> rowData.get(i), (first, second) -> first, LinkedHashMap<String, String>::new)));
// 		});
//         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
         
		 


	}

}
