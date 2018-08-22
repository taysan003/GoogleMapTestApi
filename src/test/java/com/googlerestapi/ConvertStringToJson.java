package com.googlerestapi;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.json.JacksonJsonNodeJsonProvider;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

public class ConvertStringToJson {

    public static void main(String[] args) {

        String jsonString = "{\"id\":1,\"name\":\"ashwin\",\"surname\":\"karangutkar\",\"details\":{\"City\":\"Mumbai\"}}\\";

        Configuration configuration = Configuration.builder().jsonProvider(new JacksonJsonNodeJsonProvider())
                .mappingProvider(new JacksonMappingProvider()).build();

        DocumentContext json = JsonPath.using(configuration).parse(jsonString);
        String jsonPath = "details.City";
        String newValue = "Pune";
        System.out.println(json.set(jsonPath, newValue).jsonString());

    }
}