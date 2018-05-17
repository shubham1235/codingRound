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
 *this class contain all element for test cases
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
	@FindBy(className = "booking ")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@FindBy(xpath = "//ul[@id='ui-id-1']/li[@class='list']/a[text()='Indiranagar, Bangalore, Karnataka, India']")
	private WebElement searchResult;

	@FindBy(xpath = "//td[@data-handler='selectDay']")
	private WebElement selectDate;

	
	// this function used for select from to ToDates  now i used current date and month end date 30, in future also working with this functionality
	public void clickselectdate(String fromDate, String Todate) {
		GenericFucntion.waitFor(2000);

		for (int i = 0; i <= driver.findElements(By.xpath("//td[@data-handler='selectDay']")).size(); i++) {
			if (fromDate.equals(driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).getText())) {

				driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(i).click();

				GenericFucntion.waitFor(2000);

				for (int j = 0; j <= driver.findElements(By.xpath("//td[@data-handler='selectDay']")).size(); j++) {
					if (Todate.equals(
							driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(j).getText())) {

						driver.findElements(By.xpath("//td[@data-handler='selectDay']")).get(j).click();

						break;
					}
				}

				break;

			}

		}
	}

	
	//get search button web element
	/**
	 * @return the searchResult
	 */
	public WebElement getSearchResult() {
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
