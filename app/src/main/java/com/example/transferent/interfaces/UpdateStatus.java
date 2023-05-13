package com.example.transferent.interfaces;


import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UpdateStatus {
    @POST("tracking-status-update") // Replace with your login API endpoint
    Call<JsonObject> updateStatus(@Header("Authorization") String authHeader, @Body JsonObject jsonObject);
}