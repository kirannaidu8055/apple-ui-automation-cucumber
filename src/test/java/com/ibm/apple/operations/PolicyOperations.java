package com.ibm.apple.operations;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.ibm.apple.operations.xpaths.PolicyXpaths.*;

public class PolicyOperations {
	WebDriverWait wait;
	Select select;
	WebElement element;
	Actions actions;
	public static Properties prop = new Properties();

	public WebElement clickOnPolicyTabFromLandingPage(WebDriver driver) throws IOException {
		element = driver.findElement(By.xpath(POLICY_TAB));
		element.click();
		return element;
	}

	public WebElement clickOnAddPolicyButton(WebDriver driver) {
		driver.switchTo().frame("Content");
		element = driver.findElement(By.xpath(ADD_POLICY_BUTTON));
		element.click();
		return element;
	}

	public WebElement inputPolicyNameInNameTab(WebDriver driver, String policyName) {
		String input = POLICY_NAME_FIELD;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(input)));
		driver.findElement(By.xpath(input)).click();
		driver.findElement(By.xpath(input)).sendKeys(policyName);
		return element;
	}
	

	public WebElement selectPolicyType(WebDriver driver, String type) {
		element = driver.findElement(By.xpath(POLICY_TYPE));
		select = new Select(element);
		select.selectByVisibleText(type);
		return element;
	}

	public WebElement selectPolicyStartFrom(WebDriver driver, String startFrom) {
		element = driver.findElement(By.xpath(POLICY_START_FROM));
		select = new Select(element);
		select.selectByVisibleText(startFrom);
		return element;
	}

	public WebElement clickOnContinueButton(WebDriver driver) {
		element = driver.findElement(By.xpath(CONTINUE_BUTTON));
		element.click();
		return element;
	}

	public String validatePayloadsPage(WebDriver driver) {
		String input = POLICY_NAME_ASSERTION;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(input)));
		String visiblePolicyName = driver.findElement(By.xpath(input)).getText();
		return visiblePolicyName;
	}

	public WebElement clickOnDeviceSettingsTab(WebDriver driver) {
		String input = DEVICE_SETTINGS_TAB;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(input)));
		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(DEVICE_SETTINGS_TAB))).click().perform();
		return element;
	}

	public WebElement configurePasscodePayload(WebDriver driver) {
		actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(PASSCODE_PAYLOAD_TAB))).click().perform();
		actions.moveToElement(driver.findElement(By.xpath(EDIT_BUTTON))).click().perform();
		actions.moveToElement(driver.findElement(By.xpath(CONFIGURE_PASSCODE_POLICY_CHECKBOX))).click().perform();
		element = driver.findElement(By.xpath(ENFORCE_PASSCODE_ON_MOBILE_DEVICE_CHECKBOX));
		actions.moveToElement(element).click().perform();
		return element;
	}

	public String clickOnNextButton(WebDriver driver) throws InterruptedException {

		actions = new Actions(driver);
		element = driver.findElement(By.xpath(NEXT_BUTTON));
		String buttonName = element.getText();
		actions.moveToElement(element).click().perform();
		Thread.sleep(2000);
		element = driver.findElement(By.xpath(NEXT_BUTTON));
		actions.moveToElement(element).click().perform();
		return buttonName;
	}

	public WebElement clickOnPublishButton(WebDriver driver) throws IOException {
		loadProperties();
		actions.moveToElement(driver.findElement(By.xpath(PUBLISH_BUTTON))).click().perform();
		String input = CONFIRM_BUTTON;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(input)));
		actions.moveToElement(driver.findElement(By.xpath(input))).click().perform();
		input = PASSWORD;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(input)));
		driver.findElement(By.xpath(input)).click();
		driver.findElement(By.xpath(input)).sendKeys(prop.getProperty("password"));
		actions.moveToElement(driver.findElement(By.xpath(CONFIRM_BUTTON))).click().perform();
		return element;
	}
	

	public WebElement checkIfPolicyIsPublished(WebDriver driver) {
		String input = CHECK_PUBLISH;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(input)));
		return element;
	}
	
	private void loadProperties() throws IOException {
		InputStream inStream = null;
		inStream = new FileInputStream("env.properties");
		prop.load(inStream);
	}

}
