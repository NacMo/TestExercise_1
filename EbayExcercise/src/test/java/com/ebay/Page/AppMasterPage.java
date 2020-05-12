package com.ebay.Page;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class AppMasterPage 
{
	public static AndroidDriver driver;
	public Properties prop;
	
	public AppMasterPage() throws IOException
	{
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir") +"/src/test/java/capabilities/AppRepository.properties");
		prop=new Properties();
		prop.load(fis);
		DesiredCapabilities dc=new DesiredCapabilities();
		dc.setCapability(CapabilityType.BROWSER_NAME, "");
		dc.setCapability("deviceName", prop.getProperty("device_Name"));
		dc.setCapability("platformName",prop.getProperty("platform_Name"));
		dc.setCapability("platformVersion", prop.getProperty("platforn_Version"));
		dc.setCapability("appPackage", prop.getProperty("app_Package"));
		dc.setCapability("appActivity", prop.getProperty("app_Activity"));
		
		Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723\"");
		
		URL u=new URL("http://0.0.0.0:4723/wd/hub");
		
		while(true)
		{
			try
			{
				driver=new AndroidDriver(u,dc);
				break;
			}
			catch(Exception ex) 
			{
				
			}
		}
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	
	public void sendData(String xpathKey, String userData)
	{
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).clear();
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(userData);
	}
	
	public void sendSearchData(String xpathKey, String userData, Keys key)
	{
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).clear();
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).sendKeys(userData, key);
	}
	
	public void click(String xpathKey)
	{ 
		driver.findElement(By.xpath(prop.getProperty(xpathKey))).click();
	}
	
	public void waitForElement(String xpathKey)
	{
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(prop.getProperty(xpathKey))));
	}
	
	public boolean isLinkPresent(String xpathKey)
	{
		try
		{
			driver.findElement(By.xpath(prop.getProperty(xpathKey)));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

}
