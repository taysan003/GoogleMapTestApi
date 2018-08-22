package com.googlerestapi;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static com.jayway.restassured.RestAssured.*;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class RequestLoggingTest {
    @BeforeClass
    public void setBaseUri() {

        RestAssured.baseURI = "https://maps.googleapis.com";
    }

    @Test
    public void testStatusCode() {

        Response res =
                given()
                        .param("query", "restaurants in mumbai")
                        .param("key", "Xyz")
                        .when()
                        .get("/maps/api/place/textsearch/json");

        Assert.assertEquals(res.statusCode(), 200);
    }

    @Test
    public void testStatusCodeRestAssured() {

        given().param("query", "restaurants in mumbai")
                .param("key", "Xyz")
                .when()
                .get("/maps/api/place/textsearch/json")
                .then()
                .assertThat().statusCode(200);

    }
}
