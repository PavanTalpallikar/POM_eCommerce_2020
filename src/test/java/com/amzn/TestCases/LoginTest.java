package com.amzn.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.amzn.base.TestBase;
import com.amzn.pages.LoginPage;
import com.amzn.utils.CommonUtils;


public class LoginTest extends TestBase{
	

	LoginPage loginPage;
	
	/*public LoginTest(WebDriver driver) {
		super(driver);
	
		// TODO Auto-generated constructor stub
	}*/



	
	
	@BeforeMethod
	//@Parameters({"browser"})
	public void fnInit() {
		System.out.println("Inside Login Test Init");		
		initBrowser();
		loginPage = new LoginPage(driver);
	

	}
	
	
	@Test(enabled=true)
	public void loginTestNew() {
		loginPage.doLogin(CommonUtils.getProperty("username"), CommonUtils.getProperty("password"));
	}
	
	

}
