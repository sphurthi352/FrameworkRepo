package com.learnautomation.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.learnautomation.dataProvider.ConfigReader;
import com.learnautomation.helper.Utility;


public class CoursePage
{

	WebDriver driver;
	
	
	public CoursePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	By addCourse =By.xpath("//button[normalize-space()='Add New Course']");
	By file= By.xpath("//input[@id='thumbnail']");
	By courseName=By.xpath("//input[@id='name']");
	By courseDescription=By.xpath("(//textarea[@id='description'])[1]");
	By instructor=By.xpath("//input[@id='instructorNameId']");
	By price=By.id("price");
	By startDate=By.xpath("//input[@name='startDate']");
	By nextMonthIcon=By.xpath("//button[@aria-label='Next Month']");
	By startDateSelected=By.xpath("By.xpath(//div[contains(@class,'day--001')]");
			//By.xpath("//span[contains(@class,'next')]");
	By calendar=By.xpath("div[contains(@class,'week')]/div[contains(@class,'day')]");
	By endDate =By.xpath("//input[@name='endDate']");
	By endDateSelected=By.xpath("//div[contains(@class,'day--030')]");
	By selectCategory=By.xpath("//div[normalize-space()='Select Category']");
	
	
	By save=By.xpath("//button[normalize-space()='Save']");
	
	By numCourses=By.xpath("//table//tbody//tr/td[2]");
	
	By delCourse=By.xpath("//td[text()='Selenium']//following::button[contains(@class,'delete')]");
			//By.xpath("//button[contains(@class,'delete')]//preceding::td[contains(text(),'Selenium23')]");
	////div[contains(@class,'week')]/div[contains(@class,'day')]

	int courseCount;

	
	public int CourseCount()
	{
		 courseCount=Utility.sizeOfListVisibility(driver, numCourses);
		
		return courseCount;
		
	}
	
	public void courseAdd(String fileName,String cName,String cDescription,String instructorName,String priceValue,String starDateValue,String endDateValue,String categoryName)
	{
	
		Utility.waitForWebElement(driver, addCourse).click();
		Utility.waitForWebElement(driver, file).sendKeys(fileName);
		Utility.waitForWebElement(driver, courseName).sendKeys(cName);
		Utility.waitForWebElement(driver, courseDescription).sendKeys(cDescription);
		Utility.waitForWebElement(driver, instructor).sendKeys(instructorName);
		Utility.waitForWebElement(driver, price).sendKeys(priceValue);
		
	  /* Utility.waitForWebElement(driver, startDate).click();
	   Utility.waitForWebElement(driver, nextMonthIcon).click();
	  // Utility.waitForWebElement(driver,By.xpath("//div[contains(@aria-label,'"+starDateValue+"')]")).click();  24th  in excel 
	   
	   Utility.waitForWebElement(driver, By.xpath("//div[contains(@class,'week')]/div[contains(@class,'day--0"+(int)Double.parseDouble(starDateValue)+"')]")).click();  */
		
	//Utility.selectDateFromCurrentMonth(driver, startDate, By.xpath("//div[contains(@class,'week')]/div[contains(@class,'day--0"+(int)Double.parseDouble(starDateValue)+"')]"));
	
	Utility.selectDateFromNextMonth(driver, startDate, nextMonthIcon,By.xpath("//div[contains(@class,'week')]/div[contains(@class,'day--0"+(int)Double.parseDouble(starDateValue)+"')]"));
	   
	/*   Utility.waitForWebElement(driver, endDate).click();
	   Utility.waitForWebElement(driver, nextMonthIcon).click();
	  // Utility.waitForWebElement(driver,By.xpath("//div[contains(@aria-label,'"+endDateValue+"')]")).click();  15th excel  */
	 //   Utility.waitForWebElement(driver, By.xpath("//div[contains(@class,'week')]/div[contains(@class,'day--0"+(int)Double.parseDouble(endDateValue)+"')]")).click();
	  
//  Utility.selectDateFromCurrentMonth(driver, endDate,By.xpath("//div[contains(@class,'week')]/div[contains(@class,'day--0"+(int)Double.parseDouble(endDateValue)+"')]"));
  
  Utility.selectDateFromNextMonth(driver, endDate, nextMonthIcon,By.xpath("//div[contains(@class,'week')]/div[contains(@class,'day--0"+(int)Double.parseDouble(endDateValue)+"')]"));
	    
	
		Utility.waitForWebElement(driver, selectCategory,50).click();
		Utility.waitForWebElement(driver,By.xpath("//button[normalize-space()='"+categoryName+"']"),50).click();
		Utility.waitForWebElement(driver, save,60).click();
		
		
	}
	
	
	public int courseCountAfterAddingCourse()
	{
		int count=Utility.sizeOfListMorethan(driver, numCourses, courseCount);
	
		return count;
		
	}
	
	public String courseConfirmation(String cName)
	{
		
	 String name=Utility.listElementsMoreThan(driver, numCourses, courseCount,cName);
		return name;
		
	}
	
	
	public void deleteCourse(String cName)
	{
		
		//Utility.waitForWebElement(driver, By.xpath("//button[contains(@class,'delete')]//preceding::td[contains(text(),'"+cName+"')]")).click();
		//Utility.waitForWebElement(driver, By.xpath("//button[contains(@class,'delete')]//preceding::td[contains(text(),'"+cName+"')]"),50).click();
		driver.navigate().refresh();
		
		Utility.waitForWebElement(driver,By.xpath("(//td[text()='"+cName+"']//following::button[contains(@class,'delete')])[1]"),70).click();
		
		
	}
	
	public int courseCountAfterDelete()
	{
		int count=Utility.sizeOfListtobe(driver, numCourses, courseCount);
		return count;
	}
	
	
	
}
