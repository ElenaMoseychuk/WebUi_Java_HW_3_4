package org.example.Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckProfile extends AbstractPage {

    @FindBy(css = ".s-header-item--user")
    private WebElement webElement1;

    @FindBy(css = ".s-header-item > .b-flatbutton")
    private WebElement webElement2;

    @FindBy(css = ".s-header-sub-list-item__link--profile")
    private WebElement webElement3;

    public CheckProfile(WebDriver driver) {
        super(driver);
    }
    public CheckProfile clickWebElement1() {
        webElement1.click();
        return this;
    }
    public CheckProfile clickWebElement2() {
        webElement2.click();
        return this;
    }
    public CheckProfile clickWebElement3() {
        webElement3.click();
        return this;
    }
}
