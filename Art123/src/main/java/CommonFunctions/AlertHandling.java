package CommonFunctions;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandling extends Setup 
{
	 public static Alert al=null;

	public static boolean check_if_alert_present()
	{
		WebDriverWait wait=new WebDriverWait(d, Duration.ofSeconds(30));
		if(wait.until(ExpectedConditions.alertIsPresent())==null)
		{
			System.out.println("Alert not present");
			return false;
			
		}
		else
		{
			return true;
			
		}
		
	}
	 
	 
	 
	 
	 public static  void switchtoalert()
	{
		
		System.out.println(d.getPageSource());
		d.switchTo().alert();
	}
	public static  String alertmessage()
	{
	  String message=al.getText();
	  return message;
	}
	public static void accept()
	{
		al.accept();
	}
	
	public static void dismiss()
	{
		al.dismiss();
	}


}
