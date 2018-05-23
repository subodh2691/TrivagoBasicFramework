package org.trivago.resources;


import org.trivago.resources.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.io.File;
import java.io.IOException;


@CucumberOptions(
        features = {"src/test/java/org/trivago/features/"},
        glue = {"org.trivago.stepdefs"},
        plugin = {"org.trivago.resources.ExtentCucumberFormatter:test-output/TrivagoAutomationResult.html"}
)
public class TrivagoAutomationRunner extends AbstractTestNGCucumberTests {
	
	static String screenshotpath;
	
	@BeforeSuite
	public static void start(){
		System.out.println("Starting");
		
	}
	
	@BeforeMethod
	public static void beforeMethod(){
		System.out.println("Before Method");
		Reporter.setupEnv();
	}
	
	@AfterMethod
	public static void afterMethod() throws IOException{
		Reporter.tearDownEnv();
	}
	
    @AfterSuite
    public static void setup() throws IOException {
    	System.out.println("In After Suite");
        Reporter.loadXMLConfig(new File("src/main/java/org/trivago/resources/extent-config.xml"));
        Reporter.setSystemInfo("user", System.getProperty("user.name"));
        Reporter.setSystemInfo("os", "Windows 10");
        Reporter.setTestRunnerOutput("Sample test runner output message");
    }
}
