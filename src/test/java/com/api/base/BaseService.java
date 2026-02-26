package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.models.requests.LoginRequest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {//Wrapper for the RestAssured
    //Responsible for the base URI
    // Creating the request
    //Handling the response

    private static final String BASE_URL = "BASE_URL";

    private RequestSpecification requestSpecification;

    public BaseService() {
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected Response postRequest(Object payLoad, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payLoad).post(endpoint);
    }

    protected Response getRequest(String endpoint) {
        return requestSpecification.get(endpoint);
    }

}
