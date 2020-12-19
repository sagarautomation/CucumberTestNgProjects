package Grp123.ArtificatTestNg;

import java.util.Arrays;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class ThreadinTestNg {
  @Test
  public void m1() 
  {
	  System.out.println(Thread.currentThread().getId()+"This is method 1");
  }
  
  @Test
  public void m2() 
  {
	  System.out.println(Thread.currentThread().getId()+"This is method 2");

  }
  @BeforeMethod
  public void beforeMethod() 
  {
	  System.out.println(Thread.currentThread().getId()+"This is before  method ");

	  
  }

  @AfterMethod
  public void afterMethod() 
  {
	  System.out.println(Thread.currentThread().getId()+"This is after  method ");

  }

}
