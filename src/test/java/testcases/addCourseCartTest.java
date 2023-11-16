package testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataProvider.DataProviders;
import com.learnautomation.pages.AddCourseCartPage;
import com.learnautomation.pages.LoginPage;

public class addCourseCartTest extends BaseClass 
{

	AddCourseCartPage acc;
	int numOfCourses;
	int sumPrice;
	int totalPrice;
	
	@Test(dataProvider="loginInput",dataProviderClass=DataProviders.class,priority=1)
	public void login(String uname,String pwd)
	{
	LoginPage login=new LoginPage(driver);
	
	login.loginOption();
	login.loginToApplication(uname, pwd);
	
	 acc=new AddCourseCartPage(driver);
	
	}
	
	@Test(priority=2)
	public void courseCount()
	{
		numOfCourses=acc.coursesCount();
		Assert.assertTrue(numOfCourses>0,"No Courses");
		Reporter.log("Number of Courses are "+numOfCourses,true);	
		
	}
	
	@Test(priority=3)
	public void sumPrices()
	{
		sumPrice=acc.sumPrice();
		
		Reporter.log("Sum of Prices: "+sumPrice,true);
	}
	
	@Test(priority=4)
	public void courseCartCount()
	{
		acc.addCourseCart();
		
		int numOfCoursesInCart=acc.cartCourseCount();
		
		Reporter.log("Number of Courses in Cart "+numOfCoursesInCart,true);
		
		Assert.assertEquals(numOfCoursesInCart, numOfCourses,"Num of Courses are not matching");
		
		Reporter.log("Number of Courses in Cart and Total Courses are same",true);
	}
	
	/*
	@Test(dataProvider="enrollData",dataProviderClass=DataProviders.class,priority=5)
	public void enroll(String address,String phone)
	{
		 totalPrice=acc.enroll(address, phone);
	}
	
	@Test(priority=6)
	public void orderId()
	{
		String orderNumber=acc.orderID();
		
		Assert.assertTrue(!orderNumber.isBlank());
		
		Reporter.log("Order Number is "+orderNumber,true);
		
	}
	
	@Test(priority=7)
	public void priceAfterOrder() 
	{
		Assert.assertEquals(acc.priceAfterOrderId(), 0);
		
	}
	*/
}
