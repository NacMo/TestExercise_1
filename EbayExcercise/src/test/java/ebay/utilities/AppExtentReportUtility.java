package ebay.utilities;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class AppExtentReportUtility 
{
	public static ExtentReports er;
	public static ExtentTest et;
	public static void extentReportFail(String TCName)
	{
		er =new ExtentReports("./Reports/" + TCName + ".html",false);
		et =er.startTest(TCName);
		et.log(LogStatus.FAIL, TCName +" Failed");
		String image= et.addScreenCapture("./ScreenShots/"+ TCName + "_" + AppScreenshotonFailedTC.generateDate() +".png");
		et.log(LogStatus.FAIL, TCName,image);
		er.endTest(et);
		er.flush();
	}
	
	public static void extentReportPass(String TCName)
	{
		er =new ExtentReports("./Reports/" + TCName + ".html",false);
		et =er.startTest(TCName);
		et.log(LogStatus.PASS, TCName +" Passed");
		er.endTest(et);
		er.flush();
	}

}
