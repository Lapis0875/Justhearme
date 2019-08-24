package com.teamif.justhear.apis;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

import java.io.IOException;

import retrofit2.Response;

public class ErrorResponse {
    String error;
    String message;
    int statusCode = -1;

    public String getError()
    {
        return error;
    }

    public String getMessage()
    {
        return message;
    }

    public int getStatusCode()
    {
        return statusCode;
    }

    public String getErrorMessage()
    {
        // 500 : ValueError
        // there is error shaalashala

        return statusCode + " : " + error + "\n" + message;
    }

    public static ErrorResponse getError(Response response) {
        ErrorResponse result = new ErrorResponse();

        try {
            String res = response.errorBody().string();
            result = new Gson().fromJson(res, ErrorResponse.class);
        }
        catch (Exception e) {
            result.error = "java:" + e.getClass().getName();
            result.message = e.getMessage();
        }

        if (response != null)
            result.statusCode = response.code();

        return result;
    }
}
