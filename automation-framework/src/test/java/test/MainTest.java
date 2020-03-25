package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.GoogleCloudMainPage;
import page.TemporaryEmailPage;

public class MainTest {

    private WebDriver driver;
    private TemporaryEmailPage resultPage;

    @BeforeMethod (alwaysRun = true)
    public void getSourceData() {
        driver = new ChromeDriver();
        resultPage = new GoogleCloudMainPage(driver)
                .openHomePage()
                .fillInSearchInputLine()
                .selectDesiredSearchResult()
                .clickComputerEngineButton()
                .fillInNumberOfInstance()
                .fillInRequiredData()
                .clickEmailEstimateButton()
                .getEmail()
                .addEmail();
    }

    @Test
    public void compareCostsFromDifferentSources() {
        Assert.assertTrue(CalculatorPage.costOnPage.contains(resultPage.getCostInLetter()));
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
