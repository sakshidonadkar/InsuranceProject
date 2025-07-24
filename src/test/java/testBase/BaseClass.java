package testBase;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public WebDriver driver;
	public Logger logger;
	public Properties p;
	

	@BeforeClass
	public void setup() throws IOException {
		//LOADING CONFIG
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);

		driver=new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}
	
	@AfterClass
    public void tearDown() {
    	driver.quit();
    }
	

}
