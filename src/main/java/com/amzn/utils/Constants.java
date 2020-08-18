package com.amzn.utils;

public class Constants {
	
	public static final String CONFIG_FILE_LOCATION = System.getProperty("user.dir")+"//src//main//java//com//amzn//config//config.properties";

	
	public static final String PROJECT_FULL_PATH = System.getProperty("user.dir");
	
	public static final String CHROME_DRIVER_PATH = PROJECT_FULL_PATH + "//drivers//chromedriver.exe";
	public static final String MOZILLA_DRIVER_PATH = PROJECT_FULL_PATH + "//drivers//geckodriver.exe";
	public static final String IE_DRIVER_PATH = PROJECT_FULL_PATH + "//drivers//IEDriverServer.exe";
	
	public static long PAGELOAD_TIMEOUT = 10;
	public static long IMPLICITLY_WAIT_10 = 10;
	public static long IMPLICITLY_WAIT_02 = 2;
	public static long IMPLICITLY_WAIT_05 = 5;
	public static long IMPLICITLY_WAIT_20 = 20;
 
}
