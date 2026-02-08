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
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

	public WebDriver driver;
	public String offerspageProductName;
	TestContextSetup testContextSetup;
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Then("^User searched for (.+) shortname in offers page to check if product exists$")
	public void user_searched_for_some_shortname_in_offers_page_to_check_if_product_exists(String shortName) throws InterruptedException {
		
		//PageObjectManager pageObjectManager = new PageObjectManager(testContextSetup.driver); 
		//OffersPage offersPage = new OffersPage(testContextSetup.driver);
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		
		//testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.clickTopDeals();
		switchToOffersPage();
		
		//testContextSetup.driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(shortName);
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		//offerspageProductName = testContextSetup.driver.findElement(By.xpath("//tbody//tr//td[1]")).getText();
		offerspageProductName = offersPage.getProductName();
		//testContextSetup.driver.close();
	//	testContextSetup.driver.quit();
	}
	public void switchToOffersPage() {
		//if(!(testContextSetup.driver.getCurrentUrl().contains("rahulshettyacademy.com/seleniumPractise/#/offers")))
	//	{
			testContextSetup.genericUtils.SwitchWindowToChild();
			//Set<String> windowHandles = testContextSetup.driver.getWindowHandles();
			//Iterator<String> i1 =windowHandles.iterator();
			//String parentWindow = i1.next();
			//String childWindow = i1.next();
			//testContextSetup.driver.switchTo().window(childWindow);
		//}
	}
	@Then("Validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		System.out.println("offerspageProductName --> "+offerspageProductName);
		System.out.println("landingpageProductName --> "+testContextSetup.landingpageProductName);

		Assert.assertEquals(testContextSetup.landingpageProductName,offerspageProductName);
	}
}
