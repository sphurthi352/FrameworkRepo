package com.learnautomation.dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;


public class ConfigReader
{

	
	public static String getProperty(String key)
	{
	
	Properties prop=new Properties();
	
	try 
	{
		prop.load(new FileInputStream(new File(".\\ConfigFiles\\Config.Properties")));
	} 
	
  catch (IOException e) 
	{
	
		Reporter.log(e.getMessage(),true);
	}
	
	
	String value=prop.getProperty(key);
	
	return value;
	
	
	}
	
}
