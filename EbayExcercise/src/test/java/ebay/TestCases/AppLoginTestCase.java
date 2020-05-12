package ebay.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ebay.Page.AppMasterPage;

import ebay.Pages.AppLoginPage;
import ebay.utilities.AppExtentReportUtility;
import ebay.utilities.AppScreenshotonFailedTC;
import ebay.utilities.EbayExcelUtilities;



public class AppLoginTestCase 
{
	
	
	@Test(dataProvider="provideData")
	public void loginTest(String userName, String password) throws IOException
	{
		AppLoginPage lp=new AppLoginPage();
		Assert.assertTrue(lp.doLogin(userName, password)," *** login failed *** ");

	}
	
	@DataProvider
	public Object[][] provideData() throws IOException
	{
		return (EbayExcelUtilities.readData("LoginTC"));
	}
	
	@AfterMethod
	public void postExecution(ITestResult result) throws IOException
	{
		if(result.getStatus()==2)
		{
			AppScreenshotonFailedTC.capture(AppMasterPage.driver, result.getName());
			AppExtentReportUtility.extentReportFail(result.getName());
			
		}
		if(result.getStatus()==1)
		{
			AppExtentReportUtility.extentReportPass(result.getName());
		}
		AppMasterPage.driver.closeApp();
	}
	
	@AfterTest
	public void stopAppiumServer() throws IOException
	{
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
		Runtime.getRuntime().exec("taskkill /F /IM cmd.exe");
	}
}
