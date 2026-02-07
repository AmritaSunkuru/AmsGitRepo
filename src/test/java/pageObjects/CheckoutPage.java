package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;



public class CheckoutPage {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	By cartBag = By.xpath("//img[@alt='Cart']");
	By checkOutButton = By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]");
	By promoBtn = By.xpath("//button[contains(text(), 'Apply')]");
	By placeOrderBtn = By.xpath("//button[contains(text(), 'Place Order')]");
	By itemName = By.xpath("//p[contains(text(), 'Tomato - 1 Kg')]");

	public void CheckoutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	public Boolean VerifyPromoBtn()

	{
		return driver.findElement(promoBtn).isDisplayed();
	}

	public Boolean VerifyPlaceOrderBtn()

	{
		return driver.findElement(placeOrderBtn).isDisplayed();
	}
	public String getProductName() {
		return driver.findElement(itemName).getText();
	}



}
