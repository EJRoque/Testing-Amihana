package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;

public class BalanceSheetPage {
	private WebDriver driver;
	private final String balanceSheetAdminUrl = "https://amihanawebportal.vercel.app/balance-sheet-admin";
	
	@FindBy(xpath = "//button//span[text()='Add new']")
	WebElement addNewYearBtn;
	
	@FindBy(id = "year")
	WebElement yearTextBox;
	
	@FindBy(className = "ant-modal-close-x")
	WebElement closeModalBtn;
//	
//	@FindBy(xpath = "")
//	WebElement
//	
//	@FindBy(xpath = "")
//	WebElement
//	
//	@FindBy(xpath = "")
//	WebElement
//	
//	@FindBy(xpath = "")
//	WebElement
//	@FindBy(xpath = "")
//	WebElement
	
	public BalanceSheetPage(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to(balanceSheetAdminUrl);
		PageFactory.initElements(driver, this);
	}
	
	public void openAddNewYearModal() {
		addNewYearBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Log.info("Venue modal opened...");
	}
	
	public void closeAddNewYearModal() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		closeModalBtn.click();
		Log.info("Venue modal closed...");
	}
	
	public void enterNewYear(String year) {
		addNewYearBtn.click();
		yearTextBox.sendKeys(year, Keys.ENTER);
	}
}
