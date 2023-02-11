package org.example.Lesson6.Lesson7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class AbstractTest {
    static EventFiringWebDriver eventDriver;

    @BeforeEach
    void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(10));
        eventDriver = new EventFiringWebDriver(new ChromeDriver(options));
        eventDriver.register(new MyWebDriverEventListener());
        eventDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
//        initMainPage();
        Assertions.assertDoesNotThrow(() -> eventDriver.navigate().to("https://www.livejournal.com/"), "Страница не доступна");
        closeCookie();
}

    private void closeCookie() {
        WebElement closeCookie = (new WebDriverWait(eventDriver, Duration.ofSeconds(3)).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".cookies-banner__button.b-flatbutton"))));
        closeCookie.click();
    }

    @AfterEach
    void close() {
        checkBrowser();
        if(eventDriver !=null) eventDriver.quit();
    }

    public void checkBrowser() {
        List<LogEntry> allLogRows = getDriver().manage().logs().get(LogType.BROWSER).getAll();
        if(!allLogRows.isEmpty()){

            if (allLogRows.size() > 0 ) {
                allLogRows.forEach(logEntry -> {
                    System.out.println(logEntry.getMessage());
                });
            }
        }
    }

    public WebDriver getDriver() {
        return this.eventDriver;
    }

}
