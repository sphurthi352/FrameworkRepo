package testcases;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataProvider.DataProviders;
import com.learnautomation.pages.CoursePage;
import com.learnautomation.pages.HomePage;
import com.learnautomation.pages.LoginPage;

public class courseTest extends BaseClass
{
	
	CoursePage course;
	int intialCourseCount;

	@Test(dataProvider="loginInput",dataProviderClass=DataProviders.class,priority=1)
	public void login(String uname,String pwd)
	{
		LoginPage login=new LoginPage(driver);
		
		login.loginOption();
		
		HomePage home=login.loginToApplication(uname,pwd);
		
		Assert.assertTrue(home.isManageDisplayed());
		
		home.manage();
		 course=home.course();
		 Reporter.log("Course Page is landed",true);
		
		
	}
	
	@Test(priority=2)
	public void count()
	{
		
		  intialCourseCount=course.CourseCount();
		 Assert.assertTrue(intialCourseCount>0);
	     Reporter.log("intialCourseCount is " +intialCourseCount,true);
		 
	}
	
	
	
	@Test(dataProvider="courseInput",dataProviderClass=DataProviders.class,priority=3)
	public void addcourse(String fileName,String cName,String cDescription,String instructorName,String priceValue,String starDateValue,String endDateValue,String categoryName)
	{
	
		course.courseAdd(fileName,cName, cDescription, instructorName, priceValue, starDateValue, endDateValue,categoryName);
	}
	
	@Test(priority=4)
	public void courseCountAfterAddingCourse()
	{
		//int count=course.courseCountAfterAddingCourse();
		Assert.assertTrue(course.courseCountAfterAddingCourse()>intialCourseCount);
		Reporter.log("CourseCount after adding course is "+course.courseCountAfterAddingCourse(),true);
	}
	
	@Test(dataProvider="courseName",dataProviderClass=DataProviders.class,priority=5)
	public void courseConfirmation(String cName)
	{
		//String name=course.courseConfirmation(cName);
		Reporter.log( "Course  "+course.courseConfirmation(cName)+ "is added",true);
		Assert.assertEquals(course.courseConfirmation(cName), cName);
	
	}
	
	
	
	
	@Test(dataProvider="courseName",dataProviderClass=DataProviders.class,priority=6)
	public void deleteAddedCourse(String cName)
	{
		course.deleteCourse(cName);
	
	}
	
	@Test(priority=7)
	public void courseCountAfterDelete()
	{
		//int count =course.courseCountAfterDelete();
		Reporter.log("CourseCount After deleting course is "+course.courseCountAfterDelete(),true);
		Assert.assertEquals(course.courseCountAfterDelete(), intialCourseCount);
		
		
	}
	
	
	
   
	
}
