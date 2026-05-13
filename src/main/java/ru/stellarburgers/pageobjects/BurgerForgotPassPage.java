package ru.stellarburgers.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.stellarburgers.BasePage;

public class BurgerForgotPassPage extends BasePage {

    public BurgerForgotPassPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//a[text()='Войти']")
    private WebElement enterLink;

    @Step("Кликаем ссылку Войти")
    public BurgerAuthorisationPage clickEnterLink(){
        enterLink.click();
        return new BurgerAuthorisationPage(driver);
    }
}

