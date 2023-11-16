package com.learnautomation.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.learnautomation.helper.Utility;

public class CategoryPage 
{
	WebDriver driver;
	
	int initialCategoryCount;
	String name="category"; 
	String categoryName="JMeter99";
	By noOfCategory=By.xpath("//table[contains(@class,'category-table')]//tbody/tr");
	
	By addCategory=By.xpath("//button[normalize-space()='Add New Category']");
	
	By delete=By.xpath("//button[text()='Delete']");
	
	
	
	
	public CategoryPage(WebDriver driver)
	{
		this.driver=driver;
	}
	

	
	public boolean window()
	{
		boolean status=false;
		String url=Utility.selectWindow(driver);
		if(url.contains(name))
		{
			status=true;
		}
		return status;
		
	}
	
	
	public  int categoryCount()
	{
		initialCategoryCount=Utility.sizeOfListVisibility(driver,noOfCategory);
		return initialCategoryCount;
	}
	
	
	public void addCategory()
	{
		
		Utility.waitForWebElement(driver, addCategory).click();
		
		Alert alert=Utility.alert(driver);
		
		alert.sendKeys(categoryName);
		
		alert.accept();
		
	
	}
	
	public int categoryCountAfteradd()
	{
	
		return Utility.sizeOfListMorethan(driver, noOfCategory, initialCategoryCount);
	}
	
	public String categoryConfirmation()
	{
		String cName=Utility.selectValueFromlist(driver, noOfCategory, categoryName);
		return cName;
		
	}
	
	public void updateCategory(String categoryName,String appendName)
	{
		Utility.waitForWebElement(driver, By.xpath("//td[text()='"+categoryName+"']//following::button[text()='Update ']")).click();
		
	Alert alert=Utility.alert(driver);
	
	alert.sendKeys(categoryName.concat(" ").concat(appendName));
	alert.accept();
	
		
	}
	
	
	public boolean newCategoryName(String updatedCategoryName)
	{
		boolean status=Utility.waitTextMatch(driver, By.xpath("//table[contains(@class,'category')]//tr//td[text()='"+updatedCategoryName+"']"), updatedCategoryName);
		return status;
	}
	
	
	public int deleteCategory(String updatedCategoryName)
	{
		Utility.waitForWebElement(driver,By.xpath("//td[text()='"+updatedCategoryName+"']//following::button[contains(@class,'delete')]")).click();
		Utility.waitForWebElement(driver, delete).click();
		int size=Utility.sizeOfListtobe(driver, noOfCategory, initialCategoryCount);
		return size;
		
	}
	
	
	

}
