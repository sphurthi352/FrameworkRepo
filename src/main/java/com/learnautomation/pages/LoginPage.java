package com.learnautomation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.learnautomation.helper.Utility;

public class LoginPage
{
	

	 WebDriver driver;
	 
	 public LoginPage(WebDriver driver) 
	 {
		this.driver=driver; 
	 }  

	 
	 private By menuBy=By.xpath("//img[@alt='menu']");
		
		private By loginOption=By.xpath("//button[normalize-space()='Log in']");
		
		private	By username=By.xpath("//input[@id='email1']");
		
		private By password=By.xpath("//input[@id='password1']");
		
		private	By loginButton=By.xpath("//button[normalize-space()='Sign in']");
		
		private By loginSignInOption=By.xpath("//h2[normalize-space()='Sign In']");
		
		private By socialMediaCount=By.xpath("//div[@class='social-btns']//a");
		
		private By signUp=By.xpath("//a[normalize-space()='New user? Signup']");
		//a[normalize-space()='New user? Signup']
		
		public void loginOption() 
		{
			Utility.waitForWebElement(driver, menuBy, 50).click();
			
			
			//driver.findElement(menuBy).click();
			
			Utility.waitForWebElement(driver, loginOption, 20).click();
			//driver.findElement(loginOption).click();
		}
		
		
		public RegistrationPage signUp()
		{
			Utility.waitForWebElement(driver,signUp).click();
			RegistrationPage registrationPage=new RegistrationPage(driver);
			return registrationPage;
		}
		
		
		public HomePage loginToApplication(String uname,String pass)
		{
			
			Utility.waitForWebElement(driver, username).sendKeys(uname);
			Utility.waitForWebElement(driver, password).sendKeys(pass);
			WebElement ele=Utility.waitForWebElement(driver, loginButton);
			
			Utility.clickElement(driver, ele);
			
			
			//driver.findElement(username).sendKeys(uname);
			//driver.findElement(password).sendKeys(pass);
			//driver.findElement(loginButton).click();
			
			HomePage home=new HomePage(driver);
			
			return home;
			
		}
		
		public int numberOfSocialMediaIcons() {
			
		
			return driver.findElements(socialMediaCount).size();
			
		}
		
		public boolean isSignInDisplayed() 
		{
			return Utility.waitForWebElement(driver,loginSignInOption).isDisplayed();
			//return driver.findElement(loginSignInOption).isDisplayed();
		}
		
	}
	


