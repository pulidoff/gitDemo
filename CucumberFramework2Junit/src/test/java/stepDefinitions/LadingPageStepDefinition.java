package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LadingPageStepDefinition {
public WebDriver driver;
public String LandingPageProductName;
public String offerPageProductName;
TestContextSetup testContextSetup;
LandingPage landingPage;

//este es el constructor
public LadingPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup = testContextSetup;
	//este es un objeto, al colocar "this" se le asigna a la variable global LandingPage
	this.landingPage= testContextSetup.pageObjectManager.getLandingPage();
}
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
	    
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
		
	}
	@When("^user searched with Shortname (.+) and extracted actual name of the product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
		
		landingPage.searchItem(shortName);
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    Thread.sleep(2000);
	    testContextSetup.LandingPageProductName = landingPage.getProductName().split("-")[0].trim();
	    System.out.println(testContextSetup.LandingPageProductName);    
	}
	@When("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	
}
