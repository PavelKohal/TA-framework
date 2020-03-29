package page;

import model.CloudPlatformSpecification;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage {

    WebDriver driver;
    public static String costOnPage;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    WebElement firstFrame;

    @FindBy (id = "myFrame")
    WebElement secondFrame;

    @FindBy (xpath = "//*[@id='mainForm']//div[@title='Compute Engine']")
    WebElement computeEngineButton;

    @FindBy (id = "input_55")
    WebElement inputLineNumberOfInstances;

    @FindBy (id = "select_value_label_48")
    WebElement operationSystemSelect;

    @FindBy (id = "select_value_label_49")
    WebElement machineClassSelect;

    @FindBy (id = "select_value_label_52")
    WebElement machineTypeSelect;

    @FindBy (xpath = "//md-checkbox[@aria-label='Add GPUs']")
    WebElement addGPUChexkbox;

    @FindBy (id = "select_value_label_326")
    WebElement numberOfGPUsSelect;

    @FindBy (id = "select_value_label_327")
    WebElement typeOfGPUSelect;

    @FindBy (id = "select_value_label_166")
    WebElement localSSDSelect;

    @FindBy (id = "select_value_label_53")
    WebElement datacenterLocationSelect;

    @FindBy (id = "select_value_label_54")
    WebElement committedUsageSelect;

    @FindBy (xpath = "//button[@aria-label='Add to Estimate']")
    WebElement buttonAddToEstimate;

    @FindBy (xpath = "//*[@id='resultBlock']//h2[@class='md-title']")
    WebElement costOnPageDOMElement;


    public CalculatorPage clickComputerEngineButton() {
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(computeEngineButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", computeEngineButton);
        return this;
    }

    public EstimatePage fillInRequiredData(CloudPlatformSpecification testModel) {
        inputLineNumberOfInstances.sendKeys(testModel.getNumberOfInstances());
        expandSelectionOptionsAndSelectDesired(operationSystemSelect, testModel.getOperationSystem());
        selectDesiredMachineClass(machineClassSelect, testModel.getMachineClass());
        expandSelectionOptionsAndSelectDesired(machineTypeSelect, testModel.getMachineType());
        if (testModel.getAddGPU().equals("on")) {
            clickCheckbox(addGPUChexkbox);
        }
        selectDesiredNumberOfGPU(numberOfGPUsSelect, testModel.getNumberGPU());
        expandSelectionOptionsAndSelectDesired(typeOfGPUSelect, testModel.getGPUType());
        expandSelectionOptionsAndSelectDesired(localSSDSelect, testModel.getLocalSSD());
        selectDatacenterLocation(datacenterLocationSelect, testModel.getDatacenterLocation());
        selectCommittedUsage(committedUsageSelect, testModel.getCommittedUsage());
        clickButton(buttonAddToEstimate);
        costOnPage = new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOf(costOnPageDOMElement)).getText();
        return new EstimatePage(driver);
    }

    public CalculatorPage expandSelectionOptionsAndSelectDesired(WebElement element, String textElement) {
        expandSelectToSearchForOption(element);
        By elementLocator = By.xpath(String.format("//md-option/div[contains(text(), '%s')]", textElement));
        findAndSelectDesiredOption(elementLocator);
        return this;
    }

    public CalculatorPage selectDesiredMachineClass(WebElement element, String textElement) {
        expandSelectToSearchForOption(element);
        By elementLocator = By.xpath(String.format("//div[@id='select_container_72']//div[contains(text(), '%s')]", textElement));
        findAndSelectDesiredOption(elementLocator);
        return this;
    }

    public CalculatorPage selectDesiredNumberOfGPU(WebElement element, String textElement) {
        expandSelectToSearchForOption(element);
        By elementLocator = By.xpath(String.format("//div[@id='select_container_329']//div[contains(text(), '%s')]", textElement));
        findAndSelectDesiredOption(elementLocator);
        return this;
    }

    public CalculatorPage selectDatacenterLocation(WebElement element, String textElement) {
        expandSelectToSearchForOption(element);
        By elementLocator = By.xpath(String.format("//div[@id='select_container_83']//div[contains(text(), '%s')]", textElement));
        findAndSelectDesiredOption(elementLocator);
        return this;
    }

    public CalculatorPage selectCommittedUsage(WebElement element, String textElement) {
        expandSelectToSearchForOption(element);
        By elementLocator = By.xpath(String.format("//div[@id='select_container_90']//div[contains(text(), '%s')]", textElement));
        findAndSelectDesiredOption(elementLocator);
        return this;
    }

    public void expandSelectToSearchForOption(WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void findAndSelectDesiredOption(By optionLocator) {
        WebElement selectOption = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectOption);
    }


    public CalculatorPage clickCheckbox(WebElement checkbox) {
        expandSelectToSearchForOption(checkbox);
        return this;
    }

    public CalculatorPage clickButton(WebElement button) {
        expandSelectToSearchForOption(button);
        return this;
    }
}
