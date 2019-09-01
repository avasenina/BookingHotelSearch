package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class BookingSearchPage extends BasePage{
    WebDriver driver;
    public BookingSearchPage(WebDriver driver) {super(driver); }
    By inputName = By.linkText("Гостиница Беларусь");



    public void findHotel() {
        driver.findElement(inputName);
    }


}