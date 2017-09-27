package com.db.services;

import com.db.services.enums.HTTPMethods;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BaseService {
    public static Response sendGetRequest(String url, HTTPMethods httpMethod, RequestSpecBuilder requestSpecBuilder) {
        Response response = null;
        switch (httpMethod) {
            case GET:
                response = given().spec(requestSpecBuilder.build()).get(url);
                break;
            case POST:
                response = given().spec(requestSpecBuilder.build()).post(url);
                break;
            case PUT:
                response = given().spec(requestSpecBuilder.build()).put(url);
                break;
            case DELETE:
                response = given().spec(requestSpecBuilder.build()).delete(url);
                break;
            case PATCH:
                response = given().spec(requestSpecBuilder.build()).patch(url);
                break;
            default:
                throw new RuntimeException("Invalid ");
        }
        return response;

    }

}
