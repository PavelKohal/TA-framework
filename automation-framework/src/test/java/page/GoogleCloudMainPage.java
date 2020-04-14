package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudMainPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();
    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String REQUEST_TEXT = "Google Cloud Platform Pricing Calculator";

    public GoogleCloudMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//div[@class='devsite-searchbox']")
    private WebElement searchButton;

    @FindBy(name = "q")
    private WebElement searchInputLine;

    public GoogleCloudMainPage openHomePage() {
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(searchButton));
        logger.info("Open page " + HOMEPAGE_URL);
        return this;
    }

    public SearchResultsPage fillInSearchInputLine() {
        searchButton.click();
        searchInputLine.sendKeys(REQUEST_TEXT + Keys.ENTER);
        logger.info("Fill request " + REQUEST_TEXT + " in search input");
        return new SearchResultsPage(driver);
    }
}
