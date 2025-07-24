package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class travelInsurance extends BasePage{
	public travelInsurance(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//i[@class='icon-bg homeIconsBg icon-bg-new ti']")
	WebElement btnTravel;
	
	@FindBy(id="country")
	WebElement searchClickBtn;
	
	@FindBy(xpath="//input[@id='countryMobile']")
	WebElement searchCountry;
	
	@FindBy(xpath="//*[@id=\"search-country\"]/ul/li[14]")
	WebElement ClickOnListBox;
	
	
	
	public void clickOnTravel(){
		btnTravel.click();
	}
	
	public void searchClick() {
		searchClickBtn.click();
	}
	
	public void searchCountry(String country) {
		searchClickBtn.sendKeys(country);	
	}
	
	public void searchClickOnList() {
		ClickOnListBox.click();
	}


}
