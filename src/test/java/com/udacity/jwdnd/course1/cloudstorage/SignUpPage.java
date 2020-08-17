package com.udacity.jwdnd.course1.cloudstorage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class SignUpPage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;

    @FindBy(css = "a[href='/login']")
    @CacheLookup
    private WebElement backToLogin;

    @FindBy(id = "inputFirstName")
    @CacheLookup
    private WebElement firstName;

    @FindBy(id = "inputLastName")
    @CacheLookup
    private WebElement lastName;

    private final String pageLoadedText = "";

    private final String pageUrl = "/signup";

    @FindBy(id = "inputPassword")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "submit-button")
    @CacheLookup
    private WebElement signUp;

    @FindBy(id = "inputUsername")
    @CacheLookup
    private WebElement username;

    public SignUpPage() {
    }

    public SignUpPage(WebDriver driver) {
        this();
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public SignUpPage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public SignUpPage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Back To Login Link.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage clickBackToLoginLink() {
        backToLogin.click();
        return this;
    }

    /**
     * Click on Sign Up Button.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage clickSignUpButton() {
        signUp.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage fill() {
        setFirstNameTextField();
        setLastNameTextField();
        setUsernameTextField();
        setPasswordPasswordField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to First Name Text field.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage setFirstNameTextField() {
        return setFirstNameTextField(data.get("FIRST_NAME"));
    }

    /**
     * Set value to First Name Text field.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage setFirstNameTextField(String firstNameValue) {
        firstName.sendKeys(firstNameValue);
        return this;
    }

    /**
     * Set default value to Last Name Text field.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage setLastNameTextField() {
        return setLastNameTextField(data.get("LAST_NAME"));
    }

    /**
     * Set value to Last Name Text field.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage setLastNameTextField(String lastNameValue) {
        lastName.sendKeys(lastNameValue);
        return this;
    }

    /**
     * Set default value to Password Password field.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage setPasswordPasswordField() {
        return setPasswordPasswordField(data.get("PASSWORD"));
    }

    /**
     * Set value to Password Password field.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage setPasswordPasswordField(String passwordValue) {
        password.sendKeys(passwordValue);
        return this;
    }

    /**
     * Set default value to Username Text field.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage setUsernameTextField() {
        return setUsernameTextField(data.get("USERNAME"));
    }

    /**
     * Set value to Username Text field.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage setUsernameTextField(String usernameValue) {
        username.sendKeys(usernameValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage submit() {
        clickSignUpButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the SignUpPage class instance.
     */
    public SignUpPage verifyPageLoaded() {
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
     * @return the SignUpPage class instance.
     */
    public SignUpPage verifyPageUrl() {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }
}

