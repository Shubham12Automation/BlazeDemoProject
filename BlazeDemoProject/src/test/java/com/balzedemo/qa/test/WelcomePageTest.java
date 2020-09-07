package com.balzedemo.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.qa.base.TestBase;
import com.blazedemo.qa.pagefactory.WelcomePage;
import com.blazedemo.qa.utils.TestUtils;

public class WelcomePageTest extends TestBase {

	public WelcomePage welcomepage;

	public WelcomePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void SetUp() throws IOException {
		initialization();
		welcomepage = new WelcomePage();
	}

	@Test
	public void TitleTest() {
		String str = TestUtils.validatePageTitle();
		Assert.assertEquals(str, "BlazeDemo");
	}

	@Test
	public void SelectCities() throws InterruptedException, IOException {
		welcomepage.chooseDepartureDestinationCity();

	}

	@AfterMethod
	public void QuitBrowser() {
		driver.quit();

	}

}
