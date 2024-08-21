package org.example;

import org.example.ElementsPage;
import org.example.MainPage;
import org.junit.Before;
import org.junit.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainTest {
    String Url = "https://demoqa.com";
    String testName = "Admin";
    String testEmail = "admin@example.com";

    @Before
    public void openPage() {
        new MainPage().openMainPage(Url);
        log.info("Переход на страницу осуществлен");
    }

    @Test
    public void mainPage() {
        new MainPage()
                .clickImg()
                .openItemMenuElement();
    }

    @Test
    public void elementsPage() {
        new MainPage().openItemMenuElement();

        new ElementsPage()
                .openPageClickTextBox(testName, testEmail)
                .openPageClickElementRadioButton()
                .openPageClickElementButtons()
                .openPageClickElementDynamic();
    }
}
