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
class CloudStorageApplicationTests {

	@LocalServerPort
	private int port;

	protected WebDriver driver;

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

	@Test
	public void getLoginPage() {
		driver.get("http://localhost:" + this.port + "/login");
		Assertions.assertEquals("Login", driver.getTitle());
	}

	protected HomePage signUpAndLogin() {
		Map<String, String> data = new HashMap<>();
		data.put("FIRST_NAME", "Mario");
		data.put("LAST_NAME", "Salinas");
		data.put("USERNAME", "msalinas");
		data.put("PASSWORD", "12345");

		//sign up
		driver.get("http://localhost:" + this.port + "/signup");
		SignUpPage signUpPage = new SignUpPage(driver, data);
		signUpPage.fillAndSubmit();

		//log in
		driver.get("http://localhost:" + this.port + "/login");
		LoginPage loginPage = new LoginPage(driver, data);
		loginPage.fillAndSubmit();

		return new HomePage(driver);
	}

}