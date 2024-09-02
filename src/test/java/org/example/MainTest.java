package org.example;

import org.junit.Before;
import org.junit.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainTest {
    String url = "https://demoqa.com/";
    String testName = "Admin";
    String testEmail = "admin@example.com";

    @Before
    public void openPage() {
        new MainPage().openMainPage(url);
        log.info("Переход на страницу осуществлен");
    }

    @Test
    public void mainPage() {
        new MainPage()
                .clickImg()
                .openPageElements();
    }

    @Test
    public void elementsPage() {
        new MainPage().openPageElements();
        new ElementsPage()
                .fillingFormTextBox(testName, testEmail)
                .doExerciseRadioButton()
                .doExerciseButtons()
                .doExerciseDynamicProperties();
    }
}
