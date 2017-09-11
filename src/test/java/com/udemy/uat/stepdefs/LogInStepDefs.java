package com.udemy.uat.stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.udemy.uat.pages.HomePage;
import com.udemy.uat.utilities.ConfigurationReader;
import com.udemy.uat.utilities.Driver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LogInStepDefs {
	WebDriver driver = Driver.getInstance();
	HomePage homePage=new HomePage();
	
	@Given("^User is on udemy homepage$")
	public void user_is_on_udemy_homepage() throws Throwable {
		Driver.getInstance().get(ConfigurationReader.getProperty("url"));
	    Driver.getInstance().manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);

	}

	@When("^User click log in button$")
	public void user_click_log_in_button() throws Throwable {
	   homePage.logInButton.click();
	}

	@When("^Provide a valid email and password$")
	public void provide_a_valid_email_and_password() throws Throwable {
		
		homePage.emailId.sendKeys("hasasnhusss@gmail.com");
		homePage.password.sendKeys("password1234");
	
	}

	@When("^Click log in button$")
	public void click_log_in_button() throws Throwable {
		homePage.submitButton.click();
	}

	@Then("^User should be able to log in successfully$")
	public void user_should_be_able_to_log_in_successfully() throws Throwable {
		WebDriverWait wait=new WebDriverWait(Driver.getInstance(), 20);
	    wait.until(ExpectedConditions.visibilityOf(homePage.fullName));
	    Assert.assertEquals(homePage.fullName.getText(), "Hasan Huseyin");
	}
}
