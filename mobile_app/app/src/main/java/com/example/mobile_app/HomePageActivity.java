package com.example.mobile_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HomePageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Get the calling intent
        Intent intent = getIntent();

        // Get the username of the user that just logged in
        String username = intent.getStringExtra(MainActivity.USERNAME);

        // Display the username
        TextView welcomeMessage = findViewById(R.id.welcome_msg_tv);
        welcomeMessage.setText("Welcome " + username + "!");
    }
}