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

public class Search {

    private static Search search;

    private Search() {
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
        WebElement webElement1 = driver.findElement(By.xpath("/symbol/path[1]"));
        webElement1.click();
        WebElement webElement2 = driver.findElement(By.id("//*[@id=\"SearchText\"]"));
        webElement2.sendKeys("Кино");
        WebElement webElement3 = driver.findElement(By.cssSelector(".s-do-item-search-btn .svgicon"));
        webElement3.click();
        driver.quit();
    }

    public static Search getSearch() {
        if (search == null) search = new Search();
        return search;

    }
}
