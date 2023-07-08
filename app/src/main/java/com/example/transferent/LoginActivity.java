package com.example.transferent;

import static com.example.transferent.utilities.Common.BASE_URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;



import com.example.transferent.interfaces.LoginApi;
import com.google.gson.JsonObject;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageView imageView = findViewById(R.id.imageView);


        Button btnSave = findViewById(R.id.btnSave);




        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });


    }
    private boolean validateInput() {
        EditText emailInput = findViewById(R.id.etEmail);
        EditText passwordInput = findViewById(R.id.etPassword);

        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        if (email.isEmpty()) {
            emailInput.setError("Email is required");
            return false;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailInput.setError("Please enter a valid email address");
            return false;
        }

        if (password.isEmpty()) {
            passwordInput.setError("Password is required");
            return false;
        }

        return true;
    }
    public void ShowHidePass(View view){
        EditText emailInput = findViewById(R.id.etEmail);
        EditText passwordInput = findViewById(R.id.etPassword);
        if(view.getId()==R.id.show_pass_btn){

            if(passwordInput.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.ic_eye_visible);

                //Show Password
                passwordInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.ic_eye_hidden);

                //Hide Password
                passwordInput.setTransformationMethod(PasswordTransformationMethod.getInstance());

            }
        }
    }
    private void loginUser() {
        if (!validateInput()) {
            return;
        }

        EditText emailInput = findViewById(R.id.etEmail);
        EditText passwordInput = findViewById(R.id.etPassword);

        String email = emailInput.getText().toString().trim();
        String password = passwordInput.getText().toString().trim();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        LoginApi loginApi = retrofit.create(LoginApi.class);

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("email", email);
        jsonObject.addProperty("password", password);

        Call<JsonObject> call = loginApi.loginUser(jsonObject);

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                if (response.isSuccessful()) {

                    JsonObject loginResponse = response.body();

                    JsonObject data =loginResponse.getAsJsonObject("data");
                    String token = data.get("token").getAsString();
                    // Store the token in a shared preference
                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("token", token);
                    editor.apply();
                    Intent i = new Intent(getApplicationContext(),SelectPODorQRSacnActivity.class);
                    startActivity(i);
                    finish();
                    // Handle successful login
                } else {
                    Toast.makeText(LoginActivity.this, "invalid login credentials", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.d("LoginActivity", "Error: " + t.getMessage());
                Toast.makeText(LoginActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // If the login is successful, start the next activity

    }


}