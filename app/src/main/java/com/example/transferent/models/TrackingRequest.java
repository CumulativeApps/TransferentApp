package com.example.transferent.models;

import com.google.gson.annotations.SerializedName;

public class TrackingRequest {
    @SerializedName("tracking_id")
    private String trackingId;

    public TrackingRequest(String trackingId) {
        this.trackingId = trackingId;
    }
}
