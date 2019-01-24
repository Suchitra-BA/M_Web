package MFCWEBAPP.MFC;

import org.openqa.selenium.WebDriver;

public class ClearCache 
{
    public static void ClearBrowserCache(WebDriver driver) throws InterruptedException
    {
    	driver.manage().deleteAllCookies(); //delete all cookies
    	Thread.sleep(5000); //wait 5 seconds to clear cookies.
    }
}
