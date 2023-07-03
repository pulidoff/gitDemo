package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

public String offerPageProductName;
TestContextSetup testContextSetup;
PageObjectManager pageObjectManager;

public OfferPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup = testContextSetup;
}
	   
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
		switchToOffersPage();
		OffersPage offersPage = testContextSetup.pageObjectManager.getOffersPage();
		offersPage.searchItem(shortName);
		Thread.sleep(4000);
		offerPageProductName = offersPage.getProductName();
		System.out.println(offerPageProductName);		
	}
	
	public void switchToOffersPage()
	{
		
		LandingPage landingPage= testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.SwitchWindowToChild();
		
	}
	
	
	@Then("validate product name in offers page matches with Landing Page")
	public void validate_product_in_offers_page() 
	{
		Assert.assertEquals(offerPageProductName,testContextSetup.LandingPageProductName);
		
	}

}
