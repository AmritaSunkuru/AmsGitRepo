package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


//### So our architecture has two managers- 
//1. WebDriverManager() below - which will give us the driver
//2. PageObjectManager() in pageObjects package - which will take the driver from WebDriverManager() and delegates the driver to all pageobject classes
// - and this is getting initialized in TestContextSetUp() -- which helps avoids the creation of pageObjectManager objects LOC in the step definition files
public class TestBase {
	
	public WebDriver driver;
	
	
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String Url = prop.getProperty("QAUrl");
		System.out.println("Browser is "+ prop.getProperty("browser"));
		if( driver == null) {
			switch (prop.getProperty("browser").toLowerCase()) {
			case "chrome":{
				driver = new ChromeDriver();
				break;
			}
			case "firefox":{
				driver =  new FirefoxDriver();
				break;
			}
			default:{
				 throw new IllegalArgumentException("Invalid browser name: " 
                         + prop.getProperty("browser"));

			}
			}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
		//driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.get(Url);
		}
		return driver;
	}
}
