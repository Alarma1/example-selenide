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
        ClearInput.ClearField(driver, firstNameModal);
        ClearInput.ClearField(driver, lastNameModal);
        ClearInput.ClearField(driver, userEmailModal);
        ClearInput.ClearField(driver, ageModal);
        ClearInput.ClearField(driver, salaryModal);
        ClearInput.ClearField(driver, departmentModal);
    }

    @Step("Тестируем форму 'Web Tables'")
    public void fillingFormWebTables() {
        String userBeforeDeletion;
        List<WebElement> rowsColumn;
        int countLine;
        String countPage;

        openPageElements();

        ClearInput.ClearField(driver, inputSearch);
        driver.findElement(By.xpath(inputSearch)).sendKeys(firstName);
        log.info("Производим поиск по имени работника");
        Assert.assertEquals("Работник по имени не найден", firstName, driver.findElement(By.xpath("//div[@role='rowgroup']//div//div")).getText());
        ClearInput.ClearField(driver, inputSearch);

        rowsColumn = driver.findElements(By.xpath(cellFirstName));
        driver.findElement(By.xpath(columnFirstName)).click();
        Assert.assertTrue("Столбец 'First Name' не отсортирован 'А - Я'", MethodsForStrings.sortList(driver, rowsColumn, cellFirstName, false));
        driver.findElement(By.xpath(columnFirstName)).click();
        Assert.assertTrue("Столбец 'First Name' не отсортирован 'Я - А'", MethodsForStrings.sortList(driver, rowsColumn, cellFirstName, true));
        log.info("Сортируем столбец 'First Name'");

        rowsColumn = driver.findElements(By.xpath(cellLastName));
        driver.findElement(By.xpath(columnLastName)).click();
        Assert.assertTrue("Столбец 'Last Name' не отсортирован 'А - Я'", MethodsForStrings.sortList(driver, rowsColumn, cellLastName, false));
        driver.findElement(By.xpath(columnLastName)).click();
        Assert.assertTrue("Столбец 'Last Name' не отсортирован 'Я - А'", MethodsForStrings.sortList(driver, rowsColumn, cellLastName, true));
        log.info("Сортируем столбец 'Last Name'");

        rowsColumn = driver.findElements(By.xpath(cellAge));
        driver.findElement(By.xpath(columnAge)).click();
        Assert.assertTrue("Столбец 'Age' не отсортирован 'А - Я'", MethodsForStrings.sortList(driver, rowsColumn, cellAge, false));
        driver.findElement(By.xpath(columnAge)).click();
        Assert.assertTrue("Столбец 'Age' не отсортирован 'Я - А'", MethodsForStrings.sortList(driver, rowsColumn, cellAge, true));
        log.info("Сортируем столбец 'Age'");

        rowsColumn = driver.findElements(By.xpath(cellEmail));
        driver.findElement(By.xpath(columnEmail)).click();
        Assert.assertTrue("Столбец 'Email' не отсортирован 'А - Я'", MethodsForStrings.sortList(driver, rowsColumn, cellEmail, false));
        driver.findElement(By.xpath(columnEmail)).click();
        Assert.assertTrue("Столбец 'Email' не отсортирован 'Я - А'", MethodsForStrings.sortList(driver, rowsColumn, cellEmail, true));
        log.info("Сортируем столбец 'Email'");

        rowsColumn = driver.findElements(By.xpath(cellSalary));
        driver.findElement(By.xpath(columnSalary)).click();
        Assert.assertTrue("Столбец 'Salary' не отсортирован 'А - Я'", MethodsForStrings.sortList(driver, rowsColumn, cellSalary, false));
        driver.findElement(By.xpath(columnSalary)).click();
        Assert.assertTrue("Столбец 'Salary' не отсортирован 'Я - А'", MethodsForStrings.sortList(driver, rowsColumn, cellSalary, true));
        log.info("Сортируем столбец 'Salary'");

        rowsColumn = driver.findElements(By.xpath(cellDepartment));
        driver.findElement(By.xpath(columnDepartment)).click();
        Assert.assertTrue("Столбец 'Department' не отсортирован 'А - Я'", MethodsForStrings.sortList(driver, rowsColumn, cellDepartment, false));
        driver.findElement(By.xpath(columnDepartment)).click();
        Assert.assertTrue("Столбец 'Department' не отсортирован 'Я - А'", MethodsForStrings.sortList(driver, rowsColumn, cellDepartment, true));
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
        Assert.assertNotEquals("Пользователь не был удален", userBeforeDeletion, driver.findElement(By.xpath(userMailFromTable)).getText());

        ClearInput.ClearField(driver, inputSearch);
        driver.findElement(By.xpath(inputSearch)).sendKeys(age);
        log.info("Производим поиск работника по возрасту");
        Assert.assertEquals("Работник по возразсту не найден", age, driver.findElement(By.xpath("//div[@role='rowgroup']//div//div[3]")).getText());
        ClearInput.ClearField(driver, inputSearch);

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
        Assert.assertNotEquals("Колличество столбцов не изменилось", countLine, MethodsForStrings.lineCount(driver, "//div[@role='rowgroup']//div[@role='row']"));

        countPage = driver.findElement(By.xpath(inputPage)).getAttribute("value");
        driver.findElement(By.xpath(nextBtn)).click();
        log.info("Жмем на кнопку 'Next'");
        Assert.assertNotEquals("Страница не перключилась на следующую", countPage, driver.findElement(By.xpath(inputPage)).getAttribute("value"));

        driver.findElement(By.xpath(previousBtn)).click();
        log.info("Жмем на кнопку  'Previous'");
        Assert.assertEquals("Страница не перключилась на предыдущую", countPage, driver.findElement(By.xpath(inputPage)).getAttribute("value"));

        ClearInput.ClearField(driver, inputPage);
        driver.findElement(By.xpath(inputPage)).sendKeys("3");
        log.info("Вводим номер страницы");
        driver.findElement(By.xpath(inputPage)).sendKeys(Keys.ENTER);
        log.info("Жмем 'Enter' для перехода на страницу выбранную в прошлом шаге");
        Assert.assertEquals("Не произошел переход на страницу '3'", "3", driver.findElement(By.xpath(inputPage)).getAttribute("value"));
        ClearInput.ClearField(driver, inputPage);
    }
}
