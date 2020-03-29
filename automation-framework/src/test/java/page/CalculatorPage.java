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
    //By operationSystemLocator = By.xpath(String.format("//md-option/div[contains(text(), '%s')]", "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS"));

    @FindBy (id = "select_value_label_49")
    WebElement machineClassSelect;
    By machineClassLocator = By.xpath(String.format("//div[@id='select_container_72']//div[contains(text(), '%s')]", "Regular"));

    @FindBy (id = "select_value_label_52")
    WebElement machineTypeSelect;
    By machineTypeLocator = By.xpath(String.format("//md-option/div[contains(text(), '%s')]", "n1-standard-8 (vCPUs: 8, RAM: 30GB)"));

    @FindBy (xpath = "//md-checkbox[@aria-label='Add GPUs']")
    WebElement addGPUChexkbox;

    @FindBy (id = "select_value_label_326")
    WebElement numberOfGPUsSelect;
    By numberOfGPUsLocator = By.xpath(String.format("//div[@id='select_container_329']//md-option/div[contains(text(), '%s')]", "1"));

    @FindBy (id = "select_value_label_327")
    WebElement typeOfGPUSelect;
    By typeOfGPULocator = By.xpath(String.format("//md-option/div[contains(text(),'%s')]", "NVIDIA Tesla V100"));

    @FindBy (id = "select_value_label_166")
    WebElement localSSDSelect;
    By localSSDLocator = By.xpath(String.format("//md-option/div[contains(text(),'%s')]", "2x375 GB"));

    @FindBy (id = "select_value_label_53")
    WebElement datacenterLocationSelect;
    By datacenterLocationLocator = By.xpath(String.format("//div[@id='select_container_83']//md-option/div[contains(text(),'%s')]", "Frankfurt (europe-west3)"));

    @FindBy (id = "select_value_label_54")
    WebElement committedUsageSelect;
    By committedUsageLocator = By.xpath(String.format("//div[@id='select_container_90']//md-option/div[contains(text(),'%s')]", "1 Year"));



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
//        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(operationSystemSelect));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", operationSystemSelect);
//        WebElement desiredElementOperationSystem = new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(operationSystemLocator));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredElementOperationSystem);



        //expandSelectionOptionsAndSelectDesired(choiceOfMachineClass, desiredMachineClass);
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(machineClassSelect));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", machineClassSelect);
        WebElement desiredElementMachineClass = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(machineClassLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredElementMachineClass);


        //expandSelectionOptionsAndSelectDesired(choiceOfInstanceType, desiredInstanceType);
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(machineTypeSelect));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", machineTypeSelect);
        WebElement desiredElementInstanceType = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(machineTypeLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredElementInstanceType);


        if(testModel.isAddGPU()) {
            clickCheckbox(addGPUChexkbox);
        }

 //       expandSelectionOptionsAndSelectDesired(choiceOfNumberOfGPUs, desiredNumberOfGPUs);
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(numberOfGPUsSelect));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", numberOfGPUsSelect);
        WebElement desiredElementNumberOfGPUs = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(numberOfGPUsLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredElementNumberOfGPUs);


        //expandSelectionOptionsAndSelectDesired(choiceOfGPUType, desiredGPUType);
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(typeOfGPUSelect));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", typeOfGPUSelect);
        WebElement desiredGPUType = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(typeOfGPULocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredGPUType);


        //expandSelectionOptionsAndSelectDesired(choiceOfLocalSSD, desiredLocalSSD);
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(localSSDSelect));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", localSSDSelect);
        WebElement desiredLocalSSD = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(localSSDLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredLocalSSD);



       // expandSelectionOptionsAndSelectDesired(datacenterLocationSelect, desiredLocation);
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(datacenterLocationSelect));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", datacenterLocationSelect);
        WebElement desiredLocation = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(datacenterLocationLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredLocation);


        //expandSelectionOptionsAndSelectDesired(choiceOfCommittedUsage, desiredCommittedUsage);
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(committedUsageSelect));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", committedUsageSelect);
        WebElement desiredCommittedUsage = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(committedUsageLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredCommittedUsage);


        clickButton(buttonAddToEstimate);

        costOnPage = new WebDriverWait(driver, 10).until(ExpectedConditions
                .visibilityOf(costOnPageDOMElement)).getText();
        return new EstimatePage(driver);
    }

    public CalculatorPage expandSelectionOptionsAndSelectDesired(WebElement element, String textElement) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        By elementLocator = By.xpath(String.format("//md-option/div[contains(text(), '%s')]", textElement));
        WebElement selectOption = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(elementLocator));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", selectOption);
        return this;
    }

    public CalculatorPage clickCheckbox(WebElement checkbox) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(checkbox));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
        return this;
    }

    public CalculatorPage clickButton(WebElement button) {
        new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(button));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
        return this;
    }
}
