package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.EstimatePage;
import page.GoogleCloudMainPage;
import page.TemporaryEmailPage;

public class SmokeTest extends CommonConditions {

    @Test (description = "compare cost of rent on the website and cost from manual test")
    public void compareEstimatedCostAndCostFromManualTest() {
        EstimatePage resultPageSmokeTest = new GoogleCloudMainPage(driver)
                .openHomePage()
                .fillInSearchInputLine()
                .selectDesiredSearchResult()
                .clickComputerEngineButton()
                .fillInNumberOfInstance()
                .fillInRequiredData();
        Assert.assertTrue(CalculatorPage.costOnPage.contains("1,082.77"));
    }
}
