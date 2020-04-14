package page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TemporaryEmailPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();
    private static final String TEMPORARY_MAIL_URL = "https://10minutemail.com";

    private static final By MAIL_LOCATOR = By.xpath("//*[@id='mail_address']");
    private static final By EXPECTED_MAIL_LOCATOR = By.xpath("//*[@id='mail_messages_content']//div[@class = 'small_message_icon_box']");
    private static final By COST_FROM_MAIL_LOCATOR = By.xpath("//*[@id='mobilepadding']/td/h2");

    public TemporaryEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EstimatePage getEmail() {
        driver.get(TEMPORARY_MAIL_URL);
        logger.info("The page with the random email generator is open");
        WebElement mail = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOfElementLocated(MAIL_LOCATOR));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.attributeToBeNotEmpty(mail, "value"));
        String emailStringValue = mail.getAttribute("value");
        logger.info("New email address is generated");
        ArrayList<String> browserPages = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserPages.get(0));
        return new EstimatePage(driver, emailStringValue);
    }

    public String getCostInLetter() {
        WebElement expectedMail = new WebDriverWait(driver, 180)
                .until(ExpectedConditions.elementToBeClickable(EXPECTED_MAIL_LOCATOR));
        expectedMail.click();
        WebElement costFromMail = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.presenceOfElementLocated(COST_FROM_MAIL_LOCATOR));
        logger.info("Cost from email is recieved");
        String costInLetter = costFromMail.getText();
        String[] array = costInLetter.split(":");
        return array[1].trim();
    }

    public boolean isCostCorrect() {
        return CalculatorPage.getCostOnPage().contains(getCostInLetter());
    }
}
