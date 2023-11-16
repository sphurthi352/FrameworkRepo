package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataProvider.DataProviders;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.RegistrationPage;

public class RegisterTest extends BaseClass
{

	
	@Test(dataProvider="registerInput",dataProviderClass=DataProviders.class)
	public void registerUser(String nameString,String mail,String pwd,String interests,String gender,String state,String hobby)
	{
		LoginPage login=new LoginPage(driver);
		
		login.loginOption();
		RegistrationPage register=login.signUp();
		
		register.registerUser(nameString, mail, pwd, interests, gender,state, hobby);
		boolean status=register.msg();
		
		Assert.assertTrue(status,"User is Not Registered");
		
		
	}

}
