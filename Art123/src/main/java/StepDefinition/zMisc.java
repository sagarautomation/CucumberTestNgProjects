package StepDefinition;

import org.openqa.selenium.WebElement;

public class zMisc 
{
	public static void  waituntilvisible(WebElement el,int waittime) throws InterruptedException
	{
		for(int i=0;i<=waittime;i++)
		{
			if(el.isDisplayed())
			{
				break;
			}
			
		}
	}
	
	
	public static void  waituntilenable(WebElement el,int waittime) throws InterruptedException
	{
		for(int i=0;i<=waittime;i++)
		{
			if(el.isEnabled())
			{
				break;
			}
			
		}
	}

	public static void main(String[] args) 
	{
		long end = System.currentTimeMillis();
		


	}
	
	

}
