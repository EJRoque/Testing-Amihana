package pages;

import java.time.Duration;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;

public class RegisterPage {
	private WebDriver driver;
	private final String registerUrl = "https://amihanawebportal.vercel.app/signup";

	@FindBy(id = "email")
	WebElement emailTextBox;
	
	@FindBy(id = "password")
	WebElement passwordTextBox;
	
	@FindBy(id="confirmPassword")
	WebElement confirmPasswordTextBox;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div/form/div[2]/div[1]/div[2]/div[1]/div/span/span")
	WebElement showPasswordBtn;
	
	@FindBy(xpath = "//button[@type='submit' and span[text()='Next']]")
	WebElement nextBtn;
	
	@FindBy(id="email_help")
	WebElement emailErrorText;
	
	@FindBy(id="password_help")
	WebElement passwordErrorText;
	
	@FindBy(id="confirmPassword_help")
	WebElement confirmPasswordErrorText;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/span[2]")
	WebElement passwordMismatchErrorText;
	
	//Onboarding
	@FindBy(xpath="//div[@id='fullName']/input")
	WebElement fullNameTextBox;
	
	@FindBy(id="phoneNumber")
	WebElement phoneNumberTextBox;
	
	@FindBy(id="age")
	WebElement ageTextBox;
	
	@FindBy(id="phase")
	WebElement phaseTextBox;
	
	@FindBy(id="block")
	WebElement blockTextBox;
	
	@FindBy(id="lot")
	WebElement lotTextBox;
	
	@FindBy(xpath="//input[@id='category']")
	WebElement categorySelectBtn;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content' and text()='Homeowner']")
	WebElement optionText;
	
	@FindBy(xpath="//button[@type='submit' and span[text()='Submit']]")
	WebElement submitBtn;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to(registerUrl);
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
		Log.info("Email entered...");
	}
	
	public boolean invalidEmailErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.visibilityOf(emailErrorText));
		return emailErrorText.isDisplayed() && 
			   emailErrorText.getText().contains("Please enter a valid email!");
	}
	
	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
		Log.info("Password entered...");
	}
	
	public void enterConfirmPassword(String confirmPassword) {
		confirmPasswordTextBox.sendKeys(confirmPassword);
		Log.info("Confirm password entered...");
	}
	
	public void clickShowPassword() {
		Log.info("Clicking show password");
		showPasswordBtn.click();
	}
	
	public boolean passwordIsRequiredErrorMessage() {
		return passwordErrorText.isDisplayed() && 
			   passwordErrorText.getText().contains("Password must be at least 8 characters!");
	}
	
	public boolean confirmPasswordIsRequiredErrorMessage() {
		return confirmPasswordErrorText.isDisplayed() && 
			   confirmPasswordErrorText.getText().contains("Please confirm your password!");
	}
	
	public boolean passwordMismatchErrorMessage() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	    wait.until(ExpectedConditions.visibilityOf(passwordMismatchErrorText));
		return passwordMismatchErrorText.isDisplayed() && 
			   passwordMismatchErrorText.getText().contains("Passwords do not match!");
	}
	
	public void clickNextBtn() {
		nextBtn.click();
		Log.info("Register button clicked...");
	}
	
	//Onboarding
	
	public void enterFullName(String fullName) {
		fullNameTextBox.sendKeys(fullName);
		Log.info("Full name entered...");
	}
	
	public void enterPhoneNumber(String phoneNumber) {
		phoneNumberTextBox.sendKeys(phoneNumber);
		Log.info("Phone number entered...");
	}
	
	public void enterAge(String age) {
		ageTextBox.sendKeys(age);
		Log.info("Age entered...");
	}
	
	public void enterPhase(String phase) {
		phaseTextBox.sendKeys(phase);
		Log.info("Phase entered...");
	}
	
	public void enterBlock(String block) {
		blockTextBox.sendKeys(block);
		Log.info("Block entered...");
	}
	
	public void enterLot(String lot) {
		lotTextBox.sendKeys(lot);
		Log.info("Lot entered...");
	}
	
	public void selectCategory() {
		categorySelectBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		optionText.click();
		Log.info("Category selected...");
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
		Log.info("Submit button clicked...");
	}
	
}
