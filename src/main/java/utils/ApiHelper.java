package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiHelper
{
    public static Response get(String endpoint){
        return RestAssured.given()
                .when()
                .get(endpoint);
    }

    public static Response post(String endpoint, String body)
    {
        return RestAssured.given()
                .header("Content-Type", "application/json").body(body).when().post(endpoint);
    }

    public static void validateStatusCode(Response response, int expectedStatusCode){
        response.then().statusCode(expectedStatusCode);
    }
}
