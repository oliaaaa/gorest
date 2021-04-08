package com.gorest.automation.requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;

public class Requests {
    public static JSONObject getRequest(String uri) {
        return new JSONObject(RestAssured
                .get(uri)
                .getBody()
                .asString()
                .trim());
    }

    public static JSONObject getRequestWithParam(String uri, String param, String paramValue) {
        return  new JSONObject(RestAssured.given()
                .param(param, paramValue)
                .get(uri)

                .getBody()
                .asString()
                .trim());
    }

    public static JSONObject postRequest(String uri, String body) {
        return new JSONObject(RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri(uri)
                .body(body)
                .when()
                .post()
                .getBody()
                .asString()
                .trim());
    }

    public static JSONObject patchRequest(String uri, String body) {
        return new JSONObject(RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri(uri)
                .body(body)
                .when()
                .patch()
                .getBody()
                .asString()
                .trim());
    }

    public static JSONObject putRequest(String uri, String body) {
        return new JSONObject(RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri(uri)
                .body(body)
                .when()
                .put()
                .getBody()
                .asString()
                .trim());
    }

    public static JSONObject deleteRequest(String uri) {
        return new JSONObject(RestAssured
                .given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .baseUri(uri)
                .when()
                .delete()
                .getBody()
                .asString()
                .trim());
    }
}
