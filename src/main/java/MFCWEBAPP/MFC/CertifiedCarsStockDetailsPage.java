package MFCWEBAPP.MFC;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CertifiedCarsStockDetailsPage 
{
	public static void CertifiedCarsStockDetailspage(WebDriver driver) throws IOException, InterruptedException
	{
			try
			{
				driver.get(VariablesDeclaration.URL);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//select the city 
				
				driver.findElement(By.xpath(VariablesDeclaration.bengaluruCity)).click();
				//Finding buy module
				WebElement element = driver.findElement(By.id(VariablesDeclaration.buyMenu));
					 
			    Actions action = new Actions(driver);
			    //buy module - sub modules
			    action.moveToElement(element).build().perform();
			    //certified used cars
			    driver.findElement(By.xpath(VariablesDeclaration.certifiedCars)).click();	
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			    WebElement Element = driver.findElement(By.xpath(VariablesDeclaration.vehicle));
			       
			    //This will scroll the page till the element is found		
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("arguments[0].scrollIntoView();", Element);
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			    Thread.sleep(3000);
			    driver.findElement(By.xpath(VariablesDeclaration.vehicle)).click();
			    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				//getting dealer details
				//Enter the mobile number
				driver.findElement(By.id(VariablesDeclaration.stockMobileField)).sendKeys("8792095030");
				//Enter temp name into name field
				WebElement cusName = driver.findElement(By.xpath(VariablesDeclaration.stockNameField));
				cusName.sendKeys("temp");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				//explicit wait
				WebDriverWait wait = new WebDriverWait (driver, 20);
		        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(VariablesDeclaration.stockOTPField)));
				
		        //wait until the message is sent to the mail
			    Thread.sleep(150000); 
			    String OTP= FetchingEmail.fetch(VariablesDeclaration.host,VariablesDeclaration.protocol, VariablesDeclaration.username, VariablesDeclaration.password);  
			    Thread.sleep(6000);
			    
			    //send the fetched OTP to OTP field
		        driver.findElement(By.id(VariablesDeclaration.stockOTPField)).sendKeys(OTP);
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        
		        //clear the name previously entered  
		        cusName.clear();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        
		        //Enter customer name
		        cusName.sendKeys("Suchitra Test");
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        
		        //Enter customer email
		        driver.findElement(By.id(VariablesDeclaration.stockEmailField)).sendKeys(VariablesDeclaration.customerEmail);
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        
		        //get dealer details
		        driver.findElement(By.id(VariablesDeclaration.stockSubmitDetails)).click();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        
		        //wait for screenshot
		        Thread.sleep(9000);
		        
		        //Screenshot when clicking submit
		        TakesScreenshot t = (TakesScreenshot) driver;
		        File src = t.getScreenshotAs(OutputType.FILE);
		        File dest = new File("./screenshot6.png");
		        FileUtils.copyFile(src, dest);
		   
		        Thread.sleep(10000);
		        
		        //Screenshot upon getting the dealer details.
		        TakesScreenshot t1 = (TakesScreenshot) driver;
		        File src1 = t1.getScreenshotAs(OutputType.FILE);
		        File dest1 = new File("./screenshot7.png");
		        FileUtils.copyFile(src1, dest1);
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
