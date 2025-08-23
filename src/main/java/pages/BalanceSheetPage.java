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
	
	@FindBy(xpath = "//button//span[text()='View Amount']")
	WebElement viewAmountBtn;
	
	@FindBy(xpath = "//button[img[@alt='Close Icon']]")
	WebElement viewAmountCloseBtn;
	
	@FindBy(xpath = "//button[@type='button' and span[text()='Edit']]")
	WebElement editBtn;
	
	@FindBy(xpath = "//button[@type='button' and span[normalize-space()='Add New User']]")
	WebElement addNewUserBtn;
	
	@FindBy(xpath = "//div[@class='ant-transfer-list-header']//input[@type='checkbox']")
	WebElement selectAllUser;
	
	@FindBy(xpath = "//button[@type='button']//span[@aria-label='right']")
	WebElement transferUser;
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Add Users']")
	WebElement addUsersBtn;
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Adjust Amount']")
	WebElement adjustAmountBtn;
	
	@FindBy(xpath = "//label[text()='Jan']/following-sibling::input[@type='number']")
	WebElement janNumberBox;
	
	@FindBy(xpath = "//label[text()='Feb']/following-sibling::input[@type='number']")
	WebElement febNumberBox;
	
	@FindBy(xpath = "//label[text()='Mar']/following-sibling::input[@type='number']")
	WebElement marNumberBox;
	
	@FindBy(xpath = "//label[text()='HOA Membership']/following-sibling::input[@type='number']")
	WebElement hoaNumberBox;
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Save Monthly Amounts']")
	WebElement saveMonthlyAmountBtn;
	
	@FindBy(xpath = "//button[@type='button']//span[text()='Save']")
	WebElement saveBtn;
	
//	@FindBy(xpath = "")
//	WebElement
	
//	@FindBy(xpath = "")
//	WebElement
	
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
	
	public void enterNewYear(int year) {
		addNewYearBtn.click();
		yearTextBox.clear();
		yearTextBox.sendKeys(String.valueOf(year + 1), Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		Log.info("New year entered...");
	}
	
	public void clickEditButton() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		editBtn.click();
		Log.info("Edit button clicked...");
	}
	
	public void clickAddNewUserButton() {
		addNewUserBtn.click();
		selectAllUser.click();
		transferUser.click();
		addUsersBtn.click();
		Log.info("Add new users button clicked...");
	}
	
	public void clickAdjustAmountButton(String jan, String feb, String mar, String hoa) {
		adjustAmountBtn.click();
		janNumberBox.sendKeys(jan);
		febNumberBox.sendKeys(feb);
		marNumberBox.sendKeys(mar);
		hoaNumberBox.sendKeys(hoa);
		saveMonthlyAmountBtn.click();
		Log.info("Monthly amount adjusted...");
	}
	
	public void clickSaveButton() {
		saveBtn.click();
		Log.info("Save button clicked...");
	}
}
