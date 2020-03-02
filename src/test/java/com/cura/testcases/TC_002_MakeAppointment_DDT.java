package com.cura.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cura.pageobjects.AppointmentConfirmationPage;
import com.cura.pageobjects.AppointmentPage;
import com.cura.utilities.XLUtils;


public class TC_002_MakeAppointment_DDT extends BaseClass{
	
	@Test(dataProvider = "requestdetails")
	public void makeAppointment(String facility,String readmission, String healthcarepgm, String month, String day, String comment) throws InterruptedException{
		AppointmentPage appoint = new AppointmentPage(dr1);
		appoint.enterAppointmentDetails(facility, readmission, healthcarepgm, month, day, comment);
		
		AppointmentConfirmationPage back = new AppointmentConfirmationPage(dr1);
		back.backHome();
		Thread.sleep(3000);
	}
	
	@DataProvider(name="requestdetails")
	public String[][] getData() throws IOException {
		
		String path = System.getProperty("user.dir")+"/src/test/java/com/cura/testdata/Cura_MakeAppointment_DDT.xlsx";
		
		XLUtils.setExcelFile(path, "Sheet1");
		int rownum = XLUtils.getRowCount();
		int colnum = XLUtils.getCellCount();
		
		System.out.println(rownum);
		System.out.println(colnum);
		
		String a[][] = new String[rownum][colnum];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colnum;j++) {
				a[i-1][j]=XLUtils.getCellData(i,j);
			}
			System.out.println(" ");
		}
		System.out.println(a);
		return a;
	}
	
	

}
