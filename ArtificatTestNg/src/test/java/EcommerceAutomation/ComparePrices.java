package EcommerceAutomation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import Exceltestrun.ExcelUtils;

public class ComparePrices 
{
	public ExcelUtils ex;
	public String url;
	int rows,cols;
	public WebDriver d;
    public JavascriptExecutor js;
	public List<String>productid=new ArrayList<String>();
	public List<String>price=new ArrayList<String>();
	public TreeMap<String,String>product_prices=new TreeMap<String, String>();
	public TreeMap<String,String>excel_product_prices=new TreeMap<String, String>();


	ComparePrices()
	{
		 ex=new ExcelUtils("C:\\Users\\SAGAR\\Desktop\\Ecommerceautomation.xlsx");
		 url=ex.getCellValueAsString(1, 2);
		 rows=ex.getRowCount();
		 cols=ex.getColumnCount();
		 System.out.println(rows);
		 //System.out.println(cols);
		 
		
	}
	
	
  
  @BeforeClass
  public void beforeClass() 
  {
	  
	    System.setProperty("webdriver.chrome.driver","D:\\Seleniumjars\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		d = new ChromeDriver(options);
		js = (JavascriptExecutor) d;
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    d.get(url);
		d.manage().window().maximize();
		d.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
  }
  @Parameters({"Product"})
  @Test
  public void test2(String productname) throws InterruptedException
  {
	// read excel data into Treemap
	// iterate through it and check website to verify the prices lsited in csv are matched 
	  
	  WebElement search=d.findElement(By.cssSelector("input[title^='Search for']"));
	  Actions a=new Actions(d);
	  a.sendKeys(search, productname).sendKeys(Keys.ENTER).build().perform();;
	  List<WebElement>all_pages=d.findElements(By.xpath("//a[@class= '_2Xp0TH']"));
	  
	  //System.out.println(product_prices.size());
	  //product_prices.keySet().stream().forEach(ky->System.out.println(product_prices.get(ky)));
	  product_prices=scrape_product_id_prices(all_pages);
	  excel_product_prices=store_exceldata_in_map();
	  compare(product_prices,excel_product_prices);
	  System.out.println("Total prices in excel"+excel_product_prices.size());
	  //excel_product_prices.keySet().stream().forEach(ky->System.out.println(excel_product_prices.get(ky)));

  }
  @AfterClass
  public void afterClass()
  {
  }

  
  
  public TreeMap<String,String>scrape_product_id_prices(List<WebElement> all_pages) throws InterruptedException
  {
	  
	  for(int i=0;i<=all_pages.size();i++)//4
		{
			
			List<WebElement>products=d.findElements(By.xpath("//div[@class ='_3wU53n']"));
			List<WebElement>prices=d.findElements(By.xpath("//div[@class='_1uv9Cb']//div[@class='_1vC4OE _2rQ-NK']"));
			addinmap(products,prices);
			int pageno=i+1;//0 1 1,2 2,3 ,3,4
			System.out.println(By.xpath("//a[@class='_2Xp0TH']["+pageno+"]"));
			if(i==all_pages.size())
			{
				break;
			}
			d.findElement(By.xpath("//a[@class='_2Xp0TH']["+pageno+"]")).click();
			Thread.sleep(2000);	
		} 
	   return product_prices;
	  
  }
	public void addinmap(List<WebElement>products,List<WebElement>prices)
	{
		for(int j=0;j<products.size();j++)
		{
			
			//System.out.println("Adding"+prices.get(j).getText().replaceAll("[^a-z A-Z 0-9]",""));
			product_prices.put(products.get(j).getText(), prices.get(j).getText().replaceAll("[^a-z A-Z 0-9]",""));
	
		}
	}
     
	 public TreeMap<String,String> store_exceldata_in_map()
	  {
		 //System.out.println(ex.getCellValueAsString(0, 0));	
		 //System.out.println(ex.getCellValueAsString(0, 1));

		 for(int i=1;i<=rows;i++)
		 {
			 try{
			 excel_product_prices.put(ex.getCellValueAsString(i, 0), ex.getCellValueAsString(i, 1));
			 }
			 catch(Exception e)
			 {
				 //System.out.println("exception in"+i+"row");
				 //e.printStackTrace();
			 }
		 }
		return excel_product_prices;
		  
	  }

	public void compare(TreeMap<String,String>product_prices,TreeMap<String,String>excel_product_prices)
	{
		  Set<String> all_excel_productid=excel_product_prices.keySet();
		  for(String product_id_excel:all_excel_productid)
		  {
			  if(product_prices.containsKey(product_id_excel))
			  {
				if(product_prices.get(product_id_excel).equals(excel_product_prices.get(product_id_excel)))
						{
					
							System.out.println("row num of"+ product_prices.get(product_id_excel)+"is"+ex.getrownum(product_prices.get(product_id_excel)));
							
							try{
							ex.setCellValue(ex.getrownum(product_prices.get(product_id_excel)), 3, "Pass");
							ex.setCellValue(ex.getrownum(product_prices.get(product_id_excel)), 4, product_prices.get(product_id_excel));}

							
							catch(Exception e)
							{
								
							}
							ex.save();
							
						}
				else
				{
					try{
						ex.setCellValue(ex.getrownum(excel_product_prices.get(product_id_excel)), 3, "Fail");
						ex.setCellValue(ex.getrownum(product_prices.get(product_id_excel)), 4, product_prices.get(product_id_excel));
						}
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

	
	
	
	
}
