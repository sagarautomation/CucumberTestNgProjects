package NaukriJobreminder;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Exceltestrun.ExcelUtils;

public class JobReminder
{
	WebDriver d;
	
	@BeforeTest
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Seleniumjars\\chromedriver.exe");
		d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    d.get("https://www.naukri.com");
		d.manage().window().maximize();
//		ExcelUtils ex=new ExcelUtils("C:\\Users\\SAGAR\\Desktop\\Jobdetails.xlsx");
//		int rows=ex.getRowCount();
//		System.out.println(rows);
//		ex.setCellValue(1, 1, "sagar");
//		ex.save();

		
		
		
	}
	@Parameters({"username","password"})
	@Test(enabled=true)
	public void login(String username,String password) throws InterruptedException
	{
		// +
		String mainhandle=d.getWindowHandle();
		System.out.println("mainhandle is"+mainhandle);
		
		Set<String> handles=d.getWindowHandles();
		System.out.println(handles.size());
		for(String eachhandle:handles)
		{
			if(!mainhandle.equalsIgnoreCase(eachhandle))
			{
			System.out.println("closing handle"+eachhandle);
			d.switchTo().window(eachhandle).close();;
			Thread.sleep(2000);
			}
			else
			{
				System.out.println("mainhandle is"+mainhandle+"is not closed");
	
			}
		}
		
		d.switchTo().window(mainhandle);
		System.out.println(username);
		System.out.println(password);
		d.findElement(By.cssSelector("a[title^='Jobseeker']")).click();
		d.findElement(By.cssSelector("input[placeholder*='Email ID']")).sendKeys(username);
		d.findElement(By.cssSelector("input[placeholder*='password']")).sendKeys(password);
		d.findElement(By.cssSelector("button[type^='sub']")).click();


		
	}
	
	@Parameters({"skills","location"})
	@Test(priority=2,enabled=true)
	public void searchskills(String skills,String location)
	{
		//input#qsb-keyskill-sugg
		// input#qsb-location-sugg
		//button[type^='submit']
		try
		{
		d.findElement(By.cssSelector("input#qsb-keyskill-sugg")).sendKeys(skills);
		d.findElement(By.cssSelector("input#qsb-location-sugg")).sendKeys(location);
		d.findElement(By.cssSelector("button[type^='submit']")).click();
		}
		catch(Exception e)
		{
			
		}
	
	}
	
	@Test(priority=3,enabled=true)
	public void sendsms() throws InterruptedException
	{

		ArrayList<String>designation=new ArrayList<String>();
		ArrayList<String>company=new ArrayList<String>();
		ArrayList<String>experience=new ArrayList<String>();
		ArrayList<String>location=new ArrayList<String>();
		ArrayList<String>skills=new ArrayList<String>();
		
		ExcelUtils ex=new ExcelUtils("C:\\Users\\SAGAR\\Desktop\\Jobdetails.xlsx");
		int rows=ex.getRowCount();
		System.out.println(rows);
		System.out.println(ex.getCellValueAsString(1, 0));
		List<WebElement>pages=d.findElements(By.xpath("//div[@class='fleft pages']//a")); // 1 2 3 4 5 6 7 8 9 10....
		int total_pages=pages.size();
		
		//function add_data_in_list(List<webelement>data,list)
		for(int j=0;j<=3;j++)
		{
		
		List<WebElement>des=d.findElements(By.xpath("//div[@class='jobTupleHeader']//div[@class='info fleft']//a[@class='title fw500 ellipsis']"));
	    scrape_data_from_pages(des,designation);
	    List<WebElement>com=d.findElements(By.xpath("//div[@class='jobTupleHeader']//div[@class='info fleft']//div[@class='mt-7 companyInfo subheading lh16']//a[@class='subTitle ellipsis fleft']"));
	    scrape_data_from_pages(com,company);
	    List<WebElement>exp=d.findElements(By.xpath("//ul[@class='mt-7']//li[@class='fleft grey-text br2 placeHolderLi experience']//span"));
	    scrape_data_from_pages(exp,experience);
	    List<WebElement>loc=d.findElements(By.xpath("//ul[@class='mt-7']//li[@class='fleft grey-text br2 placeHolderLi location']"));
	    scrape_data_from_pages(loc,location);
	    List<WebElement>skl=d.findElements(By.xpath("//ul[@class='tags has-description']"));
	    scrape_data_from_pages(skl,skills);	    
	    d.findElement(By.xpath("//a[@class='fright fs14 btn-secondary br2']")).click();
	    Thread.sleep(2000);
	    
		}
	    	 
	    System.out.println("size of designation"+designation.size());
	    System.out.println("size of location"+location.size());
	    System.out.println("size of company"+company.size());
	    System.out.println("size of skills"+skills.size());
	    System.out.println("size of experience"+experience.size());
  	
		for(int i=0;i<=designation.size();i++)
		{
			ex.setCellValue(i+1, 0, designation.get(i));
			ex.setCellValue(i+1, 1, company.get(i));
			ex.setCellValue(i+1, 2, experience.get(i));
			ex.setCellValue(i+1, 3, location.get(i));
			ex.setCellValue(i+1, 4, skills.get(i));
			System.out.println(i+1 +"writing done");
			ex.save();	
			
		}
		
		
	}
	
    public static ArrayList<String> scrape_data_from_pages(List<WebElement>data,ArrayList<String>list)
    {
    	
    	for(int i=0;i<data.size();i++)
	    {
	    	list.add(data.get(i).getText());
	    }
		return list;
    	
    }

	
   @Test(enabled=false)
   public void test()
   {
	   System.out.println("Testing");
   }
	
	@AfterTest
	public void teardown()
	{
	 //d.quit();	
	}

}
