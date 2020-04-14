package page;

import model.CloudPlatformSpecification;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class EstimatePage extends AbstractPage {

    String email;

    public EstimatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EstimatePage(WebDriver driver, String email) {
        super(driver);
        this.email = email;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id='email_quote']")
    WebElement emailEstimateButton;

    @FindBy (xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    WebElement firstFrameEmail;

    @FindBy (xpath = "//*[@id='myFrame']")
    WebElement secondFrameEmail;

    @FindBy (xpath = "//input[@type='email']")
    WebElement emailField;

    @FindBy (xpath = "//button[@aria-label='Send Email']")
    WebElement emailSendButton;

    public TemporaryEmailPage clickEmailEstimateButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(emailEstimateButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", emailEstimateButton);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> browserPages = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(browserPages.get(1));
        return new TemporaryEmailPage(driver);
    }

    public TemporaryEmailPage addEmail() {
        driver.switchTo().frame(firstFrameEmail).switchTo().frame(secondFrameEmail);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(emailField));
        emailField.sendKeys(email);
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.elementToBeClickable(emailSendButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", emailSendButton);
        ArrayList<String> browserPages = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(browserPages.get(1));
        return new TemporaryEmailPage(driver);
    }

    public boolean isResultEqualsToManualResult(CloudPlatformSpecification testModel) {
        return CalculatorPage.costOnPage.contains(testModel.getManualTestResult());
    }
}
