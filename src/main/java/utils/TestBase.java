package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestBase 
{
	public static WebDriver driver;
	public static  Properties prop;
	
	public TestBase()
	{
		try
		{
			prop = new Properties();
			FileInputStream fis = new FileInputStream("C:/AssignmentFlipkart/AssignmentFlipkart/src/main/java/config/config.properties");
			prop.load(fis);
		}
		catch(IOException ex)
		{
			ex.getMessage();
		}
	}
	
	
	
	public static void initialization() 
	{
		String browserName = prop.getProperty("Browser");
			
		if(browserName.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if(browserName.equals("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		
	}
	
	
	


}
