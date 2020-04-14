package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage{

    private final Logger logger = LogManager.getRootLogger();

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id='___gcse_0']//div[@class='gs-title']//b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement desiredSearchResult;

    public CalculatorPage selectDesiredSearchResult() {
        logger.info("Looking for link to page with calculator...");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(desiredSearchResult));
        logger.info("Check desired search result");
        desiredSearchResult.click();
        return new CalculatorPage(driver);
    }
}
