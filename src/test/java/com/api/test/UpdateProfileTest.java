package com.api.test;

import com.api.base.AuthService;
import com.api.base.UserProfileManagementService;
import com.api.models.requests.LoginRequest;
import com.api.models.requests.ProfileRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateProfileTest {

    @Test
    public void UpdateProfileInfoTest() {
        AuthService authService = new AuthService();
        Response response = authService.login(new LoginRequest("username", "pwd"));
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(loginResponse.getToken());

        System.out.println("--------------------------------------------------------");

        UserProfileManagementService userProfileManagementService = new UserProfileManagementService();
        response = userProfileManagementService.getProfile(loginResponse.getToken());
        System.out.println(response.asPrettyString());
        UserProfileResponse userProfileResponse = response.as(UserProfileResponse.class);
        Assert.assertEquals(userProfileResponse.getUsername(), "username");

        System.out.println("--------------------------------------------------------");

        ProfileRequest profileRequest = new ProfileRequest.Builder()
                .firstName("updateFirstName")
                        .lastName("updatedLastname")
                                .email("updatedEmail")
                                        .mobileNumber("updatedNumber")
                                                .build();
        response = userProfileManagementService.updateProfile(loginResponse.getToken(), profileRequest);
        System.out.println(response.asPrettyString());

    }
}
