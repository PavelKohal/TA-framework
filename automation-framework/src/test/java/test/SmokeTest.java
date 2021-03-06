package test;

import model.CloudPlatformSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.EstimatePage;
import page.GoogleCloudMainPage;
import service.SpecificationCreator;

public class SmokeTest extends CommonConditions {

    @Test (description = "compare cost of rent on the website and cost from manual test")
    public void compareEstimatedCostAndCostFromManualTest() {
        CloudPlatformSpecification testModel = SpecificationCreator.withCredentialsFromProperty();
        boolean expectedResultSmokeTest = new GoogleCloudMainPage(driver)
                .openHomePage()
                .fillInSearchInputLine()
                .selectDesiredSearchResult()
                .clickComputerEngineButton()
                .fillInRequiredData(testModel)
                .isResultEqualsToManualResult(testModel);

        Assert.assertTrue(expectedResultSmokeTest);
    }
}
