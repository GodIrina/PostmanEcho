package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {
    @Test
    public void shouldSendRequestBody() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("some data") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
                //Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"))
        ;
    }

    @Test
    public void shouldSendRequestBody2() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("28") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
                //Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("28"))
        ;
    }

    @Test
    public void shouldSendRequestBody3() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Нетология") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
                //Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("Нетология"))
        ;
    }
    @Test
    void shouldSendRequestHeader() {
        // Given - When - Then
        // Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Water") // отправляемые данные (заголовки и query можно выставлять аналогично)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("headers.content-length", equalTo("5"))
        ;
    }

}



