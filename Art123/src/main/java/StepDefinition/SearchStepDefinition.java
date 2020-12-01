package StepDefinition;

import java.util.List;

import org.junit.Assert;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchStepDefinition
{
	WebDriver d;
	
	@Given("^user is already on search page$")
	public void user_is_already_on_search_page() throws Throwable
	{
	     System.setProperty("webdriver.chrome.driver","D:\\Seleniumjars\\chromedriver.exe");
		 d = new ChromeDriver();
		 d.get("https://www.google.com");
		 d.manage().window().maximize();
		 WebElement img=d.findElement(By.xpath("//img"));
		 System.out.println(d.findElement(By.xpath("//img")).getAttribute("alt"));
		 Assert.assertEquals("Google",img.getAttribute("alt"));
	}

	@Then("^user cucumber interview question in search field$")
	public void user_cucumber_interview_question_in_search_field() throws Throwable
	{
		d.findElement(By.xpath("//input[@title='Search']")).sendKeys("Cucumber Interview Questions");;
		WebElement autosuggestion=d.findElement(By.className("aajZCb"));
		zMisc.waituntilvisible(autosuggestion, 100);
		List<WebElement> links=d.findElements(By.xpath("//div[contains(@class,'sbtc')]"));
		System.out.println("Total sizw"+links.size());
		System.out.println("First Text"+links.get(0).getText());
		for(int i=0;i<links.size();i++)
			
		{
			
			if(links.get(i).getText().equalsIgnoreCase("Cucumber Interview Questions capgemini"))
			{
				links.get(i).click();
				break;
			}
			else
			{
				
			}
	     	//d.findElement(By.className("gNO89b")).click();

			
		}
	}

	

	@Then("^select the first link$")
	public void select_the_first_link() throws Throwable
	{
		
		List<WebElement> links=d.findElements(By.xpath("//div//h3"));
		System.out.println("Total links"+links.size());
		//click on first link
		links.get(0).click();
		System.out.println("Pass");	
	}



}
