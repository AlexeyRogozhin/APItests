package petstoretests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.BeforeSuite;

import static io.restassured.RestAssured.given;

public class BaseTest {

    public final String baseUrl = "https://petstore.swagger.io/v2/";
    //public static final String JSON_RESPONSE_SCHEMA = "shemas/succesAnswerSchema.json";

    @BeforeSuite
    public void beforeSuite(){
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(baseUrl)
                .build();
    }
    public ValidatableResponse sendGetRequest(String ep, int statusCode){
        return given().log().everything()
                .header("accept", "application/json")
                .get(ep)
                .then()
                .statusCode(statusCode);
    }

}
