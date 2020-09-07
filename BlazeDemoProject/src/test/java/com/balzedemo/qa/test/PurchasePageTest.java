package com.balzedemo.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.qa.base.TestBase;
import com.blazedemo.qa.pagefactory.PurchasePage;
import com.blazedemo.qa.pagefactory.ReservePage;
import com.blazedemo.qa.pagefactory.WelcomePage;
import com.blazedemo.qa.utils.TestUtils;

public class PurchasePageTest extends TestBase{
	public PurchasePageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	public WelcomePage welcomepage;
	public ReservePage reservepage;
	public PurchasePage purchasepage;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		welcomepage = new WelcomePage();
		reservepage = welcomepage.chooseDepartureDestinationCity();
		purchasepage = reservepage.chooseFlight();
	}
	
	@Test
	public void TitleTest() {
		String str = TestUtils.validatePageTitle();
		Assert.assertEquals(str, "BlazeDemo Purchase");
	}
	
	@Test
	public void purchaseFlight() throws IOException
	{
		purchasepage.enterPassengerDetails();
	}

	@AfterMethod
	public void QuitBrowser() {
	driver.quit();

	}

}
