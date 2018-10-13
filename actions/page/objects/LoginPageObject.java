package page.objects;

import org.openqa.selenium.WebDriver;


import commons.AbstractPage;
import page.ui.LoginPageUI;

public class LoginPageObject extends AbstractPage{
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getLoginPageUrl() {
		return getPageURL(driver);
	}
	
	public void inputUsernameTextbox(String username) {
		waitForControlVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		senkeysToElement(driver, LoginPageUI.USER_ID_TEXTBOX, username);
	}
	
	public void inputPasswordTextbox(String password) {
		waitForControlVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}
	
	public void clickLoginButton() {
		waitForControlVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
	}
	
	public void clickHereLink() {
		waitForControlVisible(driver, LoginPageUI.HERE_LINK);
		clickToElement(driver, LoginPageUI.HERE_LINK);
	}
	
	

}
