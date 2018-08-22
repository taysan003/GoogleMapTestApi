package com.googlerestapi;

import com.jayway.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class GetJsonResponseTest {

    @BeforeClass
    public void setBaseUri () {

        RestAssured.baseURI = "https://maps.googleapis.com";
    }

    @Test
    public void test01()  {
        Response res  =given ().param ("query", "Churchgate Station")
                .param ("key", "Xyz")
                .when()
                .get ("/maps/api/place/textsearch/json").then()
                .contentType(ContentType.JSON)
                .extract().response();


        System.out.println (res.asString ());

    }

}