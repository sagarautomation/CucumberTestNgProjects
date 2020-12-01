package StepDefinition;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import java.util.stream.IntStream; 


public class Test
{

	public static List<DateTime> getDateRange(DateTime start, DateTime end) 
	{

        List<DateTime> ret = new ArrayList<DateTime>();
        DateTime tmp = start;//17/08/2020
        while(tmp.isAfter(end) || tmp.equals(end)) {
            ret.add(tmp);
            tmp = tmp.minus(1);
        }
        return ret;
    }
	
	public static List<LocalDate> getDatesBetweenUsingJava8(
			  LocalDate startDate, LocalDate endDate) { 
			 
			    long numOfDaysBetween = ChronoUnit.DAYS.between(startDate, endDate);
			    System.out.println(numOfDaysBetween);
			    return IntStream.iterate(0, i -> i + 1)
			      .limit(numOfDaysBetween)
			      .mapToObj(i -> startDate.plusDays(i))
			      .collect(Collectors.toList()); 
			}
	
	

    public static void main(String[] args) {


//        DateTime start = DateTime.parse("18-08-2020");
//        System.out.println("Start: " + start);
//
//        DateTime end = DateTime.parse("2019-08-15");
//        System.out.println("End: " + end);
//
//        List<DateTime> between = getDateRange(start, end);
//        System.out.println(between.size());
//        for (DateTime d : between) {
//            System.out.println(" " + d);
    	
//        }
    	
    	
    	
    	LocalDate startdate=LocalDate.parse("2019-01-01");
    	LocalDate enddate=LocalDate.parse("2019-12-31");


    	
    	List<LocalDate> dates=getDatesBetweenUsingJava8(startdate,enddate);
    	for (LocalDate d : dates) 
    	{
          System.out.println(" " + d);
  	
     }
    	
    }

}
