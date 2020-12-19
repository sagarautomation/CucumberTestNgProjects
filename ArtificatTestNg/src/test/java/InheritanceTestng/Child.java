package InheritanceTestng;

import org.testng.annotations.Test;

public class Child extends Parent 
{
  @Test
  public void test1() 
  {
	  System.out.println("This is test case1");
	  System.out.println("This is test case1");
	  System.out.println("Automation"+10+20);

  }
  @Test(priority=1)
  public void test2()
  {
	  System.out.println("This is test case2");
  
  }
}
