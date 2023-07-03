package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	//se crea una variable local
	public WebDriver driver;
	//Constructor
	public OffersPage(WebDriver driver) 
	{
		this.driver=driver;
	}
	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//*[contains(text(),'Tomato')]");
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	//se coloca return porque el valor que debe devolver va a ser utilizado, y al regresar un valor string, se coloca public string en vez de public void
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

	

}