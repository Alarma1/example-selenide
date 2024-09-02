package org.example;

import lombok.extern.slf4j.Slf4j;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Slf4j
public class FormsPage {
    WebDriver driver;
    String practiceFormTab = "//span[text()='Practice Form']/ancestor::div[contains(@class,'collapse')]";
    String firstNameInput = "//input[@placeholder='First Name']";
    String lastNameInput = "//input[@placeholder='Last Name']";
    String userEmailInput = "//input[@placeholder='name@example.com']";
    String userPhoneInput = "//input[@placeholder='Mobile Number']";
    String dateOfBirthInput = "//input[@id='dateOfBirthInput']";
    String subjectsInput = "//input[@id='subjectsInput']";
    String downloadInput = "//input[@type='file']";
    String currentAddressInput = "//textarea[@placeholder='Current Address']";
    String maleRadio = "//label[@for='gender-radio-1']";
    String femaleRadio = "//label[@for='gender-radio-2']";
    String otherRadio = "//label[@for='gender-radio-3']";
    String sportsCheckBox = "//label[@for='hobbies-checkbox-1']";
    String readingCheckBox = "//label[@for='hobbies-checkbox-2']";
    String musicCheckBox = "//label[@for='hobbies-checkbox-3']";
    String calendarMonthSelect = "//select[@class='react-datepicker__month-select']";
    String calendarYearSelect = "//select[@class='react-datepicker__year-select']";
    String stateSelect = "//div[text()='Select State']";
    String citySelect = "//div[@id='city']";
    String subjectsOption = "//div[@id='react-select-2-option-0']/ancestor::div[1]";
    String calendarOctoberOption = "//option[@value='9']";
    String calendarYearOption = "//option[@value='1990']";
    String stateOption = "//div[@id='react-select-3-option-1']";
    String cityOption = "//div[@id='react-select-4-option-1']";
    String calendarDayNumber = "//div[text()='10']";
    String submitBtn = "//button[@id='submit']";
    String firstName = "John";
    String lastName = "Doe";
    String userEmail = "john.doe@example.com";
    String userGender = "Other";
    String userDateOfBirth = "10 October,1990";
    String userPhone = "1234567890";
    String subjects = "Maths";
    String userHobbies = "Sports, Reading, Music";
    String userPicture = "Луфи.png";
    String currentAddress = "123 Main St, Springfield";
    String userStateAndCity = "Uttar Pradesh Lucknow";
    String modalTable = "//table";

    public FormsPage(WebDriver browserDriver) {
        driver = browserDriver;
    }

    @Step("Открываем вкладку 'Practice Form'")
    private void openTabPracticeForm() {
        driver.findElement(By.xpath(practiceFormTab)).click();
        log.info("Перешли во вкладку");
    }

