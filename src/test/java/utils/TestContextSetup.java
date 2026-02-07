package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;
import stepDefinitions.Hooks;

public class TestContextSetup {
	public WebDriver driver;
	public String landingpageProductName;
	public PageObjectManager pageObjectManager;
	public TestBase testbase;
	public GenericUtils genericUtils;
//	public Hooks hooks;
	public TestContextSetup() throws IOException{
		
		testbase = new TestBase();
		pageObjectManager = new PageObjectManager(testbase.WebDriverManager());
		genericUtils = new GenericUtils(testbase.WebDriverManager());
	//	hooks = new Hooks(testbase.WebDriverManager());
		
	}
	
}
