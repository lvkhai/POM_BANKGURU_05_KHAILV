package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractPage {

	// Brower

	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageURL(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToNextPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void quitBrower(WebDriver driver) {
		driver.quit();
	}

	// WebElement
	public void clickToElement(WebDriver driver, String locator) {
		driver.findElement(By.xpath(locator)).click();
	}

	public void senkeysToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);
	}

	public void pressKeyForElement(WebDriver driver, String locator, Keys keyname) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.sendKeys(element, keyname);
	}

	public void selectItemInDropDown(WebDriver driver, String locator, String text) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(text);
	}

	public void selectCustomDropdown(WebDriver driver, String dropdown, String listItem, String Value)
			throws Exception {
		WebElement dropdownElement = driver.findElement(By.xpath(dropdown));
		WebDriverWait wait = new WebDriverWait(driver, 30);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownElement);
		dropdownElement.click();
		List<WebElement> allItems = driver.findElements(By.xpath(listItem));
		wait.until(ExpectedConditions.visibilityOfAllElements(allItems));
		for (WebElement item : allItems) {
			if (item.getText().equals(Value)) {
				// scroll to item
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", item);
				item.isDisplayed();
				item.click();
				Thread.sleep(2000);
				break;
			}
		}
	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attributeName);
	}

	public String getText(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public int getSizeElement(WebDriver driver, String locator) {
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		return elements.size();
	}

	public void checkToChecbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckToChecbox(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	// Alert
	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dissmisAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public String getTextToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void senKeyToAlert(WebDriver driver, String text) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}

	// Windows
	public void switchToWindowByUDID(WebDriver driver, String parentUDID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentUDID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String currentWindow = driver.getTitle();
			if (currentWindow.equals(title)) {
				break;
			}
		}
	}

	public void closeToWindow(WebDriver driver, String UDID) {
		Set<String> allWindow = driver.getWindowHandles();
		for (String runWindow : allWindow) {
			if (!runWindow.equals(UDID)) {
				driver.switchTo().window(runWindow);
				driver.close();
			}
		}
		driver.switchTo().window(UDID);
	}

	public void switchToIframe(WebDriver driver, String locator) {
		driver.switchTo().frame(locator);
	}

	// User Actions

	public void doubleClickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}

	public void drapAndDropElement(WebDriver driver, String source, String target) {
		WebElement startPoint = driver.findElement(By.xpath(source));
		WebElement endPoint = driver.findElement(By.xpath(target));
		Actions action = new Actions(driver);
		action.dragAndDrop(startPoint, endPoint).perform();
	}

	// Upload
	public void uploadFile(WebDriver driver, String fileName) {
		String proDir = System.getProperty("user.dir");
		String filePath = proDir + "/resources/" + fileName;
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		element.sendKeys(filePath);
	}

	public void upLoadMultiFile(WebDriver driver, String[] fileNames) {
		String proDir = System.getProperty("user.dir");
		WebElement element = driver.findElement(By.xpath("//input[@type='file']"));
		for (String string : fileNames) {
			String filePath = proDir + "/resources/" + string;
			element.sendKeys(filePath);
		}
	}

	// JavascriptExcutor

	public void openByJS(WebDriver driver, String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location =" + url + ";");
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement element = driver.findElement(By.xpath(locator));
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollToButtonPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].removeAttribute('" + attribute + "');", element);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// Wait

	public void waitForControlPresence(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlClickable(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
	}

	public void waitForControlInvisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}

	public void waitForControlAlertPresence(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
	}

}
