package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.helper.Utility;

public class RegistrationPage 
{

	WebDriver driver;
	
	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	private By name=By.name("name");
	private By email=By.name("email");
	private By pwd=By.id("password");
	private By state=By.xpath("//select[@name='state']");
	private By hobbies=By.xpath("//select[@name='hobbies']");
	private By signUp=By.xpath("//button[text()='Sign up']");
	private By msg=By.xpath("//div[contains(text(),'Signup success')]");
	
			//label[text()='Automation Testing']
			//input[@value='Female']
	
	public void registerUser(String fname,String emailid,String password,String interests,String gender,String stateName,String hobbiesName)
	{
		
		Utility.waitForWebElement(driver, name).sendKeys(fname);
		Utility.waitForWebElement(driver, email).sendKeys(emailid);
		Utility.waitForWebElement(driver, pwd).sendKeys(password);
		Utility.waitForWebElement(driver,By.xpath("//label[text()='"+interests+"']")).click();
		Utility.waitForWebElement(driver, By.xpath("//input[@value='"+gender+"']")).click();
		//Utility.waitForWebElement(driver, state);
		Utility.selectValueFromDropDown(driver, state, stateName);
		//Utility.waitForWebElement(driver, hobbies);
		Utility.selectValueFromDropDown(driver, hobbies, hobbiesName);
		Utility.waitForWebElement(driver, signUp).click();
		
		
	}
	
	
	public boolean msg()
	{
		boolean status=Utility.waitForWebElement(driver, msg, 10).isDisplayed();
		
		return status;
	}
	
	
	
	
	
	
	
}
