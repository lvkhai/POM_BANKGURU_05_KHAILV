package page.objects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import page.ui.HomePageUI;

public class HomePageObject extends AbstractPage{

	WebDriver driver;
	public HomePageObject() {}
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isHomePageDisplayed() {
		waitForControlVisible(driver, HomePageUI.WELCOME_MESSAGES);
		return isControlDisplayed(driver, HomePageUI.WELCOME_MESSAGES);
		
		
	}
	
}
