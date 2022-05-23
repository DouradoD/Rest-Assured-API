package api.publicapis;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@Tag("all_examples")
@Tag("checking_body")
public class CheckingBody {

    private static final String BaseURL = "https://api.publicapis.org/";
    private static final String ENTRIES_PATH = "entries";

    // Must Pass
    @Test
    public void validationAPIByBody() {
        given()
                .when()
                .get(BaseURL + "entries")
                .then()
                .statusCode(200)
                .body("count", greaterThan(1));
    }
}
