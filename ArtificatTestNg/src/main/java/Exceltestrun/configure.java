package Exceltestrun;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class configure 
{
	//this class will have method that will run only the test case set to yes in excel file..
	public static ArrayList<String> testcasename=new ArrayList<String>();
	public static ArrayList<String> runstatus=new ArrayList<String>();;
	public static ExcelUtils e=new ExcelUtils("D:\\Selenium_Automationframework\\ArtificatTestNg\\src\\main\\java\\Rundetail.xlsx");


	public static void getrundetails()
	{
		int rows=e.getRowCount();
		System.out.println(rows);
		for(int i=1;i<=rows-1;i++)
		{
			String tcname=e.getCellValueAsString(i, 0);
			String runflag=e.getCellValueAsString(i, 1);
			System.out.println(tcname);
			System.out.println(runflag);

			testcasename.add(tcname);
			runstatus.add(runflag);
			
			
			
		}
	}
	public static void print()
	{
	   testcasename.stream().forEach(el->System.out.println(el));	
	}
	
	public static void run()
	{
		
		
		int rows=e.getRowCount();

		for(int i=1;i<=rows-1;i++)
		{
			String tcname=e.getCellValueAsString(i, 0);
			String runflag=e.getCellValueAsString(i, 1);
			System.out.println(tcname);
			System.out.println(runflag);
			//run only the test case set to yes in excel file
			if(runflag.equalsIgnoreCase("Yes"))
			{
				//find in which package and class this method exists
				// then inovoke the testcase
				
			}
			else
			{
				
			}
			

			
			
			
		}
        
	}
	
	public static void main(String[]args)
	{
		configure c=new configure();
		c.run();
		
	}
	

}
