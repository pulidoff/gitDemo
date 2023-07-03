package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	//Constructor
	public LandingPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	By search = By.xpath("//input[@type='search']");
	By topDeals = By.xpath("//*[contains(text(), 'Top Deals')]");
	By productName = By.xpath("//h4[@class='product-name']");
	By increment = By.xpath("//a[@class='increment']");
	By addToCart = By.xpath("//div/button[contains(text(),'ADD TO CART')]");
	
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	//se coloca return porque el valor que debe devolver va a ser utilizado, y al regresar un valor string, se coloca public string en vez de public void
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}
	
	public void incrementQuantity(int quantity)
	{
		int i = quantity-1;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}

	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}

	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
}
