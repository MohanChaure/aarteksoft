package com.aartek.aartek.util;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormat {
	public static String getYYYYMMDDDate() {
		/* java.util.Date dt = new java.util.Date(); */
		Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date today = Calendar.getInstance().getTime();
		String reportDate = formatter.format(today);
		System.out.println("Report Date: " + reportDate);
		return reportDate;
	}
}
