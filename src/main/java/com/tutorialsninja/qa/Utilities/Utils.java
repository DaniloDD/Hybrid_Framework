package com.tutorialsninja.qa.Utilities;

import java.util.Date;

public class Utils {
	
	public static final int IMPLICIT_WAIT = 60;
	public static final int PAGELOAD_TIMEOUT = 60;
	public static final int SCRIPT_TIMEOUT = 200;
	
	public static String emailWithDateStamp() {
		Date date = new Date();
		String currentDate =  date.toString().replace(" ", "_").replace(":", "_");
		String emailTimeStemp = "seleniumpanda_" + currentDate + "@gmail.com";
		return emailTimeStemp;
	}
}
