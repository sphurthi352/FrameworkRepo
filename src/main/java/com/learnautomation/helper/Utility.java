package com.learnautomation.helper;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.learnautomation.dataProvider.ConfigReader;

public class Utility
{
	
	
	public static Alert alert(WebDriver driver)
	{
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		
		return alert;
		
	}
	
	public static String selectWindow(WebDriver driver)
	{
		String parentWindow=driver.getWindowHandle();
		
		Set<String> setOfWindows=driver.getWindowHandles();
		
		List<String> listofWindows=new ArrayList<String>(setOfWindows);
		
		for(String currentWindow:listofWindows)
		{
			if(!currentWindow.equals(parentWindow))
			{
				driver.switchTo().window(currentWindow);
			}
		}
		
		String url=driver.getCurrentUrl();
		
		return url;
		
	}
	public static void selectValueFromDropDown(WebDriver driver,By locator,String value)
	{
		Select sel=new Select(Utility.waitForWebElement(driver, locator));
		
		sel.selectByVisibleText(value);
		
		
	}
	
	public static String selectValueFromlist(WebDriver driver,By locator,String valueToSearch )
	{
		String value=null;
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		List<WebElement> WebElementList=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
		for(WebElement ele:WebElementList)
		{
		
			 value=ele.getText();
			
			if(value.contains(valueToSearch) || value.equalsIgnoreCase(valueToSearch))
			{
				ele.click();
				Reporter.log("LOG INFO : Clicked on "+valueToSearch);
			
				
				 String highLightString=ConfigReader.getProperty("highLightElement");
					
					if(highLightString.equalsIgnoreCase("true"))
					{
						highLightWebElement(driver,ele);
					}
					
			break;
			
			}
		}
		
		return value;
	}
	
	
	
	public static int selectValueFromList(WebDriver driver,By locator)
	{
		int sum=0;
		List<WebElement> l1=Utility.waitForWebElements(driver, locator);
		
		for(WebElement ele:l1)
		{
			String value=ele.getText();
			
			sum=sum+Integer.parseInt(value);
		}
		
		return sum;
		
	
	}
	
	
	public static void listClick(WebDriver driver,By locator)
	{
		List<WebElement> l1=Utility.waitForWebElements(driver, locator);
		
		for(WebElement ele:l1)
		{
			ele.click();
		}
				
				
	}
	
	public static boolean waitTextMatch(WebDriver driver,By locator,String name)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		boolean status =wait.until(ExpectedConditions.textToBePresentInElementLocated(locator,name));
		return status;
	}
	
	public static void selectValueFromsuggestion(WebDriver driver,By locator,int number)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)).get(number).click();
	}
	
	public static int sizeOfListVisibility(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		int count=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator)).size();
		
		return count;

		
	}
	
	
	public static int sizeOfListMorethan(WebDriver driver,By locator,int num)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(70));
		int count=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator,num)).size();
		
		return count;

		
	}
	
	
	public static int sizeOfListtobe(WebDriver driver,By locator,int num)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(70));
		int count=wait.until(ExpectedConditions.numberOfElementsToBe(locator,num)).size();
		
		return count;

		
	}
	
	public static String listElementsMoreThan(WebDriver driver,By locator,int num,String valueToSearch)
	{
		
	String value=null;
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(70));
		
		List<WebElement> WebElementList=wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(locator, num));
		Reporter.log("LOG INFO : NewCount is "+WebElementList.size());
	
		for(WebElement ele:WebElementList)
		{
			 value=ele.getText();
			
			if(value.contains(valueToSearch) || value.equalsIgnoreCase(valueToSearch))
			{
				//System.out.println("LOG INFO : Clicked on "+valueToSearch);
				Reporter.log("LOG INFO : found "+valueToSearch);
			
				 String highLightString=ConfigReader.getProperty("highLightElement");
					
					if(highLightString.equalsIgnoreCase("true"))
					{
						highLightWebElement(driver,ele);
					}
					break;
			}
			
		}
		
		
		return value;
		
	}
	public static void selectDateFromCurrentMonth(WebDriver driver,By locator1,By locator2)
	{
		Utility.waitForWebElement(driver, locator1).click();
		
		Utility.waitForWebElement(driver, locator2).click();
	
		
	}
	
	
	public static void selectDateFromNextMonth(WebDriver driver,By locator,By nextMonthIcon,By datevalue)
	{
		
   Utility.waitForWebElement(driver, locator).click();
		
		Utility.waitForWebElement(driver, nextMonthIcon).click();
		
		Utility.waitForWebElement(driver, datevalue).click();
	

	
		

	
		
	}
	
	
	public static void rightClick(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.contextClick(ele).perform();
	}
	
	public static void doubleClick(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.doubleClick(ele).perform();
	}
	
	public static String captureScreenshotAsByte(WebDriver driver)
	{
		
		TakesScreenshot ts= (TakesScreenshot)driver;
		
		String screenshotasBase64=ts.getScreenshotAs(OutputType.BASE64);
		
		return screenshotasBase64;
	}

	public static String getCurrentDate()
	{
     SimpleDateFormat myformat=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");

       String newFormat=myformat.format(new Date());
		
		return newFormat;
	}
	
	public static void clickElement(WebDriver driver,WebElement ele)
	{
		try
		{
		ele.click();
		} catch(Exception e)
		{
			Reporter.log("LOG:INFO - WebElement Click Failed - Trying With Actions Class Click "+e.getMessage(), true);
			
			try
			{
				Actions act=new Actions(driver);
				act.click().perform();
			}catch(Exception e2)
			{
				Reporter.log("LOG:INFO - Actions Class Click Failed - Trying With JSExecutor Class "+e2.getMessage(), true);
				
					JavascriptExecutor js=(JavascriptExecutor) driver;
					js.executeScript("arguemnts[0].click()", ele);
			}
		}
	}
	
	public static void sleep(int timeInSeconds)
	{
		try {
			Thread.sleep(timeInSeconds*1000);
		} catch (InterruptedException e) {
			
			Reporter.log("LOG:ERROR - Thread Interruped "+ e.getMessage(),true);
		}
	}
	public static WebElement highLightWebElement(WebDriver driver,WebElement ele)
	{
	
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		js.executeScript("arguments[0].setAttribute('style','background: yellow; border: solid 2px red')", ele);
		
		sleep(1);
		
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px black')",ele);
		
		return ele;
	
	}
	
	
	public static void mouseHover(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).perform();
	}
	
	
	
	public static void scrollTillElementPresent(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		
		act.scrollToElement(ele).perform();
		
	}
	
	public static void scrollTillElementPresent(WebDriver driver,By Locator)
	{
		Actions act=new Actions(driver);
		
		act.scrollToElement(driver.findElement(Locator)).perform();
		
	}
	
	public static WebElement waitForWebElement(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locator));
		
    String highLightString=ConfigReader.getProperty("highLightElement");
		
		if(highLightString.equalsIgnoreCase("true"))
		{
			highLightWebElement(driver,ele);
		}
		
		return ele;
	}
	
	public static WebElement waitForWebElement(WebDriver driver,By locator,int timeInSec)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeInSec));
		
		WebElement ele=wait.until(ExpectedConditions.elementToBeClickable(locator));
		
		String highLightString=ConfigReader.getProperty("highLightElement");
		
		if(highLightString.equalsIgnoreCase("true"))
		{
			highLightWebElement(driver,ele);
		}
		
		return ele;
	}
	
	
	public static List waitForWebElements(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		
		List<WebElement> l1=wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		
		return l1;
	}
	
	
	
}
