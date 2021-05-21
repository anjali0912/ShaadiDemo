package com.example.shaadidemo.Retrofitt;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String PROFILE_URL = "https://randomuser.me/api/";
    @GET("?results=10")
    Call<JSONResponse> getJson();
}