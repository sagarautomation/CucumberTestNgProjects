package EcommerceAutomation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import Exceltestrun.ExcelUtils;

public class ProductList 
{
	
	public ExcelUtils ex;
	public String url;
	int rows,cols;
	public WebDriver d;
    public JavascriptExecutor js;
	//public List<WebElement>products;
	public List<String>productid=new ArrayList<String>();
	public List<String>price=new ArrayList<String>();


	ProductList()
	{
		 ex=new ExcelUtils("C:\\Users\\SAGAR\\Desktop\\Ecommerceautomation.xlsx");
		 url=ex.getCellValueAsString(1, 2);
		 rows=ex.getRowCount();
		 cols=ex.getColumnCount();
		 //System.out.println(cols);
		 //System.out.println(url);
		 
		
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
		//button[@class='_2AkmmA _29YdH8']
		d.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
  }
  
  
  
  
  @Parameters({"Product"})
  @Test
  public void test1(String productname) throws InterruptedException
  {
	WebElement search=d.findElement(By.cssSelector("input[title^='Search for']"));
	Actions a=new Actions(d);
	a.sendKeys(search, productname).sendKeys(Keys.ENTER).build().perform();;
	List<WebElement>all_pages=d.findElements(By.xpath("//a[@class= '_2Xp0TH']"));
	scrape_product_id_prices(all_pages);
	write_to_excel(productid,price);
	//System.out.println(price.size());
	//System.out.println(productid.size());
		
	  
  }//method
  
  
  
  
  
  
  List<String> add_products(List<WebElement> products)
	{
	  for(int j=0;j<products.size();j++)
		{
			System.out.println("Adding"+products.get(j).getText());
			productid.add(products.get(j).getText());
	
		}
	return productid;
				
	}
  
  
  List<String> add_prices(List<WebElement> prices)
	{
	  for(int j=0;j<prices.size();j++)
		{
			System.out.println("Adding"+prices.get(j).getText());
			price.add(prices.get(j).getText());
	
		}
	return price;
				
	}
  
  
	public void scrape_product_id_prices(List<WebElement> all_pages) throws InterruptedException
	{
		for(int i=0;i<=all_pages.size();i++)//4
		{
			
			List<WebElement>products=d.findElements(By.xpath("//div[@class ='_3wU53n']"));
			add_products(products);
			List<WebElement>prices=d.findElements(By.xpath("//div[@class='_1uv9Cb']//div[@class='_1vC4OE _2rQ-NK']"));
			add_prices(prices);
			int pageno=i+1;//0 1 1,2 2,3 ,3,4
			System.out.println(By.xpath("//a[@class='_2Xp0TH']["+pageno+"]"));
			if(i==all_pages.size())
			{
				break;
			}
			d.findElement(By.xpath("//a[@class='_2Xp0TH']["+pageno+"]")).click();
			Thread.sleep(2000);	
		}	
	}

   public void write_to_excel(List<String> productid,List<String>price)
   {
		IntStream.range(0, productid.size()).forEach(index -> 
		{
			String productname=productid.get(index);
			System.out.println(productname);
			String prices=price.get(index);

			try{
			ex.setCellValue(index+1, 0, productname);;
			ex.setCellValue(index+1, 1, prices.replaceAll("[^a-z A-Z 0-9]",""));
			ex.save();	
	
			}
			catch(Exception e)
			{
				System.out.println("exception"+index);
			}
		});
		   
   }
  
  
  @AfterClass
  public void afterClass() 
  {
	  d.quit();
  }

}
