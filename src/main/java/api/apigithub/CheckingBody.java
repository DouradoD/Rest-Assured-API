package api.apigithub;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckingBody {

    public static final String BASE_URL = "https://api.github.com/rate_limit";

    @Test
    public void prettyPeek() {
        RestAssured.given().when().get(BASE_URL).prettyPeek();
    }

    @Test
    public void basicMethods() {
        RestAssured.given().
                when().get(BASE_URL).
                then().body("resources", notNullValue()).
                body(containsString("resources"));
    }

    @Test
    public void jsonPathMethod() {
        JsonPath jsonPath = RestAssured.given().when().given().get(BASE_URL).body().jsonPath();
        Map<String, String> fullJson = jsonPath.get();
        Map<String, String> subMap = jsonPath.get("resources");
        System.out.println(fullJson);
        System.out.println(subMap);

        assertTrue(fullJson.containsKey("resources"));
        assertTrue(subMap.containsKey("core"));


    }

    @Test
    public void rootPath() {
        RestAssured.given().when().get(BASE_URL)
                .then()
//                body("resources", response -> containsString(response.body().jsonPath().get("resources")));
                .rootPath("resources.core")
                .body("limit", is(60))
                .body("remaining", equalTo(60))
                .body("reset", is(notNullValue()))
                .rootPath("resources.search")
                .body("limit", equalTo(10))
                .noRootPath()
                .body("resources.graphql.limit", equalTo(0));


    }
}
