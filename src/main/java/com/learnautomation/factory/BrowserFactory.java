package com.learnautomation.factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import com.learnautomation.dataProvider.ConfigReader;

public class BrowserFactory
{
	
	public static WebDriver driver;
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public static WebDriver getBrowser(String browserName,String url)
	{
		
	
		
		if(browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("Google Chrome"))
		{
			
			ChromeOptions options=new ChromeOptions();
			
			
			if (ConfigReader.getProperty("headless").equalsIgnoreCase("true")) 
			{
				options.addArguments("--headless=new");
				
				Reporter.log("LOG:INFO - Running Test In Headless Mode",true);

			}
			driver=new ChromeDriver();
		}
		
		else if(browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("Mozilla Firefox"))
		{
			driver=new FirefoxDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("Edge") || browserName.equalsIgnoreCase("Microsoft Edge"))
		{
			driver=new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("Safari")) {
			driver=new SafariDriver();
		}
		else {
			Reporter.log("LOG:INFO - Sorry currently we do support Chrome, Firefox, Edge and Safari Browser");
		}
		
		
		
		driver.manage().window().maximize();
		
		
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoadTimeOut"))));
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("scriptTimeout"))));

		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
		
		return driver;
		
		}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
		
		
	}

}
