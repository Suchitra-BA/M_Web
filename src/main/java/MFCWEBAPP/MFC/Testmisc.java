package MFCWEBAPP.MFC;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Testmisc
{
	static
	{
		System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
	}
	public static void main(String[] args) throws Exception 
	{
		WebDriver driver = new FirefoxDriver();
		
		//get stage page
		driver.get(VariablesDeclaration.URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		//get city
		driver.findElement(By.xpath(VariablesDeclaration.bengaluruCity)).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Finding buy module
		WebElement element = driver.findElement(By.id(VariablesDeclaration.buyMenu));	 
	    Actions action = new Actions(driver);
	    //buy module - sub modules
	    action.moveToElement(element).build().perform();
	    
	    //all used cars
	    driver.findElement(By.xpath(VariablesDeclaration.usedCars)).click();	
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    //selecting the first car displayed
	    WebElement Element = driver.findElement(By.xpath(VariablesDeclaration.vehicle));
	       
	       //This will scroll the page till the element is found		
	       JavascriptExecutor js = (JavascriptExecutor) driver;
	       js.executeScript("arguments[0].scrollIntoView();", Element);
	       
	       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      Thread.sleep(3000);
	       driver.findElement(By.xpath(VariablesDeclaration.vehicle)).click();
		
	}
}
