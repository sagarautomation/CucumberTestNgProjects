package StepDefinition;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import CommonFunctions.AlertHandling;
import CommonFunctions.JavacriptUtilities;
import CommonFunctions.Setup;

public class FB_Step_Definition extends Setup

{
	
	
	public String url="https://www.facebook.com/";

	@io.cucumber.java.en.Given("^user is already on FB Login Page$")
    public void user_is_already_on_FB_Login_Page() throws Throwable
	{
		launchurl(url);
		String actual=d.findElement(By.xpath("//img[@alt='Facebook']")).getAttribute("alt");
		System.out.println("Title"+actual);
		Assert.assertEquals("The title is not matched", "Facebook", actual);
		
	}
	
	@io.cucumber.java.en.Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_username_and_password(String username, String pwd) throws Throwable
	{
		d.findElement(By.cssSelector("input#email")).sendKeys(username);
		d.findElement(By.cssSelector("input#pass")).sendKeys(pwd);
	}

	@io.cucumber.java.en.Then("^user clicks on login button$")
	public void user_clicks_on_login_button() throws Throwable
	{
		
		try
		{
		WebElement button=d.findElement(By.cssSelector("button#u_0_f"));
		if(!button.isDisplayed())
		{
			System.out.println("Button not displayed");
			zMisc.waituntilvisible(button, 60);
			button.click();
		}
		else
		{
	
		}
		}
		catch(Exception e)
		{
			System.out.println("inside exception");
		  d.findElement(By.xpath("//button[@type='submit']")).click();	
		}
		
		
		
		        

	}
	
	@io.cucumber.java.en.Then("^user should be able to view the stories$")
	public void user_should_be_able_to_view_the_stories() throws Throwable 
	{
		List<WebElement> allstories = d.findElements(By.xpath("//div[@aria-label='Stories']//child::div[@class='i09qtzwb rq0escxv pmk7jnqg hzawbc8m k4urcfbm hzruof5a']"));
		for(WebElement eachstory:allstories)
		{
			try
			{
			eachstory.click();
			Thread.sleep(10000);
			d.findElement(By.xpath("//i[@class='hu5pjgll m6k467ps sp_fkuQ34WID0K sx_4d1f01']")).click();
			}
			catch(Exception e)
			{
				System.out.println(eachstory);
				CommonFunctions.JavacriptUtilities.clickelement(eachstory);

				
			}
			
			
		}
		
		
		
	}
	
	
	
	@io.cucumber.java.en.When("^user clicks on Naveen Automation labs$")
	public void user_clicks_on_Naveen_Automation_labs() throws Throwable
	{
		WebElement chnl=d.findElement(By.xpath("//*[text()='Naveen AutomationLabs']"));
		CommonFunctions.JavacriptUtilities.clickelement(chnl);
		
	}
	
	@io.cucumber.java.en.When("^user search \"([^\"]*)\" in search field$")
	public void user_search_in_search_field(String anything) throws Throwable
	{
		WebElement searchfield=d.findElement(By.xpath("//input[@name='q']"));
		searchfield.sendKeys(anything);
		//d.findElement(By.xpath("//button[@class='_42ft _4jy0 _4w98 _4jy3 _517h _51sy']")).click();
		searchfield.sendKeys(Keys.ENTER,Keys.ENTER);
//		Actions a=new Actions(d);
//		a.sendKeys(searchfield, "anything",Keys.ENTER,Keys.ENTER);
		System.out.println("entered");
		
	}
	
	
	@io.cucumber.java.en.Then("^user should be able to see filter options$")
	public void user_should_be_able_to_see_filter_options() throws Throwable 
	{
		System.out.println(d.findElement(By.xpath("//div[text()='Filter results']")).getLocation());
		
	}
	
	@io.cucumber.java.en.Then("^user selects \"([^\"]*)\" under post from and \"([^\"]*)\" under posted in groups$")
	public void user_selects_under_post_from(String arg1,String arg2) throws Throwable 
	{
		//span[@class='_6ed5' and text()='Your groups and Pages']//preceding-sibling::label
		d.findElement(By.xpath("//span[@class='_6ed5' and text()='"+arg1+"']//preceding-sibling::label")).click();
		WebElement but1=d.findElement(By.xpath("//span[@class='_6ed5' and text()='"+arg1+"']//preceding-sibling::label"));
		System.out.println(but1.isSelected());
		if(!but1.isSelected())
		{
			but1.click();

		}
		else
		{
			
		}
		Thread.sleep(2000);
		
		WebElement but2=d.findElement(By.xpath("//span[@class='_6ed5' and text()='"+arg2+"']//preceding-sibling::label"));

		if(!but2.isSelected())
		{
			but2.click();

		}
		else
		{
			
		}


		
		//span[@class='_6ed5' and text()='Your groups and Pages']//preceding-sibling::label
	}

	@io.cucumber.java.en.Then("^click choose a group link$")
	public void click_choose_a_group_link() throws Throwable
	{
		WebElement grp_link=d.findElement(By.xpath("//div[@class= '_1u6r' and text()='Choose a group...']"));;
		CommonFunctions.JavacriptUtilities.clickelement(grp_link);
		try
		{
		WebElement textbox=d.findElement(By.id("u_ps_fetchstream_5_0_5"));
		CommonFunctions.JavacriptUtilities.enter_text(textbox, "Naveen Automation labs");
		}
		catch(Exception e)
		{
			System.out.println("inside exception");
			JavacriptUtilities.js.executeScript("document.getElementById('u_ps_fetchstream_5_0_5').value='Naveen Automation Labs'");

		}
		
		
	}

	@io.cucumber.java.en.Then("^enter \"([^\"]*)\" in the field$")
	public void enter_in_the_field(String arg1) throws Throwable
	{
		//WebElement el=d.findElement(By.cssSelector("div#u_ps_fetchstream_6_0_5"));
		//System.out.println("status"+el.getAttribute("aria-hidden"));
		//d.findElement(By.xpath("div#u_ps_fetchstream_6_0_5")).sendKeys(arg1);
	}




	

	

}
