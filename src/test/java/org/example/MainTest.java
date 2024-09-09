package org.example;

import org.junit.Before;
import org.junit.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainTest {
    MainPage mainPage;
    ElementsPage elementsPage;
    String url = "https://demoqa.com/";
    String testName = "Admin";
    String testEmail = "admin@example.com";

    public MainTest() {
        mainPage = new MainPage();
        elementsPage = new ElementsPage();
    }

    @Before
    public void openPage() {
        mainPage.openMainPage(url);
        log.info("Переход на страницу осуществлен");
    }

    @Test
    public void mainPage() {
        mainPage.clickImg();
        mainPage.openPageElements();
    }

    @Test
    public void elementsPage() {
        mainPage.openPageElements();
        elementsPage.fillingFormTextBox(testName, testEmail);
        elementsPage.doExerciseRadioButton();
        elementsPage.doExerciseButtons();
        elementsPage.doExerciseDynamicProperties();
    }
}
