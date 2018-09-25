package com.bankguru.user;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;
import page.objects.AccessDetailObject;
import page.objects.LoginPageObject;
import page.objects.RegisterPageObject;
import page.ui.RegisterPageUI;

public class User01_Login_Level2 {
	WebDriver driver;
	AbstractPage abstractPage = new AbstractPage();
	LoginPageObject loginPageObject = new LoginPageObject(driver);
	RegisterPageObject registerPageObject = new RegisterPageObject(driver);
	AccessDetailObject accessDetailObject = new AccessDetailObject(driver);
	String loginPageUrl = "";
	String userID ="";
	String passWord= "";

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		abstractPage.openAnyUrl(driver, "http://demo.guru99.com/v4/");
	}

	@Test
	public void TC01_Register() {
		loginPageUrl = loginPageObject.getLoginPageUrl();
		loginPageObject.clickHereLink();
		
		registerPageObject.senkeyToEmailTextbox("test_auto" + randomNumber() + "@gmail.com");
		registerPageObject.clickSubmitButton();
		
		userID = accessDetailObject.getUserID();
		passWord = accessDetailObject.getPassword();

	}

	@Test
	public void TC02_Login() {
		abstractPage.openAnyUrl(driver, loginPageUrl);
		
		loginPageObject.inputUsernameTextbox(userID);
		loginPageObject.inputPasswordTextbox(passWord);
		loginPageObject.clickLoginButton();
				

		Assert.assertTrue(abstractPage.isControlDisplayed(driver,
				"//marquee[text()=\"Welcome To Manager's Page of Guru99 Bank\"]"));

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
