package org.example;

import Utils.ClearInput;
import Utils.MethodsForStrings;
import lombok.extern.slf4j.Slf4j;
import io.qameta.allure.Step;
import net.datafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.LinkedList;
import java.util.List;


@Slf4j
public class ElementsPageSelenium {
    WebDriver driver;
    Faker fakeData;
    String webTablesTab = "//span[text()='Web Tables']/ancestor::li";
    String addBtn = "//button[text()='Add']";
    String inputSearch = "//input[@placeholder='Type to search']";
    String inputPage = "//input[@aria-label='jump to page']";
    String editBtn = "//div[@role='rowgroup'][1]//span[@title='Edit']";
    String deleteBtn = "//div[@role='rowgroup'][1]//span[@title='Delete']";
    String previousBtn = "//button[text()='Previous']";
    String nextBtn = "//button[text()='Next']";
    String selectCountPage = "//select[@aria-label='rows per page']";
    String optionCountPage = "//option[@value='5']";
    String firstNameModal = "//input[@placeholder='First Name']";
    String lastNameModal = "//input[@placeholder='Last Name']";
    String userEmailModal = "//input[@placeholder='name@example.com']";
    String ageModal = "//input[@placeholder='Age']";
    String salaryModal = "//input[@placeholder='Salary']";
    String departmentModal = "//input[@placeholder='Department']";
    String submitBtnModal = "//button[text()='Submit']";
    String userMailFromTable = "//div[@role='rowgroup']//div[4]";
    String columnFirstName = "//div[text()='First Name']/ancestor::div[@role='columnheader']";

    String columnLastName = "//div[text()='Last Name']/ancestor::div[@role='columnheader']";
    String columnAge = "//div[text()='Age']/ancestor::div[@role='columnheader']";
    String columnEmail = "//div[text()='Email']/ancestor::div[@role='columnheader']";
    String columnSalary = "//div[text()='Salary']/ancestor::div[@role='columnheader']";
    String columnDepartment = "//div[text()='Department']/ancestor::div[@role='columnheader']";
    String cellFirstName = "//div[@class='rt-td'][1]";
    String cellLastName = "//div[@class='rt-td'][2]";
    String cellAge = "//div[@class='rt-td'][3]";
    String cellEmail = "//div[@class='rt-td'][4]";
    String cellSalary = "//div[@class='rt-td'][5]";
    String cellDepartment = "//div[@class='rt-td'][6]";
    String firstName = "Alden";
    String lastName = "Doe";
    String userEmail = "john.doe@example.com";
    String age = "23";
    String salary = "50000";
    String department = "Engineering";


    public ElementsPageSelenium(WebDriver browserDriver) {
        driver = browserDriver;
        fakeData = new Faker();
    }

    @Step("Открываем вкладку 'Web Tables'")
    private void openPageElements() {
        driver.findElement(By.xpath(webTablesTab)).click();
        log.info("Перешли во вкладку");
    }

    @Step("Заполняем форму для нового студента")
    private void fillingForm() {
        driver.findElement(By.xpath(firstNameModal)).sendKeys(fakeData.name().firstName());
        driver.findElement(By.xpath(lastNameModal)).sendKeys(lastName);
        driver.findElement(By.xpath(userEmailModal)).sendKeys(userEmail);
        driver.findElement(By.xpath(ageModal)).sendKeys(age);
        driver.findElement(By.xpath(salaryModal)).sendKeys(salary);
        driver.findElement(By.xpath(departmentModal)).sendKeys(department);
    }

    @Step("Очищаем поля для изменения данных о студеньте")
    private void clearForm() {
        ClearInput.clearField(driver, firstNameModal);
        ClearInput.clearField(driver, lastNameModal);
        ClearInput.clearField(driver, userEmailModal);
        ClearInput.clearField(driver, ageModal);
        ClearInput.clearField(driver, salaryModal);
        ClearInput.clearField(driver, departmentModal);
    }

