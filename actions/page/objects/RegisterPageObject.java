package page.objects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import page.ui.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void senkeyToEmailTextbox(String email) {
		waitForControlVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		senkeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void clickSubmitButton() {
		waitForControlVisible(driver, RegisterPageUI.SUBMIT_BUTTON);
		clickToElement(driver, RegisterPageUI.SUBMIT_BUTTON);
	}

}
