package api.apigithub;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class CheckingHeader {
    public static final String BASE_URL = "https://api.github.com";

    @Test
    public void commonElementFromHeader() {
        RestAssured.
                given().
                when().
                get(BASE_URL).
                then().
                statusCode(200).
                contentType(is("application/json; charset=utf-8"));

    }

    @Test
    public void specificElementFromHeader() {
        RestAssured.
                given().
                when().
                get(BASE_URL).
                then().header("Cache-Control", containsString("public")).
                header("Vary", is("Accept, Accept-Encoding, Accept, X-Requested-With"));

    }
}
