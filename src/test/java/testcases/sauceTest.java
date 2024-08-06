package testcases;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class sauceTest
{

	
	WebDriver driver;
	By userName=By.id("user-name");
	By pwd=By.id("password");
	By login=By.xpath("//input[@value='LOGIN']");
	By products=By.xpath("//div[text()='Products']");
	By menu=By.xpath("//button[text()='Open Menu']");
	By logout=By.xpath("//a[text()='Logout']");
	By backpack=By.xpath("//div[contains(text(),'Sauce Labs Backpack')]");
	By tshirtAddCart=By.xpath("//div[contains(text(),'Test.allTheThings() T-Shirt (Red)')]//following::button[contains(text(),'ADD TO CART')]");
	By addCart=By.xpath("//button[text()='ADD TO CART']");
	By back=By.xpath("//button[contains(text(),'Back')]");
	By remove=By.xpath("//button[contains(text(),'REMOVE')]");
	By sortDropdown=By.xpath("//select[contains(@class,'sort_container')]");
	//By priceHighLow=By.xpath("//div[@class='inventory_item_price']");
	By priceList=By.xpath("//div[@class='inventory_item_price']");
	By nameList=By.xpath("//div[@class='inventory_item_name']");
	By cartIcon=By.xpath("//a[contains(@class,'cart')]");
	By continueButton=By.xpath("//a[contains(text(),'Continue Shopping')]");
	By twitter=By.xpath("//li[text()='Twitter']");
	By checkout=By.xpath("//a[contains(text(),'CHECKOUT')]");
	By cancel=By.xpath("//a[contains(@class,'cancel')]");
	By continueCheckout=By.xpath("//input[@value='CONTINUE']");
	By error=By.xpath("//h3[@data-test='error']");
	By errorClose=By.xpath("//h3[@data-test='error']/button");
	By firstName=By.id("first-name");
	By lastName=By.id("last-name");
	By postalCode=By.id("postal-code");
	
			
	
	
	
	
	
	
	
	
	
	
	Select sel;
	List<Double> highLowPrice;
	List<Double> actualPrice;
	List<Double> actualLowPriceList;
	List<Double> expectedLowPriceList;
	List<Double> revPrice;
	List<String> names;
	List<String> actualNames;
	
	@Test(priority=1)
	public void launchApp()
	{
		
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.saucedemo.com/v1/");
		
		
		
	}
	
	@Test(priority=2)
	public void login()
	{
		driver.findElement(userName).sendKeys("standard_user");
		driver.findElement(pwd).sendKeys("secret_sauce");
		driver.findElement(login).click();
		Assert.assertTrue(driver.findElement(products).isDisplayed());
		
		Reporter.log("Login successful");
		
	}
	
	
	//@Test(priority=3)
	public void sortPriceHighLow()
	{
		actualPrice=new ArrayList();
		List<WebElement> al=driver.findElements(priceList);
		for(WebElement x:al)
		{
		
			actualPrice.add(Double.parseDouble(x.getText().substring(1)));
		 
		}
		
		Reporter.log("actual Price list "+actualPrice,true);
		
	  	Collections.sort(actualPrice);
	  	
		Reporter.log("Sorted Price  "+actualPrice,true);
		
		revPrice=new ArrayList();
		
		  for(int i=actualPrice.size()-1;i>=0;i--)
		  {
			  revPrice.add(actualPrice.get(i));
		  }
		  
		  Reporter.log("Reverse Price list "+revPrice,true); 
		
			  
	highLowPrice=new ArrayList();
	
		WebElement sortdd=driver.findElement(sortDropdown);
	  	 sel=new Select(sortdd);
	  	sel.selectByVisibleText("Price (high to low)");
	  	List<WebElement> prices=driver.findElements(priceList);
	  	for(WebElement pl:prices)
	  	{
	  		highLowPrice.add( Double.parseDouble(pl.getText().substring(1)));
	  			
	  	}
	  	
	  	Reporter.log("High to Low Price " +highLowPrice,true);
	  	
	  	Assert.assertEquals(revPrice,highLowPrice);
	  	
	  	Reporter.log("actual and sorted Prices are matching",true);
	  		  
		
	}
	
	//@Test(priority=4)
	public void sortAToZ()
	{
		
		sel.selectByVisibleText("Name (A to Z)");
		List<WebElement> l1=driver.findElements(nameList);
		
		names=new ArrayList<String>();
		for(WebElement ele :l1)
		{
			names.add(ele.getText());
		}
		
		Reporter.log("Names A to Z " +names,true);
		
		actualNames=new ArrayList<String>();
		actualNames.add("Sauce Labs Backpack");
		actualNames.add("Sauce Labs Bike Light");
		actualNames.add("Sauce Labs Bolt T-Shirt");
		actualNames.add("Sauce Labs Fleece Jacket");
		actualNames.add("Sauce Labs Onesie");
		actualNames.add("Test.allTheThings() T-Shirt (Red)");
		
		Reporter.log("Names A to Z " +actualNames,true);
		
		Assert.assertTrue(actualNames.equals(names));
		
		Reporter.log("Actual and Sorted A to Z are matching",true);	
		
	}
	
	//@Test(priority=5)
	public void sortPriceLowHigh()
	{
		expectedLowPriceList=new ArrayList<Double>();
		expectedLowPriceList.add(7.99);
		expectedLowPriceList.add(9.99);
		expectedLowPriceList.add(15.99);
		expectedLowPriceList.add(15.99);
		expectedLowPriceList.add(29.99);
		expectedLowPriceList.add(49.99);
		
		Reporter.log("Expected Price from low  to high  "+expectedLowPriceList,true);
		
		sel.selectByVisibleText("Price (low to high)");
		
		List<WebElement> l1=driver.findElements(priceList);
		actualLowPriceList=new ArrayList<Double>();
		
		
		for(WebElement ele:l1)
		{
			actualLowPriceList.add(Double.parseDouble(ele.getText().substring(1)));
		}
		
		Reporter.log("Actual Price from low  to high  "+actualLowPriceList,true);
		
		Assert.assertTrue(expectedLowPriceList.equals(expectedLowPriceList));
		
		Reporter.log("Actual and expected prices are matching",true);
		
		
	}
	
	
	
	@Test(priority=6)
	public void addCart()
	{
		driver.findElement(backpack).click();
		driver.findElement(back).click();
		driver.findElement(backpack).click();
		driver.findElement(addCart).click();
		driver.findElement(remove).click();
		driver.findElement(addCart).click();
		driver.findElement(back).click();
		driver.findElement(tshirtAddCart).click();
		driver.findElement(cartIcon).click();
		driver.findElement(continueButton).click();
		driver.findElement(cartIcon).click();
		
		Assert.assertTrue(driver.findElement(twitter).isDisplayed());
		
		Reporter.log("Products are added to cart");
		
	}
	
	@Test(priority=7)
	public void checkOut() 
	{
		
		 driver.findElement(checkout).click();
		 driver.findElement(cancel).click();
		 driver.findElement(checkout).click();
		 driver.findElement(continueCheckout).click();
		 String errorMsg=driver.findElement(error).getText();
		
		String ActualError="Error: First Name is required";
		Assert.assertTrue(ActualError.equals(errorMsg));
		Reporter.log("Error message is "+errorMsg,true);
		
		driver.findElement(errorClose).click();
		
		driver.findElement(firstName).sendKeys("abc");
		driver.findElement(lastName).sendKeys("last");
		driver.findElement(postalCode).sendKeys("12345");
		driver.findElement(continueCheckout).click();
		
		
		
		
	}
	
	
	
	public void logout()
	{
		driver.findElement(menu).click();
		driver.findElement(logout).click();
		
	}
	
	
	
	
}
