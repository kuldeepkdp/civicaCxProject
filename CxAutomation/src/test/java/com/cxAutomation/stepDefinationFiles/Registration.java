package com.cxAutomation.stepDefinationFiles;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cxAutomation.baseFunction.CommonFunction;
import com.cxAutomation.baseFunction.Selenium;
import com.cxAutomation.pages.ContactPage;
import com.cxAutomation.pages.RegistrationPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class Registration {
	
	//changes related to data table

	public Selenium sel;
	public WebDriver driver;

	public Registration(Selenium sel) {
		this.sel = sel;
		this.driver = sel.getDriver();
	}

	@Given("^I click on registration link$")
	public void i_click_on_registration_link() throws Throwable {

		driver.findElement(RegistrationPage.registerlink).click();

	}

	@And("^I click on Submit button$")
	public void i_click_on_Submit_button() throws Throwable {

		driver.findElement(RegistrationPage.submit).click();

	}

	@Then("^I got success message \"([^\"]*)\"$")
	public void i_got_success_message(String msg) throws Throwable {

		CommonFunction.waitFor(5000);
		String actulavalidation = driver.findElement(ContactPage.validationMessage).getText();

		Assert.assertEquals("Checking mandatory success msg", msg, actulavalidation);
	}

	@Given("^i login as \"([^\"]*)\" using passowrd \"([^\"]*)\"$")
	public void i_login_as_using_passowrd(String userName, String password) throws Throwable {

		String Id = CommonFunction.GetData(userName);
		String pwd = CommonFunction.GetData(password);

		/*
		 * driver.findElement(By.xpath("//*[@id='userName']")).sendKeys(Id);
		 * driver.findElement(By.xpath("//*[@id='password']")).sendKeys(pwd);
		 * driver.findElement(By.xpath("//*[@id='signIn']")).click();
		 */

		System.out.println("user logged in using username -> " + Id + "and password -> " + pwd);
	}

	@Given("^i am on registration page$")
	public void i_am_on_registration_page() throws Throwable {

		driver.findElement(RegistrationPage.registerlink).click();

	}
	
	@Given("^i fill the registration form$")
	public void i_fill_the_registration_form(DataTable table) throws Throwable {
		
		List<List<String>> data= table.raw();
		
		driver.findElement(RegistrationPage.fname).sendKeys(data.get(1).get(0));
		driver.findElement(RegistrationPage.lname).sendKeys(data.get(1).get(1));
		driver.findElement(RegistrationPage.mstatus).click();
		driver.findElement(RegistrationPage.hobby).click();
		driver.findElement(RegistrationPage.country).click();
		driver.findElement(RegistrationPage.dm).click();
		driver.findElement(RegistrationPage.dd).click();
		driver.findElement(RegistrationPage.dy).click();
		driver.findElement(RegistrationPage.ph).sendKeys(data.get(1).get(2));
		driver.findElement(RegistrationPage.uname).sendKeys(CommonFunction.generateString(8));
		driver.findElement(RegistrationPage.email).sendKeys(CommonFunction.generateString(6)+"@gmail.com");
		driver.findElement(RegistrationPage.about).sendKeys(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry’s standard dummy text ");
		driver.findElement(RegistrationPage.pw).sendKeys(data.get(1).get(3));
		driver.findElement(RegistrationPage.cpw).sendKeys(data.get(1).get(4));
	
	}
	
	@Given("^i fill the registration form using ([^\"]*)$")
	public void i_fill_the_registration_form_using(String email) throws Throwable {

		
		driver.findElement(RegistrationPage.fname).sendKeys("Tapi");
		driver.findElement(RegistrationPage.lname).sendKeys("Kumari");
		driver.findElement(RegistrationPage.mstatus).click();
		driver.findElement(RegistrationPage.hobby).click();
		driver.findElement(RegistrationPage.country).click();
		driver.findElement(RegistrationPage.dm).click();
		driver.findElement(RegistrationPage.dd).click();
		driver.findElement(RegistrationPage.dy).click();
		driver.findElement(RegistrationPage.ph).sendKeys("8271675498");
		driver.findElement(RegistrationPage.uname).sendKeys(CommonFunction.generateString(8));
		driver.findElement(RegistrationPage.email).sendKeys(email);
		driver.findElement(RegistrationPage.about).sendKeys(
				"Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry’s standard dummy text ");
		driver.findElement(RegistrationPage.pw).sendKeys("password123");
		driver.findElement(RegistrationPage.cpw).sendKeys("password123");

	}

	@Then("^I got registration success message$")
	public void i_got_registration_success_message() throws Throwable {
		String expectedValidation="Thank you for your registration";
	    Thread.sleep(5000);
		String actualvalidation= driver.findElement(By.xpath("//*[@id='post-49']/div/p")).getText();
		Assert.assertEquals(actualvalidation, expectedValidation);
	}

	
	@Then("^I got validation error stating email already exists$")
	public void i_got_validation_error_stating_email_already_exists() throws Throwable {
       
		String expectedValidation="Error: E-mail address already exists";
	    Thread.sleep(5000);
		String actualvalidation= driver.findElement(By.xpath("//*[@id='post-49']/div/p")).getText();
		Assert.assertEquals(actualvalidation, expectedValidation);
	}
}
