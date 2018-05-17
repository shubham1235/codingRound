package code;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FlightBookingTest {

	WebDriver driver;

	GenericFucntion generic = new GenericFucntion();

	@BeforeMethod
	public void setAllMethod() {
		this.driver = GenericFucntion.setDriverPath();

	}

	@Test
	public void testThatResultsAppearForAOneWayJourney() {

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://www.cleartrip.com/");

		
		GenericFucntion.WaitFor_visibilityOfElements(driver, driver.findElement(By.id("OneWay")));

		driver.findElement(By.id("OneWay")).click();

		driver.findElement(By.id("FromTag")).clear();

		driver.findElement(By.id("FromTag")).sendKeys("Bangalore");

		// wait for the auto complete options to appear for the origin

		GenericFucntion.waitFor(1000);
		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();

		driver.findElement(By.id("ToTag")).clear();
		driver.findElement(By.id("ToTag")).sendKeys("Delhi");

		// wait for the auto complete options to appear for the destination

		GenericFucntion.waitFor(1000);
		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();

		driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[3]/td[7]/a")).click();

		// all fields filled in. Now click on search
		driver.findElement(By.id("SearchBtn")).click();

		GenericFucntion.waitFor(1000);
		// verify that result appears for the provided journey search
		Assert.assertTrue(GenericFucntion.isElementPresent(driver ,By.className("searchSummary")));

		// close the browser
		driver.quit();

	}

	

}
