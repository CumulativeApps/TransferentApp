package com.example.transferent;

import static com.example.transferent.utilities.Common.BASE_URL;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.transferent.adapters.ShipmentStatusAdapter;
import com.example.transferent.interfaces.TrackingService;
import com.example.transferent.interfaces.UpdateStatus;
import com.example.transferent.interfaces.UpdateStatusVerifyOtp;
import com.example.transferent.models.ShipmentStatus;
import com.example.transferent.models.TrackingRequest;
import com.example.transferent.models.TrackingUserDetailsResponse;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    String trackingNumber;
    TextView Name, Origin, Destination, OrderStatus, PickedOn, Remark;
    String authToken;
    String setStatus;
    String getStatus;
    ArrayList<ShipmentStatus> shipmentStatusList = new ArrayList<>();
    Spinner shipmentStatusSpinner;
//    private ProgressDialog progressDialog;
    String statusName;
    boolean callSpinner = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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


        Name = findViewById(R.id.txtName);
        Origin = findViewById(R.id.txtOrigin);
        Destination = findViewById(R.id.txtDestination);
        OrderStatus = findViewById(R.id.txtOrderStatus);
        PickedOn = findViewById(R.id.txtPickedUpOn);
        Remark = findViewById(R.id.txtRemark);

        //retrieve the scanned tracking number from the intent extras
        trackingNumber = getIntent().getStringExtra("TRACKING_NUMBER");

        //display the tracking number in a TextView or any other view
        TextView textView = findViewById(R.id.textViewName);
        textView.setText(trackingNumber);
        trackingNumberAPI();
        spinnerMethod();

}

    private void spinnerMethod() {
        shipmentStatusList.add(new ShipmentStatus("Update Tracking Status"));
        shipmentStatusList.add(new ShipmentStatus("Pending Pickup From Origin"));
        shipmentStatusList.add(new ShipmentStatus("Shipment Picked Up From Origin"));
        shipmentStatusList.add(new ShipmentStatus("Shipment Scan Tallied"));
        shipmentStatusList.add(new ShipmentStatus("In Transit to Destination Hub"));
        shipmentStatusList.add(new ShipmentStatus("Shipment Out For Delivery"));
        shipmentStatusList.add(new ShipmentStatus("Shipment Delivered"));
        shipmentStatusList.add(new ShipmentStatus("RTO"));
        shipmentStatusList.add(new ShipmentStatus("Rerouted"));
        shipmentStatusList.add(new ShipmentStatus("Shipment Manifested"));
        shipmentStatusList.add(new ShipmentStatus("Out of Delivery Area"));
        shipmentStatusList.add(new ShipmentStatus("POD Correction"));
        shipmentStatusList.add(new ShipmentStatus("Lost in Transit"));
        shipmentStatusList.add(new ShipmentStatus("Consignee Out Of Station / Unavailable"));
        shipmentStatusList.add(new ShipmentStatus("Shipment Held in Hub"));
        shipmentStatusList.add(new ShipmentStatus("Shipment In scan"));
        shipmentStatusList.add(new ShipmentStatus("Rejected By Employee"));
        shipmentStatusList.add(new ShipmentStatus("Employee Not In Town"));
        shipmentStatusList.add(new ShipmentStatus("Shipment not Received from Origin"));
        shipmentStatusList.add(new ShipmentStatus("Cancelled by Shipper"));
        shipmentStatusList.add(new ShipmentStatus("Handed over Directly"));
        shipmentStatusList.add(new ShipmentStatus("On Hold As Per Consignee"));
        shipmentStatusList.add(new ShipmentStatus("Others"));
        shipmentStatusList.add(new ShipmentStatus("Shipment In Transit"));
        shipmentStatusList.add(new ShipmentStatus("TRS Asset"));
        shipmentStatusList.add(new ShipmentStatus("Out For Pickup"));
        shipmentStatusList.add(new ShipmentStatus("Received At Destination Hub"));
        shipmentStatusList.add(new ShipmentStatus("On Hold As Per Shipper Request"));
        shipmentStatusList.add(new ShipmentStatus("Invalid Contact Number / Address"));
        shipmentStatusList.add(new ShipmentStatus("Misrouted"));
        shipmentStatusList.add(new ShipmentStatus("Delayed due to lockdown"));
        shipmentStatusList.add(new ShipmentStatus("Not Responding"));
        shipmentStatusList.add(new ShipmentStatus("Cancel Request"));
        shipmentStatusList.add(new ShipmentStatus("Future Delivery Cancelled"));
        shipmentStatusList.add(new ShipmentStatus("Shipment Picked / In Transit"));
        shipmentStatusList.add(new ShipmentStatus("Asset Delivered"));
        getStatus = getIntent().getStringExtra("SET_STATUS");
        System.out.println("ScanScreenSetStatus" + getStatus);
        if (getStatus.equals("Asset Delivered") || getStatus.equals("Shipment Delivered")) {
            System.out.println("RECEIVE Asset Delivered OR Shipment Delivered");

        }else{
            shipmentStatusSpinner = findViewById(R.id.spnOrderStatus);
            ShipmentStatusAdapter adapter = new ShipmentStatusAdapter(this, shipmentStatusList);
            shipmentStatusSpinner.setAdapter(adapter);
            shipmentStatusSpinner.setVisibility(View.VISIBLE);

            shipmentStatusSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    System.out.println("SPINNERCALL");
                    ShipmentStatus selectedStatus = (ShipmentStatus) parent.getItemAtPosition(position);
                    statusName = selectedStatus.getStatusName();


                    if (statusName.equals("Asset Delivered")) {
                        showMyDialog();
                    } else if (statusName.equals("Shipment Delivered")) {
                        showMyDialog();
                    } else {
                        updateTrackingDetails(trackingNumber, statusName);
                    }


                }

                public void showMyDialog() {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    View view = getLayoutInflater().inflate(R.layout.add_aim_dialog, null);
                    builder.setView(view);
                    EditText editText = view.findViewById(R.id.edit_Aim_text);
                    Button closeButton = view.findViewById(R.id.close_Aim_button);
                    Button saveButton = view.findViewById(R.id.save_Aim_button);
                    AlertDialog dialog = builder.create();
                    closeButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });

                    saveButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String text = editText.getText().toString();
                            verifyStatusOtp(trackingNumber,text);


                            // Do something with the text
                            dialog.dismiss();
                        }
                    });

                    dialog.show();
                }


                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                    // do nothing
                }
            });

        }





    }


    private void trackingNumberAPI() {
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Loading...");
//        progressDialog.setCancelable(false);

        System.out.println("APICALL");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TrackingService service = retrofit.create(TrackingService.class);
        TrackingRequest request = new TrackingRequest(trackingNumber);
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
                    Name.setText(getEditTaskData.name);
                    Origin.setText(getEditTaskData.companyOrigin);
                    Destination.setText(getEditTaskData.postalAddress);
                    OrderStatus.setText(getEditTaskData.status != null ? getEditTaskData.status.toString() : "No Status ");
                    PickedOn.setText(getEditTaskData.pickupDate != null ? getEditTaskData.pickupDate.toString() : "No Picked On Date");
                    Remark.setText(getEditTaskData.remarks);
//                    myValue = getEditTaskData.getStatus().toString();
                    setStatus = (getEditTaskData.status != null ? getEditTaskData.status.toString() : "No Status ");
                    System.out.println("setStatus"+setStatus);
                    if (getStatus.equals("Asset Delivered") || getStatus.equals("Shipment Delivered")) {
                        System.out.println("RECEIVE Asset Delivered OR Shipment Delivered");



                    }else {
                        for (int i = 0; i < shipmentStatusList.size(); i++) {
                            ShipmentStatus shipmentStatus = shipmentStatusList.get(i);
                            if (shipmentStatus.getStatusName().equals(setStatus)) {
                                shipmentStatusSpinner.setSelection(i);
                                break;
                            }
                        }
                    }
                } else {
                    Toast.makeText(MainActivity.this, "invalid login credentials", Toast.LENGTH_SHORT).show();
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
    private void updateTrackingDetails(String trackingNumber, String statusName) {
//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Loading...");
//        progressDialog.setCancelable(false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UpdateStatus updateStatus = retrofit.create(UpdateStatus.class);
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tracking_id", trackingNumber);
        jsonObject.addProperty("status", statusName);
//        progressDialog.show();
        Call<JsonObject> call = updateStatus.updateStatus("Bearer " + authToken, jsonObject);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
//                progressDialog.dismiss();

                if (response.isSuccessful()) {
                    System.out.println("Status Changes Successfully");
                    trackingNumberAPI();
                    // Handle successful login
                } else {
                    Toast.makeText(MainActivity.this, "Something went Wrong", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
//                progressDialog.dismiss();

                Log.d("MainActivity", "Error: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void verifyStatusOtp(String trackingNumber, String otpText) {

//        progressDialog = new ProgressDialog(this);
//        progressDialog.setMessage("Loading...");
//        progressDialog.setCancelable(false);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Create an interface for your API methods
        UpdateStatusVerifyOtp updateStatusVerifyOtp = retrofit.create(UpdateStatusVerifyOtp.class);

        // Create a JsonObject for your request body
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("tracking_id", trackingNumber);
        jsonObject.addProperty("otp", otpText);
//        progressDialog.show();

        // Use the Retrofit client and interface to make the API request
        Call<ResponseBody> call = updateStatusVerifyOtp.verifyOtp("Bearer " + authToken, jsonObject);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                progressDialog.dismiss();

                if (response.isSuccessful()) {
                    // Handle successful response
                    updateTrackingDetails(trackingNumber, statusName);
                    Toast.makeText(MainActivity.this, "OTP Verified Successfully", Toast.LENGTH_SHORT).show();

                } else {
                    // Handle error response
                    Toast.makeText(MainActivity.this, "Please enter correct OTP", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                progressDialog.dismiss();

                // Handle failure
                Log.d("MainActivity", "Failure: " + t.getMessage());
            }
        });
    }

}


