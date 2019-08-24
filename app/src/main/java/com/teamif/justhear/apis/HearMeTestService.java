package com.teamif.justhear.apis;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface HearMeTestService {
    @POST("echo")
    Call<String> echo(@Body String body);

    @GET("error")
    Call<String> error();
}
