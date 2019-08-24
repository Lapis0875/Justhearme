package com.teamif.justhear;

import com.teamif.justhear.apis.ErrorResponse;
import com.teamif.justhear.apis.HearMe;
import com.teamif.justhear.apis.HearMeTestService;

import org.junit.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestUnitTest { // wtf name

    public TestUnitTest() {
        service = HearMe.retrofit.create(HearMeTestService.class);
    }

    HearMeTestService service;

    @Test
    public void echoTest(){
        final String test = "hello, world!";
        Call<String> response = service.echo(test);

        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                if (response.isSuccessful()) // success
                    assertEquals(test, response.body());
                else if (response.errorBody() != null) // SERVER error
                {
                    ErrorResponse error = ErrorResponse.getError(response);
                    log(error.getErrorMessage()); // print server error message
                }

                assertNotNull("server error occured.", response.errorBody());
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                assertTrue("client error occured.", false);
            }
        });
    }

    @Test
    public void exceptionHandleTest(){
        Call<String> response = service.error();

        response.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                assertTrue(!response.isSuccessful());

                ErrorResponse error = ErrorResponse.getError(response);
                log(error.getErrorMessage()); // print server error message
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                t.printStackTrace();
                assertTrue("client error occured.", false);
            }
        });
    }

    void log(String s) {
        System.out.println(s);
    }
}
