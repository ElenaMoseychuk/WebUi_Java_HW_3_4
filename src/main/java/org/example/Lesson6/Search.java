package org.example.Lesson6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class Search extends AbstractPage {

    @FindBy(css = ".flaticon--search > path:nth-child(1)")
    private WebElement webElement1;

    @FindBy(id = "//*[@id=\"SearchText\"]")
    private WebElement webElement2;

    @FindBy(css = ".s-do-item-search-btn .svgicon")
    private WebElement webElement3;

    public Search(WebDriver driver) {
        super(driver);
    }

    public Search clickWebElement1() {
        webElement1.click();
        return this;
    }

    public Search sendKeysWebElement2() {
        webElement2.sendKeys("Кино");
        return this;
    }

    public Search clickWebElement3() {
        webElement3.click();
        return this;
    }


    public void cardSelection(int n) throws InterruptedException {
         Thread.sleep(5000);
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
    }
}