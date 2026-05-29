package com.concast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getRandomNumber() {
		Random ranDom= new Random();
		int ranDomNum= ranDom.nextInt(5000);
		
		return ranDomNum;
		
	}

	public String getSystemYYYYDDMM() {
		Date dateobj= new Date();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		String date= sdf.format(dateobj);
		return date;
		
	}
	
	public String getRequiredYYYYDDMM(int days) {

SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");

Calendar cal = Calendar.getInstance(); // correct way
cal.add(Calendar.DAY_OF_MONTH,days);
String reqDate= sim.format(cal.getTime());
return reqDate;
	}}
