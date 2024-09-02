package org.example;

import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

@Slf4j
public class MainSeleniumTest {
    WebDriver driver = new ChromeDriver();
    String url = "https://demoqa.com/";

    public MainSeleniumTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @Before
    public void openPage() {
        new MainSeleniumPage(driver)
                .openPage(url)
                .openPageForms();
    }

    @Test
    public void formsPage() {
        new FormsPage(driver).fillingFormRegistrationForm();
    }

    @After
    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}
