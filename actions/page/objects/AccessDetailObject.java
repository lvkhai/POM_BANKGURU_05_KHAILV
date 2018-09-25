package page.objects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import page.ui.AccessDetailUI;

public class AccessDetailObject extends AbstractPage{
	WebDriver driver;

	public AccessDetailObject(WebDriver driver) {
		this.driver = driver;
	}
	public String getUserID() {
		waitForControlVisible(driver, AccessDetailUI.USER_ID);
		return getText(driver, AccessDetailUI.USER_ID);
	} 
	
	public String getPassword() {
		waitForControlVisible(driver, AccessDetailUI.PASSWORD);
		return getText(driver, AccessDetailUI.PASSWORD);
	} 

}
