package ru.stellarburgers.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.stellarburgers.BasePage;

public class BurgerAuthorisationPage extends BasePage {

    public BurgerAuthorisationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[name='name']")
    private WebElement emailField;

    @FindBy(css = "input[name='Пароль']")
    private WebElement passField;

    @FindBy(xpath = ".//button[text()='Войти']")
    private WebElement accountEntranceButton;

    @FindBy(xpath = ".//a[text()='Зарегистрироваться']")
    private WebElement accountRegistrationLink;

    @FindBy(xpath = ".//a[text()='Восстановить пароль']")
    private WebElement accountGetPassLink;

    @Step("Кликаем ссылку Зарегистрироваться")
    public BurgerRegistrationPage clickAccountRegistrationLink() {
        accountRegistrationLink.click();
        return new BurgerRegistrationPage(driver);
    }

    @Step("Кнопка Войти на странице автоизации")
    public boolean accountEntranceButtonVisible(){
        return accountEntranceButton.isDisplayed();
    }

    @Step("Вводим email")
    public void enterEmail(String email){

        emailField.clear();
                emailField.sendKeys(email);
    }

    @Step("Вводим пароль")
    public void enterPass(String pass){

        passField.clear();
        passField.sendKeys(pass);
    }

    @Step("Кликаем кнопку Войти")
    public void clickAccountEntranceButton(){

        accountEntranceButton.click();
    }

    @Step("Авторизуем пользователя")
    public BurgerMainPage authorise(String email, String pass){

        enterEmail(email);
        enterPass(pass);
        clickAccountEntranceButton();
        return new BurgerMainPage(driver);
    }

    @Step("Кликаем ссылку Восстановить пароль")
    public BurgerForgotPassPage clickAccountGetPassLink(){
        accountGetPassLink.click();
        return new BurgerForgotPassPage(driver);
    }
}
