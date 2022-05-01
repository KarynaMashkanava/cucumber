import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driver.WebDriverSingleton;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;

public class MySteps {

    WebDriver driver;
    MainPage page;

    private final String URL = "https://www.booking.com/searchresults.en-gb.html";

    @Before
    public void setUp() {
        driver = WebDriverSingleton.getDriver();
        page = new MainPage(driver);
    }

    @After
    public void tearDown() {
        WebDriverSingleton.getDriver().quit();
    }

    @And("^click search$")
    public void clickSearch() {
        page.clickSearchButton();
    }

    @When("^type '(.*)'$")
    public void typeParisHotel(String hotel) {
        page.typeSearchName(hotel);
    }

    @Then("^validate hotel '(.*)' is displayed first$")
    public void validateHotelParisHotelIsPresent(String hotel) {
        Assert.assertEquals(page.getFirstHotelName(), hotel);
    }

    @And("^validate hotel rating is '(.*)'$")
    public void validateHotelRatingIs(String rating) {
        Assert.assertEquals(rating, page.getFirstHotelRating());
    }

    @Given("^open page$")
    public void openPage() {
        driver.get(URL);
    }
}
