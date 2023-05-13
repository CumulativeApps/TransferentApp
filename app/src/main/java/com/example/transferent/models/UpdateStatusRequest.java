package com.example.transferent.models;

import com.google.gson.annotations.SerializedName;

public class UpdateStatusRequest {
    @SerializedName("tracking_id")
    private String trackingId;

    @SerializedName("status")
    private String status;

    public UpdateStatusRequest(String trackingId, String status) {
        this.trackingId = trackingId;
        this.status = status;
    }
}
