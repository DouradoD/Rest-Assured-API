package api.validation.body;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BasicHamcrest {
    public static final String BASE_URL = "https://api.github.com/rate_limit";

    @Test
    public void prettyPeek() {
        RestAssured.given().when().get(BASE_URL).prettyPeek();
    }

    @Test
    public void jsonPathWithHamcrestMethod() {
        JsonPath jsonPath = RestAssured.given().when().given().get(BASE_URL).body().jsonPath();
        Map<String, String> subMap = jsonPath.get("resources.core");
        int limit = jsonPath.get("resources.core.limit");

        assertThat(limit, equalTo(60));
        assertThat(limit, greaterThan(59));
        assertThat(limit, lessThan(61));
        assertThat(limit, is(60));

        assertThat(subMap.get("resource"),
                is("core"));
        assertThat(subMap.get("resource"),
                equalTo("core"));
        assertThat(subMap.get("resource"),
                containsString("co"));
        assertThat(subMap.get("resource"),
                containsStringIgnoringCase("or"));


        assertThat(subMap.get("resource"),
                not(containsString("a")));
        assertThat(subMap.get("resource"),
                not(is("a")));
        assertThat(subMap.get("resource"),
                not(equalTo("a")));
        assertThat(subMap.get("resource"),
                not(containsStringIgnoringCase("a")));


    }

    @Test
    public void bodyWithHamcrest() {
        String limit = "limit";
        String resource = "resource";
        RestAssured.given()
                .when()
                .given()
                .get(BASE_URL)
                .then()
                .rootPath("resources.core")
                .body(limit, equalTo(60))
                .body(limit, greaterThanOrEqualTo(60))
                .body(limit, lessThan(61))
                .body(limit, is(60))
                .body(resource, is("core"))
                .body(resource, equalTo("core"))
                .body(resource, containsString("or"))
                .body(resource, containsStringIgnoringCase("e"))
                .body(resource, not(containsString("a")))
                .body(resource, not(is("graphql")))
                .body(resource, not(equalTo("Core")));
    }
}
