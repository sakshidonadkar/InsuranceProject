package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TravelInsurance extends BasePage {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public TravelInsurance(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//i[@class='icon-bg homeIconsBg icon-bg-new ti']")
	WebElement btnTravel;

	@FindBy(className = "newPq_duration_wrap__dateCol")
	WebElement startDateSection;

	@FindBy(xpath = "//button[@aria-label='Jul 25, 2025']")
	WebElement startDate;

	@FindBy(xpath = "//div[@class=\"newPq_dateField_wrap__field --tripEnd\"]")
	WebElement endDateSection;

	@FindBy(xpath = "//button[@aria-label='Aug 20, 2025']")
	WebElement endDate;

	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueBtn;

	@FindBy(xpath = "//label[normalize-space()='2']")
	WebElement NoOfPersons;

	@FindBy(className = "customDropdown__select")
	WebElement dropdown1;

	@FindBy(xpath = "//input[@id='25 years_undefined']")
	WebElement age1;
	
	@FindBy(xpath="//div[@id='1']//div[@id='divarrow_undefined']")
	WebElement dropdown2;
	
	@FindBy(xpath = "//input[@id='25 years_undefined']")
	WebElement age2;
	
	@FindBy(id="ped_no")
	WebElement healthOption;
	
	@FindBy(id="ped_yes_traveller_0")
	WebElement patient;
	
	@FindBy(xpath="//button[text()='Done']")
	WebElement doneBtn;
	
	@FindBy(xpath="//button[normalize-space()='Explore Plans ›']")
	WebElement exploreBtn;

	public void clickOnTravel() {
		btnTravel.click();
	}

	public void searchClick() {
		WebElement searchClickBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("country")));
		searchClickBtn.click();
	}

	public void searchCountryList() {
		WebElement australiaOption = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//*[@id=\"search-country\"]/ul/li[text()='Australia']")));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", australiaOption);
		System.out.println("Australia option displayed: " + australiaOption.isDisplayed());
		System.out.println("Australia option enabled: " + australiaOption.isEnabled());
		wait.until(ExpectedConditions.elementToBeClickable(australiaOption));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", australiaOption);
	}

	public void startDateClick() {
		startDateSection.click();
	}

	public void clickOnStartDate() {
		wait.until(ExpectedConditions.elementToBeClickable(startDate));
		startDate.click();
	}

	public void endDateClick() {
		endDateSection.click();
	}

	public void clickOnEndDate() {
		wait.until(ExpectedConditions.elementToBeClickable(endDate));
		endDate.click();
	}

	public void clickContinue() {
		continueBtn.click();
	}

	public void selectPersons() {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("traveller_2")));
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(NoOfPersons));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		} catch (Exception e) {
			System.out.println("Error selecting number of persons: " + e.getMessage());
		}
	}

	public void Dropdown() {
		dropdown1.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", age1);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", age1);
		dropdown2.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", age2);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", age2);
	}

	public void clickOnHealthOption(){
		healthOption.click();
		//patient.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", doneBtn);
		if(doneBtn.isDisplayed()) {
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", doneBtn);
		}else {
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
			continueBtn.click();
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", doneBtn);
		}
		
	}
	
	public void explorePlans() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", exploreBtn);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", exploreBtn);
		System.out.println(exploreBtn.isDisplayed());
		wait.until(ExpectedConditions.elementToBeClickable(exploreBtn));
		exploreBtn.click();
	}
}
