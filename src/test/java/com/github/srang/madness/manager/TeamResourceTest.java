package com.github.srang.madness.manager;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class TeamResourceTest {
    @Test
    public void testListEndpoint() {
        given()
            .when().get("/api/teams")
            .then()
                .statusCode(200)
                .body("$.size()", is(1),
                    "[0].name", is("Duke"));
    }

    @Test
    public void testGoodAddEndpoint() {
        given()
            .body("{\"name\": \"UNC\", \"primaryColor\":\"F9F\"}")
            .header("Content-Type", "application/json")
            .when().post("/api/teams")
            .then()
                .statusCode(200);
    }

    @Test
    public void testBadLettersAddEndpoint() {
        given()
            .body("{\"name\": \"UNC\", \"primaryColor\":\"QQQ\"}")
            .header("Content-Type", "application/json")
            .when().post("/api/teams")
            .then()
            .statusCode(400);
    }

    @Test
    public void testBadLetterCountAddEndpoint() {
        given()
            .body("{\"name\": \"UNC\", \"primaryColor\":\"F1F2\"}")
            .header("Content-Type", "application/json")
            .when().post("/api/teams")
            .then()
            .statusCode(400);
        given()
            .body("{\"name\": \"UNC\", \"primaryColor\":\"F\"}")
            .header("Content-Type", "application/json")
            .when().post("/api/teams")
            .then()
            .statusCode(400);
        given()
            .body("{\"name\": \"UNC\", \"primaryColor\":\"FFFFFFFFF\"}")
            .header("Content-Type", "application/json")
            .when().post("/api/teams")
            .then()
            .statusCode(400);
    }

    @Test
    public void testBadMissingFieldAddEndpoint() {
        given()
            .body("{\"name\": \"UNC\"}")
            .header("Content-Type", "application/json")
            .when().post("/api/teams")
            .then()
            .statusCode(400);
    }

    @Test
    public void testBadMediaAddEndpoint() {
        given()
            .body("{\"name\": \"UNC\", \"primaryColor\":\"QQQ\"}")
            .when().post("/api/teams")
            .then()
            .statusCode(415);
    }
}
