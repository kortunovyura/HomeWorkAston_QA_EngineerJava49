import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTests {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "https://postman-echo.com";
    }

    @Test
    public void testGetRequest() {
        given()
                .queryParam("foo1", "bar1")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"));
    }

    @Test
    public void testPostRawText() {
        String body = "Raw text";
        given()
                .contentType(ContentType.TEXT)
                .body(body)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo(body));
    }

    @Test
    public void testPostFormData() {
        given()
                .contentType("application/x-www-form-urlencoded")
                .formParam("key", "value")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("form.key", equalTo("value"));
    }

    @Test
    public void testPutRequest() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"s\":\"ok\"}")
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("json.s", equalTo("ok"));
    }

    @Test
    public void testPatchRequest() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"s\":\"patch\"}")
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("json.s", equalTo("patch"));
    }

    @Test
    public void testDeleteRequest() {
        given()
                .contentType(ContentType.JSON)
                .body("{\"id\":1}")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("json.id", equalTo(1));
    }
}