    @Step("Заполняем и отправляем форму")
    public void fillingFormRegistrationForm() {
        String studentName = "//td[text()='Student Name']/following-sibling::td";
        String studentEmail = "//td[text()='Student Email']/following-sibling::td";
        String Gender = "//td[text()='Gender']/following-sibling::td";
        String Mobile = "//td[text()='Mobile']/following-sibling::td";
        String dateOfBirth = "//td[text()='Date of Birth']/following-sibling::td";
        String Subjects = "//td[text()='Subjects']/following-sibling::td";
        String Hobbies = "//td[text()='Hobbies']/following-sibling::td";
        String Picture = "//td[text()='Picture']/following-sibling::td";
        String Address = "//td[text()='Address']/following-sibling::td";
        String stateAndCity = "//td[text()='State and City']/following-sibling::td";
        String closeBtn = "//button[text()='Close']";
        openTabPracticeForm();
        driver.findElement(By.xpath(firstNameInput)).sendKeys(firstName);
        log.info("Заполнили поле 'Name'");
        driver.findElement(By.xpath(lastNameInput)).sendKeys(lastName);
        log.info("Заполнили поле 'Last Name'");
        driver.findElement(By.xpath(userEmailInput)).sendKeys(userEmail);
        log.info("Заполнили поле 'Email'");
        driver.findElement(By.xpath(maleRadio)).click();
        log.info("Выбрали Radio button 'Male'");
        driver.findElement(By.xpath(femaleRadio)).click();
        log.info("Выбрали Radio button 'Female'");
        driver.findElement(By.xpath(otherRadio)).click();
        log.info("Выбрали Radio button 'Other'");
        driver.findElement(By.xpath(userPhoneInput)).sendKeys(userPhone);
        log.info("Заполнили поле 'Phone'");
        driver.findElement(By.xpath(dateOfBirthInput)).click();
        log.info("Выбрали поле 'Date of Birth'");
        driver.findElement(By.xpath(calendarMonthSelect)).click();
        log.info("Кликнули на поле выбора месяца");
        driver.findElement(By.xpath(calendarOctoberOption)).click();
        log.info("Выбрали месяц 'October'");
        driver.findElement(By.xpath(calendarYearSelect)).click();
        log.info("Кликнули на поле выбора года");
        driver.findElement(By.xpath(calendarYearOption)).click();
        log.info("Выбрали год '1990'");
        driver.findElement(By.xpath(calendarDayNumber)).click();
        log.info("Выбрали день '10'");
        driver.findElement(By.xpath(subjectsInput)).sendKeys(subjects);
        log.info("Заполнитли поле 'Subjects' для появления списка для выбора выбора");
        driver.findElement(By.xpath(subjectsOption)).click();
        log.info("Заполнили поле 'Subjects'");
        driver.findElement(By.xpath(sportsCheckBox)).click();
        log.info("Выбрали checkbox 'Sport'");
        driver.findElement(By.xpath(readingCheckBox)).click();
        log.info("Выбрали checkbox 'Reading'");
        driver.findElement(By.xpath(musicCheckBox)).click();
        log.info("Выбрали checkbox 'Music'");
        driver.findElement(By.xpath(downloadInput)).sendKeys("E:\\Autotests\\MyTest\\NewProject\\src\\img\\Луфи.png");
        log.info("Загрузили изображение в поле 'Picture'");
        driver.findElement(By.xpath(currentAddressInput)).sendKeys(currentAddress);
        log.info("Заполнили поле 'Current Address'");
        driver.findElement(By.xpath(stateSelect)).click();
        log.info("Выбираем 'Select State'");
        driver.findElement(By.xpath(stateOption)).click();
        log.info("Выбираем 'Select State'");
        driver.findElement(By.xpath(citySelect)).click();
        log.info("Выбираем 'Select City'");
        driver.findElement(By.xpath(cityOption)).click();
        log.info("Выбираем City 'Lucknow'");
        driver.findElement(By.xpath(submitBtn)).click();
        log.info("Жмем на кнопку 'Submit'");

        driver.findElement(By.xpath(modalTable));
        log.info("Проверяем появилось ли модальное окно");
        Assert.assertEquals("Не совпадает Name или Last Name", firstName + " " + lastName, driver.findElement(By.xpath(studentName)).getText());
        Assert.assertEquals("Не совпадает Email", userEmail, driver.findElement(By.xpath(studentEmail)).getText());
        Assert.assertEquals("Не совпадает Gender", userGender, driver.findElement(By.xpath(Gender)).getText());
        Assert.assertEquals("Не совпадает Phone", userPhone, driver.findElement(By.xpath(Mobile)).getText());
        Assert.assertEquals("Не совпадает Date Of Birth", userDateOfBirth, driver.findElement(By.xpath(dateOfBirth)).getText());
        Assert.assertEquals("Не совпадает Subjects", subjects, driver.findElement(By.xpath(Subjects)).getText());
        Assert.assertEquals("Не совпадает Hobbies", userHobbies, driver.findElement(By.xpath(Hobbies)).getText());
        Assert.assertEquals("Не совпадает Picture", userPicture, driver.findElement(By.xpath(Picture)).getText());
        Assert.assertEquals("Не совпадает Current Address", currentAddress, driver.findElement(By.xpath(Address)).getText());
        Assert.assertEquals("Не совпадает State или City", userStateAndCity, driver.findElement(By.xpath(stateAndCity)).getText());
        driver.findElement(By.xpath(closeBtn)).click();
        log.info("Закрываем модальное окно");
    }
}
