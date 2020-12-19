package IretryAnalyzer;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retrysetup implements IRetryAnalyzer
{
	private int count=0;
	private static final int retrycount=3;

	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<retrycount)
		{
			++count;
			System.out.println("Retrying Test method : "+result.getName() + " for " + count +" times. ");
			System.out.println(result.getTestClass());
			return true;
		}
		return false;		

	}

}
