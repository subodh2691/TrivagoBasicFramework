package org.trivago.resources;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.trivago.resources.Reporter;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class PrePostSteps {
	
	public static WebDriver driver;
	public static WebDriverWait wait; 
   
   @Before
	public static void setUp(){
		try {
			System.out.println("Initilizing Driver...");
			System.setProperty("webdriver.chrome.driver", "ChromeDriver//chromedriver.exe");
			driver=new ChromeDriver();
			System.out.println("Initilizing Driver...");
			
			driver.manage().deleteAllCookies();
			System.out.println("Deleting cookies...");
			driver.manage().window().maximize();
			driver.get("http://room5.trivago.com");
			System.out.println("Driver Running");
			
		}
		catch(Exception e) {
			System.out.println("Exception Caught");
			e.printStackTrace();
		}
	}
   	
	@After
	public static void afterMethod()
	{     
		System.out.println("in AfterMethod");
	        driver = getDriver();
	    	driver.quit();
	        System.out.println("Closing driver");
	    }

	@After
	  public static void capture() {
			// TODO Auto-generated method stub

		System.out.println("Taking and processing Screenshot");
	        try {
		    	TakesScreenshot ts = (TakesScreenshot)driver;
		        File source = ts.getScreenshotAs(OutputType.FILE);
		        String dest = System.getProperty("user.dir") +"/ErrorScreenshots/Trivago"+new Date().getTime()+".png";
		        System.out.println(dest);
		        File destination = new File(dest);
				FileUtils.copyFile(source, destination);
		        Reporter.addScreenCaptureFromPath(dest,"Please review attached Screenshot");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        
	                     		
	 }
	  

	private static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
    
	
	public WebDriverWait getWebDriverWait(){
		return wait;
	}
}