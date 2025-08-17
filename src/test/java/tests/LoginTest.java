package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExtentReportManager;

public class LoginTest extends BaseTest{
	
	@Test
	public void testSuccessfulLogin() {
		test = ExtentReportManager.createTest("Test Successful Log in");
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmail("ernest.sample@gmail.com");
		test.info("email entered");
		loginPage.enterPassword("12121212");
		test.info("password entered");
		loginPage.clickShowPassword();
		test.info("show password button clicked");
		loginPage.clickLoginBtn();
		test.info("login button clicked");
		
		test.pass("Login Successfully");
	}
	
	@Test
	public void testWrongEmail() {
		test = ExtentReportManager.createTest("Test Wrong Email");
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.enterEmail("wrong.email@mail.com");
		test.info("email entered");
		loginPage.enterPassword("12121212");
		test.info("password entered");
		loginPage.clickShowPassword();
		test.info("show password button clicked");
		loginPage.clickLoginBtn();
		test.info("login button clicked");
		
		if (loginPage.isLoginErrorMessageDisplayed()) {
			test.pass("Login error message appeared as expected.");
		} else {
			test.fail("❌ Expected error message was not displayed.");
			Assert.fail("❌ Expected error message was not displayed.");
		}
	}
	
	@Test
	public void testWrongPassword() {
		test = ExtentReportManager.createTest("Test Wrong Password");
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterEmail("ernest.sample@gmail.com");
		test.info("email entered");
		loginPage.enterPassword("WrongPassword");
		test.info("password entered");
		loginPage.clickShowPassword();
		test.info("show password button clicked");
		loginPage.clickLoginBtn();
		test.info("login button clicked");
		
		if (loginPage.isLoginErrorMessageDisplayed()) {
			test.pass("Login error message appeared as expected.");
		} else {
			test.fail("❌ Expected error message was not displayed.");
			Assert.fail("❌ Expected error message was not displayed.");
		}
	}
	
	@Test
	public void testEmptyEmailField() {
		test = ExtentReportManager.createTest("Test Empty Email Field");
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterPassword("Test@1234");
		test.info("password entered");
		loginPage.clickShowPassword();
		test.info("show password button clicked");
		loginPage.clickLoginBtn();
		test.info("login button clicked");
		
		test.pass("Empty field validated Successfully");
	}
	
	@Test
	public void testEmptyPasswordField() {
		test = ExtentReportManager.createTest("Test Empty Password Field");
		LoginPage loginPage = new LoginPage(driver);

		loginPage.enterEmail("john.doe23@mail.com");
		test.info("email entered");
		loginPage.clickLoginBtn();
		test.info("login button clicked");
		
		test.pass("Empty field validated Successfully");
	}
}
