/**
 * 
 */
package code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author shubham verma
 *
 */
public class HotelBookingElement {
	
	WebDriver driver;	
	public HotelBookingElement(WebDriver driver) {
		this.driver = driver;
	 
		}

		@FindBy(xpath = "//li[@class='hotelApp ']")
		private WebElement hotelLink;

		@FindBy(id = "Tags")
		private WebElement localityTextBox;
		@FindBy(id = "SearchHotelsButton")
		private WebElement searchButton;

		@FindBy(id = "travellersOnhome")
		private WebElement travellerSelection;
		
		
		@FindBy(xpath = "//ul[@class='autoComplete']")
		private By searchResult;
		
		
		/**
		 * @return the searchResult
		 */
		public By getSearchResult() {
			return searchResult;
		}

		/**
		 * @return the hotelLink
		 */
		public WebElement getHotelLink() {
			return hotelLink;
		}

		/**
		 * @return the localityTextBox
		 */
		public WebElement getLocalityTextBox() {
			return localityTextBox;
		}

		/**
		 * @return the searchButton
		 */
		public WebElement getSearchButton() {
			return searchButton;
		}

		/**
		 * @return the travellerSelection
		 */
		public WebElement getTravellerSelection() {
			return travellerSelection;
		}


}
