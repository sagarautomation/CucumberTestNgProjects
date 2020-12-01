package StepDefinition;


import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import CommonFunctions.Setup;
import cucumber.api.DataTable;

public class FBmapStepDefinition extends Setup
{
	public String url="https://www.facebook.com/";

	@cucumber.api.java.en.Given("^user is already on FB  Page$")
    public void user_is_already_on_FB_Page() throws Throwable
	{
		launchurl(url);
		String actual=d.findElement(By.xpath("//img[@alt='Facebook']")).getAttribute("alt");
		System.out.println("Title"+actual);
		Assert.assertEquals("The title is not matched", "Facebook", actual);
		
	}
	
	@cucumber.api.java.en.Then("^Then user enters login credentials$")
	public void user_enters_login_credentials(DataTable usercredentials) throws Throwable 
	{

		//Write the code to handle Data Table
		List<Map<String,String>> data = usercredentials.asMaps(String.class,String.class);
		d.findElement(By.cssSelector("input#email")).sendKeys(data.get(0).get("Username")); 
	    d.findElement(By.cssSelector("input#pass")).sendKeys(data.get(0).get("Password"));
     }
	
	@cucumber.api.java.en.And("^user clicks on login $")

	public void user_clicks_on_login() throws Throwable 
	{

		//Write the code to handle Data Table
		d.findElement(By.xpath("//button[@type='submit']")).click();	
     }
	
}
