package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class BookingSearchPage extends BasePage{
    WebDriverWait wait;

    By hotelsNames = By.xpath("//*[contains(@class, 'sr-hotel__name')]");

    public BookingSearchPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, 10);
    }


    public ArrayList<String> getAllHotelNames() {
        ArrayList<String> hotelNames = new ArrayList<>();
        for(WebElement name: driver.findElements(hotelsNames)) {
            hotelNames.add(name.getText());
        }
        return hotelNames;
    }

    public String getHotelRate(String waitingHotelName) {
        return driver.findElement(By.xpath(String.format("//*[contains(@class, 'sr-hotel__name') and contains(text(),'%s')]/../../../../..//div[@class='bui-review-score__badge']", waitingHotelName))).getText();
    }
}