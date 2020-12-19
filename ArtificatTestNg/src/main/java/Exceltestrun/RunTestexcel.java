package Exceltestrun;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RunTestexcel
{
	
	
	@BeforeTest
	public void setup()
	{
		System.out.println("This is setup");
	
		
	}
	
	@Test()
	public void test1()
	{
		System.out.println("This is test1");

		
	}
	@Test
	public void test2()
	{
		System.out.println("This is test2");
	
	}
	
	@Test
	public void test3()
	{
		System.out.println("This is test3");
	
	}
	
	
	
	
	
	@AfterTest
	public void teardown()
	{
		System.out.println("This is tear down");

		
	}
	

}
