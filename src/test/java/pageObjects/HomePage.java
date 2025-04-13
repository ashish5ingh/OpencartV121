package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	
	public HomePage(WebDriver driver){
		
		super(driver);
	}
	
	@FindBy(xpath="//span[text()='My Account']")
	WebElement myAccount_drp;
	
	@FindBy(linkText="Register")
	WebElement register_link;
	
	@FindBy(linkText="Login")
	WebElement login_link;
	
	public void click_myAccount() {
		myAccount_drp.click();
	}
	
	public void click_register() {
		register_link.click();
	}
	
	public void click_login() {
		login_link.click();
	}

}
