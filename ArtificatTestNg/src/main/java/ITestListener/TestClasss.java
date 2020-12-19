package ITestListener;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestClasss 
{
	@BeforeMethod
	public void setupmethod()
	{
		 System.out.println("setup");	
	
	}
	@Test
	public void test1method()
	{
		Assert.fail("Failing purposefully");
	}
	@Test
	public void test2method()
	{
		 System.out.println("testcase2");	
	
	}
	@Test
	public void test3method()
	{
		 System.out.println("testcase3");	

	}
	@AfterMethod
	public void teardownmethod()
	{
		 System.out.println("Tear down");	
	
	}



}
