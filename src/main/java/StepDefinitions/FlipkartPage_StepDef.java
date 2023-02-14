package StepDefinitions;


import org.openqa.selenium.StaleElementReferenceException;

import Pages.FlipkartPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestBase;

public class FlipkartPage_StepDef extends TestBase {
	
	
	@Before
	public void initializeDriver()
	{
		TestBase.initialization();
	}
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	
	
	
	@Given("^user opens the flipkart page$")
	public void user_opens_the_flipkart_page() 
	{
		//TestBase.initialization();
		FlipkartPage flipkartPge = new FlipkartPage();
	    flipkartPge.launchFlipkart();
	    flipkartPge.closeLoginForm();
		
	 }
	@Then("^user types \"([^\"]*)\" in the search box$")
	public void user_types_in_the_search_box(String text)
	{
		FlipkartPage flipkartPge = new FlipkartPage();
		flipkartPge.enterValueInSearchBox(text);
	}
	@When("^suggestions are displayed select one of them$")
	public void suggestions_are_displayed_select_one_of_them() 
	{
		FlipkartPage flipkartPge = new FlipkartPage();
		flipkartPge.clickDropDownOption();
		
	}
	@Then("^on results page filter all results by the \"([^\"]*)\" filter$")
	public void on_results_page_filter_all_results_by_the_filter(String option) throws InterruptedException
	{
		FlipkartPage flipkartPge = new FlipkartPage();
		flipkartPge.clickConnectivityFilter();
		flipkartPge.selectWiFiOnlyFilter(option);
		
	}
	@Then("^select one of the results$")
	public void select_one_of_the_results()
	{
		
		FlipkartPage flipkartPge = new FlipkartPage();
		flipkartPge.clickPhoneImage();
		
		
	}
	@Then("^Checkout the order$")
	public void Checkout_the_order()
	{
		FlipkartPage flipkartPge = new FlipkartPage();
		flipkartPge.switchWindow();
		flipkartPge.clickGoToCartBtn();
		
	}
	@Then("^Place the order$")
	public void Place_the_order()
	{
		FlipkartPage flipkartPge = new FlipkartPage();
		flipkartPge.clickPlaceOrderBtn();
		
	}
	
	@Then("^Enter Random Email and Phone number$")
	public void Enter_Random_Email_and_Phone_number() throws InterruptedException
	{
		FlipkartPage flipkartPge = new FlipkartPage();
		flipkartPge.enterRandomEmailPhoneNumber();
		
	}

}
