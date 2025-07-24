package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

import pageObjects.TravelInsurance;
import testBase.BaseClass;

public class TravelTest extends BaseClass{
	public Properties p;
	TravelInsurance tp; 

	@Test
	public void travel() throws InterruptedException, IOException {
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
    	tp = new TravelInsurance(driver);
     	tp.clickOnTravel();
    	tp.searchClick();
        tp.searchCountryList();
        tp.startDateClick();
        tp.clickOnStartDate();
        tp.endDateClick();
        tp.clickOnEndDate();
        tp.clickContinue();
        tp.selectPersons();
        tp.Dropdown();
        tp.clickOnHealthOption();
        tp.explorePlans();
	}
	
	

}
