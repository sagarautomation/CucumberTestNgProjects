package CommonFunctions;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import StepDefinition.CoronavirusStepDefinition;

public class JavacriptUtilities extends Setup
{
	
    public static JavascriptExecutor js = (JavascriptExecutor) d;

	public static void scroll_down_until_element(WebElement el)
	{
        js.executeScript("arguments[0].scrollIntoView(true)",el);
	
	}
	
	
	 public static void scroll_down_to_bottom_of_page()
	 {
         js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

		 
	 }
	 
	 
	 public static void scroll_to_specific_location(String pixel)
	 {
		 
		 System.out.println("window.scrollTo(0,"+pixel+")");
          js.executeScript("window.scrollTo(0,"+pixel+")");
          

	 }
	 public static void clickelement(WebElement el)
	 {
		 js.executeScript("arguments[0].click();",el);

		 
	 }
	 
	 public static void enter_text(WebElement el,String text)
	 {
		js.executeScript("arguments[0].setAttribute('value', arguments[1])", el, text);

		 
	 }

}
