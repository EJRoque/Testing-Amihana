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
}
