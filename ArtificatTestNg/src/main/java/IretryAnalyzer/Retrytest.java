package IretryAnalyzer;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Retrytest 
{
	private static int counter=0;
	@Test(retryAnalyzer= Retrysetup.class)
	public void method1()
	{
		//System.out.println("Failing method purposefully.");
		//Assert.fail("Purposefully failing");
		counter++;
		if(counter< 3)
		{
			System.out.println("Failing method purposefully.");
			Assert.fail("Purposefully failing");
		}
			
		System.out.println("Test passed");
	}

}
