package com.example.transferent;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static com.example.transferent.utilities.Common.BASE_URL;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.transferent.adapters.ShipmentStatusAdapter;
import com.example.transferent.interfaces.ImageUploadService;
import com.example.transferent.interfaces.TrackingService;
import com.example.transferent.interfaces.UpdateStatus;
import com.example.transferent.interfaces.UpdateStatusVerifyOtp;
import com.example.transferent.models.ShipmentStatus;
import com.example.transferent.models.TrackingRequest;
import com.example.transferent.models.TrackingUserDetailsResponse;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public class UploadPODImageActivity extends AppCompatActivity {
    String trackingNumber;
    TextView Name, Origin, Destination, OrderStatus, PickedOn, Remark, TrackingId;
    String name, origin, destination, orderStatus, pickedOn, remark, trackingId;
    ;
    String authToken;
    String setStatus;
    String getStatus;

    TextView tvOrderStatusTitle;
    String statusName;
    private static final int REQUEST_IMAGE = 1;
    private static final int PERMISSION_REQUEST_CODE = 2;

    private Button selectImageButton;
    private Button uploadButton;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_podimage);
        MaterialToolbar toolbar = findViewById(R.id.toolbarQrScan);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        authToken = sharedPreferences.getString("token", "");
        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This will be called when the back button is clicked
                onBackPressed();
            }
        });

        TrackingId = findViewById(R.id.textViewName);
        Name = findViewById(R.id.txtName);
        Origin = findViewById(R.id.txtOrigin);
        Destination = findViewById(R.id.txtDestination);
        OrderStatus = findViewById(R.id.txtOrderStatus);
        PickedOn = findViewById(R.id.txtPickedUpOn);
        Remark = findViewById(R.id.txtRemark);

        //retrieve the scanned tracking number from the intent extras
        trackingNumber = getIntent().getStringExtra("TRACKING_NUMBER");
        name = getIntent().getStringExtra("Name");
        origin = getIntent().getStringExtra("Origin");
        destination = getIntent().getStringExtra("Destination");
        pickedOn = getIntent().getStringExtra("PickedOn");
        remark = getIntent().getStringExtra("Remark");
        getStatus = getIntent().getStringExtra("SET_STATUS");


        TextView DeliveryDate = findViewById(R.id.txtDeliveryDate);
        LinearLayout linearDeliveryDate = findViewById(R.id.linerDeliveryDate);
//
        String getDeliveryDate = getIntent().getStringExtra("DeliveryDate");
//
        if (getDeliveryDate == null) {
            linearDeliveryDate.setVisibility(View.GONE);
        } else {
            linearDeliveryDate.setVisibility(View.VISIBLE);
            DeliveryDate.setText(getDeliveryDate);
        }

        Name.setText(name);
        TrackingId.setText(trackingNumber);
        Origin.setText(origin);
        Destination.setText(destination);
        OrderStatus.setText(getStatus);
        PickedOn.setText(pickedOn);
        Remark.setText(remark);

        selectImageButton = findViewById(R.id.btnSelectPODImage);
        uploadButton = findViewById(R.id.btnUploadPODImage);
        imageView = findViewById(R.id.imageView);

        selectImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkPermission()) {
                    openImagePicker();
                } else {
                    requestPermission();
                }
            }
        });

        uploadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (imageView.getDrawable() == null) {
                    // Display toast message if no image is selected
                    Toast.makeText(UploadPODImageActivity.this, "Please select an image first", Toast.LENGTH_SHORT).show();
                } else {
                    uploadImage();
                }
            }
        });
//        TextView DeliveryDate = findViewById(R.id.txtDeliveryDate);
//        LinearLayout linearDeliveryDate = findViewById(R.id.linerDeliveryDate);
//
//        String getDeliveryDate = getIntent().getStringExtra("DeliveryDate");
//
//        if (getDeliveryDate == null) {
//            linearDeliveryDate.setVisibility(View.GONE);
//        } else {
//            linearDeliveryDate.setVisibility(View.VISIBLE);
//            DeliveryDate.setText(getDeliveryDate);
//        }




        //display the tracking number in a TextView or any other view

        trackingNumberAPI();

    }


    private void trackingNumberAPI() {
        System.out.println("TRACKING API CALL");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TrackingService service = retrofit.create(TrackingService.class);
        TrackingRequest request = new TrackingRequest(trackingNumber);
        String authHeader = "Bearer " + authToken;

        Call<JsonObject> call = service.sendTrackingId(authHeader, request);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {
                    JsonObject loginResponse = response.body();
                    JsonObject data = loginResponse.getAsJsonObject("data");
                    TrackingUserDetailsResponse.Data getEditTaskData = new Gson().fromJson(data.toString(), TrackingUserDetailsResponse.Data.class);
                    TrackingId.setText(getEditTaskData.uid);
                    Name.setText(getEditTaskData.name);
                    Origin.setText(getEditTaskData.companyOrigin);
                    Destination.setText(getEditTaskData.postalAddress);
                    OrderStatus.setText(getEditTaskData.status != null ? getEditTaskData.status.toString() : "No Status ");
                    PickedOn.setText(getEditTaskData.pickupDate != null ? getEditTaskData.pickupDate.toString() : "No Picked On Date");
                    Remark.setText(getEditTaskData.remarks);
//                    myValue = getEditTaskData.getStatus().toString();
                    setStatus = (getEditTaskData.status != null ? getEditTaskData.status.toString() : "No Status ");

                } else {
                    Toast.makeText(UploadPODImageActivity.this, "invalid login credentials", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("UploadPODImageActivity", "Failure: " + t.getMessage());

                // Handle the error
            }
        });

    }

    private boolean checkPermission() {
        int result = ContextCompat.checkSelfPermission(this, READ_EXTERNAL_STORAGE);
        return result == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, new String[]{READ_EXTERNAL_STORAGE},
                PERMISSION_REQUEST_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                openImagePicker();
            }
        }
    }

    private void openImagePicker() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE && resultCode == RESULT_OK && data != null) {
            Uri imageUri = data.getData();
            Glide.with(this)
                    .load(imageUri)
                    .into(imageView);
            Toast.makeText(UploadPODImageActivity.this, "Image Selected Successfully", Toast.LENGTH_SHORT).show();

        }
    }

    private void uploadImage() {
        Bitmap imageBitmap = ((BitmapDrawable) imageView.getDrawable()).getBitmap();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        byte[] imageBytes = byteArrayOutputStream.toByteArray();
        String encodedImage = Base64.encodeToString(imageBytes, Base64.DEFAULT);



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        String authHeader = "Bearer " + authToken;
        ImageUploadService service = retrofit.create(ImageUploadService.class);
        Call<String> call = service.uploadImage(authHeader,trackingNumber, "data:image/png;base64,"+encodedImage);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    // Handle successful image upload
                    String imageUrl = response.body();
                    Toast.makeText(UploadPODImageActivity.this, "Image Uploaded Successfully", Toast.LENGTH_SHORT).show();

                    // Process the response or perform any further actions
                } else {
                    Toast.makeText(UploadPODImageActivity.this, "Something went Wrong!", Toast.LENGTH_SHORT).show();

                    // Handle unsuccessful image upload
                    // Display an error message or retry the upload
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                // Handle failure in making the API call or network issues
            }
        });
    }


}




