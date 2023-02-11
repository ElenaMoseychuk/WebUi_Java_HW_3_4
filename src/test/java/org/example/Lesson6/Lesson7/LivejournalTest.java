package org.example.Lesson6.Lesson7;

import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Story("Тестирование Livejournal")
public class LivejournalTest extends AbstractTest {

    @Test
    @DisplayName("Тестировние кнопки написать")
    @Link("https://www.livejournal.com/")
    @Severity(SeverityLevel.MINOR)
    void ButtonWrite() throws IOException {
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".b-flatbutton:nth-child(1)"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.cssSelector(".s-header-item-post--short"));
        webElement2.click();
        WebElement webElement3 = getDriver().findElement(By.cssSelector(".b-flatbutton:nth-child(1)"));
        webElement3.click();
        saveScreen("Кнопка написать");
        String urlRequest = "https://www.livejournal.com/post";
//        Assertions.assertEquals(urlRequest, getDriver().getCurrentUrl());
    }
    private void saveScreen(String name) throws IOException {
        File file = MyUtils.makeScreenshot(getDriver(),name + " " + System.currentTimeMillis() + ".png");
        saveScreenshot(Files.readAllBytes(file.toPath()));
    }
    @Step("Степ 1")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }

    @Test
    @DisplayName("Тестировние кнопки профиль")
    @Link("https://www.livejournal.com/")
    @Severity(SeverityLevel.CRITICAL)
    void CheckProfile() throws InterruptedException, IOException {
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".s-header-item--user"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.cssSelector(".s-header-item > .b-flatbutton"));
        webElement2.click();
        WebElement webElement3 = getDriver().findElement(By.cssSelector(".s-header-sub-list-item__link--profile"));
        webElement3.click();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://myatochka-life.livejournal.com/profile"));
        saveScreen("Кнопка профиль");
            }

    @Test
    @DisplayName("Тестировние аторизации профиля пользователя")
    @Link("https://www.livejournal.com/")
    @Severity(SeverityLevel.CRITICAL)
    void Auth() throws InterruptedException, IOException {
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.cssSelector(".b-loginform-field__input"));
        webElement2.sendKeys("Myatochka_life");
        WebElement webElement3 = getDriver().findElement(By.xpath("//*[@id=\"lj_loginwidget_password\"]"));
        webElement3.sendKeys("ABKJ642dZEveQwE");
        WebElement webElement4 = getDriver().findElement(By.xpath("//html/body/div[2]/div[3]/div/div[2]/form[1]/button"));
        webElement4.click();
        Assertions.assertTrue(getDriver().getCurrentUrl().contains("https://www.livejournal.com/"));
        saveScreen("Авторизация пользователя");
    }
    }

