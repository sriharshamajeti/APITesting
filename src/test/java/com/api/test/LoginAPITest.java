package com.api.test;

import static io.restassured.RestAssured.*;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test(description = "Verify if Login API works...")
    public void LoginTest() {
        LoginRequest loginRequest = new LoginRequest("username", "pwd");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);

        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());

    }

}
