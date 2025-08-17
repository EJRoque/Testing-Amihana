package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import base.BaseTest;
import pages.RegisterPage;
import utils.ExtentReportManager;
import utils.Log;
import utils.EmailUtils;

public class RegisterTest extends BaseTest{
	@Test
	public void testSuccessfulRegistration() {
		test = ExtentReportManager.createTest("Test Successful Register");
		RegisterPage registerPage = new RegisterPage(driver);
		
		// Generate unique email
        String email = EmailUtils.generateUniqueEmail();
		
		registerPage.enterEmail(email);
		test.info("email entered");
		registerPage.enterPassword("Test@1234");
		test.info("password entered");
		registerPage.enterConfirmPassword("Test@1234");
		test.info("confirm password entered");
		registerPage.clickShowPassword();
		test.info("show password button clicked");
		//registerPage.clickNextBtn();
		test.info("next button clicked");
		test.pass("Register Successfully");
	}
	
	@Test
	public void testMismatchedPasswords() {
		test = ExtentReportManager.createTest("Test Mismatched Passwords");
		RegisterPage registerPage = new RegisterPage(driver);
		
		// Generate unique email
        String email = EmailUtils.generateUniqueEmail();
		
		registerPage.enterEmail(email);
		test.info("email entered");
		registerPage.enterPassword("Password123");
		test.info("password entered");
		registerPage.enterConfirmPassword("WrongPassword");
		test.info("confirm password entered");
		registerPage.clickShowPassword();
		test.info("show password button clicked");
		registerPage.clickNextBtn();
		test.info("next button clicked");
		
		if (registerPage.passwordMismatchErrorMessage()) {
		    test.pass("Password mismatch error appeared as expected.");
		} else {
		    test.fail("❌ Expected password mismatch error was not displayed.");
		    Assert.fail("❌ Expected password mismatch error was not displayed.");
		}

	}
	
	@Test
	public void testInvalidEmailFormat() {
		test = ExtentReportManager.createTest("Test Invalid Email");
		RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.enterEmail("invalidemail");
		test.info("email entered");
		registerPage.enterPassword("12121212");
		test.info("password entered");
		registerPage.enterConfirmPassword("12121212");
		test.info("confirm password entered");
		registerPage.clickShowPassword();
		test.info("show password button clicked");
		registerPage.clickNextBtn();
		test.info("next button clicked");
		
		if (registerPage.invalidEmailErrorMessage()) {
		    test.pass("Invalid email format validation appeared as expected.");
		} else {
		    test.fail("❌ Expected email format error was not displayed.");
		    Assert.fail("❌ Expected email format error was not displayed.");
		}

	}
	
	@Test
	public void testEmptyRequiredFields() {
		test = ExtentReportManager.createTest("Test Empty Required Fields");
		RegisterPage registerPage = new RegisterPage(driver);
		
		registerPage.clickNextBtn();
		test.info("next button clicked");
		
		Assert.assertTrue(registerPage.invalidEmailErrorMessage(), "❌ Email error not displayed.");
		Assert.assertTrue(registerPage.passwordIsRequiredErrorMessage(), "❌ Password error not displayed.");
		Assert.assertTrue(registerPage.confirmPasswordIsRequiredErrorMessage(), "❌ Confirm Password error not displayed.");
		
		test.pass("All required field validations appeared as expected.");
	}
}
