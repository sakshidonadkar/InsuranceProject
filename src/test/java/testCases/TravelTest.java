package testCases;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.travelInsurance;
import testBase.BaseClass;

public class TravelTest extends BaseClass{
	public Properties p;
	WebDriver driver;
	@Test
	public void travel() throws InterruptedException, IOException {
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
    	
    	travelInsurance tp = new travelInsurance(driver);
    	tp.clickOnTravel();
    	tp.searchClick();

        tp.searchCountry(p.getProperty("country"));
        
    	tp.searchClickOnList();
    	Thread.sleep(10000);
	}
	
	

}
