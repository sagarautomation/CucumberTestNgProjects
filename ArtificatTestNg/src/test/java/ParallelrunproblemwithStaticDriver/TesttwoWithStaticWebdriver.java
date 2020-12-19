package ParallelrunproblemwithStaticDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TesttwoWithStaticWebdriver
{
	
	@Test
	  public void filpkarttest() throws InterruptedException 
	  {
		  WebDriverFactoryStatic.setdriver().get("https://www.flipkart.com");;
		  Thread.sleep(15000);
		  System.out.println("Title printed by thread"+Thread.currentThread().getId()+WebDriverFactoryStatic.setdriver().getTitle());
		  WebDriverFactoryStatic.setdriver().manage().deleteAllCookies();
		  

		  
		  
	  }
	  
	  @Test
	  public void myntratest() throws InterruptedException 
	  {
		  WebDriverFactoryStatic.setdriver().get("https://www.myntra.com");;
		  Thread.sleep(15000);
		  System.out.println("Title printed by thread"+Thread.currentThread().getId()+WebDriverFactoryStatic.setdriver().getTitle());
		  WebDriverFactoryStatic.setdriver().manage().deleteAllCookies();


		  
		  
	  }
	  @BeforeClass
	  public void setup()
	  {
		  System.out.println("Browser setup by current thread"+ Thread.currentThread().getId());
		  WebDriverFactoryStatic.setdriver();
		  
	  }

	  @AfterClass
	  public void teardown()
	  {
		  System.out.println("Browser close by current thread"+ Thread.currentThread().getId());
		  WebDriverFactoryStatic.setdriver().close();
	  
		  
	  }

  

}
