package ParallelrunproblemwithStaticDriver;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestoneWithStaticWebdriver {
  @Test
  public void googletest() throws InterruptedException 
  {
	  WebDriverFactoryStatic.setdriver().get("https://www.google.com");;
	  Thread.sleep(15000);
	  System.out.println("Title printed by thread"+Thread.currentThread().getId()+WebDriverFactoryStatic.setdriver().getTitle());
	  WebDriverFactoryStatic.setdriver().manage().deleteAllCookies();
	  

	  
	  
  }
  
  @Test
  public void fbtest() throws InterruptedException 
  {
	  WebDriverFactoryStatic.setdriver().get("https://www.facebook.com");;
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
