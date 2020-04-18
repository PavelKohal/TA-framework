package page;

import model.CloudPlatformSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage extends AbstractPage{

    private static String costOnPage;
    private final Logger logger = LogManager.getRootLogger();

    public CalculatorPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static String getCostOnPage() {
        return costOnPage;
    }

    @FindBy (xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement firstFrame;

    @FindBy (id = "myFrame")
    private WebElement secondFrame;

    @FindBy (xpath = "//*[@id='mainForm']//div[@title='Compute Engine']")
    private WebElement computeEngineButton;

    @FindBy (id = "input_56")
    private WebElement inputLineNumberOfInstances;

    @FindBy (id = "select_value_label_49")
    private WebElement operationSystemSelect;

    @FindBy (id = "select_value_label_50")
    private WebElement machineClassSelect;

    @FindBy (id = "select_value_label_53")
    private WebElement machineTypeSelect;

    @FindBy (xpath = "//md-checkbox[@aria-label='Add GPUs']")
    private WebElement addGPUChexkbox;

    @FindBy (id = "select_value_label_327")
    private WebElement numberOfGPUsSelect;

    @FindBy (id = "select_value_label_328")
    private WebElement typeOfGPUSelect;

    @FindBy (id = "select_value_label_167")
    private WebElement localSSDSelect;

    @FindBy (id = "select_value_label_54")
    private WebElement datacenterLocationSelect;

    @FindBy (id = "select_value_label_55")
    private WebElement committedUsageSelect;

    @FindBy (xpath = "//button[@aria-label='Add to Estimate']")
    private WebElement buttonAddToEstimate;

    @FindBy (xpath = "//*[@id='resultBlock']//h2[@class='md-title']")
    private WebElement costOnPageDOMElement;


    public CalculatorPage clickComputerEngineButton() {
        logger.info("Open Google Cloud Calculator Page");
        driver.switchTo().defaultContent();
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(computeEngineButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", computeEngineButton);
        logger.info("Computer engine button was clicked.");
        return this;
    }

    public EstimatePage fillInRequiredData(CloudPlatformSpecification testModel) {
        logger.info("Start to fill in required data");
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(inputLineNumberOfInstances));
        inputLineNumberOfInstances.sendKeys(testModel.getNumberOfInstances());
        logger.info("Number of instances is filled in");
        expandSelectionOptionsAndSelectDesired(operationSystemSelect, testModel.getOperationSystem());
        logger.info("Operation system is selected");
        selectDesiredMachineClass(machineClassSelect, testModel.getMachineClass());
        logger.info("Machine class is selected");
        expandSelectionOptionsAndSelectDesired(machineTypeSelect, testModel.getMachineType());
        logger.info("Machine type is selected");
        if (testModel.getAddGPU().equals("on")) {
            clickCheckbox(addGPUChexkbox);
            logger.info("Add GPU checkbox is checked");
        }
        selectDesiredNumberOfGPU(numberOfGPUsSelect, testModel.getNumberGPU());
        logger.info("Number of GPU is selected");
        expandSelectionOptionsAndSelectDesired(typeOfGPUSelect, testModel.getGPUType());
        logger.info("Type of GPU is selected");
        expandSelectionOptionsAndSelectDesired(localSSDSelect, testModel.getLocalSSD());
        logger.info("Local SSD is selected");
        selectDatacenterLocation(datacenterLocationSelect, testModel.getDatacenterLocation());
        logger.info("Datacenter location is selected");
        selectCommittedUsage(committedUsageSelect, testModel.getCommittedUsage());
        logger.info("Committed usage is selected");
        logger.info("Required fields are filled");
        clickButton(buttonAddToEstimate);
        logger.info("AddToEstimate button is clicked");
        costOnPage = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions
                .visibilityOf(costOnPageDOMElement)).getText();
        return new EstimatePage(driver);
    }

    public void expandSelectionOptionsAndSelectDesired(WebElement element, String textElement) {
        expandSelectToSearchForOption(element);
        By elementLocator = By.xpath(String.format("//md-option/div[contains(text(), '%s')]", textElement));
        findAndSelectDesiredOption(elementLocator);
    }

    public void selectDesiredMachineClass(WebElement element, String textElement) {
        expandSelectToSearchForOption(element);
        By elementLocator = By.xpath(String.format("//div[@id='select_container_73']//div[contains(text(), '%s')]", textElement));
        findAndSelectDesiredOption(elementLocator);
    }

    public void selectDesiredNumberOfGPU(WebElement element, String textElement) {
        expandSelectToSearchForOption(element);
        By elementLocator = By.xpath(String.format("//div[@id='select_container_330']//div[contains(text(), '%s')]", textElement));
        findAndSelectDesiredOption(elementLocator);
    }

    public void selectDatacenterLocation(WebElement element, String textElement) {
        expandSelectToSearchForOption(element);
        By elementLocator = By.xpath(String.format("//div[@id='select_container_84']//div[contains(text(), '%s')]", textElement));
        findAndSelectDesiredOption(elementLocator);
    }

    public void selectCommittedUsage(WebElement element, String textElement) {
        expandSelectToSearchForOption(element);
        By elementLocator = By.xpath(String.format("//div[@id='select_container_91']//div[contains(text(), '%s')]", textElement));
        findAndSelectDesiredOption(elementLocator);
    }

    public void expandSelectToSearchForOption(WebElement element) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    public void findAndSelectDesiredOption(By optionLocator) {
        WebElement selectOption = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfElementLocated(optionLocator));
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
