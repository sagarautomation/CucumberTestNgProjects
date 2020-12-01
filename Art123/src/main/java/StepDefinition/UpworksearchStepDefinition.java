package StepDefinition;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class UpworksearchStepDefinition
{
	WebDriver d;
	
	@Given("^user is already on Upwork site$")
	public void user_is_already_on_Upwork_site() throws Throwable
	{
		System.setProperty("webdriver.chrome.driver","D:\\Seleniumjars\\chromedriver.exe");
		 d = new ChromeDriver();
		d.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		 d.get("https://www.upwork.com");
		 d.manage().window().maximize();
		 System.out.println(d.getTitle());

	}

	@Then("^search selenium  automation jobs$")
	public void search_selenium_automation_jobs() throws Throwable
	{
//		WebElement el=d.findElement(By.xpath("//div[@class= 'navbar-header']//button//span[@class= 'caret glyphicon air-icon-arrow-expand']")) ;
//		
//		System.out.println(el.isDisplayed());
//		if(!el.isDisplayed())
//		{
//		 zMisc.waituntilvisible(el, 100);
//		 el.click();
//
//		}
//		else
//		{
//			
//		}
		
		
//		By el=By.xpath("//div[@class= 'navbar-header']//button//span[@class='caret glyphicon air-icon-arrow-expand']");
//		WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(el)).click();;
//		Select osel= new Select(d.findElement(By.xpath("//ul[contains(@class,'dropdown-menu open')]")));
//		osel.selectByValue("Jobs");
		
		WebElement search=d.findElement(By.xpath("//span[contains(@class,'glyphicon glyphicon-md air-icon-search m-0 text-muted')]"));
		WebElement el=d.findElement(RelativeLocator.withTagName("button").toRightOf(search));
		el.click();
		System.out.println("click done");
		
	
		
		
	}



}
