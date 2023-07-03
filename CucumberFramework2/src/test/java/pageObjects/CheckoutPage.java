package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	public WebDriver driver;
	//Constructor
	public CheckoutPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	By cartBag = By.xpath("//img[@alt='Cart']");
	By checkOutButton = By.xpath("//*[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn = By.xpath("//button[contains(text(),'Apply')]");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	
	
	public void CheckoutItem()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	}
	
	public Boolean VerifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
		
	}
	
	public Boolean VerifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
		
	}
	
	

}
