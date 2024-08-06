package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataProvider.DataProviders;
import com.learnautomation.dataProvider.ExcelReader;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;


// Login Test Cases


// To check Login 

public class LoginTest extends BaseClass
{
	
	

	
	@Test(dataProvider="loginInput",dataProviderClass=DataProviders.class)
	public void validLogin(String uname,String pwd)
	{
		LoginPage login=new LoginPage(driver);
		
		login.loginOption();
		
		HomePage homePage=login.loginToApplication(uname, pwd);
		Assert.assertTrue(homePage.isManageDisplayed());
		
		homePage.signOutFromApplication();
		Assert.assertTrue(login.isSignInDisplayed());
		
		}
	
	
	

}

