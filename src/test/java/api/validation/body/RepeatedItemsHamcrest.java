package api.validation.body;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class RepeatedItemsHamcrest {
    public static final String BASE_URL = "https://reqres.in/api/users?page=1";

    @Test
    public void prettyPeek() {
        RestAssured.given().when().get(BASE_URL).prettyPeek();
    }

    @Test
    public void checkingRepeatedItems() {
        RestAssured.given()
                .when()
                .given()
                .get(BASE_URL)
                .then()
                .rootPath("data")
                .body("id[0]", equalTo(1))
                .body("id[3]", equalTo(4))
                .body("last_name[3]", equalTo("Holt"))
                .body("avatar[2]", equalTo("https://reqres.in/img/faces/3-image.jpg"))
                .body("first_name", hasItem("Janet"))
                .body("first_name", hasItems("Janet", "Eve"))
                .body("first_name", hasItems(startsWith("Ja")))
                .body("first_name", hasItems(not(endsWith("z"))))
                .body("first_name", hasSize(6))
                .body("first_name", hasSize(6))
        ;
    }
}
