package com.example.transferent;

import static com.example.transferent.utilities.Common.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.transferent.interfaces.TrackingService;
import com.example.transferent.models.ShipmentStatus;
import com.example.transferent.models.TrackingRequest;
import com.example.transferent.models.TrackingUserDetailsResponse;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.squareup.picasso.Picasso;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ScanQrCodeActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonScan;
    private TextView textViewName, textViewAddress;
    String qrData;
    private IntentIntegrator qrScan;
    String authToken;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr_code);
        ImageView imageView = findViewById(R.id.imageView);

//        Picasso.get()
//                .load(R.drawable.app_logo)
//                .resize(250, 150) // adjust the size according to your needs
//                .into(imageView);
        MaterialToolbar toolbar = findViewById(R.id.toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_back_arrow);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // This will be called when the back button is clicked
                onBackPressed();
            }
        });





        buttonScan = (Button) findViewById(R.id.btnScanCode);

        //intializing scan object
        qrScan = new IntentIntegrator(this);

        //attaching onclick listener
        buttonScan.setOnClickListener(this);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);

        if (result != null) {
            //if qrcode has nothing in it
            if (result.getContents() == null) {
                Toast.makeText(this, "Result Not Found", Toast.LENGTH_LONG).show();
            } else {
                //if qr contains data
                //converting the data to json
                 qrData = result.getContents();
                System.out.println("result.getContents())" +qrData);
                trackingNumberAPI(qrData);
//                    JSONObject obj = new JSONObject(result.getContents());
                //create a new intent to go to the new activity


            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    private void trackingNumberAPI(String qrData) {
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Loading...");
//        progressDialog.setCancelable(false);
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        authToken = sharedPreferences.getString("token", "");
        System.out.println("APICALL");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TrackingService service = retrofit.create(TrackingService.class);
        TrackingRequest request = new TrackingRequest(qrData);
        String authHeader = "Bearer " + authToken;
//        progressDialog.show();

        Call<JsonObject> call = service.sendTrackingId(authHeader, request);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                progressDialog.dismiss();

                if (response.isSuccessful()) {
                    JsonObject loginResponse = response.body();
                    JsonObject data = loginResponse.getAsJsonObject("data");
                    TrackingUserDetailsResponse.Data getEditTaskData = new Gson().fromJson(data.toString(), TrackingUserDetailsResponse.Data.class);
                    String setStatus = (getEditTaskData.status != null ? getEditTaskData.status.toString() : "No Status ");


                    Intent intent = new Intent(ScanQrCodeActivity.this, MainActivity.class);
                    //put the data as an extra in the intent
                    intent.putExtra("TRACKING_NUMBER", qrData);
                    intent.putExtra("SET_STATUS", setStatus);

                    //start the new activity
                    startActivity(intent);


                } else {
                    Toast.makeText(ScanQrCodeActivity.this, "invalid login credentials", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
//                progressDialog.dismiss();
                Log.d("MainActivity", "Failure: " + t.getMessage());

                // Handle the error
            }
        });

    }


    @Override
    public void onClick(View view) {
        // set custom prompt message

        qrScan.setPrompt("Scan QR code");
        //initiating the qr code scan

        qrScan.initiateScan();
    }
}