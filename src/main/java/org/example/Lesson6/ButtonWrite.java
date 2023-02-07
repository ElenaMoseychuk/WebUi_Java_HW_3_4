package org.example.Lesson6;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ButtonWrite extends AbstractPage {

    @FindBy(css = ".b-flatbutton:nth-child(1)")
    private WebElement webElement1;

    @FindBy(css = ".s-header-item-post--short")
    private WebElement webElement2;

    @FindBy(css = ".b-flatbutton:nth-child(1)")
    private WebElement webElement3;

    public ButtonWrite(WebDriver driver) {
        super(driver);
    }

    public ButtonWrite clickWebElement1() {
        webElement1.click();
        return this;
    }

    public ButtonWrite clickWebElement2() {
        webElement1.click();
        return this;
    }

    public ButtonWrite clickWebElement3() {
        webElement1.click();
        return this;
    }
}

