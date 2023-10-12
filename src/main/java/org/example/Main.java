package org.example;

import io.restassured.RestAssured;

import java.io.File;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class Main {
    public static void main(String[] args)
    {
        File body = new File("D:\\Java\\Json\\body.json");

        RestAssured.baseURI = "https://petstore.swagger.io";
        given().log().all()
                //.header("accept", "application/json")
                //.header("Content-Type","application/json")
                .body(body)
//                .body("{\n" +
//                "  \"id\": 0,\n" +
//                "  \"category\": {\n" +
//                "    \"id\": 0,\n" +
//                "    \"name\": \"string\"\n" +
//                "  },\n" +
//                "  \"name\": \"doggie\",\n" +
//                "  \"photoUrls\": [\n" +
//                "    \"string\"\n" +
//                "  ],\n" +
//                "  \"tags\": [\n" +
//                "    {\n" +
//                "      \"id\": 0,\n" +
//                "      \"name\": \"string\"\n" +
//                "    }\n" +
//                "  ],\n" +
//                "  \"status\": \"available\"\n" +
//                "}")
                .when().post("v2/pet")
                .then().assertThat().statusCode(400);
    }
}