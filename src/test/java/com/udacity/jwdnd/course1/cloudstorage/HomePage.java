package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class HomePage {
    private Map<String, String> data;
    private int timeout = 15;
    private WebDriverWait wait;
    private JavascriptExecutor js;

    @FindBy(id = "buttonAddCredential")
    private WebElement addANewCredential;

    @FindBy(id = "btnAddNewNote")
    private WebElement addANewNote;

    @FindBy(css = "#noteModal div.modal-dialog div.modal-content div:nth-of-type(3) button:nth-of-type(1)")
    private WebElement close1;

    @FindBy(css = "#credentialModal div.modal-dialog div.modal-content div:nth-of-type(3) button:nth-of-type(1)")
    private WebElement close2;

    @FindBy(id = "nav-credentials-tab")
    private WebElement credentials;

    @FindBy(id = "anchorDeleteNote")
    private WebElement delete;

    @FindBy(id = "anchorDeleteCredential")
    private WebElement delete2;

    @FindBy(id = "note-description")
    private WebElement description;

    @FindBy(id = "tableNoteTitle")
    private WebElement tableNoteTitle;

    @FindBy(id = "tableNoteDescription")
    private WebElement tableNoteDescription;

    @FindBy(id = "buttonEditNote")
    private WebElement edit;

    @FindBy(id = "buttonEditCredential")
    private WebElement buttonEditCredential;

    @FindBy(id = "nav-files-tab")
    private WebElement files;

    @FindBy(id = "btnLogout")
    private WebElement logout;

    @FindBy(id = "nav-notes-tab")
    private WebElement notes;

    private final String pageLoadedText = "";

    private final String pageUrl = "/home";

    @FindBy(id = "credential-password")
    private WebElement password;

    @FindBy(id = "buttonSaveNote")
    private WebElement saveChanges1;

    @FindBy(id = "buttonSaveCredential")
    private WebElement saveChanges2;

    @FindBy(id = "note-title")
    private WebElement title;

    @FindBy(css = "button.btn.btn-dark")
    private WebElement upload;

    @FindBy(id = "fileUpload")
    private WebElement uploadANewFile;

    @FindBy(id = "credential-url")
    private WebElement url;

    @FindBy(id = "credential-username")
    private WebElement username;

    @FindBy(id = "tblCredentialUrl")
    private WebElement tblCredentialUrl;

    @FindBy(id = "tblCredentialUsername")
    private WebElement tblCredentialUsername;

    @FindBy(id = "tblCredentialPassword")
    private WebElement tblCredentialPassword;

    public HomePage() {
    }

    public HomePage(WebDriver driver) {
        this();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, timeout);
        js = (JavascriptExecutor) driver;
    }

    public HomePage(WebDriver driver, Map<String, String> data) {
        this(driver);
        this.data = data;
    }

    public HomePage(WebDriver driver, Map<String, String> data, int timeout) {
        this(driver, data);
        this.timeout = timeout;
    }

    /**
     * Click on Add A New Credential Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickAddANewCredentialButton() {
//        boolean staleElement = true;
//        while(staleElement){
//            try{
//                driver.findElement(By.id("buttonAddCredential")).click();
//                staleElement = false;
//            } catch(StaleElementReferenceException e){
//                staleElement = true;
//            }
//
//        }
//        wait.until(ExpectedConditions.elementToBeClickable(addANewCredential)).click();
        js.executeScript("arguments[0].click();", addANewCredential);
        return this;
    }

    /**
     * Click on Add A New Note Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickAddANewNoteButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(addANewNote)).click();
        js.executeScript("arguments[0].click();", addANewNote);
        return this;
    }

    /**
     * Click on Edit Credential Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickEditCredentialButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(buttonEditCredential)).click();
        js.executeScript("arguments[0].click();", buttonEditCredential);
        return this;
    }

    /**
     * Click on Close Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickClose1Button() {
        close1.click();
        return this;
    }

    /**
     * Click on Close Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickClose2Button() {
        close2.click();
        return this;
    }

    /**
     * Click on Credentials Link.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickCredentialsLink() {
//        boolean staleElement = true;
//        while(staleElement){
//            try{
//                driver.findElement(By.id("nav-credentials-tab")).click();
//                staleElement = false;
//            } catch(StaleElementReferenceException e){
//                staleElement = true;
//            }
//
//        }
//        wait.until(ExpectedConditions.elementToBeClickable(credentials)).click();
        js.executeScript("arguments[0].click();", credentials);
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickDeleteLink() {
//        wait.until(ExpectedConditions.elementToBeClickable(delete)).click();
        js.executeScript("arguments[0].click();", delete);
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickDeleteLink2() {
//        boolean staleElement = true;
//        while(staleElement){
//            try{
//                driver.findElement(By.id("anchorDeleteCredential")).click();
//                staleElement = false;
//            } catch(StaleElementReferenceException e){
//                staleElement = true;
//            }
//
//        }
//        wait.until(ExpectedConditions.elementToBeClickable(delete2)).click();
        js.executeScript("arguments[0].click();", delete2);
        return this;
    }

    /**
     * Click on Edit Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickEditButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(edit)).click();
        js.executeScript("arguments[0].click();", edit);
        return this;
    }

    /**
     * Click on Files Link.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickFilesLink() {
        files.click();
        return this;
    }

    /**
     * Click on Logout Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickLogoutButton() {
//        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
        js.executeScript("arguments[0].click();", logout);
        return this;
    }

    /**
     * Click on Notes Link.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickNotesLink() {
//        wait.until(ExpectedConditions.elementToBeClickable(notes)).click();
        js.executeScript("arguments[0].click();", notes);
        return this;
    }

    /**
     * Click on Save Changes Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickSaveChanges1Button() {
//        wait.until(ExpectedConditions.elementToBeClickable(saveChanges1)).click();
        js.executeScript("arguments[0].click();", saveChanges1);
        return this;
    }

    /**
     * Click on Save Changes Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickSaveChanges2Button() {
//        wait.until(ExpectedConditions.elementToBeClickable(saveChanges2)).click();
        js.executeScript("arguments[0].click();", saveChanges2);
        return this;
    }

    /**
     * Click on Upload Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickUploadButton() {
        upload.click();
        return this;
    }

    /**
     * Fill every fields in the page.
     *
     * @return the HomePage class instance.
     */
    public HomePage fill() {
        setTitleTextField();
        setDescriptionTextareaField();
        setUrlTextField();
        setUsernameTextField();
        setPasswordTextField();
        return this;
    }

    /**
     * Fill every fields in the page and submit it to target page.
     *
     * @return the HomePage class instance.
     */
    public HomePage fillAndSubmit() {
        fill();
        return submit();
    }

    /**
     * Set default value to Description Textarea field.
     *
     * @return the HomePage class instance.
     */
    public HomePage setDescriptionTextareaField() {
        return setDescriptionTextareaField(data.get("DESCRIPTION"));
    }

    /**
     * Set value to Description Textarea field.
     *
     * @return the HomePage class instance.
     */
    public HomePage setDescriptionTextareaField(String descriptionValue) {
        wait.until(ExpectedConditions.elementToBeClickable(description)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(description)).sendKeys(descriptionValue);
        return this;
    }

    /**
     * Set default value to Password Text field.
     *
     * @return the HomePage class instance.
     */
    public HomePage setPasswordTextField() {
        return setPasswordTextField(data.get("PASSWORD"));
    }

    /**
     * Set value to Password Text field.
     *
     * @return the HomePage class instance.
     */
    public HomePage setPasswordTextField(String passwordValue) {
        wait.until(ExpectedConditions.elementToBeClickable(password)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(password)).sendKeys(passwordValue);
        return this;
    }

    /**
     * Set default value to Title Text field.
     *
     * @return the HomePage class instance.
     */
    public HomePage setTitleTextField() {
        return setTitleTextField(data.get("TITLE"));
    }

    /**
     * Set value to Title Text field.
     *
     * @return the HomePage class instance.
     */
    public HomePage setTitleTextField(String titleValue) {
        wait.until(ExpectedConditions.elementToBeClickable(title)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(title)).sendKeys(titleValue);
        return this;
    }

    /**
     * Set Upload A New File File field.
     *
     * @return the HomePage class instance.
     */
    public HomePage setUploadANewFileFileField() {
        return this;
    }

    /**
     * Set default value to Url Text field.
     *
     * @return the HomePage class instance.
     */
    public HomePage setUrlTextField() {
        return setUrlTextField(data.get("URL"));
    }

    /**
     * Set value to Url Text field.
     *
     * @return the HomePage class instance.
     */
    public HomePage setUrlTextField(String urlValue) {
        wait.until(ExpectedConditions.elementToBeClickable(url)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(url)).sendKeys(urlValue);
        return this;
    }

    /**
     * Set default value to Username Text field.
     *
     * @return the HomePage class instance.
     */
    public HomePage setUsernameTextField() {
        return setUsernameTextField(data.get("USERNAME"));
    }

    /**
     * Set value to Username Text field.
     *
     * @return the HomePage class instance.
     */
    public HomePage setUsernameTextField(String usernameValue) {
        wait.until(ExpectedConditions.elementToBeClickable(username)).clear();
        wait.until(ExpectedConditions.elementToBeClickable(username)).sendKeys(usernameValue);
        return this;
    }

    /**
     * Submit the form to target page.
     *
     * @return the HomePage class instance.
     */
    public HomePage submit() {
        clickLogoutButton();
        return this;
    }

    /**
     * Verify that the page loaded completely.
     *
     * @return the HomePage class instance.
     */
    public HomePage verifyPageLoaded(WebDriver driver) {
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
     * @return the HomePage class instance.
     */
    public HomePage verifyPageUrl(WebDriver driver) {
        (new WebDriverWait(driver, timeout)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getCurrentUrl().contains(pageUrl);
            }
        });
        return this;
    }

    public Note getNote() {
        String title = wait.until(ExpectedConditions.elementToBeClickable(tableNoteTitle)).getText();
        String description = wait.until(ExpectedConditions.elementToBeClickable(tableNoteDescription)).getText();

        return new Note(null, title, description, null);
    }

    public boolean validateElement(WebDriver driver, By id) {
        try {
            driver.findElement(id);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean validateNote(WebDriver driver) {
        return !validateElement(driver,By.id("tableNoteTitle")) && !validateElement(driver,By.id("tableNoteDescription"));
    }

    public Credential getCredential() {
        String url = wait.until(ExpectedConditions.elementToBeClickable(tblCredentialUrl)).getText();
        String username = wait.until(ExpectedConditions.elementToBeClickable(tblCredentialUsername)).getText();
        String password = wait.until(ExpectedConditions.elementToBeClickable(tblCredentialPassword)).getText();

        return new Credential(null, url, username, null, password,null);
    }

    public boolean validateCredentials(WebDriver driver) {
        return !validateElement(driver, By.id("tblCredentialUrl")) && !validateElement(driver, By.id("tblCredentialUsername")) && !validateElement(driver, By.id("tblCredentialPassword"));
    }
}

