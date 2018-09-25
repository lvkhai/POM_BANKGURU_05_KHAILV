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
	public AbstractPage abstractPage;
	public LoginPageObject loginPageObject;
	public RegisterPageObject registerPageObject;
	public AccessDetailObject accessDetailObject;
	String loginPageUrl = "";
	String userID ="";
	String passWord= "";

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		abstractPage = new AbstractPage();
		abstractPage.openAnyUrl(driver, "http://demo.guru99.com/v4/");
		
	}

	@Test
	public void TC01_Register() {
		loginPageObject = new LoginPageObject(driver);
		loginPageUrl = loginPageObject.getLoginPageUrl();
		System.out.println(loginPageUrl);
		loginPageObject.clickHereLink();
		System.out.println(123);

		
		registerPageObject = new RegisterPageObject(driver);
		registerPageObject.senkeyToEmailTextbox("test_auto" + randomNumber() + "@gmail.com");
		registerPageObject.clickSubmitButton();
		
		accessDetailObject = new AccessDetailObject(driver);
		userID = accessDetailObject.getUserID();
		passWord = accessDetailObject.getPassword();

	}

	
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
