package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookingMainPage extends BasePage {
    @FindBy(id = "ss")
    private WebElement searchField;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement searchButton;

    public BookingMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);}

    public void searchByKeyword(String keyword){
        searchField.clear();
        searchField.sendKeys(keyword);
        searchButton.click();
    }
}