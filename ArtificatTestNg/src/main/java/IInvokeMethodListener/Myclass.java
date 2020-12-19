package IInvokeMethodListener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

public class Myclass implements IInvokedMethodListener
{

	@Override
	public void beforeInvocation(IInvokedMethod method, ITestResult testResult)
	{
		System.out.println("Before invocation");
		System.out.println(method.getTestMethod().getMethod());
		
	}

	@Override
	public void afterInvocation(IInvokedMethod method, ITestResult testResult)
	{
		System.out.println("After invocation");
		System.out.println(method.getTestMethod().getMethod());

	
	}

}
