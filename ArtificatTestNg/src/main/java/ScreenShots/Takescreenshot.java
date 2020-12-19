package ScreenShots;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Takescreenshot
{
	WebDriver d;
	@BeforeTest
	public void setup() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","D:\\Seleniumjars\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		d = new ChromeDriver(options);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    d.get("https:\\google.com");
		
		
		
	}
	@Test(enabled=true)
	public void test1() throws IOException
	{
		d.manage().window().maximize();
		CaptureSnap.shoot(d);
		
		
	}
	@Test
	public void test2() throws IOException
	{
//		boolean flag;
//	      String directory = "c:\\a";
//	      File file = new File(directory);
//	      flag = file.mkdir();
//	      System.out.println("The directory is created? " + flag);
		CaptureSnap.shoot(d);
//		
	}
	@AfterTest
	public void teardown()
	{
		d.quit();
		
	}

}
