package stepDefinitions;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.*;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	//public String landingpageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage =testContextSetup.pageObjectManager.getLandingPage();
	}
	@Given("User is on Greenkart Landing page")
	public void user_is_on_greenkart_landing_page() {
		//System.setProperty("webdriver.chrome.driver",""));
		//testContextSetup.driver = new ChromeDriver();
		//testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		Assert.assertTrue(landingPage.getTitle().contains("GreenKart"));
		
	}
	@When("^User searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		//PageObjectManager pageObjectManager = new PageObjectManager(testContextSetup.driver);
		
		//LandingPage landingPage = new LandingPage(testContextSetup.driver);
		//LandingPage landingPage =testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortName);
		
		Thread.sleep(2000);
		
	//	testContextSetup.landingpageProductName = testContextSetup.driver.findElement(By.xpath("//h4[@class='product-name']")).getText().split("-")[0].trim();
		testContextSetup.landingpageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingpageProductName);
		Assert.assertTrue(testContextSetup.landingpageProductName.contains(shortName));
		/*replaced below code with Assert above
		 * if(testContextSetup.landingpageProductName.equalsIgnoreCase("Tomato"))
		 * System.out.println("PASSED - Shortname-"+shortName+" matched the FullName -"
		 * +testContextSetup.landingpageProductName+ "of the vegetable"); else
		 * System.out.println("FAILED");
		 */
	}
	@When("^Added (.+) items to the selected product to the cart$")
	public void added_items_to_the_selected_product_to_the_cart(String quantity) {
		landingPage.IncrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
}