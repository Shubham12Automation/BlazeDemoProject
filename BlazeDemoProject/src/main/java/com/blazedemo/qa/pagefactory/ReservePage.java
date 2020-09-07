package com.blazedemo.qa.pagefactory;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.blazedemo.qa.base.TestBase;

public class ReservePage extends TestBase {
	
	@FindBy(xpath = "//table[@class = 'table']//th[4]")
	WebElement departsTh;
	
	@FindBy(xpath = "//table[@class = 'table']//th[5]")
	WebElement arrivesTh;
	
	@FindBy(xpath = "//tbody//tr[2]//input[@type = 'submit']")
	WebElement chooseflightbutton;
	
	@FindBy(xpath ="//tbody//tr[2]//td[2]")
	WebElement selectedflightnumber;
	
	@FindBy(xpath ="//tbody//tr[2]//td[3]")
	WebElement selectedairline;
	
	@FindBy(xpath ="//tbody//tr[2]//td[4]")
	WebElement selectedflightdepartstiming;
	
	@FindBy(xpath ="//tbody//tr[2]//td[5]")
	WebElement selectedflightarrivestiming;
	
	@FindBy(xpath ="//tbody//tr[2]//td[6]")
	WebElement selectedflightprice;
	
	public ReservePage() throws IOException {
		PageFactory.initElements(driver, this);
	}

//Actions
	
	public String verifyDepartsCity()
	{
		
		return departsTh.getText();
	}
	
	public String verifyArrivesCity()
	{
		return arrivesTh.getText();
	}
	
	public PurchasePage chooseFlight() throws IOException
	{
		chooseflightbutton.click();
		return new PurchasePage();
	}

	

}
