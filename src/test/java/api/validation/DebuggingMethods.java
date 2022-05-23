package api.validation;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("all_examples")
public class DebuggingMethods {
    public static final String BASE_URL = "https://api.github.com";

    @Test
    public void peek() {
        RestAssured.given().when().get(BASE_URL).peek();
    }

    @Test
    public void prettyPeek() {
        RestAssured.given().when().get(BASE_URL).prettyPeek();
    }

    @Test
    public void print() {
        RestAssured.given().get(BASE_URL).print();
    }

    @Test
    public void prettyPrint() {
        RestAssured.given().get(BASE_URL).prettyPrint();
    }
}
