package com.blazedemo.qa.pagefactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.qa.base.TestBase;

public class ConfirmationPage extends TestBase {

	@FindBy(xpath = "//tbody//tr[1]//td[2]")
	WebElement id;

	@FindBy(xpath = "//tbody//tr[7]//td[2]")
	WebElement date;

	@FindBy(xpath = "//tbody//tr[3]//td[2]")
	WebElement amount;

	public ConfirmationPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String getAmountOnConfirmationPage() {
		return amount.getText();
	}

	public String getConfirmationId() {
		return id.getText();
	}

}
