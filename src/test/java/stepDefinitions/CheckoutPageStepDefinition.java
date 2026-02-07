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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	
	public WebDriver driver;
	public PageObjectManager pageObjectManager;
	public CheckoutPage checkoutPage;
	//public String landingpageProductName;
	TestContextSetup testContextSetup;
	
	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage =testContextSetup.pageObjectManager.getCheckoutPage();
	}
	

	
	@Then("verify user has ability to enter promo code and place the order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() {
		
		Assert.assertTrue(checkoutPage.VerifyPromoBtn());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrderBtn());
	}
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_tom_items_in_checkout_page(String name) throws InterruptedException {
	 
		checkoutPage.CheckoutItems();
		Thread.sleep(2000);
		System.out.println("the name in checkout page is - "+checkoutPage.getProductName().subSequence(0, 3));
		Assert.assertEquals(name, checkoutPage.getProductName().subSequence(0, 3));
	}
	
	
}