package org.example.Lesson5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LivejournalTest extends AbstractTest {

    public static Logger logger = LoggerFactory.getLogger(LivejournalTest.class);

    @Test
    void Search() {
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".flaticon--search > path:nth-child(1)"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.id("//*[@id=\"SearchText\"]"));
        webElement2.sendKeys("Кино");
        WebElement webElement3 = getDriver().findElement(By.cssSelector(".s-do-item-search-btn .svgicon"));
        webElement3.click();
        String urlCard = "https://www.livejournal.com/rsearch?q=%D0%9A%D0%B8%D0%BD%D0%BE&sort=_score&searchArea=post";
        Assertions.assertEquals(urlCard, getDriver().getCurrentUrl());
        logger.info("Поиск");
    }

    @Test
    void ButtonWrite() {
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".b-flatbutton:nth-child(1)"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.cssSelector(".s-header-item-post--short"));
        webElement2.click();
        WebElement webElement3 = getDriver().findElement(By.cssSelector(".b-flatbutton:nth-child(1)"));
        webElement3.click();
        logger.info("Кнопка Написать");
    }

    @Test
    void CheckProfile() {
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".s-header-item--user"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.cssSelector(".s-header-item > .b-flatbutton"));
        webElement2.click();
        WebElement webElement3 = getDriver().findElement(By.cssSelector(".s-header-sub-list-item__link--profile"));
        webElement3.click();
        String urlCard = "https://myatochka-life.livejournal.com/profile";
        Assertions.assertEquals(urlCard, getDriver().getCurrentUrl());
        logger.info("Профиль пользователя");
    }

    @Test
    void MyPhotos() {
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".s-userpic"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.xpath("//li[2]/a/span"));
        webElement2.click();
        WebElement webElement3 = getDriver().findElement(By.xpath("//html[@id='js']/body/div[2]/header/div/nav[2]/ul/li[2]/a/span"));
        webElement3.click();
        WebElement webElement4 = getDriver().findElement(By.cssSelector(".post-card--big > div:nth-child(2) > footer:nth-child(3) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1) > span"));
        webElement4.click();
        WebElement webElement5 = getDriver().findElement(By.xpath("//li[2]/a/span"));
        webElement5.click();
        logger.info("Мои фото");
    }

    @Test
    void Auth() {
        WebElement webElement1 = getDriver().findElement(By.cssSelector(".s-header-item__link--login"));
        webElement1.click();
        WebElement webElement2 = getDriver().findElement(By.cssSelector(".b-loginform-field__input"));
        webElement2.sendKeys("Myatochka_life");
        WebElement webElement3 = getDriver().findElement(By.xpath("//*[@id=\"lj_loginwidget_password\"]"));
        webElement3.sendKeys("ABKJ642dZEveQwE");
        WebElement webElement4 = getDriver().findElement(By.xpath("//html/body/div[2]/div[3]/div/div[2]/form[1]/button"));
        webElement4.click();
        logger.info("Авторизация");
    }

    @Test
    void PrivacyPolicy() throws InterruptedException {
        WebElement webElement1 = getDriver().findElement(By.xpath("//footer/div[2]/div[2]/div/ul/li[1]/a"));
        webElement1.click();
        String originalWindow = getDriver().getWindowHandle();
        getDriver().switchTo().newWindow(WindowType.WINDOW);
        getDriver().navigate().to("https://help.rambler.ru/legal/1142/");
        Thread.sleep(10000);
        getDriver().switchTo().window(originalWindow);
        for (String windowHandle : getDriver().getWindowHandles()) {
            System.out.println(windowHandle);
        }
        String urlPress = "https://help.rambler.ru/legal/1142/";
        Assertions.assertEquals(urlPress, getDriver().getCurrentUrl());
        logger.info("Политика конфиденциальности");
        getDriver().close();
    }
}
