package MFCWEBAPP.MFC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MainClass 
{
	static
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
	}
	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = new FirefoxDriver();
		
		//Used Cars page-- Listing Page
		UsedCarsPage.UserdCarsListingPage(driver);
		
		Thread.sleep(2000);
		//Certified cars page-- Listing Page
		CertifiedCarsPage.CertifiedListingPage(driver);
		
		Thread.sleep(2000);
		//Used Cars page-- Stock details page
		UsedCarsStockDetailspPage.UsedCarsStockDetailspage(driver);
		
		Thread.sleep(2000);
		//Certified cars page--Stock details page
		CertifiedCarsStockDetailsPage.CertifiedCarsStockDetailspage(driver);
	}

}
