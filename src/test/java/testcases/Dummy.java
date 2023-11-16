package testcases;

import org.testng.annotations.Test;

import com.learnautomation.dataProvider.DataProviders;
import com.learnautomation.dataProvider.ExcelReader;

public class Dummy
{
	@Test(dataProvider="Dummy",dataProviderClass=DataProviders.class)
	public void data(String a1)
	{

	
	System.out.println(a1);
	
	
		
	}

}
