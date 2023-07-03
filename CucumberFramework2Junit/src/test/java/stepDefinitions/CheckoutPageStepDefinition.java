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
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
public WebDriver driver;
public String LandingPageProductName;
public String offerPageProductName;
public CheckoutPage checkoutPage;
TestContextSetup testContextSetup;

public CheckoutPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup = testContextSetup;
	this.checkoutPage= testContextSetup.pageObjectManager.getCheckoutPage();
}
	
@Then("verify user has ability to enter promo code and place the order")
public void verify_user_has_ability_to_enter_promo()
{
	
	Assert.assertTrue(checkoutPage.VerifyPromoBtn());
	Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
}

@Then("^User proceeeds to Checkout and validate the (.+) items in checkout page$")
public void User_proceeeds_to_Checkout(String name) throws InterruptedException
{
	checkoutPage.CheckoutItem();
}
	
	
}
