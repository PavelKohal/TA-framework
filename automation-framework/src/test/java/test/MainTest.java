package test;

import model.CloudPlatformSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.GoogleCloudMainPage;
import page.TemporaryEmailPage;
import service.SpecificationCreator;

public class MainTest extends CommonConditions {

    @Test (description = "compare the cost of rent in the received letter and on the website")
    public void compareCostsFromDifferentSources() {
        CloudPlatformSpecification testModel = SpecificationCreator.withCredentialsFromProperty();
        boolean expectedResult = new GoogleCloudMainPage(driver)
                .openHomePage()
                .fillInSearchInputLine()
                .selectDesiredSearchResult()
                .clickComputerEngineButton()
                .fillInRequiredData(testModel)
                .clickEmailEstimateButton()
                .getEmail()
                .addEmail()
                .isCostCorrect();

        Assert.assertTrue(expectedResult);
    }
}
