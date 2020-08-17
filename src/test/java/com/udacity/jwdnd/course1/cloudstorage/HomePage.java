package com.udacity.jwdnd.course1.cloudstorage;

import com.udacity.jwdnd.course1.cloudstorage.model.Credential;
import com.udacity.jwdnd.course1.cloudstorage.model.Note;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class HomePage {
    private Map<String, String> data;
    private WebDriver driver;
    private int timeout = 15;
    private WebDriverWait wait;

    @FindBy(id = "buttonAddCredential")
    @CacheLookup
    private WebElement addANewCredential;

    @FindBy(id = "btnAddNewNote")
    @CacheLookup
    private WebElement addANewNote;

    @FindBy(css = "#noteModal div.modal-dialog div.modal-content div:nth-of-type(3) button:nth-of-type(1)")
    @CacheLookup
    private WebElement close1;

    @FindBy(css = "#credentialModal div.modal-dialog div.modal-content div:nth-of-type(3) button:nth-of-type(1)")
    @CacheLookup
    private WebElement close2;

    @FindBy(id = "nav-credentials-tab")
    @CacheLookup
    private WebElement credentials;

    @FindBy(id = "anchorDeleteNote")
    @CacheLookup
    private WebElement delete;

    @FindBy(id = "anchorDeleteCredential")
    @CacheLookup
    private WebElement delete2;

    @FindBy(id = "note-description")
    @CacheLookup
    private WebElement description;

    @FindBy(id = "tableNoteTitle")
    @CacheLookup
    private WebElement tableNoteTitle;

    @FindBy(id = "tableNoteDescription")
    @CacheLookup
    private WebElement tableNoteDescription;

    @FindBy(id = "buttonEditNote")
    @CacheLookup
    private WebElement edit;

    @FindBy(id = "btnEditCredential")
    @CacheLookup
    private WebElement btnEditCredential;

    @FindBy(id = "nav-files-tab")
    @CacheLookup
    private WebElement files;

    @FindBy(id = "btnLogout")
    @CacheLookup
    private WebElement logout;

    @FindBy(id = "nav-notes-tab")
    @CacheLookup
    private WebElement notes;

    private final String pageLoadedText = "";

    private final String pageUrl = "/home";

    @FindBy(id = "credential-password")
    @CacheLookup
    private WebElement password;

    @FindBy(id = "buttonSaveNote")
    @CacheLookup
    private WebElement saveChanges1;

    @FindBy(id = "buttonSaveCredential")
    @CacheLookup
    private WebElement saveChanges2;

    @FindBy(id = "note-title")
    @CacheLookup
    private WebElement title;

    @FindBy(css = "button.btn.btn-dark")
    @CacheLookup
    private WebElement upload;

    @FindBy(id = "fileUpload")
    @CacheLookup
    private WebElement uploadANewFile;

    @FindBy(id = "credential-url")
    @CacheLookup
    private WebElement url;

    @FindBy(id = "credential-username")
    @CacheLookup
    private WebElement username;

    @FindBy(id = "tblCredentialUrl")
    @CacheLookup
    private WebElement tblCredentialUrl;

    @FindBy(id = "tblCredentialUsername")
    @CacheLookup
    private WebElement tblCredentialUsername;

    @FindBy(id = "tblCredentialPassword")
    @CacheLookup
    private WebElement tblCredentialPassword;

    public HomePage() {
    }

    public HomePage(WebDriver driver) {
        this();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, timeout);
        this.driver = driver;
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
        boolean staleElement = true;
        while(staleElement){
            try{
                driver.findElement(By.id("buttonAddCredential")).click();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }

        }
        //wait.until(ExpectedConditions.elementToBeClickable(addANewCredential)).click();
        return this;
    }

    /**
     * Click on Add A New Note Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickAddANewNoteButton() {
        wait.until(ExpectedConditions.elementToBeClickable(addANewNote)).click();
        return this;
    }

    /**
     * Click on Edit Credential Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickEditCredentialButton() {
        wait.until(ExpectedConditions.elementToBeClickable(btnEditCredential)).click();
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
        boolean staleElement = true;
        while(staleElement){
            try{
                driver.findElement(By.id("nav-credentials-tab")).click();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }

        }
        //wait.until(ExpectedConditions.elementToBeClickable(credentials)).click();
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickDeleteLink() {
        wait.until(ExpectedConditions.elementToBeClickable(delete)).click();
        return this;
    }

    /**
     * Click on Delete Link.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickDeleteLink2() {
        boolean staleElement = true;
        while(staleElement){
            try{
                driver.findElement(By.id("anchorDeleteCredential")).click();
                staleElement = false;
            } catch(StaleElementReferenceException e){
                staleElement = true;
            }

        }
        //wait.until(ExpectedConditions.elementToBeClickable(delete2)).click();
        return this;
    }

    /**
     * Click on Edit Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickEditButton() {
        wait.until(ExpectedConditions.elementToBeClickable(edit)).click();
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
        wait.until(ExpectedConditions.elementToBeClickable(logout)).click();
        return this;
    }

    /**
     * Click on Notes Link.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickNotesLink() {
        wait.until(ExpectedConditions.elementToBeClickable(notes)).click();
        return this;
    }

    /**
     * Click on Save Changes Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickSaveChanges1Button() {
        wait.until(ExpectedConditions.elementToBeClickable(saveChanges1)).click();
        return this;
    }

    /**
     * Click on Save Changes Button.
     *
     * @return the HomePage class instance.
     */
    public HomePage clickSaveChanges2Button() {
        wait.until(ExpectedConditions.elementToBeClickable(saveChanges2)).click();
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
    public HomePage verifyPageLoaded() {
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
    public HomePage verifyPageUrl() {
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

    public boolean validateElement(By id) {
        try {
            driver.findElement(id);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public boolean validateNote() {
        return !validateElement(By.id("tableNoteTitle")) && !validateElement(By.id("tableNoteDescription"));
    }

    public Credential getCredential() {
        String url = wait.until(ExpectedConditions.elementToBeClickable(tblCredentialUrl)).getText();
        String username = wait.until(ExpectedConditions.elementToBeClickable(tblCredentialUsername)).getText();
        String password = wait.until(ExpectedConditions.elementToBeClickable(tblCredentialPassword)).getText();

        return new Credential(null, url, username, null, password,null);
    }

    public boolean validateCredentials() {
        return !validateElement(By.id("tblCredentialUrl")) && !validateElement(By.id("tblCredentialUsername")) && !validateElement(By.id("tblCredentialPassword"));
    }
}

