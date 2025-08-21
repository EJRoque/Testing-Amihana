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
		venueAdminPage.clickSubmitBtn();
		test.info("submit button clicked");
		test.pass("Modal Opening and Closing test succesfully");
	}
	
	@Test
    public void testSubmitWithoutDate() {
        test = ExtentReportManager.createTest("Test Venue Reservation Submission Without Date");
        VenueAdminPage venueAdminPage = new VenueAdminPage(driver);

        venueAdminPage.openVenueModal();
        test.info("Venue modal opened");

        venueAdminPage.selectVenue();
        test.info("Venue selected");

        venueAdminPage.selectStartTimeDuration("4:30 PM");
        venueAdminPage.selectEndTimeDuration("5:30 PM");
        test.info("Times selected");

        venueAdminPage.clickSubmitBtn();
        test.info("Submit button clicked without selecting date");

        Assert.assertTrue(venueAdminPage.isDateValidationMessageDisplayed(), "Validation message for missing date not shown.");
        test.pass("Validation for missing date works correctly");
    }
	
	 @Test
	    public void testSubmitWithoutVenue() {
	        test = ExtentReportManager.createTest("Test Venue Reservation Submission Without Venue");
	        VenueAdminPage venueAdminPage = new VenueAdminPage(driver);

	        venueAdminPage.openVenueModal();
	        test.info("Venue modal opened");

	        venueAdminPage.selectDate();
	        test.info("Date selected");

	        venueAdminPage.selectStartTimeDuration("4:30 PM");
	        venueAdminPage.selectEndTimeDuration("5:30 PM");
	        test.info("Times selected");

	        venueAdminPage.clickSubmitBtn();
	        test.info("Submit button clicked without selecting venue");

	        Assert.assertTrue(venueAdminPage.isVenueValidationMessageDisplayed(), "Validation message for missing venue not shown.");
	        test.pass("Validation for missing venue works correctly");
	    }

	    @Test
	    public void testInvalidTimeRange() {
	        test = ExtentReportManager.createTest("Test Venue Reservation With Invalid Time Range");
	        VenueAdminPage venueAdminPage = new VenueAdminPage(driver);

	        venueAdminPage.openVenueModal();
	        test.info("Venue modal opened");

	        venueAdminPage.selectDate();
	        test.info("Date selected");
	        venueAdminPage.selectVenue();
	        test.info("Venue selected");

	        venueAdminPage.selectEndTimeDuration("5:30 PM");
	        test.info("Invalid time range selected");

	        venueAdminPage.clickSubmitBtn();
	        test.info("Submit button clicked with invalid time range");

	        Assert.assertTrue(venueAdminPage.isTimeValidationMessageDisplayed(), "Validation message for invalid time not shown.");
	        test.pass("Validation for invalid time range works correctly");
	    }
	
}
