/**
 * 
 */
package code;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author shubham verma
 *
 */
public class GenericFucntion {

	public static ChromeDriver setDriverPath( ) {
	    	
		//PlatformUtil.isMac() depriciated 
	
	        if (OsValidation.isMac()) {
	        	
	            System.setProperty("webdriver.chrome.driver", "chromedriver");          
	        }
	        if (OsValidation.isWindows()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	        }
	        if (OsValidation.isUnix()) {
	            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
	        }
	        
	      // this is for (disable notification popup )
	       
	        Map<String, Object> prefs = new HashMap<String, Object>();
	        prefs.put("profile.default_content_setting_values.notifications", 1);
	        ChromeOptions options = new ChromeOptions();
	        options.setExperimentalOption("prefs", prefs);
	       
	       ChromeDriver driver = new ChromeDriver(options);	
	        
	       return driver;
	    }
	
    public static void waitFor(int durationInMilliSeconds) {
        try {
            Thread.sleep(durationInMilliSeconds);
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
    
    
    public static void WaitFor_visibilityOfElements(WebDriver driver, WebElement element) {
		(new WebDriverWait(driver, 60)).until(ExpectedConditions.visibilityOf(element));
	}
    
    public static boolean isElementPresent(WebDriver driver, By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}
}
