package org.example.Lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MyPhotos {

    private static MyPhotos myPhotos;

    private MyPhotos() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("start-maximized");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://www.livejournal.com/");

        WebElement closeCookie = (new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='cookie-notification__button']"))));
        closeCookie.click();
        WebElement webElement1 = driver.findElement(By.cssSelector(".s-userpic"));
        webElement1.click();
        WebElement webElement2 = driver.findElement(By.xpath("//li[2]/a/span"));
        webElement2.click();
        WebElement webElement3 = driver.findElement(By.xpath("//html[@id='js']/body/div[2]/header/div/nav[2]/ul/li[2]/a/span"));
        webElement3.click();
        WebElement webElement4 = driver.findElement(By.cssSelector(".post-card--big > div:nth-child(2) > footer:nth-child(3) > ul:nth-child(1) > li:nth-child(2) > a:nth-child(1) > span"));
        webElement4.click();
        WebElement webElement5 = driver.findElement(By.xpath("//li[2]/a/span"));
        webElement5.click();
        driver.quit();
    }
    public static MyPhotos getMyPhotos() {
        if(myPhotos==null) myPhotos = new MyPhotos();
        return myPhotos;
    }
}
