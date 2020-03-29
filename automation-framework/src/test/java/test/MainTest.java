package test;

import model.CloudPlatformSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.GoogleCloudMainPage;
import page.TemporaryEmailPage;

import service.SpecificationCreator;

public class MainTest extends CommonConditions {

//    @Test (description = "compare the cost of rent in the received letter and on the website")
//    public void compareCostsFromDifferentSources() {
//        CloudPlatformSpecification testModel = SpecificationCreator.withCredentialsFromProperty();
//        TemporaryEmailPage resultPage = new GoogleCloudMainPage(driver)
//                .openHomePage()
//                .fillInSearchInputLine()
//                .selectDesiredSearchResult()
//                .clickComputerEngineButton()
//                .fillInRequiredData(testModel)
//                .clickEmailEstimateButton()
//                .getEmail()
//                .addEmail();
//        Assert.assertTrue(CalculatorPage.costOnPage.contains(resultPage.getCostInLetter()));
//    }
}
