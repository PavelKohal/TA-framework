package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommonConditions {

    protected WebDriver driver;

    @BeforeMethod ()
    public void setUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod (alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
