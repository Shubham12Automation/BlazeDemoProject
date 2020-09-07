package com.blazedemo.qa.pagefactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.qa.base.TestBase;
import com.blazedemo.qa.utils.TestUtils;


public class WelcomePage extends TestBase {

	@FindBy(name = "fromPort")
	WebElement departurecity;

	@FindBy(name = "toPort")
	WebElement destinationcity;

	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement findFlights;
	
	
	public WelcomePage() throws IOException {
		PageFactory.initElements(driver, this);

	}

	// Actions

	public String validateWelocomePageTitle() {
		return driver.getTitle();
	}

	public ReservePage chooseDepartureDestinationCity() throws IOException {
		TestUtils.fn_Select(departurecity, prop.getProperty("departurecity"));
		TestUtils.fn_Select(destinationcity, prop.getProperty("destinationcity"));
		findFlights.click();
		return new ReservePage();
	}

}
