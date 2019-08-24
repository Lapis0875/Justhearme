package com.teamif.justhear.apis;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HearMe
{
    public final static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(HearMe.Host)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static final String Host = "https://nanobot.tk:7000/";
}
