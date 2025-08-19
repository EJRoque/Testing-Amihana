package pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Log;

public class VenueAdminPage {
	private WebDriver driver;
	private final String venueAdminUrl = "https://amihanawebportal.vercel.app/events-admin";
	
	@FindBy(xpath = "//button[normalize-space(text())='Add new']")
	WebElement newVenueBtn;
	
	@FindBy(className = "ant-modal-close")
	WebElement closeModalBtn;
	
	@FindBy(xpath = "//button[.//abbr[@aria-label='August 22, 2025']]")
	WebElement dateBtn;
	
	@FindBy(xpath = "//*[@id=\"rc_select_2\"]")
	WebElement selectVenueBtn;
	
	@FindBy(xpath = "//div[@class='ant-select-item-option-content' and text()='Basket Ball Court']")
	WebElement basketballBtn;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/form/div/div[1]/div/div/div[2]/div/div/div/div/input")
	WebElement startTimeSelectBtn;
	
	@FindBy(xpath = "/html/body/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div/div/form/div/div[2]/div/div/div[2]/div/div/div/div/input")
	WebElement endTimeSelectBtn;
	
	@FindBy(xpath = "//button[@type='button' and .//span[text()='Submit Reservation']]")
	WebElement submitBtn;
	
//	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/ul/li[2]/button")
//	WebElement okBtn;
	
	public VenueAdminPage(WebDriver driver) {
		this.driver = driver;
		driver.navigate().to(venueAdminUrl);
		PageFactory.initElements(driver, this);
	}
	
	public void openVenueModal() {
		newVenueBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Log.info("Venue modal opened...");
	}
	
	public void closeVenueModal() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		closeModalBtn.click();
		Log.info("Venue modal closed...");
	}
	
	public void selectDate() {
		dateBtn.click();
		Log.info("Date selected...");
	}
	
	public void selectVenue() {
		selectVenueBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		basketballBtn.click();
		Log.info("Venue selected...");
	}
	
	public void selectStartTimeDuration(String time) {
		startTimeSelectBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		startTimeSelectBtn.sendKeys(time, Keys.ENTER);
		Log.info("Start time duration selected...");
	}
	
	public void selectEndTimeDuration(String time) {
		endTimeSelectBtn.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		endTimeSelectBtn.sendKeys(time, Keys.ENTER);
		Log.info("End time duration selected...");
	}
	
	public void clickSubmitBtn() {
		submitBtn.click();
		Log.info("Submit button clicked...");
	}
}
