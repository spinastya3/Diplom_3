import io.qameta.allure.junit4.DisplayName;
import models.User;
import org.junit.Before;
import org.junit.Test;
import service.UserGenerator;

import static org.junit.Assert.assertTrue;

public class AuthorisationTests extends BaseTest {

    private User user;

    @Before
    public void setUp() {

        user = UserGenerator.user();
        accessToken = userClient.create(user).path("accessToken");
    }

    @Test
    @DisplayName("Проверка авторизации пользователя после перехода на страницу авторизации по кнопке Войти в аккаунт на главной странице")
    public void userAuthorisationFromMainPageButtonMiddle() {

        burgerMainPage
                .clickAccountEntranceButtonMiddle()
                .authorise(user.getEmail(), user.getPassword());

        assertTrue("Нет кнопки оформить заказ", burgerMainPage
                .createOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка авторизации пользователя после перехода на страницу авторизации по кнопке Личный кабинет на главной странице")
    public void userAuthorisationFromMainPageButtonHeader() {

        burgerMainPage
                .clickAccountEntranceButtonHeader()
                .authorise(user.getEmail(), user.getPassword());

        assertTrue("Нет кнопки оформить заказ", burgerMainPage
                .createOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка авторизации пользователя после перехода на страницу авторизации по кнопке Войти на странице регистрации")
    public void userAuthorisationFromRegistrationPage() {

        burgerMainPage
                .clickAccountEntranceButtonMiddle()
                .clickAccountRegistrationLink()
                .clickAuthorisationLink()
                .authorise(user.getEmail(), user.getPassword());

        assertTrue("Нет кнопки оформить заказ", burgerMainPage
                .createOrderButtonVisible());
    }

    @Test
    @DisplayName("Проверка авторизации пользователя после перехода на страницу авторизации по кнопке Войти на странице восстановления пароля")
    public void userAuthorisationFromForgotPassPage() {

        burgerMainPage
                .clickAccountEntranceButtonMiddle()
                .clickAccountGetPassLink()
                .clickEnterLink()
                .authorise(user.getEmail(), user.getPassword());

        assertTrue("Нет кнопки оформить заказ", burgerMainPage
                .createOrderButtonVisible());
    }
}
