package api.publicapis;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class CheckingHeaders {
    private static final String BaseURL = "https://api.publicapis.org/";
    private static final String ENTRIES_PATH = "entries";

    // Must Pass
    @Test
    public void checkStatusCodeTwoHandled() {
        given().when().get(BaseURL + "entries").then().statusCode(200).contentType("");
    }

    // Must pass
    @Test
    public void checkStatusCodeFourHandled() {
        given().when().get(BaseURL + "entr").then().statusCode(404);
    }

}
