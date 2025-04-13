package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterAccountPage extends BasePage {

	public RegisterAccountPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(name = "firstname")
	WebElement txt_firstName;

	@FindBy(name = "lastname")
	WebElement txt_lastName;

	@FindBy(name = "email")
	WebElement txt_email;

	@FindBy(name = "telephone")
	WebElement txt_telephone;

	@FindBy(name = "password")
	WebElement txt_password;

	@FindBy(name = "confirm")
	WebElement txt_confirmPassword;

	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	WebElement yes_newsletter_option;

	@FindBy(name = "agree")
	WebElement privacyPolicy_checkbox;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement continue_btn;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstname(String firstname) {

		txt_firstName.sendKeys(firstname);
	}

	public void setLastname(String lastname) {

		txt_lastName.sendKeys(lastname);
	}

	public void setEmail(String email) {

		txt_email.sendKeys(email);
	}

	public void setTelephone(String telephone) {

		txt_telephone.sendKeys(telephone);
	}

	public void setPassword(String pwd) {

		txt_password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd) {

		txt_confirmPassword.sendKeys(pwd);
	}

	public void checkPrivacyPolicy() {

		privacyPolicy_checkbox.click();
	}

	public void clickContinueBtn() {
		
		//sol1
		continue_btn.click();
		
		//sol2
		//continue_btn.submit();
		
		//sol3
		//Actions act = new Actions(driver);
		//act.moveToElement(continue_btn).click().perform();
		
		//sol4
		//JavascriptExecutor js = (JavascriptExecutor)driver;
		//js.executeScript("argument[0].click;", continue_btn);
		
		//sol5
		//continue_btn.sendKeys(Keys.ENTER);
		
		//sol6
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.elementToBeClickable(continue_btn)).click();
		
		
	}
	
	public String getConfirmationMsg() {
		
		try {
			
			return msgConfirmation.getText();
		} catch (Exception e) {
			return (e.getMessage());
		}
		
		
		
	}
	

}
