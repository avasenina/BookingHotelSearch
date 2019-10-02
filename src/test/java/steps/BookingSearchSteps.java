package steps;

import io.qameta.allure.*;
import model.SearchItem;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BookingMainPage;
import pages.BookingSearchPage;
import utils.AllureUtils;
import utils.CapabilitiesGenerator;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BookingSearchSteps {
    private static final String Booking_URL = "https://www.booking.com/searchresults.en-gb.html";
    private BookingSearchSteps searchPage;
    private WebDriver driver;
    private BookingMainPage bookingMainPage;
    private SearchItem searchItem;
    private Integer numberOfHotelInList = 0;

    @cucumber.api.java.en.Given("I want Search is {string}")

    public void iWantSearchForSearchIs(String keyword) {
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/webdriver/chromedriver.exe");
        searchItem = new SearchItem(keyword);
    }

    @cucumber.api.java.en.When("I click SearchButton")
    @Step("1.Customer openes Home page on Booking.com site")
    @Description("2.Customer clears the Enter field 3. Customer fills the Search field by Name of Hotel 4. Clicks the Search button")
    @Link("https://docs.google.com/spreadsheets/d/1WwxcFRtuEtJ0uiiwZVqMj4XHkgiBa9RX1bYzKRLDjcc/edit#gid=0")
    @Issue("Jira-1")
    @TmsLink("TestRail-bla")
    public void iOpenSearchScrnDoesSearch() throws InterruptedException {
        driver = new ChromeDriver(CapabilitiesGenerator.getChromeOptions());
        driver.get(Booking_URL);
        bookingMainPage = new  BookingMainPage(driver);
        driver.manage().window().maximize();
        bookingMainPage.searchByKeyword(searchItem.getSearchString());
        AllureUtils.takeScreenshot(driver);
    }

    @cucumber.api.java.en.Then("I get bookingPage {string} is on the first page with rating {string}")
    @Step("Comparing HotelRage with searching item")
    @Link("https://docs.google.com/spreadsheets/d/1WwxcFRtuEtJ0uiiwZVqMj4XHkgiBa9RX1bYzKRLDjcc/edit#gid=0")
    @Issue("Jira 141414")
    @TmsLink("TestRail 151515")
    public void hotelSearchResultsComparing(String waitingHotelName, String waitingHotelRate) {
        boolean requestedHotelExistsInSearchResult = false;
        numberOfHotelInList = 0;
        BookingSearchPage set = new BookingSearchPage(driver);
        List<String> hotels = set.getAllHotelNames();
        for (String hotelName : hotels) {
            System.out.println(hotelName);
            if (hotelName.equals(waitingHotelName)) {
                requestedHotelExistsInSearchResult = true;
                break;
            }
            numberOfHotelInList++;
        }
        assertTrue(requestedHotelExistsInSearchResult);

        if (requestedHotelExistsInSearchResult) {
                BookingSearchPage page = new BookingSearchPage(driver);
                String hotelRate = page.getHotelRate(waitingHotelName);
                assertEquals(hotelRate, waitingHotelRate);
            }
        driver.quit();
    }

}
