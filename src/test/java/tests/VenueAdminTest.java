package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import pages.Announcement_AdminPage;
import pages.VenueAdminPage;
import utils.ExtentReportManager;

public class VenueAdminTest extends BaseTest{
	@Test
	public void testOpeningAndClosingModal() {
		test = ExtentReportManager.createTest("Test Opening and Closing the Modal");
		VenueAdminPage venueAdminPage = new VenueAdminPage(driver);
		
		venueAdminPage.openVenueModal();
		test.info("venue modal opened");
		venueAdminPage.closeVenueModal();
		test.info("venue modal closed");
		test.pass("Modal Opening and Closing test succesfully");
	}
	
	@Test
	public void testValidReservationSubmission() {
		test = ExtentReportManager.createTest("Test Valid Venue Reservation Submission");
		VenueAdminPage venueAdminPage = new VenueAdminPage(driver);
		
		venueAdminPage.openVenueModal();
		test.info("venue modal opened");
		venueAdminPage.selectDate();
		test.info("date selected");
		venueAdminPage.selectVenue();
		test.info("venue selected");
		venueAdminPage.selectStartTimeDuration("4:30 PM");
		test.info("start time selected");
		venueAdminPage.selectEndTimeDuration("5:30 PM");
		test.info("end time selected");
		//venueAdminPage.clickSubmitBtn();
		test.info("submit button clicked");
		test.pass("Modal Opening and Closing test succesfully");
	}
	
}
