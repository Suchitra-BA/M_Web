package MFCWEBAPP.MFC;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;

public class UsedCarsPage 
{	
	public static void UserdCarsListingPage(WebDriver driver) throws Exception
	{ 
		try
		{
			Reporter.log("Testing phase 1");
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
       
       WebElement Element = driver.findElement(By.xpath(VariablesDeclaration.findEle));
       
       //This will scroll the page till the element is found		
       JavascriptExecutor js = (JavascriptExecutor) driver;
       
       js.executeScript("arguments[0].scrollIntoView();", Element);
       
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       Thread.sleep(2000);
      
       driver.findElement(By.xpath(VariablesDeclaration.findEle)).click();

       driver.findElement(By.id(VariablesDeclaration.mobileField)).sendKeys(VariablesDeclaration.customerMobile);
   
       WebElement name = driver.findElement(By.id(VariablesDeclaration.nameField));
       
       name.sendKeys("temp");
       driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       
       //wait until the message is sent to the mail
       Thread.sleep(150000);
       
       String OTP= FetchingEmail.fetch(VariablesDeclaration.host,VariablesDeclaration.protocol, VariablesDeclaration.username, VariablesDeclaration.password);
       
       Thread.sleep(6000);
       
       driver.findElement(By.id(VariablesDeclaration.OTPField)).sendKeys(OTP);
       
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       name.clear();
       name.sendKeys(VariablesDeclaration.customerName);
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       driver.findElement(By.id(VariablesDeclaration.emailfield)).sendKeys(VariablesDeclaration.customerEmail);
       
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       
       driver.findElement(By.id(VariablesDeclaration.submitDetails)).click();
       
       //wait for screenshot
       Thread.sleep(9000);
       //Screenshot when clicking submit
       TakesScreenshot t = (TakesScreenshot) driver;
       File src = t.getScreenshotAs(OutputType.FILE);
       File dest = new File("./screenshot.png");
       FileUtils.copyFile(src, dest);
       
       Thread.sleep(10000);
       //Screenshot upon getting the dealer details.
       TakesScreenshot t1 = (TakesScreenshot) driver;
       File src1 = t1.getScreenshotAs(OutputType.FILE);
       File dest1 = new File("./screenshot1.png");
       FileUtils.copyFile(src1, dest1);
       
       //verify in OMS
       
      
       

		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			ClearCache.ClearBrowserCache(driver);
		}
	}
}
