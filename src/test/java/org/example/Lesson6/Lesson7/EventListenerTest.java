package org.example.Lesson6.Lesson7;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;


public class EventListenerTest extends AbstractTest {

    @Test
    @DisplayName("Тестирование поиска")
    @Description("Тестируем строку поиск")
    @Link("https://www.livejournal.com/")
    @Severity(SeverityLevel.CRITICAL)
    void Search() {
        try {
            WebElement webElement1 = getDriver().findElement(By.cssSelector(".flaticon--search > path:nth-child(1)"));
            webElement1.click();
            WebElement webElement2 = getDriver().findElement(By.id("//*[@id=\"SearchText\"]"));
            webElement2.sendKeys("Кино");
            WebElement webElement3 = getDriver().findElement(By.cssSelector(".s-do-item-search-btn .svgicon"));
            webElement3.click();
            Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://www.livejournal.com/rsearch?q=%D0%9A%D0%B8%D0%BD%D0%BE&sort=_score&searchArea=post"));
        } catch (NoSuchElementException e) {
            MyUtils.makeScreenshot(getDriver(),
                    "EventListenerTest.test" + System.currentTimeMillis() + ".png");
        }
    }
}

