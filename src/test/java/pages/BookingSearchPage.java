package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Collections;
import java.util.List;


public class BookingSearchPage extends BasePage{
    public BookingSearchPage(WebDriver driver) {super(driver); }
    By hotelsNames = By.xpath("//div[@class='sr_item_photo']/./parent::div");
    By rate = By.xpath("//div[@class='bui-review-score__badge']");

    public List<String> HotelsNames() {
        return Collections.singletonList(driver.findElement(hotelsNames).getText());
    }

    public String Rate() {
        return driver.findElement(rate).getText();
    }

    public By getHotelsNames() {
        return hotelsNames;
    }

    public void setHotelsNames(By hotelsNames) {
        this.hotelsNames = hotelsNames;
    }

    public By getRate() {
        return rate;
    }

    public void setRate(By rate) {
        this.rate = rate;
    }
}