package com.blazedemo.qa.pagefactory;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.blazedemo.qa.base.TestBase;

public class PurchasePage extends TestBase {

	@FindBy(id = "inputName")
	WebElement passengerName;
	
	@FindBy(id = "address")
	WebElement passengerAddress;
	
	@FindBy(id = "city")
	WebElement passengerCity;
	
	@FindBy(id = "state")
	WebElement passengerState;
	
	@FindBy(id = "creditCardNumber")
	WebElement passengerCCNumber;
			
	@FindBy(xpath = "//input[@type = 'submit']")
	WebElement purchaseFlights;
	
	@FindBy(xpath = "//div//p[5]//em")
	WebElement totalcost;
	
	
	public PurchasePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
	
//Actions
	
	
	public String getTotalCostonPurchasePage() {
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//p[5]//em")));
		return totalcost.getText();
	}
	
	public ConfirmationPage enterPassengerDetails() throws IOException
	{
		passengerName.sendKeys(prop.getProperty("PassengerName"));
		passengerAddress.sendKeys(prop.getProperty("PassengerAddress"));
		passengerCity.sendKeys(prop.getProperty("PassengerCity"));
		passengerState.sendKeys(prop.getProperty("PassengerState"));
		passengerCCNumber.sendKeys(prop.getProperty("PassengerCreditCardNumber"));
		purchaseFlights.click();
		
		return new ConfirmationPage();
	}

}
