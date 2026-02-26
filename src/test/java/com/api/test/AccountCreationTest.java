package com.api.test;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTest {
    @Test(description = "Verify if Account Creation API is working")

    public void createAccountTest() {

        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .userName("johndoe123456")
                .email("johndoe123456@email.com")
                .firstName("John")
                .password("John@123")
                .lastName("Doe")
                .mobileNumber("9999999998")
                .build();

        AuthService authService =  new AuthService();
        Response response = authService.signUp(signUpRequest);

        Assert.assertEquals(response.asPrettyString(),"User registered successfully!");
    }
}
