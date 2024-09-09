package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class MethodsForStrings {
    public static int lineCount(WebDriver driver, String xpath) {
        List<WebElement> list = driver.findElements(By.xpath(xpath));
        return list.size();
    }

    public static boolean sortList(WebDriver driver, List<WebElement> origin, String locator, boolean reverse) {
        List<WebElement> countLines = driver.findElements(By.xpath(locator));
        List<String> textListOrigin = new ArrayList<>();
        List<String> textListChanged = new ArrayList<>();

        for (WebElement list : origin) {
            if (!list.getText().isBlank()) {
                textListOrigin.add(list.getText());
            }
        }

        for (WebElement list : countLines) {
            if (!list.getText().isBlank()) {
                textListChanged.add(list.getText());
            }
        }

        Comparator<String> comparator = (s1, s2) -> {
            try {
                Float f1 = Float.parseFloat(s1);
                Float f2 = Float.parseFloat(s2);
                return f1.compareTo(f2);
            } catch (NumberFormatException e) {
                return s1.compareTo(s2);
            }
        };

        if (reverse) {
            textListOrigin.sort(comparator.reversed());
        } else {
            textListOrigin.sort(comparator);
        }

        return textListOrigin.equals(textListChanged);
    }

}
