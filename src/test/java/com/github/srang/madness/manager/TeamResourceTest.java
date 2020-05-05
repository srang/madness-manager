package com.github.srang.madness.manager;

import com.github.srang.madness.manager.model.Team;
import io.quarkus.test.junit.QuarkusTest;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;

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
            .body("{\"name\": \"UNC\", \"primaryColor\":\"FFF\"}")
            .header("Content-Type", "application/json")
            .when().post("/api/teams")
            .then()
                .statusCode(200);
    }

    @Test
    public void testBadAddEndpoint() {
        given()
            .body("{\"name\": \"UNC\", \"primaryColor\":\"QQQ\"}")
            .header("Content-Type", "application/json")
            .when().post("/api/teams")
            .then()
            .statusCode(400);
    }

}
