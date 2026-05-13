package ru.stellarburgers.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.stellarburgers.BasePage;

public class BurgerMainPage extends BasePage {

    public BurgerMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    private WebElement accountEntranceButtonMiddle;

    @FindBy(xpath = ".//p[text()='Личный Кабинет']")
    private WebElement accountEntranceButtonHeader;

    @FindBy(xpath = ".//span[text()='Булки']/parent::div")
    private WebElement bunsTab;

    @FindBy(xpath = ".//span[text()='Соусы']/parent::div")
    private WebElement saucesTab;

    @FindBy(xpath = ".//span[text()='Начинки']/parent::div")
    private WebElement fillingsTab;

    @FindBy(xpath = ".//button[text()='Оформить заказ']")
    private WebElement createOrderButton;

    @Step("Кликаем кнопку Войти в аккаунт по центру страницы")
    public BurgerAuthorisationPage clickAccountEntranceButtonMiddle() {
            accountEntranceButtonMiddle.click();
        return new BurgerAuthorisationPage(driver);
    }

    @Step("Кликаем кнопку Личный кабинет в хедере страницы")
    public BurgerAuthorisationPage clickAccountEntranceButtonHeader() {
        accountEntranceButtonHeader.click();
        return new BurgerAuthorisationPage(driver);
    }

    @Step("Кликаем вкладку Булки")
    public void clickBunTab() {
        bunsTab.click();
    }
    @Step("Кликаем вкладку Соусы")
    public BurgerMainPage clickSaucesTab() {
        saucesTab.click();
        return this;
    }
    @Step("Кликаем вкладку Начинки")
    public void clickFillingsTab() {
        fillingsTab.click();
    }

    @Step("Вкладка Булки стала активной")
    public boolean bunTabActive(){
        return bunsTab.getAttribute("class").contains("current");
    }

    @Step("Вкладка Соусы стала активной")
    public boolean saucesTabActive(){
        return saucesTab.getAttribute("class").contains("current");
    }
    @Step("Вкладка Начинки стала активной")
    public boolean fillingsTabActive(){
        return fillingsTab.getAttribute("class").contains("current");
    }

    @Step("Видим кнопку Оформить заказ")
    public boolean createOrderButtonVisible(){
        return createOrderButton.isDisplayed();
    }
}