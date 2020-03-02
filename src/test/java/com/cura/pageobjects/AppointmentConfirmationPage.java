package com.cura.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentConfirmationPage {
	
	WebDriver dr1;
	
	public AppointmentConfirmationPage(WebDriver dr1) {
		this.dr1= dr1;
		PageFactory.initElements(dr1, this);
	}
	
	@FindBy(xpath ="//*[@id=\"summary\"]/div/div/div[7]/p/a")
	WebElement goToHomePage;
	
	public void backHome() {
		goToHomePage.click();
	}

}
