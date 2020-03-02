package com.cura.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AppointmentPage {
	
	WebDriver dr1;
	//String month = "December 2019";
	//String day ="11";
	
	public AppointmentPage(WebDriver dr1){
		this.dr1= dr1;
		PageFactory.initElements(dr1, this);
	}
	
	@FindBy(id="combo_facility")
	WebElement cmboxFacility;
	
	@FindBy(id="chk_hospotal_readmission")
	WebElement chkboxReadmission;
	
	@FindBy(xpath ="//*[@id=\"appointment\"]/div/div/form/div[3]/div/label/input")
	List<WebElement> radiobtnMedicaid;
	
	@FindBy(id="txt_visit_date")
	WebElement calendarVisitDate;
	
	@FindBy(id="txt_comment")
	WebElement txtboxComment;
	
	@FindBy(id="btn-book-appointment")
	WebElement btnBookAppointment;
	
	public void enterAppointmentDetails(String facility, String readmission, String healthcarepgm, String month, String day, String comment) throws InterruptedException {
		Select dropdown = new Select(cmboxFacility);
		dropdown.selectByValue(facility);
		//chkboxReadmission.click();
		
		if(readmission.equals("Yes")) {
			chkboxReadmission.click();
		}
		
		//radiobtnMedicaid.click();
		//System.out.println(radiobtnMedicaid.get(0).getAttribute("value"));
		//System.out.println(radiobtnMedicaid.get(1).getAttribute("value"));
		//System.out.println(radiobtnMedicaid.get(2).getAttribute("value"));
	
		if (healthcarepgm.equals(radiobtnMedicaid.get(0).getAttribute("value"))) {
			radiobtnMedicaid.get(0).click();
		}else if(healthcarepgm.equals(radiobtnMedicaid.get(1).getAttribute("value"))) {
			radiobtnMedicaid.get(1).click();
		}else {
			radiobtnMedicaid.get(2).click();
		}
		
		//calendarVisitDate.sendKeys("12/12/2019");
		selectDate(month, day);
		
		Thread.sleep(2000);
		txtboxComment.sendKeys(comment);
		btnBookAppointment.click();
	}
	
	public void selectDate(String month, String day) throws InterruptedException {
		calendarVisitDate.click();
		while(true) {
		String text = dr1.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[2]")).getText();
		if(text.equals(month)) {
			break;
		}else {
			dr1.findElement(By.xpath("/html/body/div/div[1]/table/thead/tr[2]/th[3]")).click();
		}
		}
		dr1.findElement(By.xpath("/html/body/div/div[1]/table/tbody/tr/td[contains(text(),"+day+")]")).click();
	}

}
