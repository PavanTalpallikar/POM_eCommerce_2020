package com.amzn.pages;

import org.openqa.selenium.WebDriver;

import com.amzn.base.TestBase;
import com.amzn.utils.Constants;
import com.amzn.utils.DriverUtils;

public class LoginPage extends TestBase{
	
	public static String XPATH_USERNAME = "a-input-text a-span12 auth-autofocus auth-required-field";
	public static String XPATH_CONTINUE_BUTTON = "//*[@class='a-button-input' and @type='submit']";
	public static String XPATH_PASSWORD = "//*[@id='ap_password']";
	public static String XPATH_LOGIN_BUTTON  =  "//*[@id='signInSubmit' and @class='a-button-input']";
	
	
	public LoginPage(WebDriver driver) {
		super(driver);		
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
		
	}
	
	
	public void doLogin(String username, String password) {
		
		System.out.println("In do login class");
		
		DriverUtils.navigateToURL(driver, prop.getProperty("URL"));
		waitImplicitInSeconds(Constants.IMPLICITLY_WAIT_05);
		
		findElementByXpath(XPATH_USERNAME).sendKeys(username);
		waitImplicitInSeconds(Constants.IMPLICITLY_WAIT_02);

		findElementByXpath(XPATH_CONTINUE_BUTTON).click();
		waitImplicitInSeconds(Constants.IMPLICITLY_WAIT_02);

		findElementByXpath(XPATH_PASSWORD).sendKeys(password);;
		waitImplicitInSeconds(Constants.IMPLICITLY_WAIT_02);
		
		findElementByXpath(XPATH_LOGIN_BUTTON);
		waitImplicitInSeconds(Constants.IMPLICITLY_WAIT_05);
	}

}
