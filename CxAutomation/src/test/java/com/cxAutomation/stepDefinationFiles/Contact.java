package com.cxAutomation.stepDefinationFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cxAutomation.baseFunction.CommonFunction;
import com.cxAutomation.baseFunction.Selenium;
import com.cxAutomation.pages.ContactPage;
import com.cxAutomation.pages.RegistrationPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;


public class Contact {

	public Selenium sel;
	public WebDriver driver;

	public Contact(Selenium sel) {
		this.sel = sel;
		this.driver = sel.getDriver();
	}

	@Given("^I click on contact link$")
	public void i_click_on_contact_link() throws Throwable {

		driver.findElement(ContactPage.contactLink).click();
	}

	@Given("^I click on Send button$")
	public void i_click_on_Send_button() throws Throwable {

		driver.findElement(ContactPage.send).click();

	}

	@Then("^I got validation error message$")
	public void i_got_validation_error_message() throws Throwable {
		String expectedValidation = "Validation errors occurred. Please confirm the fields and submit it again.";
		Thread.sleep(5000);
		String actulavalidation = driver.findElement(ContactPage.validationMessage).getText();

		Assert.assertEquals("Checking mandatory field validation", expectedValidation, actulavalidation);

	}

	@Given("^I fill the contact form$")
	public void i_fill_the_contact_form() throws Throwable {
		driver.findElement(ContactPage.name).sendKeys("Kuldeep Kumar");
		driver.findElement(ContactPage.email).sendKeys("kuldeepkumar@gmail.com");
		driver.findElement(ContactPage.subject).sendKeys("Test Subject");
		driver.findElement(ContactPage.message).sendKeys("Test message");

	}
	
	@Then("^I got validation error message for mandatory fields$")
	public void i_got_validation_error_message_for_mandatory_fields() throws Throwable {
		String actualvalidation= driver.findElement(RegistrationPage.requiredField).getText();
		Assert.assertEquals("Checking mandatory field validation", "* This field is require", actualvalidation);
	}
	

}
