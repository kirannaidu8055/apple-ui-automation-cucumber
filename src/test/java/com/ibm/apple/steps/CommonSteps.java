package com.ibm.apple.steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static com.ibm.apple.operations.xpaths.CommonXpaths.*;

public class CommonSteps {
	public WebDriver driver;
	public static Properties prop = new Properties();
	private static final String MY_ALERT_CENTER = "My Alert Center";
	private static final Logger LOGGER = LogManager.getLogger(CommonSteps.class.getName());

	@Before
	public void setup() throws IOException {
		
		loadDriverOptions();
		loginToPortal();
	}

	@After
	public void tearDown() {
		LOGGER.info("------------------END-------------------");
		driver.quit();
	}

	private void loadDriverOptions() {
		// Load the login page
		System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
	}

	private void loginToPortal() throws IOException {
		// Open Portal
		loadProperties();
		driver.navigate().to(prop.getProperty("instance.url"));
		driver.manage().window().maximize();

		// Login Username
		WebElement element = driver.findElement(By.id(USERNAME));
		element.click();
		element.sendKeys(prop.getProperty("customer.id"));
		driver.findElement(By.id("submit")).click();

		// Password
		element = driver.findElement(By.xpath(PASSWORD));
		element.click();
		element.sendKeys(prop.getProperty("password"));
		driver.findElement(By.id("submit")).click();

		// Login Success Assertion
		driver.switchTo().frame("Content");
		String validateText = driver.findElement(By.xpath(VALIDATE_LOGIN)).getText();
		driver.switchTo().defaultContent();
		Assert.assertEquals(validateText, MY_ALERT_CENTER);
	}

	public void loadProperties() throws IOException {
		InputStream inStream = new FileInputStream("env.properties");
		prop.load(inStream);
	}

	public WebDriver getDriver() {
		return driver;
	}

}