    @Step("Тестируем форму 'Web Tables'")
    public void fillingFormWebTables() {
        String userBeforeDeletion;
        List<WebElement> rowsColumn;
        LinkedList<String> messagesError = new LinkedList<String>();
        boolean testNotPassed = false;
        Integer countLine;
        String countPage;
        openPageElements();

        ClearInput.clearField(driver, inputSearch);
        driver.findElement(By.xpath(inputSearch)).sendKeys(firstName);
        log.info("Производим поиск по имени работника");
        if (!firstName.equals(driver.findElement(By.xpath("//div[@role='rowgroup']//div//div")).getText())) {
            testNotPassed = true;
            messagesError.add("Работник по имени не найден");
        }
        ClearInput.clearField(driver, inputSearch);

        rowsColumn = driver.findElements(By.xpath(cellFirstName));
        driver.findElement(By.xpath(columnFirstName)).click();
        if (!MethodsForStrings.sortList(driver, rowsColumn, cellFirstName, false)) {
            testNotPassed = true;
            messagesError.add("Столбец 'First Name' не отсортирован 'А - Я'");
        }
        driver.findElement(By.xpath(columnFirstName)).click();
        if (!MethodsForStrings.sortList(driver, rowsColumn, cellFirstName, true)) {
            testNotPassed = true;
            messagesError.add("Столбец 'First Name' не отсортирован 'Я - А'");
        }
        log.info("Сортируем столбец 'First Name'");

        rowsColumn = driver.findElements(By.xpath(cellLastName));
        driver.findElement(By.xpath(columnLastName)).click();
        if (!MethodsForStrings.sortList(driver, rowsColumn, cellLastName, false)) {
            testNotPassed = true;
            messagesError.add("Столбец 'Last Name' не отсортирован 'А - Я'");
        }
        driver.findElement(By.xpath(columnLastName)).click();
        if (!MethodsForStrings.sortList(driver, rowsColumn, cellLastName, true)) {
            testNotPassed = true;
            messagesError.add("Столбец 'Last Name' не отсортирован 'Я - А'");
        }
        log.info("Сортируем столбец 'Last Name'");

        rowsColumn = driver.findElements(By.xpath(cellAge));
        driver.findElement(By.xpath(columnAge)).click();
        if (!MethodsForStrings.sortList(driver, rowsColumn, cellAge, false)) {
            testNotPassed = true;
            messagesError.add("Столбец 'Age' не отсортирован 'А - Я'");
        }
        driver.findElement(By.xpath(columnAge)).click();
        if (!MethodsForStrings.sortList(driver, rowsColumn, cellAge, true)) {
            testNotPassed = true;
            messagesError.add("Столбец 'Age' не отсортирован 'Я - А'");
        }
        log.info("Сортируем столбец 'Age'");

        rowsColumn = driver.findElements(By.xpath(cellEmail));
        driver.findElement(By.xpath(columnEmail)).click();
        if (!MethodsForStrings.sortList(driver, rowsColumn, cellEmail, false)) {
            testNotPassed = true;
            messagesError.add("Столбец 'Email' не отсортирован 'А - Я'");
        }
        driver.findElement(By.xpath(columnEmail)).click();
        if (!MethodsForStrings.sortList(driver, rowsColumn, cellEmail, true)) {
            testNotPassed = true;
            messagesError.add("Столбец 'Email' не отсортирован 'Я - А'");
        }
        log.info("Сортируем столбец 'Email'");

        rowsColumn = driver.findElements(By.xpath(cellSalary));
        driver.findElement(By.xpath(columnSalary)).click();
        if (!MethodsForStrings.sortList(driver, rowsColumn, cellSalary, false)) {
            testNotPassed = true;
            messagesError.add("Столбец 'Salary' не отсортирован 'А - Я'");
        }
        driver.findElement(By.xpath(columnSalary)).click();
        if (!MethodsForStrings.sortList(driver, rowsColumn, cellSalary, true)) {
            testNotPassed = true;
            messagesError.add("Столбец 'Salary' не отсортирован 'Я - А'");
        }
        log.info("Сортируем столбец 'Salary'");

        rowsColumn = driver.findElements(By.xpath(cellDepartment));
        driver.findElement(By.xpath(columnDepartment)).click();
        if (!MethodsForStrings.sortList(driver, rowsColumn, cellDepartment, false)) {
            testNotPassed = true;
            messagesError.add("Столбец 'Department' не отсортирован 'А - Я'");
        }
        driver.findElement(By.xpath(columnDepartment)).click();
        if (!MethodsForStrings.sortList(driver, rowsColumn, cellDepartment, true)) {
            testNotPassed = true;
            messagesError.add("Столбец 'Department' не отсортирован 'Я - А'");
        }
        log.info("Сортируем столбец 'Department'");

        driver.findElement(By.xpath(editBtn)).click();
        log.info("Редактируем данные конкретного работника");
        clearForm();
        fillingForm();
        driver.findElement(By.xpath(submitBtnModal)).click();
        log.info("Сохраняем измененные данные");
        userBeforeDeletion = driver.findElement(By.xpath(userMailFromTable)).getText();

        driver.findElement(By.xpath(deleteBtn)).click();
        log.info("Удаляем работника из списка");
        if (userBeforeDeletion.equals(driver.findElement(By.xpath(userMailFromTable)).getText())) {
            testNotPassed = true;
            messagesError.add("Пользователь не был удален");
        }

        ClearInput.clearField(driver, inputSearch);
        driver.findElement(By.xpath(inputSearch)).sendKeys(age);
        log.info("Производим поиск работника по возрасту");
        if (!age.equals(driver.findElement(By.xpath("//div[@role='rowgroup']//div//div[3]")).getText())) {
            testNotPassed = true;
            messagesError.add("Работник по возразсту не найден");
        }
        ClearInput.clearField(driver, inputSearch);

        for (int i = 0; i < 10; i++) {
            driver.findElement(By.xpath(addBtn)).click();
            fillingForm();
            driver.findElement(By.xpath(submitBtnModal)).click();
        }
        log.info("Добавляем 10 новых работников");

        countLine = MethodsForStrings.lineCount(driver, "//div[@role='rowgroup']//div[@role='row']");
        driver.findElement(By.xpath(selectCountPage)).click();
        log.info("Выбираем поле выбора количества строк в таблице");
        driver.findElement(By.xpath(optionCountPage)).click();
        log.info("Выбираем количество строк '5'");
        if (countLine.equals(MethodsForStrings.lineCount(driver, "//div[@role='rowgroup']//div[@role='row']"))) {
            testNotPassed = true;
            messagesError.add("Количество столбцов не изменилось");
        }
        countPage = driver.findElement(By.xpath(inputPage)).getAttribute("value");
        driver.findElement(By.xpath(nextBtn)).click();
        log.info("Жмем на кнопку 'Next'");
        if (countPage.equals(driver.findElement(By.xpath(inputPage)).getAttribute("value"))) {
            testNotPassed = true;
            messagesError.add("Страница не перключилась на следующую");
        }

        driver.findElement(By.xpath(previousBtn)).click();
        log.info("Жмем на кнопку  'Previous'");
        if (!countPage.equals(driver.findElement(By.xpath(inputPage)).getAttribute("value"))) {
            testNotPassed = true;
            messagesError.add("Страница не перключилась на предыдущую");
        }

        ClearInput.clearField(driver, inputPage);
        driver.findElement(By.xpath(inputPage)).sendKeys("3");
        log.info("Вводим номер страницы");
        driver.findElement(By.xpath(inputPage)).sendKeys(Keys.ENTER);
        log.info("Жмем 'Enter' для перехода на страницу выбранную в прошлом шаге");
        if (!"3".equals(driver.findElement(By.xpath(inputPage)).getAttribute("value"))) {
            testNotPassed = true;
            messagesError.add("Не произошел переход на страницу '3'");
        }
        ClearInput.clearField(driver, inputPage);
        Assert.assertFalse(String.format("Не прошли проверку:%s", messagesError), testNotPassed);
    }
}
