package com.example.transferent.interfaces;

import com.example.transferent.models.TrackingRequest;
import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface TrackingService {
    @POST("tracking-app-data")
    Call<JsonObject> sendTrackingId(@Header("Authorization") String authHeader, @Body TrackingRequest request);
}

