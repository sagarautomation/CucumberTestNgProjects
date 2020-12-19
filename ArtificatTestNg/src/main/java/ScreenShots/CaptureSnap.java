package ScreenShots;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class CaptureSnap
{
	public static int screenshotiterator=0;
	public static void shoot(WebDriver d) throws IOException
	{
		

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date=now.format(formatter);
		System.out.println(date);
		String tcname="test"+screenshotiterator;
		System.out.println("Testcase name is"+tcname);
	    String subdir = tcname;
	    File file = new File("D:\\Result"+"\\"+subdir);
	    file.mkdir();
		Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(d);
		ImageIO.write(screenshot.getImage(), "jpg", new File(file.getAbsoluteFile()+"\\"+tcname+date+".jpg"));
		screenshotiterator+=1;



		
	}

}
