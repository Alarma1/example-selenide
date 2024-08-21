package org.example;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$x;
import static org.junit.Assert.*;

@Slf4j
public class ElementsPage {
    SelenideElement textBoxTab = $x("//span[text()='Text Box']/..");
    SelenideElement radioButtonTab = $x("//span[text()='Radio Button']/..");
    SelenideElement buttonTab = $x("//span[text()='Buttons']/..");
    SelenideElement dynamicPropertiesTab = $x("//span[text()='Dynamic Properties']/..");
    SelenideElement nameField = $x("//input[@placeholder='Full Name']");
    SelenideElement nameFieldResult = $("#name");
    SelenideElement emailField = $x("//input[@placeholder='name@example.com']");
    SelenideElement emailFieldResult = $("#email");
    SelenideElement currentAddressField = $("#currentAddress");
    SelenideElement currentAddressResult = $("#currentAddress", 1);
    SelenideElement permanentAddressField = $("#permanentAddress");
    SelenideElement permanentAddressResult = $("#permanentAddress", 1);
    SelenideElement submitBtn = $("#submit");
    SelenideElement radioButtonYesActive = $x("//label[@for='yesRadio']");
    SelenideElement radioButtonYesStatus = $("#yesRadio");
    SelenideElement radioButtonImpressiveActive = $x("//label[@for='impressiveRadio']");
    SelenideElement radioButtonImpressiveStatus = $("#impressiveRadio");
    SelenideElement radioButtonNoStatus = $("#noRadio");
    SelenideElement doubleClickBtn = $x("//button[@id='doubleClickBtn']");
    SelenideElement textRelatedDCBtn = $x("//p[@id='doubleClickMessage']");
    SelenideElement rightClickBtn = $x("//button[@id='rightClickBtn']");
    SelenideElement textRelatedRCBtn = $x("//p[@id='rightClickMessage']");
    SelenideElement clickMeBtn = $x("//button[text()='Click Me']");
    SelenideElement textRelatedCBtn = $x("//p[@id='dynamicClickMessage']");
    SelenideElement delayBtn = $x("//button[@id='enableAfter']");
    SelenideElement redTextBtn = $x("//button[@id='colorChange']");
    SelenideElement invisibleBtn = $x("//button[@id='visibleAfter']");

    @Step("Кликаем на вкладку 'TextBox', заполняем форму и жмем кнопу подтверждения")
    public ElementsPage openPageClickTextBox(String name, String email) {
        textBoxTab.shouldBe(visible).click();
        log.info("Переши во вкладку.");

        nameField.shouldBe(visible).sendKeys(name);
        emailField.shouldBe(visible).sendKeys(email);
        currentAddressField.shouldBe(visible).sendKeys(name + name);
        permanentAddressField.shouldBe(visible).sendKeys(email);
        log.info("Заполнил форму.");

        submitBtn.shouldBe(visible).scrollTo().click();
        log.info("Нажали кнопку подтверждения.");

        assertEquals("Введенное значение имени отличается", "Name:" + name, nameFieldResult.shouldBe(visible).getText());
        assertEquals("Введенное значение почты отличается", "Email:" + email, emailFieldResult.shouldBe(visible).getText());
        assertEquals("Введенное значение адреса прописки отличается", "Current Address :" + name + name, currentAddressResult.shouldBe(visible).getText());
        assertEquals("Введенное значение адреса проживания отличается", "Permananet Address :" + email, permanentAddressResult.shouldBe(visible).getText());
        log.info("Проверили заполненные данные.");
        sleep(2000);
        return this;
    }

    @Step("Кликаем на вкладку 'RadioButton',перключаем и проверяем результат RadioButton")
    public ElementsPage openPageClickElementRadioButton() {
        radioButtonTab.shouldBe(visible).click();
        log.info("Переши во вкладку.");

        sleep(1000);
        radioButtonYesActive.shouldBe(visible).click();
        log.info("Выбираем поле.");
        assertTrue("'Yes' не выбрано", radioButtonYesStatus.should(exist).isSelected());
        assertFalse("'Impressive' не должен быть выбран", radioButtonImpressiveStatus.should(exist).isSelected());
        log.info("Проверяем состояние элемента.");

        radioButtonImpressiveActive.shouldBe(visible).click();
        log.info("Выбираем поле.");
        assertTrue("'impressive' не выбрано", radioButtonImpressiveStatus.should(exist).isSelected());
        assertFalse("'Yes' не должен быть выбран", radioButtonYesStatus.should(exist).isSelected());
        log.info("Проверяем состояние элемента.");

        assertFalse("'No' доступно для выбора", radioButtonNoStatus.should(exist).isEnabled());
        log.info("Проверяем состояние элемента.");
        sleep(2000);
        return this;
    }

    @Step("Кликаем на вкладку 'Button',кликаем на каждую кнопку и проверяем результат.")
    public ElementsPage openPageClickElementButtons() {
        buttonTab.shouldBe(visible).click();
        log.info("Переши во вкладку.");

        doubleClickBtn.shouldBe(visible, Duration.ofSeconds(1)).doubleClick();
        log.info("Кликаем дважды на кнопку.");
        assertEquals("Двойное нажатие на кнопку 'Double Click Me' не выполнено", "You have done a double click", textRelatedDCBtn.getText());
        log.info("Проверяем появление текста после клика.");

        rightClickBtn.shouldBe(visible).contextClick();
        log.info("Кликаем правой кнопкой мыши.");
        assertEquals("Нажатие правой кнопкой мыши на кнопку 'Right Click Me' не выполнено", "You have done a right click", textRelatedRCBtn.getText());
        log.info("Проверяем появление текста после клика.");


        clickMeBtn.shouldBe(visible).click();
        log.info("Кликаем на кнопку.");
        assertEquals("Нажатие на кнопку 'Click Me' не выполнено", "You have done a dynamic click", textRelatedCBtn.getText());
        log.info("Проверяем появление текста после клика.");
        sleep(2000);
        return this;
    }

    @Step("Кликаем на вкладку 'Dynamic Properties',проверяем состояние кнопок.")
    public void openPageClickElementDynamic() {
        dynamicPropertiesTab.shouldBe(visible).click();
        log.info("Переши во вкладку.");

        assertEquals("Кнопка доступна", "true", delayBtn.shouldBe(visible).getAttribute("disabled"));
        log.info("Проверяем наличие атрибута до прошествия 5 секунд.");
        sleep(5000);
        assertNull("Кнопка не доступна", delayBtn.shouldBe(visible).getAttribute("disabled"));
        log.info("Проверяем наличие атрибута после прошествия 5 секунд.");

        String rightClass = redTextBtn.shouldBe(visible).getAttribute("class");
        assertNotNull("Нет класса", rightClass);
        log.info("Проверяем наличие классов в атрибуте 'Class'");

        assertTrue("Цвет кнопки не изменился", rightClass.contains("text-danger"));
        log.info("Проверяем наличие нужного класса в атрибуте.");

        assertTrue("Кнопка не появилась", invisibleBtn.shouldBe(visible).exists());
        log.info("Проверяем что кнопка появилась в DOM");
        sleep(2000);
    }
}
