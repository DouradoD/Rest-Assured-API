import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

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
        .body("count", is(1420))
        .body(ENTRIES_PATH, hasSize(1420));
  }
}
