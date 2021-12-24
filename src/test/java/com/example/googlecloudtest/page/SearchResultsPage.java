package com.example.googlecloudtest.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractPage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='gs-title']/a/b[contains(text(),'Google Cloud Platform Pricing Calculator')]")
    WebElement searchResult;

    public GoogleCloudPricingCalculatorPage searchResultView() {
        searchResult.click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }

    public SearchResultsPage openPage() {
        return this;
    }

}
