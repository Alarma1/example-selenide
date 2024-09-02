package org.example;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

@Slf4j
public class MainSeleniumPage {
    WebDriver driver;
    String pageForms = "//h5[text()='Forms']/ancestor::div[contains(@class, 'mt-4')]";
    String itemForCheck = "//div[@class='left-pannel']";


    public MainSeleniumPage(WebDriver browserDriver) {
        driver = browserDriver;
    }

    @Step("Открываем главную страницу")
    public MainSeleniumPage openPage(String url) {
        driver.get(url);
        driver.manage().window().fullscreen();
        return this;
    }

    @Step("Переходим во вкладку 'Forms'")
    public void openPageForms() {
        driver.findElement(By.xpath(pageForms)).click();
        driver.findElement(By.xpath(itemForCheck));
        log.info("Кликнули на блок для перехода на страницу 'Forms'.");
    }

}
