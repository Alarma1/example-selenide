package org.example;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Set;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.junit.Assert.*;

@Slf4j
public class MainPage {
    SelenideElement blockWithImage = $x("//a[@target='_blank']/..");
    SelenideElement pageElements = $x("//h5[text()='Elements']/../../..");

    @Step("Переходим на страницу.")
    public MainPage openMainPage(String Url) {
        open(Url);
        getWebDriver().manage().window().maximize();
        return this;
    }

    @Step("Кликаем на блок с картинкой,возвращаемся на главную страницу.")
    public MainPage clickImg() {
        blockWithImage.shouldBe(visible).click();
        log.info("Кликнули на блок.");
        String mainWindow = getWebDriver().getWindowHandle();
        Set<String> allWindows = getWebDriver().getWindowHandles();
        for (String windowSearch : allWindows) {
            if (!windowSearch.equals(mainWindow)) {
                switchTo().window(windowSearch);
                sleep(3000);
                closeWindow();
                break;
            }
        }
        log.info("Закрываем открытую вкладку.");
        switchTo().window(mainWindow);
        log.info("Возвращаемся на главную страницу.");
        sleep(2000);
        return this;
    }

    @Step
    public MainPage openItemMenuElement() {
        pageElements.shouldBe(visible).click();
        log.info("Кликнули на блок для перехода на страницу 'Elements'.");
        sleep(2000);
        return this;
    }
}