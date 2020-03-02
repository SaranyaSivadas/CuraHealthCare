package com.cura.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver dr1;
	
	public LoginPage(WebDriver dr1){
		this.dr1=dr1;
		PageFactory.initElements(dr1, this);
	}
	
	@FindBy(id = "txt-username")
	WebElement txtboxUsername;
	
	@FindBy(id ="txt-password")
	WebElement txtboxPassword;
	
	@FindBy(id="btn-login")
	WebElement btnLogin;
	
	public void enterLoginDetails(String username, String password) {
		txtboxUsername.sendKeys(username);
		txtboxPassword.sendKeys(password);
		btnLogin.click();
	}
	
}
