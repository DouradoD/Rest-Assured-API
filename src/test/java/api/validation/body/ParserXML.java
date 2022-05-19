package api.validation.body;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;

public class ParserXML {

    public static final String BASE_URL_JSON = "https://api.github.com/";
    public static final String BASE_URL_XML = "http://restapi.adequateshop.com/api/Traveler";


    @Test
    public void prettyPeek() {
        RestAssured.given().when().get(BASE_URL_XML).prettyPeek();
    }

    @Test
    public void parserXML() {
        RestAssured
                .given()
                .when()
                .get(BASE_URL_XML)
                .then()
                // If it is valid to readability, include the both line below
                .using()
                .defaultParser(Parser.XML)
                .contentType("application/xml; charset=utf-8")
                .body("TravelerinformationResponse.travelers.Travelerinformation[0].id", is("1189"))
                .body("TravelerinformationResponse.travelers.Travelerinformation[0].name",
                        containsString("David William"));
    }

    @Test
    public void defaultParserJSON() {
        RestAssured
                .given()
                .when()
                .get(BASE_URL_JSON).then()
                // If it is valid to readability, include the both line below
                .using()
                .defaultParser(Parser.JSON)
                .body("current_user_url", equalTo(BASE_URL_JSON + "user"));
    }
}
