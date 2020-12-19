package ParallelrunproblemwithStaticDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactoryStatic 
{
	public static WebDriver d;
	public static WebDriver setdriver()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Seleniumjars\\chromedriver.exe");
		d = new ChromeDriver();
		return d;
	}

}
