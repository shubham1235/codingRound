package code;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class HotelBookingTest {

	WebDriver driver;
// this class contain generic function 
	// also contain selenium driver so we no need to create again and again for every test class
	GenericFucntion generic = new GenericFucntion();

	@Test
	public void shouldBeAbleToSearchForHotels() {

		//set driver from GenericFunction class
		this.driver = GenericFucntion.setDriverPath();

		// create object for HotelBooking element also gave driver to that class for element 
		HotelBookingElement bookingElement = PageFactory.initElements(driver, HotelBookingElement.class);

		// this method wait 160 second for website loading if website take too much time for opening so it mean soting wrong with network
		driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);

		driver.get("https://www.cleartrip.com/");

		//click on hotel booking link
		GenericFucntion.WaitFor_visibilityOfElements(driver, bookingElement.getHotelLink());

		
		bookingElement.getHotelLink().click();

		// wail till element will be visible 
		GenericFucntion.WaitFor_visibilityOfElements(driver, bookingElement.getLocalityTextBox());

		//search hotel or location based hotel
		bookingElement.getLocalityTextBox().sendKeys("Indiranagar, Bangalore");

		GenericFucntion.waitFor(3000);

		// get all search result in drop box the we will select particular element
		bookingElement.getSearchResult().click();

		GenericFucntion.waitFor(2000);

		// get today date by system this is basic java code for date
		String timeStamp = new SimpleDateFormat("dd").format(Calendar.getInstance().getTime());

		System.out.println("hello this is " + timeStamp);

		// select date which we want to use for hotel booking(from and  to date)
		bookingElement.clickselectdate(timeStamp, "30");

		GenericFucntion.waitFor(1000);

		// select how many person want hotel
		new Select(bookingElement.getTravellerSelection()).selectByVisibleText("1 room, 2 adults");

		GenericFucntion.waitFor(1000);

		//search hotel
		bookingElement.getSearchButton().click();

		// wait 5 second for search hotel result 
		GenericFucntion.waitFor(5000);

		driver.quit();

	}

}
