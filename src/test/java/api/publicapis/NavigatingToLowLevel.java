package api.publicapis;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@Tag("all_examples")
public class NavigatingToLowLevel {
    private static final String BaseURL = "https://api.publicapis.org/";
    private static final String ENTRIES_PATH = "entries";

    // Check if all arrays contain the CATEGORY key equal to Animals, it should Fail
    @Test
    public void checkSpecificElementFromArrayOfArray() {

        Response response = given().when().get(BaseURL + ENTRIES_PATH);
        response.then().statusCode(200);
        JsonPath jsonPath = response.jsonPath();

        List<Map> sits;
        sits = jsonPath.getList(ENTRIES_PATH);
        for (Map sit : sits) {
            assertThat(sit.get("Category").toString(), is("Animals"));
        }
    }

    // Must Pass
    @Test
    public void validationAPIByBody() {
        given()
                .when()
                .get(BaseURL + "entries")
                .then()
                .statusCode(200)
                .body("count", is(1420))
                .rootPath("entries[0]")
                .body("API", containsString("opt"))
                .body("", hasEntry("Category", "Animals"))
                .body("", hasKey("Category"))
                .body("", anyOf(hasValue("Animals")))
                .body("", allOf(notNullValue()))
                .body("", anyOf(hasValue("apiKey")));
    }
}
