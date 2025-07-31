package pageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomeInsurance extends BasePage {
	private JavascriptExecutor js;
	WebDriverWait wait=  new WebDriverWait(driver, Duration.ofSeconds(30));; 

	public HomeInsurance(WebDriver driver) {
		super(driver);
		this.js = (JavascriptExecutor) driver;
	}
	
	@FindBy(xpath="//a[normalize-space()='View all products']")
	WebElement allInsurance;

	@FindBy(xpath = "//i[@class='icon-bg homeIconsBg home-insurance']")
	WebElement btnHome;

	@FindBy(id = "Fullname")
	WebElement nameInput;

	@FindBy(name = "MobileNo")
	WebElement phoneInput;

	@FindBy(name = "Home Structure")
	WebElement checkbox;

	@FindBy(xpath = "//button[@class='pq-cta price-effective-wrapper shineAnim']")
	WebElement viewBtn;

	@FindBy(id = "StructureValue")
	WebElement marketValueHome;
	
	@FindBy(id = "ContentValue")
	WebElement valueOfHomeItems;

	@FindBy(xpath = "//button[normalize-space()='View Discounted Plans']")
	WebElement viewPlans;

	@FindBy(xpath = "//div[@class=' insurers-plan']")
	List<WebElement> planSection;
	
	@FindBy(xpath="//span[normalize-space()='Please enter value between 10 lac to 100 crore']")
	WebElement errMsg1;
	
	public void clickonHomeBtn() {
		js.executeScript("arguments[0].scrollIntoView(true);", allInsurance);
		js.executeScript("arguments[0].click();", btnHome);
	}

	public void userInfo(String name, String phone) {
		nameInput.sendKeys(name);
		phoneInput.sendKeys(phone);
		checkbox.click();
		viewBtn.click();
	}

	public void propertyDetails(String homeVal, String homeItems) {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("StructureValue")));
		marketValueHome.click();
		marketValueHome.sendKeys(homeVal);
		valueOfHomeItems.click();
		valueOfHomeItems.sendKeys(homeItems);	
		int price = Integer.parseInt(homeVal);
		int price1 = Integer.parseInt(homeItems);
		if((price >= 1000000 && price <= 1000000000) && (price1 >= 100000 && price1 <= 500000000)) {
			viewPlans.click();
		}else {		
			if(errMsg1.isDisplayed()) {				
				Assert.assertEquals(errMsg1.getText(),"Please enter value between 10 lac to 100 crore");
			}
			Assert.fail("price is not in range");
		}
		
	}
	
	public void listOfPlans() throws InterruptedException {
	    System.out.println("Size of list: " + planSection.size());

	    for (int i = 0; i < planSection.size(); i++) {
	        try {
	            WebElement plan = planSection.get(i);
	            WebElement ele1 = plan.findElement(By.tagName("p"));
	            WebElement ele2 = plan.findElement(By.tagName("button"));

	            String planName = ele1.getText();
	            String perMonthRS = ele2.getText();

	            System.out.println( planName + " : " + perMonthRS );
	        } catch (StaleElementReferenceException staleEx) {
	            System.out.println("⚠️ StaleElementReferenceException: Retrying...");
	            Thread.sleep(1000);
	            i--;
	        } catch (Exception e) {
	            System.out.println("❌ Error processing plan at index " + i + ": " + e.getMessage());
	        }
	    }
	}



}
