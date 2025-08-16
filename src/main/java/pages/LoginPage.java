package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.Log;

public class LoginPage {
private WebDriver driver;
	
	@FindBy(id = "email")
	WebElement emailTextBox;
	
	@FindBy(id = "password")
	WebElement passwordTextBox;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div/form/span/span")
	WebElement showPasswordBtn;
	
	@FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/form[1]/p[1]/a[1]")
	WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div[1]/div/div/form/button")
	WebElement loginBtn;
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div/div/span[2]")
	WebElement loginErrorMessage;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String email) {
		Log.info("Entering email address");
		emailTextBox.sendKeys(email);
	}
	
	public void enterPassword(String password) {
		Log.info("Entering password");
		passwordTextBox.sendKeys(password);
	}
	
	public void clickShowPassword() {
		Log.info("Clicking show password");
		showPasswordBtn.click();
	}
	
	public void clickLoginBtn() {
		Log.info("Clicking Log in button");
		loginBtn.click();
	}
	
	public boolean isLoginErrorMessageDisplayed() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
	    wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
	    return loginErrorMessage.isDisplayed() &&
	           loginErrorMessage.getText().contains("Invalid email or password. Please try again.");
	    
	    
	}

}
