package com.bankguru.user;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.AbstractPage;

public class User01_Login_Level1 {
	WebDriver driver;
	AbstractPage abstractPage = new AbstractPage();
	String loginPageUrl;
	String userID;
	String passWord;

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		abstractPage.openAnyUrl(driver, "http://demo.guru99.com/v4/");

	}

	@Test
	public void TC01_Register() {
		loginPageUrl = abstractPage.getPageURL(driver);
		abstractPage.clickToElement(driver, "//a[text()='here']");
		abstractPage.waitForControlVisible(driver, "//input[@name='emailid']");
		abstractPage.senkeysToElement(driver, "//input[@name='emailid']", "test_auto" + randomNumber() + "@gmail.com");
		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");

		userID = abstractPage.getText(driver, "//td[text()='User ID :']/following-sibling::td");
		passWord = abstractPage.getText(driver, "//td[text()='Password :']/following-sibling::td");

	}

	@Test
	public void TC02_Login() {
		abstractPage.openAnyUrl(driver, loginPageUrl);

		//abstractPage.waitForControlVisible(driver, "//input[@name='password']");

		abstractPage.senkeysToElement(driver, "//input[@name='uid']", userID);
		abstractPage.senkeysToElement(driver, "//input[@name='password']", passWord);

		abstractPage.clickToElement(driver, "//input[@name='btnLogin']");

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