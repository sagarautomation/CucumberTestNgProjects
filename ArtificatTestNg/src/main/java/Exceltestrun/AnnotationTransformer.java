package Exceltestrun;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class AnnotationTransformer implements IAnnotationTransformer
{
	
	private final List<String> activatedTest=new ArrayList<String>();

	public ExcelUtils e;
	public AnnotationTransformer()
	{
	 e=new ExcelUtils("D:\\Selenium_Automationframework\\ArtificatTestNg\\src\\main\\java\\Rundetail.xlsx");
	 int rows=e.getRowCount();
	 for(int i=1;i<=rows-1;i++)
		{
			String tcname=e.getCellValueAsString(i, 0);
			String runflag=e.getCellValueAsString(i, 1);
			if(runflag.equalsIgnoreCase("Yes"))
			{
				activatedTest.add(tcname);
				System.out.println(tcname);
			}
			else
			{
				
			}
			
		}	
		
	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass,
			Constructor testConstructor, Method testMethod) 
	{
		
		if(activatedTest.contains(testMethod.getName()))
		{
			annotation.setEnabled(true);
			//annotation.setInvocationCount(2);
			
		}
		else
		{
			annotation.setEnabled(false);
	
		}

		
	}	
		
		
	

	
}
