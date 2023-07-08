package com.example.transferent.interfaces;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ImageUploadService {
    @FormUrlEncoded
    @POST("upload-pod") // Replace "upload" with your actual API endpoint for image upload
    Call<String> uploadImage(@Header("Authorization") String authHeader,@Field("tracking_id") String trackingNumber, @Field("pod_img") String encodedImage);
}