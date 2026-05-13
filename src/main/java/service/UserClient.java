package service;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import models.User;

import static io.restassured.RestAssured.given;

public class UserClient {

    private static final String CLIENT_REGISTRATION_PATH = "/api/auth/register";
    private static final String CLIENT_DELETE_PATH = "/api/auth/user";
    private static final String CLIENT_LOGIN_PATH = "/api/auth/login";

    @Step("Создание пользователя")
    public Response create(User user) {
        return given()
                .header("Content-type", "application/json")
                .body(user)
                .post(CLIENT_REGISTRATION_PATH);
    }

    @Step("Авторизация пользователя")
    public Response login(User user) {
        return  given()
                .header("Content-type", "application/json")
                .body(user)
                .post(CLIENT_LOGIN_PATH);
    }


    @Step("Удаление пользователя")
    public void delete(String accessToken) {

        given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .log().all()
                .delete(CLIENT_DELETE_PATH);
    }
}