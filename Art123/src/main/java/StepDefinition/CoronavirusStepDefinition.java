package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import CommonFunctions.Setup;
import CommonFunctions.WebTableUtilities;

public class CoronavirusStepDefinition extends Setup
{
	//public static WebDriver d;
	public String url="https://www.worldometers.info/coronavirus/";
	Given("^user is already on worldometer page$")
	public void user_is_already_on_worldometer_page() throws Throwable
	{
		launchurl(url);

		String actual=d.findElement(By.cssSelector("img[title='Worldometer']")).getAttribute("title");
		System.out.println("Title"+actual);
		Assert.assertEquals("The title is matched", "Worldometer", actual);
		
		
  
	}
	
	
	@io.cucumber.java.en.Then("^user scroll down until table$")
	public void user_scroll_down_until_table() throws Throwable 
	{
		//CommonFunctions.JavacriptUtilities.scroll_to_specific_location("5000");
		WebElement todaytable=d.findElement(By.cssSelector("table[id*='main_table_countries_today']"));
		System.out.println(todaytable.isDisplayed());
		if(!todaytable.isDisplayed())
		{
			zMisc.waituntilvisible(todaytable, 100);
			CommonFunctions.JavacriptUtilities.scroll_down_until_element(todaytable);

			
		}
		else
		{
		CommonFunctions.JavacriptUtilities.scroll_down_until_element(todaytable);
		System.out.println(todaytable.getLocation());
		System.out.println(todaytable.getRect());
		}
		

	}
	
	
	
	Then("^extract data of any three countries based on user input$")
	public void extract_data_of_any_three_countries_based_on_user_input()
	{
	  WebElement todaytable=d.findElement(By.cssSelector("table[id*='main_table_countries_today']"));
	  WebTableUtilities.extractdata("USA","Russia","China");

		
	}
	
	Then("^extract data of any three countries based on user input alternate way$")
	public void extract_data_of_any_three_countries_based_on_user_input_alternate_way()
	{
		  WebTableUtilities.extractdata_alternate_way("India","Pakistan","China");

		
	}

	

}
