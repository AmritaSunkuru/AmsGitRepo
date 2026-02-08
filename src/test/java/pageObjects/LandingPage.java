package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


//Using By locators (MOST COMMON & FLEXIBLE)
//------------------------------------------
public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By search =By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4[@class='product-name']");
	By topDealsLimk = By.linkText("Top Deals");
	By incrementSign =By.xpath("//a[@class='increment']");
	By addToCartBtn =By.xpath("//button[text()='ADD TO CART']");
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String getSearchText(String name) {
		return driver.findElement(search).getText();
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public void  clickTopDeals() {
		driver.findElement(topDealsLimk).click();
	}
	public String getTitle() {
		return driver.getTitle();
	}
	
	public void IncrementQuantity(int quantity) {
		for(int i = 0 ; i< (quantity-1); i++) {
			driver.findElement(incrementSign).click();
		}
	}
	public void addToCart() {
		driver.findElement(addToCartBtn).click();
	}
}
