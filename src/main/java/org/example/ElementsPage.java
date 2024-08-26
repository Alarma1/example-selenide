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
    SelenideElement textBoxTab = $x("//span[text()='Text Box']/ancestor::li[@id='item-0']");
    SelenideElement titleBoxTab = $x("//h1[text()='Text Box']");
    SelenideElement radioButtonTab = $x("//span[text()='Radio Button']/ancestor::li[@id='item-2']");
    SelenideElement titleRadioButton = $x("//h1[text()='Radio Button']");
    SelenideElement buttonsTab = $x("//span[text()='Buttons']/ancestor::li[@id='item-4']");
    SelenideElement titleButtons = $x("//h1[text()='Buttons']");
    SelenideElement dynamicPropertiesTab = $x("//span[text()='Dynamic Properties']/ancestor::li[@id='item-8']");
    SelenideElement titleDynamicProperties = $x("//h1[text()='Dynamic Properties']");
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

    @Step("Открываем вкладку 'Text Box'")
    private void openTabTextBox() {
        textBoxTab.shouldBe(visible).click();
        titleBoxTab.shouldBe(visible);
        log.info("Перешли во вкладку");
    }

    @Step("Открываем вкладку 'Radio Button'")
    private void openTabRadioButton() {
        radioButtonTab.shouldBe(visible).click();
        titleRadioButton.shouldBe(visible);
        log.info("Перешли во вкладку");
    }

    @Step("Открываем вкладку 'Buttons'")
    private void openTabButtons() {
        buttonsTab.shouldBe(visible).click();
        titleButtons.shouldBe(visible);
        log.info("Перешли во вкладку");
    }

    @Step("Открываем вкладку 'Dynamic Properties'")
    private void openTabDynamicProperties() {
        dynamicPropertiesTab.shouldBe(visible).click();
        titleDynamicProperties.shouldBe(visible);
        log.info("Перешли во вкладку");
    }

    @Step("Кликаем на вкладку 'Text Box',заполняем форму 'Text Box' и жмем кнопу подтверждения")
    public ElementsPage fillingFormTextBox(String name, String email) {
        openTabTextBox();
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
        //        sleep(2000); // Можно включить для визуальной демонстации выполенения теста.
        return this;
    }

    @Step("Кликаем на вкладку 'Radio Button',переключаем и проверяем результат 'Radio Button'")
    public ElementsPage doExerciseRadioButton() {
        openTabRadioButton();
        sleep(200);
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
        //        sleep(2000); // Можно включить для визуальной демонстации выполенения теста.
        return this;
    }

    @Step("Кликаем на вкладку 'Buttons',кликаем на каждую кнопку и проверяем результат.")
    public ElementsPage doExerciseButtons() {
        openTabButtons();

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
        //        sleep(2000); // Можно включить для визуальной демонстации выполенения теста.
        return this;
    }

    @Step("Кликаем на вкладку 'Dynamic Properties',проверяем состояние кнопок.")
    public void doExerciseDynamicProperties() {
        openTabDynamicProperties();
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
        //        sleep(2000); // Можно включить для визуальной демонстации выполенения теста.
    }
}
