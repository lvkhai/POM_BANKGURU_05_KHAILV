package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractTest {
	 WebDriver driver;

	public  WebDriver openMultiBrower(String browerName) {
		if (browerName.equals("chrome")) {
			System.getProperty("webdriver.chrome.driver", ".//resources/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().fullscreen();
		} else if (browerName.equals("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		} else {
			System.getProperty("webdriver.chrome.driver", ".//resources/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1379x768");
			driver = new ChromeDriver(options);
		}
		return driver;
	}
}
