package org.example.Lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Auth extends AbstractPage {

    @FindBy(css = ".s-header-item__link--login")
    private WebElement webElement1;

    @FindBy(css = ".b-loginform-field__input")
    private WebElement webElement2;

    @FindBy(xpath = "//*[@id=\"lj_loginwidget_password\"]")
    private WebElement webElement3;

    @FindBy(xpath = "//html/body/div[2]/div[3]/div/div[2]/form[1]/button")
    private WebElement webElement4;

    public Auth(WebDriver driver) {
        super(driver);
    }

    public Auth clickWebElement1() {
        webElement1.click();
        return this;
    }

    public Auth sendKeysWebElement2() {
        webElement2.sendKeys("Myatochka_life");
        return this;
    }

    public Auth sendKeysWebElement3() {
        webElement3.sendKeys("ABKJ642dZEveQwE");
        return this;
    }
    public Auth clickWebElement4() {
        webElement4.click();
        return this;
    }

}
