package com.learnautomation.dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders
{

	@DataProvider(name="loginInput")
	public Object[][] getData()
	{
		
		Object arr[][]=ExcelReader.getDataFromExcel("LoginData");
		
		return arr;
	}
	
	
	@DataProvider(name="registerInput")
	public Object[][] getRegisterData()
	{
		
		Object arr[][]=ExcelReader.getDataFromExcel("RegisterData");
		
		return arr;
	}
	
	
	@DataProvider(name="courseInput")
	public Object[][] getCourseData()
	{
		
		Object arr[][]=ExcelReader.getDataFromExcel("courseInput");
		
		return arr;
	}
	
	@DataProvider(name="courseName")
	public Object[][] getCourseName()
	{
		
		Object arr[][]=ExcelReader.getDataFromExcel("courseName");
		
		return arr;
	}
	
	@DataProvider(name="categoryInput")
	public Object[][] getCategory()
	{
		
		Object arr[][]=ExcelReader.getDataFromExcel("categoryInput");
		
		return arr;
	}
	
	
	@DataProvider(name="categoryInput1")
	public Object[][] getCategory1()
	{
		
		Object arr[][]=ExcelReader.getDataFromExcel("categoryInput1");
		
		return arr;
	}
	
	
	@DataProvider(name="enrollData")
	public Object[][] getenrollData()
	{
		
		Object arr[][]=ExcelReader.getDataFromExcel("enrollData");
		
		return arr;
	}
	@DataProvider(name="Dummy")
	public Object[][] getdummy()
	{
		
		Object arr[][]=ExcelReader.getDataFromExcel("Dummy");
		
		return arr;
	}
}
