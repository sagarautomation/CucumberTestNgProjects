package ITestListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener
{
	public static String Testcasename;
	public static String gettestcasename()
	{
		return Testcasename;
		
	}
	public static  void settestcasename(String tcname)
	{
	  tcname=Testcasename;	
	}

	@Override
	public void onTestStart(ITestResult result)
	{
		Testcasename=result.getMethod().getMethodName();
		System.out.println(Testcasename);
		
	}

	@Override
	public void onTestSuccess(ITestResult result)
	{
	 System.out.println(result.getMethod().getMethodName()+"is passed");	
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		 System.out.println(result.getMethod().getMethodName()+"is failed");	

		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
	{
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
