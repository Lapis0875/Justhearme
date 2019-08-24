package com.teamif.justhear;

import com.teamif.justhear.apis.ErrorResponse;
import com.teamif.justhear.apis.HearMe;
import com.teamif.justhear.apis.HearMeLoginService;
import com.teamif.justhear.apis.LoginRequest;
import com.teamif.justhear.apis.LoginResponse;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class LoginUnitTest {
    LoginResponse session;
    HearMeLoginService service;

    public LoginUnitTest() {
        service = HearMe.retrofit.create(HearMeLoginService.class);
    }

    @Test
    public void loginTest()
    {
        log("start login test");
        session = null;

        String testEmail = "ksi123456ab@gmail.com";
        String testPass = "test";

        service.login(new LoginRequest(testEmail, testPass))
                .enqueue(new Callback<LoginResponse>() {
                    @Override
                    public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                        if (response.isSuccessful()) // success
                            session = response.body();
                        else if (response.errorBody() != null) // SERVER error
                        {
                            ErrorResponse error = ErrorResponse.getError(response);
                            log(error.getErrorMessage()); // print server error message
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResponse> call, Throwable t) { // CLIENT error
                        t.printStackTrace();
                    }
                });

        assertNull("login failed. session was null.", session);
        assertEquals("1d889959-44d7-4434-a717-65b5c1c6dd8a", session.getUuid());
    }

    void log(String s) {
        System.out.println(s);
    }
}
