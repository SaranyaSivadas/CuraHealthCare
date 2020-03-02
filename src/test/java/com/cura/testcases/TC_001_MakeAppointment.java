package com.cura.testcases;

import org.testng.annotations.Test;

import com.cura.pageobjects.AppointmentPage;


public class TC_001_MakeAppointment extends BaseClass{
	
	@Test
	public void makeAppointment() throws InterruptedException {
		
		AppointmentPage appoint = new AppointmentPage(dr1);
		appoint.enterAppointmentDetails("Hongkong CURA Healthcare Center","No","Medicaid","January 2020", "12", "Revisit");
	}

}
