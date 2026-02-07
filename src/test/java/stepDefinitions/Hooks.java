package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import io.cucumber.java.*;
import utils.TestContextSetup;

public class Hooks {

	public WebDriver driver;
	/*public Hooks(WebDriver driver) {
		this.driver=driver;
	}*/
	

	
	//so in our framework anytime we want to use the driver, we need to access the WebDriverManager() 
	//                                                   --> in the Test Base - so we need to create TestBase object to call the WebDriverManager()
	                                                  //-->but this object is already created in the TestContextSetup class
	      											  //-->and we have been using driver via TestcontextSetUp using dependency injection (like we did in the stepdefinition files)
	                                                 //--> so when Hooks is called (like via aftermethod() - then Hooks Constrcutor is called then TestContextSetup object is created, then testbase object is accessible, 
	                                                 //-->so now WebDriverManager() is accessible
	public TestContextSetup testContextSetup;
	public Hooks (TestContextSetup testContextSetup) { 
		this.testContextSetup = testContextSetup;     
	}
	@After
	public void AfterScenario() throws IOException {
		testContextSetup.testbase.WebDriverManager().quit();
		
	}
	/*
	@After
	public void AfterScenario() throws IOException {
		driver.quit();
		
	}
	*/
	
	//For SCREENSHOT
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws WebDriverException, IOException {
		if(scenario.isFailed()) {//we can execute this method only when scneario is failed to save memory
			File sourcePath = ((TakesScreenshot)testContextSetup.testbase.WebDriverManager()).getScreenshotAs(OutputType.FILE);
			byte[] bytefile = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(bytefile, "image/png", "image");
		}
	}
}
