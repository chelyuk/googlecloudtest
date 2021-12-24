package com.example.googlecloudtest.test;

import com.example.googlecloudtest.page.GoogleCloudPricingCalculatorPage;
import com.example.googlecloudtest.page.HomePage;
import com.example.googlecloudtest.page.SearchResultsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleCloudTest {

    private WebDriver driver;
    private static final String SEARCH_REQUEST = "Google Cloud Platform Pricing Calculator";
    private static final String NUMBER_OF_INSTANCES = "4";
    private static final String OPERATING_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu or BYOL (Bring Your Own License)";
    private static final String CLASS = "Regular";
    private static final String SERIES = "N1";
    private static final String TYPE = "n1-standard-8 (vCPUs: 8, RAM: 30GB)";
    private static final String GPU_TYPE = "NVIDIA Tesla T4";
    private static final String GPUS_NUMBER = "1";
    private static final String SSD = "2x375 GB";
    private static final String LOCATION = "Frankfurt (europe-west3)";
    private static final String USAGE = "1 Year";

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(description = "We are testing Google")
    public void GoogleTest() {
        HomePage makeSearch = new HomePage(driver).openPage();
        SearchResultsPage searchResults = makeSearch.showResults(SEARCH_REQUEST);
        GoogleCloudPricingCalculatorPage form = searchResults
                .searchResultView()
                .computeEngineSetup()
                .selectNumberOfInstances(NUMBER_OF_INSTANCES)
                .selectOperatingSystem(OPERATING_SYSTEM)
                .selectMachineClass(CLASS)
                .selectSeries(SERIES)
                .selectMachineType(TYPE)
                .addGPUs()
                .selectGPUType(GPU_TYPE)
                .selectGPUNumbers(GPUS_NUMBER)
                .selectLocalSSD(SSD)
                .selectDataCenterLocation(LOCATION)
                .selectCommitedUsage(USAGE)
                .getPrice();

        Assert.assertEquals(form.estimationIsReady(), "Estimate");
    }

    @AfterMethod(alwaysRun = true)
    public void browserShutDown() {
        driver.quit();
        driver = null;
    }
}
