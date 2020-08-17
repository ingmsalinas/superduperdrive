package com.udacity.jwdnd.course1.cloudstorage;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTests {

    @LocalServerPort
    private int port;

    private WebDriver driver;

    @BeforeAll
    static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void beforeEach() {
        this.driver = new ChromeDriver();
    }

    @AfterEach
    public void afterEach() {
        if (this.driver != null) {
            driver.quit();
        }
    }

    /**
     * Write a test that verifies that an unauthorized user can only access the login and signup pages.
     */
    @Test
    public void testUnauthorizedAccess() {
        driver.get("http://localhost:" + this.port + "/login");
        Assertions.assertEquals("Login", driver.getTitle());

        driver.get("http://localhost:" + this.port + "/signup");
        Assertions.assertEquals("Sign Up", driver.getTitle());

        driver.get("http://localhost:" + this.port + "/home");
        Assertions.assertEquals("Login", driver.getTitle());
    }


    /**
     * Write a test that signs up a new user, logs in, verifies that the home page is accessible, logs out,
     * and verifies that the home page is no longer accessible.
     */
    @Test
    public void testLoginLogoutAccess() {
        Map<String, String> data = new HashMap<>();
        data.put("FIRST_NAME", "Mario");
        data.put("LAST_NAME", "Salinas");
        data.put("USERNAME", "msalinas");
        data.put("PASSWORD", "12345");

        //signs up a new user
        driver.get("http://localhost:" + this.port + "/signup");
        Assertions.assertEquals("Sign Up", driver.getTitle());

        SignUpPage signUpPage = new SignUpPage(driver, data);
        signUpPage.fillAndSubmit();

        //logs in
        driver.get("http://localhost:" + this.port + "/login");
        Assertions.assertEquals("Login", driver.getTitle());

        LoginPage loginPage = new LoginPage(driver, data);
        loginPage.fillAndSubmit();

        //verifies that the home page is accessible
        driver.get("http://localhost:" + this.port + "/home");
        Assertions.assertEquals("Home", driver.getTitle());

        //logs out
        HomePage homePage = new HomePage(driver);
        homePage.clickLogoutButton();

        //verifies that the home page is no longer accessible
        driver.get("http://localhost:" + this.port + "/home");
        Assertions.assertEquals("Login", driver.getTitle());
    }


}
