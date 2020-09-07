package com.balzedemo.qa.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.blazedemo.qa.base.TestBase;
import com.blazedemo.qa.pagefactory.ConfirmationPage;
import com.blazedemo.qa.pagefactory.PurchasePage;
import com.blazedemo.qa.pagefactory.ReservePage;
import com.blazedemo.qa.pagefactory.WelcomePage;
import com.blazedemo.qa.utils.TestUtils;

public class ConfirmationPageTest extends TestBase {

	public WelcomePage welcomepage;
	public ReservePage reservepage;
	public PurchasePage purchasepage;
	public ConfirmationPage confirmationpage;

	public ConfirmationPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		welcomepage = new WelcomePage();
		reservepage = welcomepage.chooseDepartureDestinationCity();
		purchasepage = reservepage.chooseFlight();
		confirmationpage = purchasepage.enterPassengerDetails();

	}

	@Test
	public void TitleTest() {
		String str = TestUtils.validatePageTitle();
		Assert.assertEquals(str, "BlazeDemo Confirmation");
	}

	@Test
	public void getConfirmationId() {
		String str = confirmationpage.getConfirmationId();
		System.out.println("Confirmation ID od your booking is:" + str);
	}

	@Test
	public void verifyFinalAmountcollected() {
		String str = confirmationpage.getAmountOnConfirmationPage();
		driver.navigate().back();
		String str1 = purchasepage.getTotalCostonPurchasePage();
		Assert.assertTrue(str.contains(str1));
		System.out.println(str+ " " +str1);
	}

	@AfterMethod
	public void QuitBrowser() {
		driver.quit();

	}
}
