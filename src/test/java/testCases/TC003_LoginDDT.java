package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="DataDriven") // getting data provider form different class
																				
	public void verify_loginDDT(String email, String pwd, String exp) {
		
		logger.info("***** Starting TC_003_LoginDDT *****");
		
		try {
		// HomePage
		HomePage hp = new HomePage(driver);
		hp.click_myAccount();
		hp.click_login();

		// Login
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();

		// MyAccount
		MyAccountPage map = new MyAccountPage(driver);
		boolean targetPage = map.isMyAccountPageExists();

		/*
		 * Data is valid - login success - test pass - logout - login failed -test fail
		 * 
		 * Data is invalid - login success - test fail - logout - login failed - test
		 * pass
		 */

		if (exp.equalsIgnoreCase("Valid")) {

			if (targetPage == true) {

				map.clickLogout();
				Assert.assertTrue(true);

			} else {
				Assert.assertTrue(false);
			}
		}

		else if (exp.equalsIgnoreCase("Invalid")) {

			if (targetPage == true) {

				map.clickLogout();
				Assert.assertTrue(false);

			} else {
				Assert.assertTrue(true);
			}

		}
		} catch(Exception e) {
			Assert.fail();
		}
		
		logger.info("***** Finished TC_003_LoginDDT *****");
  
	}

}
