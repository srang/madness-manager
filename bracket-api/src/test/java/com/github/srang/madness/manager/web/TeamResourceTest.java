package com.github.srang.madness.manager.web;

import com.github.srang.madness.manager.model.Team;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.response.ResponseBody;
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
                .body("$.size()", is(91));
    }

    @Test
    public void testGoodAddEndpoint() {
        given()
            .body("{\"name\": \"Oklahoma\", \"primaryColor\":\"000000\"}")
            .header("Content-Type", "application/json")
            .when().post("/api/teams")
            .then()
                .statusCode(201);
    }

    @Test
    public void testGoodUpdateEndpoint() {
        Team duke = given()
            .when().get("/api/teams/name/Duke")
            .getBody().as(Team.class);
        given()
            .body("{\"name\": \"DOOK\"}")
            .header("Content-Type", "application/json")
            .when().put("/api/teams/id/"+duke.id)
            .then()
            .statusCode(201);
    }

    @Test
    public void testUniqueNamePostEndpoint() {
        given()
            .when().get("/api/teams/name/Duke")
            .then().statusCode(200);

        given()
            .body("{\"name\": \"Duke\", \"primaryColor\":\"000000\"}")
            .header("Content-Type", "application/json")
            .when().put("/api/teams")
            .then()
            .statusCode(400);
    }

    @Test
    public void testUniqueNamePutEndpoint() {
        Team duke = given()
            .when().get("/api/teams/name/Duke")
            .getBody().as(Team.class);
        given()
            .when().get("/api/teams/name/UAB")
            .then().statusCode(200);
        given()
            .body("{\"name\": \"UAB\", \"primaryColor\":\"000000\"}")
            .header("Content-Type", "application/json")
            .when().put("/api/teams/id/"+duke.id)
            .then()
            .statusCode(400);
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
