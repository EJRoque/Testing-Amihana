package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import pages.Announcement_AdminPage;
import utils.ExtentReportManager;

public class Announcement_AdminTest extends BaseTest{
	@Test
	public void testOpeningAndClosingModal() {
		test = ExtentReportManager.createTest("Test Opening and Closing the Modal");
		Announcement_AdminPage announcement_AdminPage = new Announcement_AdminPage(driver);
		
		announcement_AdminPage.openPostModal();
		test.info("post modal opened");
		announcement_AdminPage.closePostModal();
		test.info("post modal closed");
		test.pass("Modal Opening and Closing test succesfully");
	}
	
	@Test
	public void testValidAnnouncementPostSubmission() {
		test = ExtentReportManager.createTest("Test Valid Announcement Post Submission");
		Announcement_AdminPage announcement_AdminPage = new Announcement_AdminPage(driver);
		
		announcement_AdminPage.openPostModal();
		test.info("post modal opened");
		announcement_AdminPage.enterTitle("This title comes from selenium");
		test.info("title entered");
		announcement_AdminPage.enterBody("This body comes from selenium. I am doing a Automation Testing");
		test.info("body entered");
		announcement_AdminPage.clickPostSubmitBtn();
		test.info("post submit button clicked");
		test.pass("Announcement Post Successfully");
	}
	
	@Test 
	public void testRequiredFieldValidation() {
		test = ExtentReportManager.createTest("Test Required Field Validation");
		Announcement_AdminPage announcement_AdminPage = new Announcement_AdminPage(driver);
		
		announcement_AdminPage.openPostModal();
		test.info("post modal opened");
		announcement_AdminPage.clickPostSubmitBtn();
		test.info("post submit button clicked");
		test.pass("Validation error appeared as expected");
	}
}
