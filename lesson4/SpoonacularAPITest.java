package org.example.lesson4;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.containsString;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class SpoonacularAPITest {

    @BeforeAll
    static void beforeAll() {
        baseURI = "https://api.spoonacular.com";
        requestSpecification = new RequestSpecBuilder()
                .addPathParam("username", "marina-mm081")
                .addQueryParam("hash", "78e82572fb72ec08305e480e90e1695a2fa981ba")
                .addQueryParam("apiKey", "a96c9091e62a49c183828ab44d515dd6")
                .log(LogDetail.ALL)
                .build();

        responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectResponseTime(Matchers.lessThan(5000L))
                .build();
    }
    static String idp;

    @Order(1)
    @Test
    void addShoppingListTest() {

        idp = given()
                .body("{\n"
                        + " \"item\": 1 pkg parmesan cheese,\n"
                        + " \"aisle\": Cheese,\n"
                        + " \"parse\": true\n"
                        + "}")
                .when()
                .post("/mealplanner/{username}/shopping-list/items")
                .prettyPeek()
                .then()
                .extract()
                .jsonPath()
                .get("id")
                .toString();
    }

    @Order(2)
    @Test
    void readShoppingListTest() {
        given()
                .when()
                .get("/mealplanner/{username}/shopping-list")
                .prettyPeek()
                .then()
                .body(containsString("parmesan cheese"));
    }

    @Order(3)
    @Test
    void clearShoppingListTest() {
        given()
                .when()
                .delete("/mealplanner/{username}/shopping-list/items/" + idp);
    }
}
