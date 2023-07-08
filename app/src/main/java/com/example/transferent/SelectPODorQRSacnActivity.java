package com.example.transferent;

import static com.example.transferent.utilities.Common.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.transferent.interfaces.TrackingService;
import com.example.transferent.models.TrackingRequest;
import com.example.transferent.models.TrackingUserDetailsResponse;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class SelectPODorQRSacnActivity extends AppCompatActivity {
Button btnShipment,btnPOD;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_podor_qrsacn);

        btnPOD = findViewById(R.id.btnUploadPOD);
        btnShipment = findViewById(R.id.btnShipment);

        btnPOD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set custom prompt message
                Intent i = new Intent(getApplicationContext(),PodScanQrCodeActivity.class);
                startActivity(i);

            }
        });

        btnShipment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),ScanQrCodeActivity.class);
                startActivity(i);

            }
        });
    }

}