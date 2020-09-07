package com.balzedemo.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.qa.base.TestBase;
import com.blazedemo.qa.pagefactory.ReservePage;
import com.blazedemo.qa.pagefactory.WelcomePage;
import com.blazedemo.qa.utils.TestUtils;

public class ReservePageTest extends TestBase{
	
	public WelcomePage welcomepage;
	public ReservePage reservepage;

	public ReservePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		welcomepage = new WelcomePage();
		reservepage = welcomepage.chooseDepartureDestinationCity();
	}

	
	public void TitleTest() {
		String str = TestUtils.validatePageTitle();
		Assert.assertEquals(str, "BlazeDemo - reserve");
	}

	
	@Test
	public void reserveFlight() throws IOException
	{
		reservepage.chooseFlight();
	}
	
	@Test
	public void verifyDepartCity()
	{
		String str = reservepage.verifyDepartsCity();
		Assert.assertTrue(str.contains(prop.getProperty("departurecity")));
	}
	
	@Test
	public void verifyArrivesCity()
	{
		String str1 = reservepage.verifyArrivesCity();
		Assert.assertTrue(str1.contains(prop.getProperty("destinationcity")));
	}

	@AfterMethod
	public void QuitBrowser() {
		driver.quit();

	}
	
	
}

	
	

