package com.googlerestapi;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

public class GetRequestTest {

    @BeforeClass
    public void setBaseUri () {

        RestAssured.baseURI = "https://maps.googleapis.com";
    }

    @Test
    public void testResult ()  {
        Response res  =given ().param ("query", "Churchgate Station")
                .param ("key", "Xyz")
                .when()
                .get ("/maps/api/place/textsearch/json").then()
                .contentType(ContentType.JSON)
                .extract().path ("results[0].formatted_address");

        Assert.assertEquals (res, "Maharshi Karve Rd, Churchgate, Mumbai, Maharashtra 400020");

    }

}
