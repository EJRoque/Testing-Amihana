package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import pages.Announcement_AdminPage;
import pages.BalanceSheetPage;
import utils.ExtentReportManager;

public class BalanceSheetTest extends BaseTest{
	@Test
	public void testOpeningAndClosingModal() {
		test = ExtentReportManager.createTest("Test Opening and Closing the Modal");
		BalanceSheetPage balanceSheetPage = new BalanceSheetPage(driver);
		
		balanceSheetPage.openAddNewYearModal();
		test.info("venue modal opened");
		balanceSheetPage.closeAddNewYearModal();
		test.info("venue modal closed");
		test.pass("Modal Opening and Closing test succesfully");
	}
	
	@Test
	public void testCreatingNewBalanceSheet() {
		test = ExtentReportManager.createTest("Test Creating New Balance Sheet");
		BalanceSheetPage balanceSheetPage = new BalanceSheetPage(driver);
		
		balanceSheetPage.enterNewYear(2040);
		test.info("New year entered");
		balanceSheetPage.clickEditButton();
		test.info("Edit button clicked");
		balanceSheetPage.clickAddNewUserButton();
		test.info("New users added");
		balanceSheetPage.clickAdjustAmountButton("200", "200", "200", "400");
		test.info("Monthly amount adjusted");
		balanceSheetPage.clickSaveButton();
		test.info("Save button clicked");
		test.pass("New balance sheet created succesfully");
	}
}
