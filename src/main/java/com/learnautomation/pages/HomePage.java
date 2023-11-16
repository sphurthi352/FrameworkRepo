package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.helper.Utility;

public class HomePage 
{
	
WebDriver driver;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
private By manageOption=By.xpath("//span[normalize-space()='Manage']");
	
	private By menu=By.xpath("//img[@alt='menu']");
	
	private By signOut=By.xpath("//button[normalize-space()='Sign out']");
	
	private By manageCourse =By.xpath("//a[text()='Manage Courses']");
	
	private By manageCategory=By.xpath("//a[contains(@href,'category')]");
	
	HomePage home;
	
	
	public void manage()
	{
      Utility.waitForWebElement(driver, manageOption);
		
		Utility.mouseHover(driver, driver.findElement(manageOption));
	
	}
	
	public CoursePage course()
	{
		//Utility.waitForWebElement(driver, manageOption);
		
		//Utility.mouseHover(driver, driver.findElement(manageOption));
	
		Utility.waitForWebElement(driver, manageCourse).click();
		CoursePage coursePage=new CoursePage(driver);
		return coursePage;
		
		
	}
	
	
	public CategoryPage Category()
	{
	
		Utility.waitForWebElement(driver, manageCategory).click();
		CategoryPage category=new CategoryPage(driver);
		return category;
		
		
	}
	
	
	
	public boolean isManageDisplayed()
	{
	  //  boolean status=driver.findElement(manageOption).isDisplayed();
	    
	    boolean status=Utility.waitForWebElement(driver, manageOption).isDisplayed();
	    
	    return status;
	}
	
	
	
	public void signOutFromApplication()
	{
		
		
	  Utility.waitForWebElement(driver, menu).click();
	  Utility.waitForWebElement(driver, signOut).click();
		//driver.findElement(menu).click();
		
		//driver.findElement(signOut).click();
	}

}
