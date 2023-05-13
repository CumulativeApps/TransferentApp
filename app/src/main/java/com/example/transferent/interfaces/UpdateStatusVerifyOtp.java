package com.example.transferent.interfaces;

import com.google.gson.JsonObject;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface UpdateStatusVerifyOtp {
    @POST("tracking-check-otp")
    Call<ResponseBody> verifyOtp(@Header("Authorization") String authHeader, @Body JsonObject jsonObject);
}
