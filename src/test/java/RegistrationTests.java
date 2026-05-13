import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import models.User;
import org.junit.Before;
import org.junit.Test;
import ru.stellarburgers.pageobjects.BurgerAuthorisationPage;
import ru.stellarburgers.pageobjects.BurgerRegistrationPage;
import service.UserGenerator;

import static org.junit.Assert.assertTrue;
import static org.apache.http.HttpStatus.*;

public class RegistrationTests extends BaseTest {

    private User user;
    private BurgerRegistrationPage burgerRegistrationPage;

    @Before
    public void setUp(){

        burgerRegistrationPage = burgerMainPage
                 .clickAccountEntranceButtonHeader()
                 .clickAccountRegistrationLink();
    }

    @Test
    @DisplayName("Проверка регистрации пользователя с валидными данными")
    public void successRegistrationTest() {

        user = UserGenerator.user();

        BurgerAuthorisationPage burgerAuthorisationPage = burgerRegistrationPage
                .registration(user.getName(), user.getEmail(), user.getPassword());

        accessToken = userClient.login(user).path("accessToken");

        assertTrue("Нет кнопки Войти", burgerAuthorisationPage.accountEntranceButtonVisible());

    }

    @Test
    @DisplayName("Проверка регистрации пользователя с невалидным паролем")
    public void wrongPassRegistrationTest(){

        String shortPass = "test";
        user = UserGenerator.user().withPassword(shortPass);

        burgerRegistrationPage
                .registration(user.getName(), user.getEmail(), shortPass);

        Response response =userClient.login(user);
        if (response.statusCode() == SC_OK) {
            accessToken = response.path("accessToken");
        }

         assertTrue("Нет сообщения об некорректном пароле",burgerRegistrationPage.wrongPassMessageVisible());
    }
}
