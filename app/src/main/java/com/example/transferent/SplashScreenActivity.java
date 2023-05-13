package com.example.transferent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class SplashScreenActivity extends AppCompatActivity {
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        ImageView imageView = findViewById(R.id.imageView);

//        Picasso.get()
//                .load(R.drawable.app_logo)
//                .resize(250, 150) // adjust the size according to your needs
//                .into(imageView);

        handler=new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);

                String authToken = sharedPreferences.getString("tokeen", null);
                System.out.println("authToken"+authToken);

                if (authToken != null) {
                    // The auth token exists, so redirect to the home page
                    Intent intent = new Intent(SplashScreenActivity.this, ScanQrCodeActivity.class);
                    startActivity(intent);
                    finish(); // This prevents the user from going back to the login screen
                } else if(authToken == null){
                    // The auth token doesn't exist, so the user needs to log in
                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish(); // This prevents the user from going back to the home screen if they press the back button
                }

            }
        },5000);

    }
}