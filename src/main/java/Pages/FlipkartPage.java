package Pages;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.TestBase;

public class FlipkartPage extends TestBase{
	
	
	//Page elements
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2doB4z']")
	WebElement closeLoginForm;
	
	@FindBy(xpath="//input[@title='Search for products, brands and more']")
	WebElement searchBar;
	
	
	@FindBy(xpath="(//div[@class='lrtEPN _17d0yO']/child::span)[2]")
	WebElement dropDownOption;
	
	
	@FindBy(xpath="(//*[name()='svg'][@class='ttx38n'])[4]")
	WebElement connectivityFltr;
	
	@FindBy(xpath="(//section[@class='_167Mu3 _2hbLCH'])[4]/div/div/child::div")
	List<WebElement> connectivityDrpDwnOptions;
	
	
	@FindBy(xpath="(//div[@class='MIXNux']/div/div)[1]")
	WebElement phoneImg;
	
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	WebElement goToCartBtn;
	
	
	@FindBy(xpath="//span[normalize-space()='Place Order']")
	WebElement placeOrderBtn;
	
	@FindBy(xpath="//input[@type='text']")
	WebElement emailMobileField;
	

	
	
	//Initializing Page Objects
	
		public FlipkartPage()
		{
			PageFactory.initElements(driver, this);
		}	
		
	
	//Actions
		
	private String url="https://www.flipkart.com";
	private String email="xyz@gmail.com";
	private String mobileNum="2121231313";
		
	public void launchFlipkart()
	{
		driver.get(url);
	}
	
	public void closeLoginForm()
	{
		//This method will close the login form that appears after opening flipkart website
		closeLoginForm.click();
	}
	public void enterValueInSearchBox(String text)
	{   
		//This method will enter the text in the search box
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(searchBar));
		searchBar.sendKeys(text);
	}
	public void clickDropDownOption()
	{
		//This method will select one of the drop down items from search results
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(dropDownOption));
		dropDownOption.click();
	}
	public void clickConnectivityFilter() throws InterruptedException
	{
		//This method will click on the connectivity filter
		Thread.sleep(2000);
		connectivityFltr.click();
		
		//scroll down little so that WI-FI only check box can be visible and checked.
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)", "");
	}
	
	public void selectWiFiOnlyFilter(String filterName)
	{
		//This method will select the Wi-Fi Only option from the connectivity drop down
		connectivityDrpDwnOptions=driver.findElements(By.xpath("(//section[@class='_167Mu3 _2hbLCH'])[4]/div/div/child::div"));
		
		for(int i=0;i<connectivityDrpDwnOptions.size();i++) 
		{
			WebElement fltrName=connectivityDrpDwnOptions.get(i);
			if(fltrName.getText().equals(filterName)) 
			{
				fltrName.click();
				break;
			}
		}
	
	}
	public void clickPhoneImage()
	{
		//This method will click on one of the ipad images
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(phoneImg));
		try
		{
		phoneImg.click();
		}catch(StaleElementReferenceException e)
		{
			phoneImg=driver.findElement(By.xpath("(//div[@class='MIXNux']/div/div)[1]"));
			phoneImg.click();
		}
	}
	
	public void clickGoToCartBtn()
	{
		//This method will click on add to cart button
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(goToCartBtn));
		goToCartBtn.click();
	}
	public void clickPlaceOrderBtn()
	{
		//This method will click on place order button
		WebDriverWait wait=new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.visibilityOf(placeOrderBtn));
		placeOrderBtn.click();
	}
	
	public void switchWindow()
	{
		//This method will switch the focus from parent window to child window
		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();
        Iterator<String> iterator = allWindowHandles.iterator();

       
        while (iterator.hasNext()) 
        {
            String ChildWindow = iterator.next();
                if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) 
                {
                driver.switchTo().window(ChildWindow);
                }
	
        }  
	} 
	
	
	public String generateRamdomEmail()
	{
		//This method will generate random gmail every time when the test is run
		String randomEmail=RandomStringUtils.randomAlphabetic(8);
		String email=randomEmail+"@gmail.com";
		return email;
	}
	public String generateRamdomPhoneNumber()
	{
		//This method will generate random 10 digits phone number every time when the test is run
		String randomPhoneNum=RandomStringUtils.randomNumeric(10);
		String phoneNum=randomPhoneNum;
		return phoneNum;
	}
	public void enterRandomEmailPhoneNumber() throws InterruptedException
	{
		//This method will enter the random phone number and email in the email/mobile number field
		String emailId=generateRamdomEmail();
		Thread.sleep(5000);
		emailMobileField.sendKeys(emailId);
		Thread.sleep(5000);
		emailMobileField.clear();
		String phoneNumber=generateRamdomPhoneNumber();
		emailMobileField.sendKeys(phoneNumber);
		Thread.sleep(5000);
	}
}
