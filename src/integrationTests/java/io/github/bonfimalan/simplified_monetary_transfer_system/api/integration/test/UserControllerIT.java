package io.github.bonfimalan.simplified_monetary_transfer_system.api.integration.test;

import io.github.bonfimalan.simplified_monetary_transfer_system.Random;
import io.github.bonfimalan.simplified_monetary_transfer_system.api.integration.test.config.ApiIntegrationTest;
import io.restassured.builder.RequestSpecBuilder;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

public class UserControllerIT extends ApiIntegrationTest {

    @Test
    void should() {
        var email = Random.email();
        var document = Random.cpf();

        var body = new HashMap<String, Object>();
        body.put("fullName", "Test");
        body.put("document", document);
        body.put("email", email);
        body.put("password", "password");
        body.put("userType", "USER");

        given()
                .spec(new RequestSpecBuilder()
                        .addHeader("Accept", "application/json")
                        .addHeader("Content-Type", "application/json")
                        .build())
                .basePath("/api/v1")
                .body(body)
                .when()
                .post("/users")
                .then()
                .statusCode(201)
                .body("fullName", is("Test"))
                .body("document", is(document))
                .body("email", is(email))
                .body("password", is(nullValue()))
                .body("balance", is(0.0F));
    }

}
