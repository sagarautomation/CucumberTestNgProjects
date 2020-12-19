package DataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;





import Exceltestrun.ExcelUtils;

public class ComparePricesinExcel
{
	public ExcelUtils ex;
	public String url;
	int rows,cols;
	public TreeMap<String,String>web_product_prices=new TreeMap<String, String>();
	public TreeMap<String,String>excel_product_prices=new TreeMap<String, String>();
	ComparePricesinExcel()
	{
		ex=new ExcelUtils("C:\\Users\\SAGAR\\Desktop\\Ecommerceautomation.xlsx");
		ex.selectSheet("Sheet2");
		rows=ex.getRowCount();cols=ex.getColumnCount();
		//System.out.println(rows); System.out.println(cols); 	
	
	}
	
	public TreeMap<String,String>web_prices()
	{
		web_product_prices.put("ID1", "1000");
		web_product_prices.put("ID2", "101");
		web_product_prices.put("ID3", "102");
		web_product_prices.put("ID4", "104");
		web_product_prices.put("ID5", "500");
		web_product_prices.put("ID6", "700");
		web_product_prices.put("ID7", "600");
		web_product_prices.put("ID8", "900");
		web_product_prices.put("ID9", "800");
		web_product_prices.put("ID10", "1099");

		return web_product_prices;
		
	}
	public TreeMap<String,String>excel_prices()
	{
		for(int i=1;i<=rows;i++)
		 {
			 try{
			 excel_product_prices.put(ex.getCellValueAsString(i, 0), ex.getCellValueAsString(i, 1));
			 }
			 catch(Exception e)
			 {
				 //System.out.println("exception in"+i+"row");
			 }
		 }
		//System.out.println(excel_product_prices.size());
		return excel_product_prices;
		
	}
	
	public void compare(TreeMap<String,String>web_product_prices,TreeMap<String,String>excel_product_prices)
	{
		  Set<String> all_excel_productid=excel_product_prices.keySet();
		  for(String product_id_excel:all_excel_productid)
		  {
			  if(web_product_prices.containsKey(product_id_excel))
			  {
				if(web_product_prices.get(product_id_excel).equals(excel_product_prices.get(product_id_excel)))
						{
					
							System.out.println("row num of"+ web_product_prices.get(product_id_excel)+"is"+ex.getrownum(web_product_prices.get(product_id_excel)));
							
							try{
							ex.setCellValue(ex.getrownum(web_product_prices.get(product_id_excel)), 2, "Pass");}
							catch(Exception e)
							{
								
							}
							ex.save();
							
						}
				else
				{
					try{
						ex.setCellValue(ex.getrownum(excel_product_prices.get(product_id_excel)), 2, "Not matched");}
						catch(Exception e)
						{
							
						}
						ex.save();
							
				}
				
			  }
			  else
			  {
				  try{
						ex.setCellValue(ex.getrownum(product_id_excel), 2, "Product id unavailable ");}
						catch(Exception e)
						{
							
						}
						ex.save();
						  
					
			  }
			  
			  
		  }//for loop
		
		
		
	}
	
	public static void main(String[]args)
	{
		ComparePricesinExcel cp=new	ComparePricesinExcel();
		TreeMap<String,String>p1=cp.web_prices();
		TreeMap<String,String>p2=cp.excel_prices();
		cp.compare(p1, p2);
	}
	
	

}
