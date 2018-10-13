package com.bankguru.user;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractPage;
import commons.AbstractTest;
import page.objects.AccessDetailObject;
import page.objects.HomePageObject;
import page.objects.LoginPageObject;
import page.objects.RegisterPageObject;
import page.ui.RegisterPageUI;

public class User_Login_Level3 extends AbstractTest {
	WebDriver driver;
	private AbstractPage abstractPage;
	private LoginPageObject loginPageObject;
	private RegisterPageObject registerPageObject;
	private AccessDetailObject accessDetailObject;
	private HomePageObject homePageObject;
	String loginPageUrl = "";
	String userID = "";
	String passWord = "";

	@Parameters("brower")
	@BeforeClass
	public void beforeClass(String browerName) {
		driver = openMultiBrower(browerName);
		abstractPage = new AbstractPage();
		abstractPage.openAnyUrl(driver, "http://demo.guru99.com/v4/");

	}

	@Test
	public void TC01_Register() {
		loginPageObject = new LoginPageObject(driver);
		loginPageUrl = loginPageObject.getLoginPageUrl();

		loginPageObject.clickHereLink();

		registerPageObject = new RegisterPageObject(driver);
		registerPageObject.senkeyToEmailTextbox("test_auto" + randomNumber() + "@gmail.com");
		registerPageObject.clickSubmitButton();

		accessDetailObject = new AccessDetailObject(driver);
		userID = accessDetailObject.getUserID();
		passWord = accessDetailObject.getPassword();

	}

	@Test
	public void TC02_Login() throws InterruptedException {
		accessDetailObject.openAnyUrl(driver, loginPageUrl);

		loginPageObject.inputUsernameTextbox(userID);
		loginPageObject.inputPasswordTextbox(passWord);
		loginPageObject.clickLoginButton();

		homePageObject = new HomePageObject(driver);
		Assert.assertTrue(homePageObject.isHomePageDisplayed());

	}

	@AfterClass
	public void afterClass() {
		abstractPage.quitBrower(driver);
	}

	private int randomNumber() {
		Random random = new Random();
		int number = random.nextInt(9999) + 1;
		return number;
	}

}
