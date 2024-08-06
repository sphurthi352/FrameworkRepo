package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataProvider.DataProviders;
import com.learnautomation.pages.CategoryPage;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;

public class categoryTest extends BaseClass
{
	
	CategoryPage category;
	
	int initialCategoryCount;
	
	@Test(dataProvider="loginInput",dataProviderClass=DataProviders.class,priority=1)
	public void login(String uname,String pwd)
	{
		LoginPage login=new LoginPage(driver);
		
		login.loginOption();
		
		HomePage home=login.loginToApplication(uname,pwd);
		
		Assert.assertTrue(home.isManageDisplayed());
		
		home.manage();
		
		category=home.Category();
		
	}
	
	@Test(priority=2)
	public void windowURL()
	{
		Assert.assertTrue(category.window());
		Reporter.log("Category Page is landed",true);
		
	
	}
	
	
	@Test(priority=3)
	public void categoryCount()
	{
		 initialCategoryCount=category.categoryCount();
		 
		 Reporter.log("Initial Category count is "+initialCategoryCount,true);
		 
	}
	
	@Test(priority=4)
	public void addCategoryCount()
	{
		category.addCategory();
         Assert.assertEquals(category.categoryCountAfteradd(), initialCategoryCount+1);
		Reporter.log("New Category count is "+	category.categoryCountAfteradd(),true);
		
	}
	
	

	@Test(dataProvider="categoryInput",dataProviderClass=DataProviders.class,priority=5)
	public void updateCategoryName(String categoryName,String appendName,String latestName)
	{
		category.updateCategory(categoryName, appendName);	
		Assert.assertTrue(category.newCategoryName(latestName));
		Reporter.log("Category name is modified to "+latestName,true);
		
	}
	
	@Test(dataProvider="categoryInput1",dataProviderClass=DataProviders.class,priority=6)
	public void deleteCategory(String latestName)
	{
		int categoryCountAfterDelete=category.deleteCategory(latestName);
		
		Reporter.log("New count after category is deleted " +categoryCountAfterDelete,true);
		
		Assert.assertEquals(categoryCountAfterDelete, initialCategoryCount);
		
		Reporter.log(latestName+ "Category is deleted",true);
	}
}
