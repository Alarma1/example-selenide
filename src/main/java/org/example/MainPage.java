package org.example;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.assertEquals;

@Slf4j
public class MainPage {
    SelenideElement blockWithImage = $x("//a[@target='_blank']/ancestor::div[@class='home-banner']");
    SelenideElement pageRegistation = $x("//img[@alt='Certified Guy']/../following-sibling::div/child::div[contains(text(),'Selenium')]");
    SelenideElement pageElements = $x("//h5[text()='Elements']/ancestor::div[contains(@class, 'mt-4')]");
    SelenideElement itemForCheck = $x("//div[@class='left-pannel']");

    @Step("Открываем главную страницу")
    public void openMainPage(String url) {
        open(url);
        webdriver().shouldHave(url(url));
        getWebDriver().manage().window().maximize();
    }

    @Step("Кликаем на блок с картинкой,возвращаемся на главную страницу")
    public void clickImg() {
        blockWithImage.shouldBe(visible).click();
        log.info("Кликнули на блок");
        String mainWindow = getWebDriver().getWindowHandle();
        Set<String> allWindows = getWebDriver().getWindowHandles();
        for (String windowSearch : allWindows) {
            if (!windowSearch.equals(mainWindow)) {
                switchTo().window(windowSearch);
                pageRegistation.shouldBe(visible);
                //   sleep(3000); // Можно включить для визуальной демонстации выполенения теста
                closeWindow();
                break;
            }
        }
        log.info("Закрываем открытую вкладку");
        switchTo().window(mainWindow);
        log.info("Возвращаемся на главную страницу");
        //        sleep(2000); // Можно включить для визуальной демонстации выполенения теста
    }

    @Step("Переходим во вкладку 'Elements'")
    public void openPageElements() {
        pageElements.shouldBe(visible).click();
        itemForCheck.shouldBe(visible);
        log.info("Кликнули на блок для перехода на страницу 'Elements'.");

        //        sleep(2000); // Можно включить для визуальной демонстации выполенения теста.
    }
}