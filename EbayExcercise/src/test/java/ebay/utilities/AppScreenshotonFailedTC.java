package ebay.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AppScreenshotonFailedTC 
{
	public static String generateDate()
	{
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("YYYY_MM_dd_HH_mm_ss");
			return sdf.format(date);
	}
	public static void capture(WebDriver driver, String TCName) throws IOException
	{
		
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/"+ TCName + "_" + generateDate() +".png"));
	}

}
