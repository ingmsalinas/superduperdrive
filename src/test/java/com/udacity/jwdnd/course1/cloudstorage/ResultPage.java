package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class ResultPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;
    private WebDriverWait wait;

    @FindBy(id = "anchorResultSuccess")
    @CacheLookup
    private WebElement here;

    private final String pageLoadedText = "Your changes were successfully saved";

    private final String pageUrl = "/note/handleNote";

    public ResultPage() {
    }

    public ResultPage(WebDriver driver) {
        this();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, timeout);
        this.driver = driver;
    }

    public ResultPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public ResultPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Here Link.
     *
     * @return the ResultPage class instance.
     */
    public ResultPage clickHereLink() {
        wait.until(ExpectedConditions.elementToBeClickable(here)).click();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the ResultPage class instance.
     */
    public ResultPage verifyPageLoaded() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getPageSource().contains(pageLoadedText);
            }
        });
        return this;
    }

    /**
     * Verify that current page URL matches the expected URL.
     *
     * @return the ResultPage class instance.
     */
    public ResultPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}

