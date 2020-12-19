package Mapconcept;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

import Utilities.ExcelUtils;


public class ReadExcelDataIntoListOfMap 
{
	
	public static List<LinkedHashMap<String,String>> getexceldataasmap(String filepath) throws IOException
	{
		ExcelUtils ex=new ExcelUtils(filepath);
		//create a list of map..map represent data set of excel
		List<LinkedHashMap<String,String>>datalist=new ArrayList();
		int DataSetCount=ex.getRow(0).getPhysicalNumberOfCells();

		for(int i=1;i<DataSetCount;i++)
		{
			int rowcount=ex.getRowCount();
			LinkedHashMap<String,String>data= new LinkedHashMap<String,String>();
			for(int j=1;j<rowcount;j++)
			{
				XSSFRow r=ex.getRow(j);
				String fieldname=r.getCell(0).getStringCellValue();

				XSSFCell c=r.getCell(i);
				switch(c.getCellType())
				{
				case STRING:
					data.put(fieldname, c.getStringCellValue());
					break;
				case NUMERIC:
					String fieldval=Double.toString(c.getNumericCellValue());
					data.put(fieldname,fieldval);
					break;
				default:
					System.out.println("");
				
				}
				//String fieldname=r.getCell(0).getStringCellValue();
				//String fieldval=r.getCell(i).getStringCellValue();

				//data.put(fieldname, fieldval);	
			}
			datalist.add(data);
		}
		
		return datalist;
	}
	public static LinkedHashMap<String,List<String>> getexceldataasmap1(String filepath) throws IOException
	{
		
		ExcelUtils ex=new ExcelUtils(filepath);
		int rowcount=ex.getRowCount();
		int colCount=ex.getRow(0).getPhysicalNumberOfCells();

		LinkedHashMap<String,List<String>> mappeddata=new LinkedHashMap<String,List<String>>();
		for(int i=1;i<rowcount;i++)
		{
			XSSFRow r=ex.getRow(i);
			String fieldname=r.getCell(0).getStringCellValue();
			List<String> data=new ArrayList();
			for(int j=1;j<colCount;j++)
			{
				XSSFCell c=r.getCell(j);
				switch(c.getCellType())
				{
				case STRING:
					data.add(c.getStringCellValue());
					break;
				case NUMERIC:
					String val=Double.toString(c.getNumericCellValue());
					data.add(val);
					break;
				default:
					System.out.println("");
				
				}
			
			}
			mappeddata.put(fieldname, data);
			
			
			
		}

		
		
		return mappeddata;
		
	}

	
	
	
    public static void main( String[] args ) throws IOException
    {
    	String currentDirectory = System.getProperty("user.dir");
		String filepath=currentDirectory+"\\"+"Resource"+"\\"+"DataSheet.xlsx";
		System.out.println(filepath);
//		List<LinkedHashMap<String,String>> mapDataList=  getexceldataasmap(filepath);
//		System.out.println(mapDataList.get(0));
//		System.out.println(mapDataList.size());
		
		LinkedHashMap<String,List<String>>mapDataList1= getexceldataasmap1(filepath);
		System.out.println(mapDataList1.size());
		Set<String>keys=mapDataList1.keySet();
		for(String k:keys)
		{
			System.out.println("The value for"+k+"is------>"+mapDataList1.get(k).toString());
			
		}
		
		


    }
}
