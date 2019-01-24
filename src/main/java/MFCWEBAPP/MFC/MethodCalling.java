package MFCWEBAPP.MFC;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class MethodCalling 
{
	static
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
	}
	static WebDriver driver = new FirefoxDriver();
	
	@Test
	public static void method1() throws Exception
	{
		//Used Cars page-- Listing Page
		UsedCarsPage.UserdCarsListingPage(driver);
		Thread.sleep(2000);
	}			
	@Test
	public static void method2() throws Exception
	{
		//Certified cars page-- Listing Page
		CertifiedCarsPage.CertifiedListingPage(driver);
		Thread.sleep(2000);
	}			
	@Test
	public static void method3() throws Exception
	{
		//Used Cars page-- Stock details page
		UsedCarsStockDetailspPage.UsedCarsStockDetailspage(driver);
		Thread.sleep(2000);
	}			
	@Test
	public static void method4() throws Exception
	{
		//Certified cars page--Stock details page
		CertifiedCarsStockDetailsPage.CertifiedCarsStockDetailspage(driver);
		Thread.sleep(2000);
	}			
	
}
