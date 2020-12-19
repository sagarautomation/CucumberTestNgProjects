package Datetime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Date
{
	public static void currentdatetime()
	{
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));
		System.out.println(dtf.format(now).toString());
		System.out.println(now.toString().replace('T', ' '));
		  
		
	}
	public static void main(String[]args)
	{
		Date d=new Date();
		d.currentdatetime();
		
	}

}

