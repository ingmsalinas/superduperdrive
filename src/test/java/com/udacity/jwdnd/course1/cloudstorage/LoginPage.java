package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class LoginPage {
    private Map<String, String> data;
    private int timeout = 15;
    private JavascriptExecutor js;

    @FindBy(id = "signup-link")
    private WebElement clickHereToSignUp;

    @FindBy(id = "submit-button")
    private WebElement login;

    private final String pageLoadedText = "Click here to sign up";

    private final String pageUrl = "/login";

    @FindBy(id = "inputPassword")
    private WebElement password;

    @FindBy(id = "inputUsername")
    private WebElement username;

    public LoginPage() {
    }

    public LoginPage(WebDriver driver) {
        this();
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor) driver;
    }

    public LoginPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public LoginPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Click Here To Sign Up Link.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage clickClickHereToSignUpLink() {
//        clickHereToSignUp.click();
        js.executeScript("arguments[0].click();", clickHereToSignUp);
        return this;
    }

    /**
     * Click on Login Button.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage clickLoginButton() {
//        login.click();
        js.executeScript("arguments[0].click();", login);
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage fill() {
        setUsernameTextField();
        setPasswordPasswordField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Password Password field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setPasswordPasswordField() {
        return setPasswordPasswordField(data.get("PASSWORD"));
    }

    /**
     * Set value to Password Password field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setPasswordPasswordField(String passwordValue) {
        password.sendKeys(passwordValue);
        return this;
    }

    /**
     * Set default value to Username Text field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setUsernameTextField() {
        return setUsernameTextField(data.get("USERNAME"));
    }

    /**
     * Set value to Username Text field.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage setUsernameTextField(String usernameValue) {
        username.sendKeys(usernameValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage submit() {
        clickLoginButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the LoginPage class instance.
     */
    public LoginPage verifyPageLoaded(WebDriver driver) {
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
     * @return the LoginPage class instance.
     */
    public LoginPage verifyPageUrl(WebDriver driver) {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}
