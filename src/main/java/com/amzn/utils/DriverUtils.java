package com.amzn.utils;

import org.openqa.selenium.WebDriver;

public class DriverUtils {
	
	
	public static void navigateToURL(WebDriver driver, String URL) {
		driver.navigate().to(URL);
		
	}
	

}
