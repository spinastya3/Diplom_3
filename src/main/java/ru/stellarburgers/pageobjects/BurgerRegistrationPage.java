package ru.stellarburgers.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.stellarburgers.BasePage;

public class BurgerRegistrationPage extends BasePage {

    public BurgerRegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//label[text()='Имя']/../input")
    private WebElement nameField;

    @FindBy(xpath = ".//label[text()='Email']/../input")
    private WebElement emailField;

    @FindBy(xpath = ".//label[text()='Пароль']/../input")
    private WebElement passField;

    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private WebElement registrationButton;

    @FindBy(xpath = ".//a[text()='Войти']")
    private WebElement authorisationLink;

    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    private WebElement wrongPassMessage;

    @Step("Вводим имя")
    public void enterName(String name){

        nameField.clear();
        nameField.sendKeys(name);
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

    @Step("Кликаем кнопку Зарегистрироваться")
    public void clickRegistrationButton(){

     registrationButton.click();
    }

    @Step("Регистрируем пользователя")
    public BurgerAuthorisationPage registration(String name, String email, String pass){

        enterName(name);
        enterEmail(email);
        enterPass(pass);
        clickRegistrationButton();
        return new BurgerAuthorisationPage(driver);
    }

    @Step("Кликаем ссылку Войти")
    public BurgerAuthorisationPage clickAuthorisationLink(){
        authorisationLink.click();
        return new BurgerAuthorisationPage(driver);
    }

    @Step("Отображение фразы некорректный пароль")
    public boolean wrongPassMessageVisible(){
           return  wrongPassMessage.isDisplayed();
    }
}
