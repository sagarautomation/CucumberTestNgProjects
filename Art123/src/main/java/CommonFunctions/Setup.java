package CommonFunctions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Setup 
{
	public static WebDriver d;

	
	public void launchurl(String url)
	{
		System.setProperty("webdriver.chrome.driver","D:\\Seleniumjars\\chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		d = new ChromeDriver(options);
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    d.get(url);
		d.manage().window().maximize();
		//System.out.println(System.getProperty("os.name"));
		
		
	}


}
