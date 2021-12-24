package com.example.googlecloudtest.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "q")
    WebElement searchString;

    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public SearchResultsPage showResults(String string) {
        searchString.click();
        searchString.sendKeys(string);
        searchString.sendKeys(Keys.RETURN);
        return new SearchResultsPage(driver);
    }

}
