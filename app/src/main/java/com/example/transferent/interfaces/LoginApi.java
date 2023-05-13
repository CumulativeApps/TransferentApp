package com.example.transferent.interfaces;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginApi {
    @POST("app-user-login") // Replace with your login API endpoint
    Call<JsonObject> loginUser(@Body JsonObject jsonObject);
}