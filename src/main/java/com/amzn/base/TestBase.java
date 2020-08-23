/*In this framework we are making only 1 parent class which is extended by all page as well as test classes. 
* This is not the best approach.  We should ideally create 1 basePage class which is extended by all pages and there should be a 
* driver base which should be extended by all test class to initiate driver and open browser. 
*/

package com.amzn.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.amzn.utils.Constants;
import com.amzn.utils.Report;

public class TestBase {

	public WebDriver driver;
	public static  Properties prop;
	
	public TestBase() {
	}

	public TestBase(WebDriver driver) {
		this.driver=driver;
	}

	
	
	public void initBrowser() {
		
		prop = new Properties();
		
		try {
		FileInputStream fis = new FileInputStream(Constants.CONFIG_FILE_LOCATION);
		prop.load(fis);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		String browserName;
		
		//if(browser.isEmpty() || browser==null) {
			browserName = prop.getProperty("browser");
//		} else {
//			browserName=browser;
//		}

			if(browserName.equalsIgnoreCase("chrome")) {
				Report.info("Bowser is chrome");
				ChromeOptions cOptions = new ChromeOptions();
				cOptions.addArguments("--disable-notifications");
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
				driver = new ChromeDriver(cOptions);
				
			} else if (browserName.equalsIgnoreCase("mozilla")) {
				
				System.setProperty("webdriver.gecko.driver", Constants.MOZILLA_DRIVER_PATH);
				driver = new FirefoxDriver();
				
			} else {
				
				System.setProperty("webdriver.ie.driver", Constants.IE_DRIVER_PATH);
				driver = new InternetExplorerDriver();
			}	
			
			
			
			//return driver;
			
			
		
	}
	
	
	public WebElement findElementByXpath(String xpathOfPageObject) {
		return driver.findElement(By.xpath(xpathOfPageObject));
	}
	
	
	public void waitImplicitInSeconds(long waitInSeconds) {
		driver.manage().timeouts().implicitlyWait(waitInSeconds, TimeUnit.SECONDS);	
	}
	
	
	public void waitAsThreadSleepInMilliSeconds(long waitInMilliSeconds) throws InterruptedException {
		Thread.sleep(waitInMilliSeconds);	
	}
	
	public void pageLoadTimeOutInSeconds(long waitInSeconds) {
		driver.manage().timeouts().pageLoadTimeout(waitInSeconds, TimeUnit.SECONDS);
	}
	
	public void waitExplicitUntilVisibilityOfElement(String xpathOfPageObject) {
		WebDriverWait expWait = new WebDriverWait(driver,30);
		expWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathOfPageObject)));
	}
	
	
}
