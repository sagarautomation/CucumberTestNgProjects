package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStepDefinition
{
	
	WebDriver driver,d;

	
	
	@Given("^user is already on Login Page$")
	public void user_is_already_on_Login_Page() 
	{
		System.setProperty("webdriver.chrome.driver","D:\\Seleniumjars\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.get("https://www.gmail.com");
		 driver.manage().window().maximize();
		 System.out.println("");
		 
		 String title=driver.getTitle();
		 System.out.println(title);
		 Assert.assertEquals("Gmail", title);
		 System.out.println("Assertion passed");
		 
		 
	    
	}	
	

	
	@Then("^user enters username and password$")
	public void user_enters_username_and_password()
	{
		WebElement username=driver.findElement(By.id("identifierId"));
		username.sendKeys("sagaremail28");
		WebElement nextbutton= driver.findElement(By.className("VfPpkd-RLmnJb"));
		nextbutton.click();
		driver.close();
	}
	


	@Given("^user is already on Youtube channel$")
	public void user_is_already_on_Youtube_channel() throws Throwable
	{
		
		
		System.setProperty("webdriver.chrome.driver","D:\\Seleniumjars\\chromedriver.exe");
		ChromeOptions option=new ChromeOptions();
		option.setExperimentalOption("debuggerAddress","localhost:9014");
		d=new ChromeDriver(option);
		d.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
	}
	
	@Then("^user enter channelname in search field$")
	public void user_enter_channelname_in_search_field() throws Throwable
	{
		
		WebElement search=d.findElement(By.xpath("//input[@id='search']"));
		System.out.println(search.isDisplayed());
		search.sendKeys("How to become genius in CSS Selector in Selenium naveen automation labs");
	    //WebElement button= d.findElement(By.id("search-icon-legacy"));
	    d.findElement(By.cssSelector("button#search-icon-legacy>yt-icon")).click();
		Thread.sleep(2000);
	    //button.click();
	}
	@Then("^play first video$")
    public void play_first_video() throws Throwable
	{
		
		WebElement title=d.findElement(By.xpath("//span[@id='title']"));
		System.out.println("title is"+title.isDisplayed());
	    WebElement firstlink=d.findElement(RelativeLocator.withTagName("ytd-video-renderer").below(title));
	     firstlink.click();

	}
	
	@Then("^Scroll down to bottom$")
	public void scroll_down_to_bottom() throws InterruptedException
	{
		Thread.sleep(2000);
		//---->scroll to specific location(x,y coordinates)....
        JavascriptExecutor js = (JavascriptExecutor) d;
//        js.executeScript("window.scrollTo(0,3000)");
//        System.out.println("scroll pass");
        
        
		//----->scroll upto an element using scrollIntoView()....
        try
        {
        WebElement user=d.findElement(By.xpath("//a[@href='/channel/UC_YKW4u1t1cepb8WoNkT3GA']//span[1]"));
        js.executeScript("arguments[0].scrollIntoView(true)",user);
        System.out.println("scrolling to element pass");


        }
        catch(Exception e)
        {
            System.out.println("scrolling to element fail");
	
        }
        
		//----->scroll until the bottom of the page....................
        try
        {
         js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
         System.out.println("scrolling to bottom of page pass");

        }
        catch(Exception e)
        {
            System.out.println("scrolling to bottom of page fail");

        }
        
		//----->scroll dynamically loading pages....................
        
        //long initialheight=(long)(js.executeScript("return document.body.scrollHeight"));

        
        //public static Long convertToLong(Object o){
         


        
        

        
		
	}

	
}
		

