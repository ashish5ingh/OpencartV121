package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
	
	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		logger.info("******  Starting TC002_LoginTest *******");
		try {
		HomePage hp = new HomePage(driver);
		hp.click_myAccount();
		logger.info("Clicked on MyAccount link");
		hp.click_login();
		logger.info("Clicked on Login link");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(prop.getProperty("email"));
		lp.setPassword(prop.getProperty("password"));
		logger.info("Entered valid Login credentials");
		lp.clickLogin();
		
		logger.info("Validating MyAccount displayed");
		MyAccountPage map = new MyAccountPage(driver);
		Assert.assertTrue(map.isMyAccountPageExists(),"Login Failed..");
		} catch(Exception e) {
			Assert.fail();
		}
		logger.info("******  Finished TC002_LoginTest *******");
	}

}
