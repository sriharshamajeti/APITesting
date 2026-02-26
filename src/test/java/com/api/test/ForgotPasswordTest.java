package com.api.test;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    @Test(description = "Verify if Forgot Password API is working")

    public void forgotPasswordTest() {

        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("email@email.com");
        System.out.println(response.asPrettyString());

    }
}
