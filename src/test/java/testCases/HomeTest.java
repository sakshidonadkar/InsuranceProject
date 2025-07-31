package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import pageObjects.HomeInsurance;
import testBase.BaseClass;
import utilities.ExcelUtils;

public class HomeTest  extends BaseClass{
	public Properties p;
	HomeInsurance hi; 

	@Test(dataProvider = "PlanData", dataProviderClass = ExcelUtils.class)
	public void homeSection(String name, String phone, String homeVal, String homeItems) throws InterruptedException, IOException {
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		hi = new HomeInsurance(driver);
    	hi.clickonHomeBtn();
    	hi.userInfo(name,phone);
    	hi.propertyDetails(homeVal, homeItems);
    	hi.listOfPlans();
	}
	
	

}