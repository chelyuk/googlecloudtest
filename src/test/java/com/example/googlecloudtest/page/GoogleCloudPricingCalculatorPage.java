package com.example.googlecloudtest.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class GoogleCloudPricingCalculatorPage extends AbstractPage {

    private static final String CALCULATOR_PAGE_URL = "https://cloud.google.com/products/calculator";

    // TODO: investigate how to deal with iFrames in PageFactory
    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//md-tab-item//div[contains(@class,'hexagon')][@title='Compute Engine']")
    WebElement computeEngineSettings;

    @FindBy(id = "input_75")
    WebElement numberOfInstances;

    // @FindBy(id = "input_76")
    // WebElement instancesFor;

    @FindBy(id = "select_88")
    Select operatingSystemSelect;

    @FindBy(id = "select_92")
    Select machineClassSelect;

    @FindBy(id = "select_100")
    Select seriesSelect;

    @FindBy(id = "select_102")
    Select machineTypeSelect;

    @FindBy(xpath = "//form[contains(@aria-label, 'ComputeEngineForm')]//md-checkbox[contains(@aria-label, 'Add GPUs')]")
    WebElement addGPUsCheckBox;

    @FindBy(id = "select_451")
    Select typeGPUSelect;

    @FindBy(id = "select_453")
    Select numberOfGPUsSelect;

    @FindBy(id = "select_413")
    Select localSSDSelect;

    @FindBy(id = "select_108")
    Select dataCenterLocationSelect;

    @FindBy(id = "select_115")
    Select commitedUsagSelect;

    @FindBy(xpath = "//form[contains(@aria-label, 'ComputeEngineForm')]//button[contains(@aria-label, 'Add to Estimate')]")
    WebElement addToEstimateButton;

    public GoogleCloudPricingCalculatorPage selectNumberOfInstances(String string) {
        return selectorSet(numberOfGPUsSelect, string);
    }

    public GoogleCloudPricingCalculatorPage selectOperatingSystem(String string) {
        return selectorSet(operatingSystemSelect, string);
    }

    public GoogleCloudPricingCalculatorPage selectMachineClass(String string) {
        return selectorSet(machineClassSelect, string);
    }

    public GoogleCloudPricingCalculatorPage selectSeries(String string) {
        return selectorSet(seriesSelect, string);
    }

    public GoogleCloudPricingCalculatorPage selectMachineType(String string) {
        return selectorSet(machineClassSelect, string);
    }

    public GoogleCloudPricingCalculatorPage selectGPUType(String string) {
        return selectorSet(typeGPUSelect, string);
    }

    public GoogleCloudPricingCalculatorPage selectGPUNumbers(String string) {
        return selectorSet(numberOfGPUsSelect, string);
    }

    public GoogleCloudPricingCalculatorPage selectLocalSSD(String string) {
        return selectorSet(localSSDSelect, string);
    }

    public GoogleCloudPricingCalculatorPage selectDataCenterLocation(String string) {
        return selectorSet(dataCenterLocationSelect, string);
    }

    public GoogleCloudPricingCalculatorPage selectCommitedUsage(String string) {
        return selectorSet(commitedUsagSelect, string);
    }

    public GoogleCloudPricingCalculatorPage addGPUs() {
        addGPUsCheckBox.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage computeEngineSetup() {
        computeEngineSettings.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage getPrice() {
        addToEstimateButton.click();
        return this;
    }

    public String estimationIsReady() {
        return driver.findElement(By.className("md-flex")).getText();
    }

    public GoogleCloudPricingCalculatorPage openPage() {
        driver.get(CALCULATOR_PAGE_URL);
        return this;
    }

    private GoogleCloudPricingCalculatorPage selectorSet(Select menu, String string) {
        menu.selectByValue(string);
        return this;
    }
}