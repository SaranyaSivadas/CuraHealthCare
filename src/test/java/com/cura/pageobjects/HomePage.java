package com.cura.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver dr1;
	
	public HomePage (WebDriver dr1){
		
		this.dr1= dr1;
		PageFactory.initElements(dr1, this);
	}
	
	@FindBy(id="btn-make-appointment")
	WebElement btnMakeAppointment; 
	
	public void clickmakeAppointment() {
		btnMakeAppointment.click();
	}

}
