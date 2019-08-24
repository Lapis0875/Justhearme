package com.teamif.justhear.apis;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface HearMeLoginService
{
    @POST("login")
    Call<LoginResponse> login(@Body LoginRequest request);
}
