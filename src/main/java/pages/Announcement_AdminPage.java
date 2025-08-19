package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class Announcement_AdminPage {
	private WebDriver driver;
	private final String annoucementAdminUrl = "https://amihanawebportal.vercel.app/announcement-admin";
	
	@FindBy(xpath = "//button[@type='button' and .//span[text()='Post']]")
	WebElement postBtn;
	
	@FindBy(xpath = "//button[@type='button' and @aria-label='Close']")
	WebElement closePostBtn;
	
	@FindBy(id = "title")
	WebElement titleTextBox;
	
	@FindBy(className = "ql-editor")
	WebElement bodyTextBox;
	
	@FindBy(xpath = "//span[text()='Post Announcement']/parent::button")
	WebElement postSubmitBtn;
	
	public Announcement_AdminPage(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to(annoucementAdminUrl);
		PageFactory.initElements(driver, this);
	}
	
	public void openPostModal() {
		postBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Log.info("Post modal opened...");
	}
	
	public void closePostModal() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		closePostBtn.click();
		Log.info("Post modal closed...");
	}
	
	public void enterTitle(String title) {
		titleTextBox.sendKeys(title);
		Log.info("Title entered");
	}
	
	public void enterBody(String body) {
		bodyTextBox.sendKeys(body);
		Log.info("Body entered");	
	}
	
	public void clickPostSubmitBtn() {
		postSubmitBtn.click();
		Log.info("Post submit button clicked");	
	}
}
