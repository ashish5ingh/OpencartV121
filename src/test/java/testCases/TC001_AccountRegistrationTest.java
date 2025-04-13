package testCases;

/*Logging- record all the events in the form of text.
 * 
 * Log levels - All<Trace<Debug<Info<Warn<Error<Fatal<Off
 * 
 * Appenders - where to generate logs (Console/File)
 * Loggers - what type of logs generate (All<Trace<Debug<Info<Warn<Error<Fatal<Off)*/

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.HomePage;
import pageObjects.RegisterAccountPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration() {

		logger.info("***** Starting TC001_AccountRegistrationTest ******"); //log4j2
		try {
			HomePage hp = new HomePage(driver);
			hp.click_myAccount();
			logger.info("Clicked on MyAccount link");
			hp.click_register();
			logger.info("Clicked on Register Link");

			RegisterAccountPage rap = new RegisterAccountPage(driver);
			logger.info("Providing customer details...");
			rap.setFirstname(randomString());
			rap.setLastname(randomString());
			rap.setEmail(randomString() + "@gmail.com"); // randomly generated the email
			rap.setTelephone(randomNumber());

			String password = randomAlphaNumeric();
			rap.setPassword(password);
			rap.setConfirmPassword(password);
			rap.checkPrivacyPolicy();
			rap.clickContinueBtn();

			logger.info("Validating expected message...");
			if(rap.getConfirmationMsg().equals("Your Account Has Been Created!")) {
				Assert.assertTrue(true);
			}
			else {
				logger.error("Test failed..");
				logger.debug("Debug logs..");
				Assert.assertTrue(false);
			}
		} catch (Exception e) {
		
			Assert.fail();
		}
		logger.info("***** Finished TC001_AccountRegistrationTest ******");
	}

}
