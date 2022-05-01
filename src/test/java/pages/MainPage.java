package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class MainPage {

    WebDriver driver;

    @FindBy
    private By searchInput = By.xpath("//input[@name = 'ss']");
    private By searchButton = By.xpath("//button[@type = 'submit']");
    private By firstHotel = By.xpath("//div[@data-testid = 'title']");
    private By firstHotelRating = By.xpath("(//div[@data-testid = 'review-score'])[1]/div[@aria-label]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void typeSearchName(String name) {
        driver.findElement(searchInput).sendKeys(name);
    }

    public void clickSearchButton() {
        driver.findElement(searchButton).click();
    }

    public String getFirstHotelName() {
        return driver.findElement(firstHotel).getText();
    }

    public String getFirstHotelRating() {
        return driver.findElement(firstHotelRating).getText();
    }

}
