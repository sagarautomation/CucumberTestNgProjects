package InheritanceTestng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Parent
{
  
  @BeforeClass
  public void m2()
  {
	  System.out.println("This is before class");
  }

  @AfterClass
  public void m3()
  {
	  System.out.println("This is after class");

  }

  @BeforeTest
  public void m1()
  {
	  System.out.println("This is before test");

  }

  @AfterTest
  public void m4() 
  {
	  System.out.println("This is after test");

  }

}
