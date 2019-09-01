package steps;

import cucumber.api.java.en.Then;
import model.SearchItem;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingMainPage;
import pages.BookingSearchPage;

public class BookingSearchSteps {
    private static final String Booking_URL = "https://www.booking.com/searchresults.en-gb.html";
    private BookingSearchSteps searchPage;
    private WebDriver driver;
    private BookingMainPage bookingMainPage;
    private SearchItem searchItem;



    @cucumber.api.java.en.Given("I want Search is {string}")
    public void iWantSearchForSearchIs(String keyword) {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/webdrivers/chromedriver.exe");
        searchItem = new SearchItem(keyword);
    }

    @cucumber.api.java.en.When("I click SearchButton")
    public void iOpenSearchScrnDoesSearch() throws InterruptedException {
        driver = new ChromeDriver();
        driver.get(Booking_URL);
        bookingMainPage = new  BookingMainPage(driver);
        driver.manage().window().maximize();
        bookingMainPage.searchByKeyword(searchItem.getSearchString());
        driver.wait(3);
    }

    @cucumber.api.java.en.Then("I get bookingPage {string} is on the first page with rating {string}")
    public void iGetBookingPageIsOnTheFirstPageWithRating(String arg0, String arg1) {
        BookingSearchPage set = new BookingSearchPage(driver);
        set.findHotel();
        searchItem = new SearchItem(arg0);
        searchItem = new SearchItem(arg1);
    }
}
