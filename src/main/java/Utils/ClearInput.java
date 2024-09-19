package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public abstract class ClearInput {
    public static void clearField(WebDriver driver, String locator) {
        driver.findElement(By.xpath(locator)).sendKeys(Keys.CONTROL + "a");
        driver.findElement(By.xpath(locator)).sendKeys(Keys.DELETE);
    }
}
