package com.googlerestapi;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.jayway.restassured.RestAssured.*;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import static com.jayway.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import com.restapiclass.Posts;

public class JsonSchemaValidationTest {

    @BeforeClass
    public void setBaseUri () {

        RestAssured.baseURI = "https://maps.googleapis.com";
    }


    @Test
    public void validateJSON () {

        given ().param ("query", "Churchgate Station")
                .param ("key", "XYZ")
                .when ()
                .get ("/maps/api/place/textsearch/json")
                .then ()
                .body (matchesJsonSchemaInClasspath("json-schema.json"));
    }
}