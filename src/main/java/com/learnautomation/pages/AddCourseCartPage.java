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

import com.learnautomation.helper.Utility;

public class AddCourseCartPage 
{
	
	WebDriver driver;
	public AddCourseCartPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	private By numOfCourses= By.xpath("//div[contains(@class,'course-data')]");
	private By priceValues=By.xpath("//span[contains(text(),'Price')]/b");
	private By addCart=By.xpath("//button[contains(text(),'Add to Cart')]");
	private By cartButton=By.xpath("//button[contains(@class,'cartBtn')]");
	private By numOfCousesInCart=By.xpath("//div[@class='cart-container']/div[@class='course-card row']");
	//By numOfCourseIncart=By.xpath("//span[@class='count']");
	private By enroll=By.xpath("//button[text()='Enroll Now']");
	private By TotalPrice=By.xpath("//h3[contains(text(),'Total Price:')]/b");
	private By address=By.name("address");
	private By phone=By.id("phone");
	private By enrollNow=By.xpath("(//button[text()='Enroll Now'])[2]");
	private By orderId=By.xpath("//h4[@class='uniqueId']/b");
	private By close=By.xpath("//button[@aria-label='Close']");
	 int courseCount;
	
	public int coursesCount()
	{
		
       courseCount=  Utility.sizeOfListVisibility(driver, numOfCourses);
      
      return courseCount;
       
	}
	
	public int sumPrice()
	{
		int sumOfPrices=0;
		
		List<WebElement> l1=Utility.waitForWebElements(driver, priceValues);
		//System.out.println("list size "+l1.size());
	
		
		for(WebElement ele :l1)
		{
			sumOfPrices=sumOfPrices+Integer.parseInt(ele.getText().replace("₹", ""));
		}
		return sumOfPrices;
		
	}
	

	
	public void addCourseCart()
	{
		Utility.listClick(driver, addCart);
		
	}

	
	public int cartCourseCount()
	{
		//int cartCoursesCount =Integer.parseInt(Utility.waitForWebElement(driver, numOfCourseIncart,50).getText());
		Utility.waitForWebElement(driver, cartButton).click();
		int cartCoursesCount=Utility.sizeOfListVisibility(driver, numOfCousesInCart);
		return cartCoursesCount;
	
		
	}
	
	public int enroll(String addressValue,String phoneNumber)
	{
		Utility.waitForWebElement(driver, enroll).click();
		int totalPrice=Integer.parseInt(Utility.waitForWebElement(driver, TotalPrice).getText().replace("₹",""));
		Utility.waitForWebElement(driver, address).sendKeys(addressValue);
		Utility.waitForWebElement(driver, phone).sendKeys(phoneNumber);
		Utility.waitForWebElement(driver, enrollNow).click();
		return totalPrice;
	}
	
	
	
	public String orderID()
	{
		WebElement ele=Utility.waitForWebElement(driver, orderId, 70);
		String order[]=ele.getText().split("-");
		String orderNumber=order[1];
		Utility.waitForWebElement(driver, close).click();
		return orderNumber;
		
	}
	
	public int priceAfterOrderId()
	{
		int price=Integer.parseInt(Utility.waitForWebElement(driver, TotalPrice).getText().replace("₹",""));
		return price;
	}
}
