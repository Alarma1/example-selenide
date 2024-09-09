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
    MainSeleniumPage mainSeleniumPage;
    ElementsPageSelenium elementsPageSelenium;
    FormsPage formsPage;
    WebDriver driver = new ChromeDriver();
    String url = "https://demoqa.com/";

    public MainSeleniumTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        mainSeleniumPage = new MainSeleniumPage(driver);
        elementsPageSelenium = new ElementsPageSelenium(driver);
        formsPage = new FormsPage(driver);
    }

    @Before
    public void openPage() {
        mainSeleniumPage.openPage(url);
    }

    @Test
    public void openPageElements() {
        mainSeleniumPage.openPageElementsSelenium();
        elementsPageSelenium.fillingFormWebTables();
    }

//    @Test
//    public void openPageForms() {
//        mainSeleniumPage.openPageForms();
//        formsPage.studentRegistrationForm();
//    }

    @After
    public void quitDriver() {
        driver.quit();
        driver = null;
    }
}
