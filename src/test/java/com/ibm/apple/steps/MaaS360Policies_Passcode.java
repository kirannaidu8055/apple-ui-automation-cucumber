package com.ibm.apple.steps;

import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ibm.apple.operations.PolicyOperations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MaaS360Policies_Passcode {

	 private static final Logger LOGGER = LogManager.getLogger(MaaS360Policies_Passcode.class.getName());
	 String log4jConfPath = "log4j.properties";
	 WebElement element;
	public MaaS360Policies_Passcode(CommonSteps commonSteps) {

		this.driver = commonSteps.getDriver();
	}

	WebDriver driver;
	String policyName;
	PolicyOperations policyOperations = new PolicyOperations();

	@Given("I have the Passcode Policy Name")
	public void i_have_the_passcode_policy_name() {
		PropertyConfigurator.configure(log4jConfPath);
		policyName = "Passcode_Policy_" + System.nanoTime();
		LOGGER.info("Policy Name : "+policyName);
	}

	@When("I click on Policy Tab")
	public void i_click_on_policy_tab() throws IOException {
		element = policyOperations.clickOnPolicyTabFromLandingPage(driver);
		Assert.assertTrue(element.isDisplayed());
		LOGGER.info("Policy Tab Is Displayed");
	}

	@When("I click on the Add Policy Button")
	public void i_click_on_the_add_policy_button() {
		element = policyOperations.clickOnAddPolicyButton(driver);
		LOGGER.info("Add Policy Button Is Displayed");
	}

	@When("I give policy name")
	public void i_give_policy_name() throws InterruptedException {
		element = policyOperations.inputPolicyNameInNameTab(driver, policyName);
		Assert.assertTrue(element.isDisplayed());
		LOGGER.info("Policy Name Is Given");
	}

	@When("I select the type")
	public void i_select_the_type() {
		element = policyOperations.selectPolicyType(driver, "iOS MDM");
		LOGGER.info("Policy Type Is Displayed in Dropped Down");
	}

	@When("I select start from")
	public void i_select_start_from() {
		element = policyOperations.selectPolicyStartFrom(driver, "My Existing Policies");
		LOGGER.info("Start From Is displayed in Dropped Down");
	}

	@When("I click on continue")
	public void i_click_on_continue() {
		element = policyOperations.clickOnContinueButton(driver);
		LOGGER.info("Continue Button Is Clicked");
	}

	@When("I will get payloads page")
	public void i_will_get_payloads_page() {
		String policyNameReturned = policyOperations.validatePayloadsPage(driver);
		Assert.assertEquals(policyNameReturned, policyName);
		LOGGER.info("Payloads Page Is Visible");
	}

	@When("I click on Device Settings tab")
	public void i_click_on_device_settings_tab() {
		element = policyOperations.clickOnDeviceSettingsTab(driver);
		Assert.assertTrue(element.isDisplayed());
		LOGGER.info("Device Settings Is Visible");
	}

	@When("I configure Passcode Settings")
	public void i_configure_passcode_settings() {
		element = policyOperations.configurePasscodePayload(driver);
		Assert.assertTrue(element.isDisplayed());
		LOGGER.info("Passcode Settings Configuration Is Completed");

	}

	@When("I click Next")
	public void i_click_next() throws InterruptedException {
		String buttonNameReturned = policyOperations.clickOnNextButton(driver);
		Assert.assertEquals("Next",buttonNameReturned);
		LOGGER.info("Next Button Is Clicked");
	}

	@When("I click on Publish")
	public void i_click_on_publish() throws IOException {
		element = policyOperations.clickOnPublishButton(driver);
		Assert.assertTrue(element.isDisplayed());
		LOGGER.info("Publish Button Is Clicked");

	}

	@Then("I will see the policy version as one.")
	public void i_will_see_the_policy_version_as_one() {
		element = policyOperations.checkIfPolicyIsPublished(driver);
		Assert.assertTrue(element.isDisplayed());
		LOGGER.info("Published Status Is Visible");

	}

}
