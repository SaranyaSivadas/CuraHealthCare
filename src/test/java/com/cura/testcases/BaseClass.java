package com.cura.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.cura.pageobjects.HomePage;
import com.cura.pageobjects.LoginPage;
import com.cura.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	ReadConfig readconfig = new ReadConfig();
	
	public WebDriver dr1 = null;
	public String URL = readconfig.getURL();
	public String username = readconfig.getUsername();
	public String password = readconfig.getpassword();
	
	@BeforeTest
	@Parameters("browser")
	public void setUp(String browser) throws IOException {
		
		if(browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			dr1 = new ChromeDriver();
		}else if(browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			dr1 = new FirefoxDriver();
		}else if(browser.equals("ie")) {
			WebDriverManager.iedriver().setup();
			dr1 = new InternetExplorerDriver();
		}
		dr1.get(URL);
		dr1.manage().window().maximize();
		
		HomePage home = new HomePage(dr1);
		home.clickmakeAppointment();
		
		LoginPage login = new LoginPage(dr1);
		login.enterLoginDetails(username, password);
		
	}
	
	
	@AfterTest
	public void tearDown() {
		dr1.close();
	}
	
}
