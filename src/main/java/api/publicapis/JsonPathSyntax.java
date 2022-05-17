package api.publicapis;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;

public class JsonPathSyntax {
  private static final String BaseURL = "https://api.publicapis.org/";
  private static final String ENTRIES_PATH = "entries";

  @Test
  public void advancedValidation() {
    given()
        .when()
        .get(BaseURL + ENTRIES_PATH)
        .then()
        .statusCode(200)
        .body("entries.API", hasItem("AdoptAPet"))
        //        .body("entries.Category", allOf(is("Animal")))
        .body("entries.API.findAll{it.startsWith('Ado')}", hasItem("AdoptAPet"))
        .body("entries.HTTPS.findAll{it == true}", hasItem(true))
        .body("entries.HTTPS.findAll{it != false}", hasItem(true))
        .body("entries.API.findAll{it.startsWith('A')}", hasItem("AdoptAPet"));
    //        .body(
    //            "entries.API.findAll{it.startsWith('A')}.collect{it.toUpperCase()}.toArray()",
    //            allOf(hasItem("AdoptAPet")))
  }
}
